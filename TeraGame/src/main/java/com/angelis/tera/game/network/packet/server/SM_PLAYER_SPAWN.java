package com.angelis.tera.game.network.packet.server;

import java.nio.ByteBuffer;

import com.angelis.tera.game.models.enums.StorageTypeEnum;
import com.angelis.tera.game.models.player.Player;
import com.angelis.tera.game.models.player.enums.PlayerRelationEnum;
import com.angelis.tera.game.models.storage.Storage;
import com.angelis.tera.game.models.storage.enums.InventorySlotEnum;
import com.angelis.tera.game.models.visible.WorldPosition;
import com.angelis.tera.game.network.connection.TeraGameConnection;
import com.angelis.tera.game.network.packet.TeraServerPacket;

public class SM_PLAYER_SPAWN extends TeraServerPacket {

    private final Player player;
    private final PlayerRelationEnum playerRelation;
    
    public SM_PLAYER_SPAWN(final Player player, final PlayerRelationEnum playerRelation) {
        this.player = player;
        this.playerRelation = playerRelation;
    }
    
    @Override
    protected void writeImpl(final TeraGameConnection connection, final ByteBuffer byteBuffer) {
        writeH(byteBuffer, 0); // Name shift
        writeH(byteBuffer, 0); // Legion shift
        writeH(byteBuffer, 0); // Unk1 shift
        writeH(byteBuffer, 0); // Details shift
 
        writeH(byteBuffer, (short) this.player.getPlayerAppearance().getDetails1().length); // 2000
        writeH(byteBuffer, 0); // Unk2 shift
        writeH(byteBuffer, 0); // Unk3 shift
        writeH(byteBuffer, 0); // Unk4 shift
        writeH(byteBuffer, (short) this.player.getPlayerAppearance().getDetails2().length); // 4000

        writeD(byteBuffer, 14);
        writeD(byteBuffer, this.player.getId());

        writeUid(byteBuffer, this.player);

        final WorldPosition worldPosition = this.player.getWorldPosition();
        writeF(byteBuffer, worldPosition.getX());
        writeF(byteBuffer, worldPosition.getY());
        writeF(byteBuffer, worldPosition.getZ());
        writeH(byteBuffer, worldPosition.getHeading());

        writeD(byteBuffer, this.playerRelation.getValue());
        writeD(byteBuffer, this.player.getRaceGenderClassValue());

        writeB(byteBuffer, "00007800AA00000000000101"); //???

        writeB(byteBuffer, this.player.getPlayerAppearance().getData());

        final Storage storage = this.player.getStorage(StorageTypeEnum.INVENTORY);
        writeD(byteBuffer, storage.getStorageItemByInventorySlot(InventorySlotEnum.WEAPON, Storage.NEW_STORAGE_ITEM).getItemId());
        writeD(byteBuffer, storage.getStorageItemByInventorySlot(InventorySlotEnum.ARMOR, Storage.NEW_STORAGE_ITEM).getItemId());
        writeD(byteBuffer, storage.getStorageItemByInventorySlot(InventorySlotEnum.GLOVES, Storage.NEW_STORAGE_ITEM).getItemId());
        writeD(byteBuffer, storage.getStorageItemByInventorySlot(InventorySlotEnum.FOOT, Storage.NEW_STORAGE_ITEM).getItemId());
        writeD(byteBuffer, storage.getStorageItemByInventorySlot(InventorySlotEnum.HAIR, Storage.NEW_STORAGE_ITEM).getItemId());
        writeD(byteBuffer, storage.getStorageItemByInventorySlot(InventorySlotEnum.FACE, Storage.NEW_STORAGE_ITEM).getItemId());

        writeC(byteBuffer, 1);
        
        writeD(byteBuffer, 0);
        writeD(byteBuffer, 0);
        writeD(byteBuffer, 0);
        writeD(byteBuffer, 0);
        writeD(byteBuffer, 0);
        writeD(byteBuffer, 0);
        writeD(byteBuffer, 0);
        writeD(byteBuffer, 0);
        
        writeD(byteBuffer, 0);
        writeD(byteBuffer, 0);
        writeD(byteBuffer, 0);
        
        writeD(byteBuffer, storage.getStorageItemByInventorySlot(InventorySlotEnum.HAIR_DECORATION, Storage.NEW_STORAGE_ITEM).getItemId());
        writeD(byteBuffer, storage.getStorageItemByInventorySlot(InventorySlotEnum.MASK, Storage.NEW_STORAGE_ITEM).getItemId());
        writeD(byteBuffer, storage.getStorageItemByInventorySlot(InventorySlotEnum.BACK, Storage.NEW_STORAGE_ITEM).getItemId());
        writeD(byteBuffer, storage.getStorageItemByInventorySlot(InventorySlotEnum.WEAPON_APPEARANCE, Storage.NEW_STORAGE_ITEM).getItemId());
        writeD(byteBuffer, storage.getStorageItemByInventorySlot(InventorySlotEnum.ARMOR_APPEARANCE, Storage.NEW_STORAGE_ITEM).getItemId());
        writeD(byteBuffer, 0); //Unk possible Item?
        
        writeH(byteBuffer, 0);
        writeH(byteBuffer, 0);
        writeD(byteBuffer, this.player.getLevel());
        writeB(byteBuffer, "000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000640000000000803F");

        this.writeBufferPosition(byteBuffer, 4, Size.H);
        writeS(byteBuffer, this.player.getName()); //Name

        this.writeBufferPosition(byteBuffer, 6, Size.H);
        writeS(byteBuffer, this.player.getGuild() != null ? this.player.getGuild().getName() : "");

        this.writeBufferPosition(byteBuffer, 8, Size.H);
        writeS(byteBuffer, ""); //Unk1

        this.writeBufferPosition(byteBuffer, 10, Size.H);
        writeB(byteBuffer, this.player.getPlayerAppearance().getDetails1());
        writeB(byteBuffer, this.player.getPlayerAppearance().getDetails2());

        this.writeBufferPosition(byteBuffer, 14, Size.H);
        writeS(byteBuffer, ""); //Unk2

        this.writeBufferPosition(byteBuffer, 16, Size.H);
        writeS(byteBuffer, ""); // TODO guild title
        
        this.writeBufferPosition(byteBuffer, 18, Size.H);
    }
}
