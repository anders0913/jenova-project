package com.angelis.tera.game.xml.entity.creatures;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.angelis.tera.game.xml.entity.SpawnEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="spawn", namespace = "http://angelis.com/creature_spawns")
public class TeraCreatureSpawnEntity extends SpawnEntity {

    @XmlAttribute(name = "heading")
    private short heading;

    public short getHeading() {
        return heading;
    }
}
