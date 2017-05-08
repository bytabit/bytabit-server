package com.bytabit.server.profile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ProfileRepository extends CrudRepository<Profile, String> {

    Optional<Profile> findOneByPubKey(String pubKey);

    Iterable<Profile> findByIsArbitrator(Boolean isArbitrator);
}
