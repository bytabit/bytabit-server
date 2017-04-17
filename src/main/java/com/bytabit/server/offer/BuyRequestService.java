package com.bytabit.server.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BuyRequestService {

    @Autowired
    private BuyRequestRepository buyRequestRepository;

    public BuyRequest create(String sellerEscrowPubkey, BuyRequest buyRequest) {
        assert (sellerEscrowPubkey.equals(buyRequest.getSellerEscrowPubKey()));
        buyRequest.setCreated(LocalDateTime.now());
        buyRequest.setUpdated(LocalDateTime.now());
        return buyRequestRepository.save(buyRequest);
    }

    public List<BuyRequest> read(String sellerEscrowPubKey) {
        return buyRequestRepository.findBySellerEscrowPubKey(sellerEscrowPubKey);
    }
}
