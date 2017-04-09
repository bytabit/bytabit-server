package com.bytabit.server.offer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyRequestRepository extends CrudRepository<BuyRequest, Long> {

    List<BuyRequest> findBySellerEscrowPubKeyAndDeletedIsNull(String pubKey);

    List<BuyRequest> findByDeletedIsNull();
}
