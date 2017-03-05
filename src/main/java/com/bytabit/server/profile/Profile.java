package com.bytabit.server.profile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "profile", indexes = {@Index(name = "profile_pubkey", columnList = "pubKey", unique = true)})
public class Profile {

    protected Profile() {
    }

    @Id
    @Column(nullable = false)
    private String pubKey;

    @Column(nullable = false)
    private Boolean isArbitrator = Boolean.FALSE;

    @Column
    private String name;

    @Column
    private String phoneNum;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;

    @Column
    private LocalDateTime removed;

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
