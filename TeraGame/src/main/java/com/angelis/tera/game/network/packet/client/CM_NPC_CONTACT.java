package com.angelis.tera.game.network.packet.client;

import java.nio.ByteBuffer;

import com.angelis.tera.game.network.connection.TeraGameConnection;
import com.angelis.tera.game.network.packet.TeraClientPacket;
import com.angelis.tera.game.services.DialogService;

public class CM_NPC_CONTACT extends TeraClientPacket {

    private int npcId;
    public CM_NPC_CONTACT(final ByteBuffer byteBuffer, final TeraGameConnection connection) {
        super(byteBuffer, connection);
    }
    
    @Override
    protected void readImpl() {
        this.npcId = readD();
        readD(); // object familly
    }

    @Override
    protected void runImpl() {
        DialogService.getInstance().onNpcContact(this.getConnection().getActivePlayer(), this.npcId);
    }
}
