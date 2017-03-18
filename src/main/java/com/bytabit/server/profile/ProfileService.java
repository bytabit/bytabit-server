package com.bytabit.server.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepo;


    public Profile create(Profile profile) {
        profile.setCreated(LocalDateTime.now());
        profile.setUpdated(LocalDateTime.now());
        return profileRepo.save(profile);
    }

    public Iterable<Profile> read(Boolean isArbitrator) {
        if (isArbitrator == null) {
            return profileRepo.findAll();
        } else {
            return profileRepo.findByIsArbitrator(isArbitrator);
        }
    }

    public Profile update(String pubkey, Profile profile) {
        Optional<Profile> found = profileRepo.findOneByPubKey(pubkey);

        if (found.isPresent()) {
            if (profile.getIsArbitrator() != null) {
                found.get().setIsArbitrator(profile.getIsArbitrator());
            }
            if (profile.getName() != null) {
                found.get().setName(profile.getName());
            }
            if (profile.getPhoneNum() != null) {
                found.get().setPhoneNum(profile.getPhoneNum());
            }
            found.get().setUpdated(LocalDateTime.now());
            return profileRepo.save(found.get());
        } else {
            // if not found create new
            profile.setPubKey(pubkey);
            return create(profile);
        }
    }
}
