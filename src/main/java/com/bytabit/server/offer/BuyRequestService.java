package com.bytabit.server.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BuyRequestService {

    @Autowired
    private BuyRequestRepository buyRequestRepository;

    public BuyRequest create(BuyRequest buyRequest) {
        buyRequest.setCreated(LocalDateTime.now());
        buyRequest.setUpdated(LocalDateTime.now());
        return buyRequestRepository.save(buyRequest);
    }
}
