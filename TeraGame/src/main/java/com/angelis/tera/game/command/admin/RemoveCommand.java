package com.angelis.tera.game.command.admin;

import com.angelis.tera.game.command.AdminErrorMessageEnum;
import com.angelis.tera.game.controllers.enums.RightEnum;
import com.angelis.tera.game.models.account.Account;
import com.angelis.tera.game.models.enums.StorageTypeEnum;
import com.angelis.tera.game.models.player.Player;
import com.angelis.tera.game.models.player.craft.enums.CraftTypeEnum;
import com.angelis.tera.game.models.player.gather.enums.GatherTypeEnum;
import com.angelis.tera.game.models.storage.Storage;
import com.angelis.tera.game.network.connection.TeraGameConnection;
import com.angelis.tera.game.network.packet.server.SM_PLAYER_STATS;
import com.angelis.tera.game.services.CraftService;
import com.angelis.tera.game.services.GatherService;
import com.angelis.tera.game.services.PlayerService;
import com.angelis.tera.game.services.SkillService;
import com.angelis.tera.game.services.StorageService;
import com.angelis.tera.game.services.WorldService;

public class RemoveCommand extends AbstractAdminCommand {

    private enum CommandEnum {
        RIGHT,
        CRAFT,
        GATHER,
        MONEY,
        ITEM,
        STORAGE,
        SKILL
    }
    
    @Override
    public void execute(final TeraGameConnection connection, final String[] arguments) {
        final Player targetPlayer = WorldService.getInstance().getOnlinePlayerWithName(arguments[1]);
        if (targetPlayer == null) {
            this.sendTranslatedErrorMessage(connection, AdminErrorMessageEnum.TARGET_NOT_FOUND.key);
            return;
        }
        
        final Account targetAccount = targetPlayer.getAccount();
        if (targetAccount.getAccess() > connection.getAccount().getAccess()) {
            this.sendTranslatedErrorMessage(connection, AdminErrorMessageEnum.TARGET_HAS_MORE_RIGHTS_THAN_YOU.key);
            return;
        }
        
        final CommandEnum command = CommandEnum.valueOf(arguments[0].toUpperCase());
        switch (command) {
            case RIGHT:
                targetPlayer.getController().removeRight(RightEnum.valueOf(arguments[2].toUpperCase()));
                targetPlayer.getConnection().sendPacket(new SM_PLAYER_STATS(targetPlayer));
                targetPlayer.getKnownList().update();
            break;
            
            case CRAFT:
                CraftService.getInstance().unlearnCraft(targetPlayer, CraftTypeEnum.valueOf(arguments[2].toUpperCase()), Integer.valueOf(arguments[3]));
            break;
            
            case GATHER:
                GatherService.getInstance().unlearnGather(targetPlayer, GatherTypeEnum.valueOf(arguments[2].toUpperCase()), Integer.valueOf(arguments[3]));
            break;
            
            case MONEY:
                PlayerService.getInstance().removeMoney(targetPlayer, Integer.valueOf(arguments[2]));
            break;
            
            case ITEM:
                final Storage storage = targetPlayer.getStorage(StorageTypeEnum.INVENTORY);
                StorageService.getInstance().removeItem(targetPlayer, storage, Integer.valueOf(arguments[2]), Integer.valueOf(arguments[3]));
            break;
            
            case STORAGE:
                StorageService.getInstance().downgradeInventory(targetPlayer, targetPlayer.getStorage(StorageTypeEnum.INVENTORY));
            break;
            
            case SKILL:
                SkillService.getInstance().unlearnSkill(targetPlayer, Integer.valueOf(arguments[2]));
            break;
        }
    }
    
    @Override
    public int getAccessLevel() {
        return 1;
    }

    @Override
    public int getArgumentCount() {
        return 3;
    }

    @Override
    public boolean checkArguments(final String[] arguments) {
        try {
            CommandEnum.valueOf(arguments[0].toUpperCase());
            return true;
        } catch (final Exception e) {
            return false;
        }
    }

    @Override
    public String getSyntax() {
        return "remove {right | craft | gather} [targetName] [value]";
    }
}