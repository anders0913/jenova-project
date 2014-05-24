package com.angelis.tera.game.network.packet.client;

import java.nio.ByteBuffer;

import com.angelis.tera.game.models.player.Player;
import com.angelis.tera.game.models.player.request.PartyInviteRequest;
import com.angelis.tera.game.models.player.request.Request;
import com.angelis.tera.game.models.player.request.enums.RequestTypeEnum;
import com.angelis.tera.game.network.connection.TeraGameConnection;
import com.angelis.tera.game.network.packet.TeraClientPacket;
import com.angelis.tera.game.services.RequestService;
import com.angelis.tera.game.services.WorldService;

public class CM_PLAYER_REQUEST extends TeraClientPacket {

    private Request request;
    
    public CM_PLAYER_REQUEST(final ByteBuffer byteBuffer, final TeraGameConnection connection) {
        super(byteBuffer, connection);
    }

    @Override
    protected void readImpl() {
        final short nameShift = (short) (readH()-4);
        readH(); //unk shift

        final RequestTypeEnum requestType = RequestTypeEnum.fromValue(readH());
        switch (requestType) {
            case PARTY_INVITE:
                for (int i = 8 ; i < nameShift ; i++) {
                    readC();
                }
                
                final String playerName = readS();
                final Player targetPlayer = WorldService.getInstance().getOnlinePlayerWithName(playerName);
                this.request = new PartyInviteRequest(this.getConnection().getActivePlayer(), targetPlayer);
                readC();
            break;
            
            case DUEL:
                // TODO
            break;
            
            case PEGASUS:
                // TODO
            break;
        }
    }

    @Override
    protected void runImpl() {
        RequestService.getInstance().onPlayerRequest(this.getConnection().getActivePlayer(), this.request);
    }
}
