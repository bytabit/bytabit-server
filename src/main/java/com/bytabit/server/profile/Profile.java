package com.bytabit.server.profile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "profile", indexes = {@Index(name = "profile_pubkey", columnList = "pubKey", unique = true)})
public class Profile {

    protected Profile() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String pubKey;

    @Column
    private Boolean isArbitrator;

    @Column
    private String name;

    @Column
    private String phoneNum;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;

    @Column
    private LocalDateTime removed;

    public Long getId() {
        return id;
    }

    public String getPubKey() {
        return pubKey;
    }

    public Boolean getIsArbitrator() {
        return isArbitrator;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public LocalDateTime getRemoved() {
        return removed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    public void setIsArbitrator(Boolean arbitrator) {
        isArbitrator = arbitrator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public void setRemoved(LocalDateTime removed) {
        this.removed = removed;
    }
}
