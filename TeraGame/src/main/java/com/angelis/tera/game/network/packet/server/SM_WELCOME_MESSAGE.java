package com.angelis.tera.game.network.packet.server;

import java.nio.ByteBuffer;

import com.angelis.tera.game.config.GlobalConfig;
import com.angelis.tera.game.network.connection.TeraGameConnection;
import com.angelis.tera.game.network.packet.TeraServerPacket;

public class SM_WELCOME_MESSAGE extends TeraServerPacket {

    @Override
    protected void writeImpl(final TeraGameConnection connection, final ByteBuffer byteBuffer) {
        writeB(byteBuffer, "0C004E003F000000");
        writeS(byteBuffer, GlobalConfig.GLOBAL_WELCOME_TITLE);
        writeS(byteBuffer, "");
        writeS(byteBuffer, GlobalConfig.GLOBAL_WELCOME_CONTENT);
    }
}
