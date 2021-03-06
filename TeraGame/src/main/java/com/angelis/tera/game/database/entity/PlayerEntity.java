package com.angelis.tera.game.database.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.angelis.tera.common.database.entity.AbstractDatabaseEntity;
import com.angelis.tera.game.models.player.enums.GenderEnum;
import com.angelis.tera.game.models.player.enums.PlayerClassEnum;
import com.angelis.tera.game.models.player.enums.PlayerModeEnum;
import com.angelis.tera.game.models.player.enums.RaceEnum;

@Entity
@Table(name = "players")
public class PlayerEntity extends AbstractDatabaseEntity {

    private static final long serialVersionUID = 1630861678711998407L;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Enumerated(EnumType.STRING)
    private RaceEnum race;

    @Enumerated(EnumType.STRING)
    private PlayerClassEnum playerClass;

    @Column
    private int level;

    @Column
    private long experience;

    @Column
    private int currentRestedExperience;
    
    @Column
    private int maxRestedExperience;
    
    @Column()
    private int money;

    @Column
    private int hp;
    
    @Column
    private int mp;
    
    @Column
    private int stamina;

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletionTime;

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastOnlineTime;

    @Column()
    private String description;

    @Column(length=1000)
    private byte[] userSettings;

    @Column()
    private int mapId;

    @Column()
    private float x;

    @Column()
    private float y;

    @Column()
    private float z;

    @Column()
    private short heading;

    @Column()
    private byte[] data;

    @Column()
    private byte[] details1;

    @Column()
    private byte[] details2;

    @Column()
    private boolean online;

    @Column
    private int title;

    @Column()
    private PlayerModeEnum playerMode;

    @Column()
    private byte[] zoneData;

    @ManyToOne(optional = true)
    private GuildEntity guild;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<StorageEntity> storages;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "player")
    private Set<CraftEntity> crafts;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "player")
    private Set<GatherEntity> gathers;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "player")
    private Set<SkillEntity> skills;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "player")
    private Set<QuestEntity> quests;

    // @ManyToMany(mappedBy="owner")
    @Transient
    private List<FriendEntity> friends;

    // @ManyToMany(mappedBy="owner")
    @Transient
    private List<BlockEntity> blockeds;

    public PlayerEntity(final Integer id) {
        super(id);
    }

    public PlayerEntity() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(final GenderEnum gender) {
        this.gender = gender;
    }

    public RaceEnum getRace() {
        return race;
    }

    public void setRace(final RaceEnum race) {
        this.race = race;
    }

    public PlayerClassEnum getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(final PlayerClassEnum playerClass) {
        this.playerClass = playerClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int i) {
        this.level = i;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(final long experience) {
        this.experience = experience;
    }

    public int getCurrentRestedExperience() {
        return currentRestedExperience;
    }

    public void setCurrentRestedExperience(final int currentRestedExperience) {
        this.currentRestedExperience = currentRestedExperience;
    }

    public int getMaxRestedExperience() {
        return maxRestedExperience;
    }

    public void setMaxRestedExperience(final int maxRestedExperience) {
        this.maxRestedExperience = maxRestedExperience;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(final int money) {
        this.money = money;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(final int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(final int mp) {
        this.mp = mp;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(final int stamina) {
        this.stamina = stamina;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(final Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getDeletionTime() {
        return deletionTime;
    }

    public void setDeletionTime(final Date deletionTime) {
        this.deletionTime = deletionTime;
    }

    public Date getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime(final Date lastOnlineTime) {
        this.lastOnlineTime = lastOnlineTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public byte[] getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(final byte[] userSettings) {
        this.userSettings = userSettings;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(final int mapId) {
        this.mapId = mapId;
    }

    public float getX() {
        return x;
    }

    public void setX(final float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(final float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(final float z) {
        this.z = z;
    }

    public short getHeading() {
        return heading;
    }

    public void setHeading(final short heading) {
        this.heading = heading;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(final byte[] data) {
        this.data = data;
    }

    public byte[] getDetails1() {
        return details1;
    }

    public void setDetails1(final byte[] details1) {
        this.details1 = details1;
    }

    public byte[] getDetails2() {
        return details2;
    }

    public void setDetails2(final byte[] details2) {
        this.details2 = details2;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(final boolean online) {
        this.online = online;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(final int title) {
        this.title = title;
    }

    public PlayerModeEnum getPlayerMode() {
        return playerMode;
    }

    public void setPlayerMode(final PlayerModeEnum playerMode) {
        this.playerMode = playerMode;
    }

    public byte[] getZoneData() {
        return zoneData;
    }

    public void setZoneData(final byte[] zoneData) {
        this.zoneData = zoneData;
    }

    public GuildEntity getGuild() {
        return guild;
    }

    public void setGuild(final GuildEntity guild) {
        this.guild = guild;
    }

    public Set<StorageEntity> getStorages() {
        return storages;
    }

    public void setStorages(final Set<StorageEntity> storages) {
        this.storages = storages;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(final AccountEntity account) {
        this.account = account;
    }

    public Set<CraftEntity> getCrafts() {
        return crafts;
    }

    public void setCrafts(final Set<CraftEntity> crafts) {
        this.crafts = crafts;
    }

    public Set<GatherEntity> getGathers() {
        return gathers;
    }

    public void setGathers(final Set<GatherEntity> gathers) {
        this.gathers = gathers;
    }

    public Set<SkillEntity> getSkills() {
        return skills;
    }

    public void setSkills(final Set<SkillEntity> skills) {
        this.skills = skills;
    }

    public Set<QuestEntity> getQuests() {
        return quests;
    }

    public void setQuests(final Set<QuestEntity> quests) {
        this.quests = quests;
    }

    public List<FriendEntity> getFriends() {
        return friends;
    }

    public void setFriends(final List<FriendEntity> friends) {
        this.friends = friends;
    }

    public List<BlockEntity> getBlockeds() {
        return blockeds;
    }

    public void setBlockeds(final List<BlockEntity> blockeds) {
        this.blockeds = blockeds;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof PlayerEntity)) {
            return false;
        }
        final PlayerEntity other = (PlayerEntity) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }
}
