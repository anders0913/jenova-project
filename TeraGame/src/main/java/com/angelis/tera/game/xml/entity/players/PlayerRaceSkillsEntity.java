package com.angelis.tera.game.xml.entity.players;

import java.util.Set;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javolution.util.FastSet;

import com.angelis.tera.common.xml.entity.AbstractXMLEntity;
import com.angelis.tera.game.models.player.enums.RaceEnum;
import com.angelis.tera.game.xml.entity.SkillEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "player_race_skill", namespace = "http://angelis.com/player_race_skills")
public class PlayerRaceSkillsEntity extends AbstractXMLEntity {

    private static final long serialVersionUID = 1644913096394500435L;

    @XmlAttribute(name = "targetRace")
    private RaceEnum targetRace;

    @XmlElement(name = "skill", namespace = "http://angelis.com/player_race_skills")
    private Set<SkillEntity> skills;

    public RaceEnum getTargetRace() {
        return targetRace;
    }

    public Set<SkillEntity> getSkills() {
        if (skills == null) {
            skills = new FastSet<>();
        }
        return skills;
    }

    @Override
    public void afterUnmarshalling(final Unmarshaller unmarshaller) {
    }

    @Override
    public void onLoad() {
    }
}
