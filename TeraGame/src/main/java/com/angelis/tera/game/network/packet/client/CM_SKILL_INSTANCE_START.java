package com.angelis.tera.game.network.packet.client;

import java.nio.ByteBuffer;

import com.angelis.tera.common.utils.Point3D;
import com.angelis.tera.game.models.creature.Creature;
import com.angelis.tera.game.models.enums.ObjectFamilyEnum;
import com.angelis.tera.game.models.skill.SkillArgs;
import com.angelis.tera.game.network.connection.TeraGameConnection;
import com.angelis.tera.game.network.packet.TeraClientPacket;
import com.angelis.tera.game.services.ObjectIDService;
import com.angelis.tera.game.services.SkillService;

public class CM_SKILL_INSTANCE_START extends TeraClientPacket {

    private final SkillArgs skillArgs = new SkillArgs();

    public CM_SKILL_INSTANCE_START(final ByteBuffer byteBuffer, final TeraGameConnection connection) {
        super(byteBuffer, connection);
    }

    @Override
    protected void readImpl() {
        final int count = readH();
        readH();
        readD();
        this.skillArgs.setSkillId(readD() - 0x4000000);

        this.skillArgs.setStartPosition(readWorldPosition());

        readD();
        readC();

        final Point3D endPosition = new Point3D();
        endPosition.setX(readF());
        endPosition.setY(readF());
        endPosition.setZ(readF());
        this.skillArgs.setEndPosition(endPosition);

        for (int i = 0 ; i < count ; i++) {
            readD(); // shifts

            readD(); // familly
            final int uid = readD();

            final Creature creature = (Creature) ObjectIDService.getInstance().getObjectFromUId(ObjectFamilyEnum.CREATURE, uid);
            if (creature != null) {
                //skillArgs.setTarget(creature);
            }
        }
    }

    @Override
    protected void runImpl() {
        SkillService.getInstance().onPlayerSkillInstanceUse(this.getConnection().getActivePlayer(), this.skillArgs);
    }
}
