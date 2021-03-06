package com.angelis.tera.game.network.packet;

import java.nio.ByteBuffer;

import com.angelis.tera.common.network.packet.AbstractClientPacket;
import com.angelis.tera.game.models.visible.WorldPosition;
import com.angelis.tera.game.network.connection.TeraGameConnection;

public abstract class TeraClientPacket extends AbstractClientPacket<TeraGameConnection> {

    public TeraClientPacket(final ByteBuffer byteBuffer, final TeraGameConnection connection) {
        super(byteBuffer, connection);
    }
    
    public WorldPosition readWorldPosition() {
        final WorldPosition worldPosition = new WorldPosition();
        worldPosition.setX(readF());
        worldPosition.setY(readF());
        worldPosition.setZ(readF());
        worldPosition.setHeading(readH());
        
        return worldPosition;
    }
}
