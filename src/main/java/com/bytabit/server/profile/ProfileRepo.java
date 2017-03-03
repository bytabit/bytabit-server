package com.bytabit.server.profile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepo extends CrudRepository<Profile, Long> {

    Optional<Profile> findOneByPubKey(String pubKey);
}
