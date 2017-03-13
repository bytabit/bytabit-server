package com.bytabit.server.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;



    public Profile create(Profile profile) {
        profile.setCreated(LocalDateTime.now());
        profile.setUpdated(LocalDateTime.now());
        return profileRepo.save(profile);
    }

    public Profile update(String pubkey, Profile profile) {
        Optional<Profile> saved = profileRepo.findOneByPubKey(pubkey).map(p -> {
            if (profile.getIsArbitrator() != null) {
                p.setIsArbitrator(profile.getIsArbitrator());
            }
            if (profile.getName() != null) {
                p.setName(profile.getName());
            }
            if (profile.getPhoneNum() != null) {
                p.setPhoneNum(profile.getPhoneNum());
            }
            p.setUpdated(LocalDateTime.now());
            return profileRepo.save(p);
        });

        // TODO get or throw once exception handling in place
        return saved.orElseGet(null);
    }

    public Iterable<Profile> findAll(Boolean isArbitrator) {
        return profileRepo.findByIsArbitrator(isArbitrator);
    }
}
