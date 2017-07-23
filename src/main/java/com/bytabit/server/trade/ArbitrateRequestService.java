package com.bytabit.server.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ArbitrateRequestService {

    @Autowired
    private ArbitrateRequestRepository arbitrateRequestRepository;

    public ArbitrateRequest create(String arbitratorProfilePubKey, ArbitrateRequest arbitrateRequest) {
        assert (arbitratorProfilePubKey.equals(arbitrateRequest.getArbitratorProfilePubKey()));
        ArbitrateRequest newArbitrateRequest = ArbitrateRequest.builder()
                .escrowAddress(arbitrateRequest.getEscrowAddress())
                .arbitratorProfilePubKey(arbitrateRequest.getArbitratorProfilePubKey())
                .reason(arbitrateRequest.getReason())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
        return arbitrateRequestRepository.save(newArbitrateRequest);
    }

    public List<ArbitrateRequest> readForArbitrator(String arbitratorProfilePubKey) {
        return arbitrateRequestRepository.findByArbitratorProfilePubKey(arbitratorProfilePubKey);
    }

    public ArbitrateRequest read(String escrowAddress) {
        return arbitrateRequestRepository.findOne(escrowAddress);
    }
}
