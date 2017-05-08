package com.bytabit.server.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    public Profile create(Profile profile) {
        Profile newProfile = Profile.builder()
                .pubKey(profile.getPubKey())
                .name(profile.getName())
                .phoneNum(profile.getPhoneNum())
                .isArbitrator(profile.getIsArbitrator())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();

        return profileRepository.save(newProfile);
    }

    public Iterable<Profile> read(Boolean isArbitrator) {
        if (isArbitrator == null) {
            return profileRepository.findAll();
        } else {
            return profileRepository.findByIsArbitrator(isArbitrator);
        }
    }

    public Profile update(String pubkey, Profile profile) {
        Optional<Profile> foundProfile = profileRepository.findOneByPubKey(pubkey);
        if (foundProfile.isPresent()) {
            Profile.ProfileBuilder updatedProfile = Profile.builder()
                    .pubKey(foundProfile.get().getPubKey())
                    .name(foundProfile.get().getName())
                    .phoneNum(foundProfile.get().getPhoneNum())
                    .isArbitrator(foundProfile.get().getIsArbitrator())
                    .created(foundProfile.get().getCreated())
                    .updated(LocalDateTime.now());

            if (profile.getIsArbitrator() != null) {
                updatedProfile.isArbitrator(profile.getIsArbitrator());
            }
            if (profile.getName() != null) {
                updatedProfile.name(profile.getName());
            }
            if (profile.getPhoneNum() != null) {
                updatedProfile.phoneNum(profile.getPhoneNum());
            }
            return profileRepository.save(updatedProfile.build());
        } else {
            // if not found create new
            return create(profile);
        }
    }
}
