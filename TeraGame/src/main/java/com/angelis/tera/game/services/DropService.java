package com.angelis.tera.game.services;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javolution.util.FastList;
import javolution.util.FastMap;

import org.apache.log4j.Logger;

import com.angelis.tera.common.domain.mapper.MapperManager;
import com.angelis.tera.common.utils.Rnd;
import com.angelis.tera.game.config.DropConfig;
import com.angelis.tera.game.domain.mapper.xml.DropMapper;
import com.angelis.tera.game.models.creature.Creature;
import com.angelis.tera.game.models.creature.TeraCreature;
import com.angelis.tera.game.models.drop.Drop;
import com.angelis.tera.game.models.drop.DropItem;
import com.angelis.tera.game.models.drop.enums.ItemCategoryEnum;
import com.angelis.tera.game.models.enums.ObjectFamilyEnum;
import com.angelis.tera.game.models.enums.StorageTypeEnum;
import com.angelis.tera.game.models.group.Group;
import com.angelis.tera.game.models.item.Item;
import com.angelis.tera.game.models.player.Player;
import com.angelis.tera.game.models.visible.WorldPosition;
import com.angelis.tera.game.network.SystemMessages;
import com.angelis.tera.game.network.packet.server.SM_DROP_ITEM_LOOT;
import com.angelis.tera.game.tasks.drop.DropItemGetFreeTask;
import com.angelis.tera.game.xml.entity.creatures.CreatureDropsEntity;
import com.angelis.tera.game.xml.entity.creatures.CreatureDropsEntityHolder;

public class DropService extends AbstractService {

    /** LOGGER */
    private static Logger log = Logger.getLogger(DropService.class.getName());

    private final Map<Integer, List<Drop>> drops = new FastMap<>();

    @Override
    public void onInit() {
        final Set<CreatureDropsEntity> creatureDropEntities = XMLService.getInstance().getEntity(CreatureDropsEntityHolder.class).getCreatureDrops();
        for (final CreatureDropsEntity creatureDropEntitie : creatureDropEntities) {
            drops.put(creatureDropEntitie.getCreatureId(), MapperManager.getXMLListMapper(DropMapper.class).map(creatureDropEntitie));
        }
        XMLService.getInstance().clearEntity(CreatureDropsEntityHolder.class);

        log.info("DropService started");
    }

    @Override
    public void onDestroy() {
        drops.clear();
        log.info("DropService stopped");
    }

    public List<Drop> getLootFromCreature(final TeraCreature creature, final ItemCategoryEnum itemCategory) {
        final List<Drop> drops = new FastList<>();

        final List<Drop> creatureDrops = this.drops.get(creature.getId());
        if (creatureDrops != null && !creatureDrops.isEmpty()) {
            for (final Drop drop : creatureDrops) {
                if (drop.getItemCategory() == itemCategory) {
                    drops.add(drop);
                }
            }
        }

        return drops;
    }
    
    public final List<DropItem> generateDrop(final TeraCreature creature, final Player player) {
        final List<DropItem> dropItems = new FastList<>();

        final List<Drop> drops = this.getLootFromCreature(creature, ItemCategoryEnum.NONE);
        if (drops == null) {
            return dropItems;
        }

        if (Rnd.chance(75)) {
            final int amount = (int) (10 * CreatureService.getInstance().getExperience(creature.getLevel()) / Rnd.get(20, 60));
            if (amount > 0) {
                dropItems.add(createDropItem(creature, player, Item.MONEY_ID, creature.getWorldPosition().clone(), amount, amount));
            }
        }

        for (final Drop drop : drops) {
            int dropChance = Rnd.get(0, 100);
            dropChance *= DropConfig.DROP_CREATURE_RATE;
            if (dropChance > 100) {
                dropChance = 100;
            }

            if (drop.getDropChance().value > dropChance) {
                continue;
            }

            dropItems.add(createDropItem(creature, player, drop.getItemId(), creature.getWorldPosition().clone(), drop.getMinAmount(), drop.getMaxAmount()));
        }

        return dropItems;
    }

    public void pickupItem(final Player player, final int dropItemUid) {
        final DropItem dropItem = (DropItem) ObjectIDService.getInstance().getObjectFromUId(ObjectFamilyEnum.DROP_ITEM, dropItemUid);
        if (dropItem == null) {
            return;
        }

        if (!dropItem.isFree() && !dropItem.getOwner().equals(player)) {
            final Group group = dropItem.getOwner().getGroup();
            if (group == null || !group.equals(player.getGroup())) {
                player.getConnection().sendPacket(SystemMessages.THAT_IS_NOT_YOURS());
                return;
            }
        }

        if (StorageService.getInstance().addItem(player, player.getStorage(StorageTypeEnum.INVENTORY), dropItem.getItem().getId(), dropItem.getAmount())) {
            SpawnService.getInstance().despawnDropItem(dropItem);
            VisibleService.getInstance().sendPacketForVisible(player, new SM_DROP_ITEM_LOOT(player, dropItem, dropItem.getAmount()));
            ObjectIDService.getInstance().releaseId(ObjectFamilyEnum.DROP_ITEM, dropItemUid);
        }
    }

    private DropItem createDropItem(final Creature creature, final Player player, final int itemId, final WorldPosition worldPosition, final int minAmount, final int maxAmount) {
        final Item item = new Item(itemId);
        worldPosition.addX(Rnd.get(-50, 50));
        worldPosition.addY(Rnd.get(-50, 50));
        worldPosition.addZ(Rnd.get(-50, 50));

        int amount = minAmount;
        if (minAmount != maxAmount) {
            final int chance = Rnd.get(0, 100);
            if (chance > 50) {
                amount = maxAmount;
            }
        }

        final DropItem dropItem = new DropItem(null, creature, player, item, worldPosition, amount);
        ThreadPoolService.getInstance().scheduleTask(new DropItemGetFreeTask(dropItem), DropConfig.DROP_FREE_TIME, TimeUnit.SECONDS);
        return dropItem;
    }

    /** SINGLETON */
    public static DropService getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        protected static final DropService instance = new DropService();
    }
}
