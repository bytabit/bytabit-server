package com.bytabit.server.profile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Profile {

    protected Profile() {
    }

    @Id
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
    private LocalDateTime deleted;

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

    public LocalDateTime getDeleted() {
        return deleted;
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

    public void setDeleted(LocalDateTime deleted) {
        this.deleted = deleted;
    }
}
