package com.bytabit.server.offer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellOfferRepository extends CrudRepository<SellOffer, String> {
}
