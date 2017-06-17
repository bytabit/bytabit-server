package com.bytabit.server.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class PayoutCompletedService {

    @Autowired
    private PayoutCompletedRepository payoutCompletedRepository;

    public PayoutCompleted create(String escrowAddress, PayoutCompleted payoutCompleted) {
        assert (escrowAddress.equals(payoutCompleted.getEscrowAddress()));
        PayoutCompleted newPayoutCompleted = PayoutCompleted.builder()
                .escrowAddress(payoutCompleted.getEscrowAddress())
                .payoutTxHash(payoutCompleted.getPayoutTxHash())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
        return payoutCompletedRepository.save(newPayoutCompleted);
    }

    public PayoutCompleted read(String escrowAddress) {
        return payoutCompletedRepository.findOne(escrowAddress);
    }

    public PayoutCompleted update(String escrowAddress, PayoutCompleted payoutCompleted) {
        assert (escrowAddress.equals(payoutCompleted.getEscrowAddress()));
        PayoutCompleted foundPayoutCompleted = payoutCompletedRepository.findOne(escrowAddress);
        if (foundPayoutCompleted != null) {
            PayoutCompleted.PayoutCompletedBuilder updatedPayoutCompleted = PayoutCompleted.builder()
                    .escrowAddress(foundPayoutCompleted.getEscrowAddress())
                    .payoutTxHash(foundPayoutCompleted.getPayoutTxHash())
                    .created(foundPayoutCompleted.getCreated())
                    .updated(LocalDateTime.now());
            if (payoutCompleted.getPayoutTxHash() != null) {
                updatedPayoutCompleted.payoutTxHash(payoutCompleted.getPayoutTxHash());
            }
            return payoutCompletedRepository.save(updatedPayoutCompleted.build());
        } else {
            return create(escrowAddress, payoutCompleted);
        }
    }
}
