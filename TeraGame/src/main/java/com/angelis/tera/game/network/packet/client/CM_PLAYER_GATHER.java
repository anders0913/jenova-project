package com.angelis.tera.game.network.packet.client;

import java.nio.ByteBuffer;

import com.angelis.tera.common.utils.PrintUtils;
import com.angelis.tera.game.models.enums.ObjectFamilyEnum;
import com.angelis.tera.game.network.connection.TeraGameConnection;
import com.angelis.tera.game.network.packet.TeraClientPacket;
import com.angelis.tera.game.services.PlayerService;

public class CM_PLAYER_GATHER extends TeraClientPacket {

    private ObjectFamilyEnum objectFamilyEnum;
    private int gatherUId;
    
    public CM_PLAYER_GATHER(final ByteBuffer byteBuffer, final TeraGameConnection connection) {
        super(byteBuffer, connection);
    }

    @Override
    protected void readImpl() {
        this.gatherUId = readD();
        this.objectFamilyEnum = ObjectFamilyEnum.fromValue(PrintUtils.bytes2hex(readB(4)));
    }

    @Override
    protected void runImpl() {
        PlayerService.getInstance().onPlayerGatherStart(this.getConnection().getActivePlayer(), this.objectFamilyEnum, this.gatherUId);
    }

}
