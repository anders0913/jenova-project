package com.angelis.tera.game.network.packet.client;

import java.nio.ByteBuffer;

import com.angelis.tera.game.network.connection.TeraGameConnection;
import com.angelis.tera.game.network.packet.TeraClientPacket;
import com.angelis.tera.game.network.packet.server.SM_PLAYER_DONJON_CLEAR_COUNT_LIST;
import com.angelis.tera.game.services.PlayerService;

public class CM_PLAYER_DONJON_CLEAR_COUNT_LIST extends TeraClientPacket {

    private String playerName;

    public CM_PLAYER_DONJON_CLEAR_COUNT_LIST(final ByteBuffer byteBuffer, final TeraGameConnection connection) {
        super(byteBuffer, connection);
    }

    @Override
    protected void readImpl() {
        this.playerName = readS();
    }

    @Override
    protected void runImpl() {
        this.getConnection().sendPacket(new SM_PLAYER_DONJON_CLEAR_COUNT_LIST(PlayerService.getInstance().findPlayerByName(playerName)));
    }

}
