package com.bytabit.server.profile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

    Optional<Profile> findOneByPubKey(String pubKey);

    Iterable<Profile> findByIsArbitrator(Boolean isArbitrator);
}
