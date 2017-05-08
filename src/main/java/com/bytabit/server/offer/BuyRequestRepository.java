package com.bytabit.server.offer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface BuyRequestRepository extends CrudRepository<BuyRequest, String> {

    List<BuyRequest> findBySellerEscrowPubKey(String sellerEscrowPubKey);

    void deleteByBuyerEscrowPubKey(String buyerEscrowPubKey);

    void deleteBySellerEscrowPubKey(String sellerEscrowPubKey);
}
