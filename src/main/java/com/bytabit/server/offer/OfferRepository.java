package com.bytabit.server.offer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends CrudRepository<SellOffer, Long> {

    Optional<SellOffer> findOneBySellerEscrowPubKeyAndDeletedIsNull(String pubKey);

    List<SellOffer> findByDeletedIsNull();
}
