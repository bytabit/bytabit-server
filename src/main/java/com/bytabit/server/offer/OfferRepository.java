package com.bytabit.server.offer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {

    Optional<Offer> findOneByPubKey(String pubKey);
}
