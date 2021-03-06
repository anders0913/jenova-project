package com.angelis.tera.game.xml.entity.gathers;

import java.util.Set;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javolution.util.FastSet;

import org.apache.log4j.Logger;

import com.angelis.tera.common.xml.entity.AbstractXMLEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="gather_spawns", namespace="http://angelis.com/gather_spawns")
public class GatherSpawnEntityHolder extends AbstractXMLEntity {

    private static final long serialVersionUID = 449824353877386690L;

    /** LOGGER */
    private static Logger log = Logger.getLogger(GatherSpawnEntityHolder.class.getName());
    
    @XmlElement(name="gather_spawn", namespace="http://angelis.com/gather_spawns")
    private Set<GatherSpawnEntity> gatherSpawns;
    
    public Set<GatherSpawnEntity> getGatherSpawns() {
        if (gatherSpawns == null) {
            gatherSpawns = new FastSet<>(0);
        }
        return gatherSpawns;
    }
    
    @Override
    public void afterUnmarshalling(final Unmarshaller unmarshaller) {
    }

    @Override
    public void onLoad() {
        log.info("Loaded "+getGatherSpawns().size()+" gathers !");
    }
}
