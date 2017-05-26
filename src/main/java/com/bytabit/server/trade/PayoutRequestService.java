package com.bytabit.server.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class PayoutRequestService {

    @Autowired
    private PayoutRequestRepository payoutRequestRepository;

    public PayoutRequest create(String escrowAddress, PayoutRequest payoutRequest) {
        assert (escrowAddress.equals(payoutRequest.getEscrowAddress()));
        PayoutRequest newPayoutRequest = PayoutRequest.builder()
                .escrowAddress(payoutRequest.getEscrowAddress())
                .paymentReference(payoutRequest.getPaymentReference())
                .payoutTxSignature(payoutRequest.getPayoutTxSignature())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
        return payoutRequestRepository.save(newPayoutRequest);
    }

    public PayoutRequest read(String escrowAddress) {
        return payoutRequestRepository.findOne(escrowAddress);
    }

    public PayoutRequest update(String escrowAddress, PayoutRequest payoutRequest) {
        assert (escrowAddress.equals(payoutRequest.getEscrowAddress()));
        PayoutRequest foundPayoutRequest = payoutRequestRepository.findOne(escrowAddress);
        if (foundPayoutRequest != null) {
            PayoutRequest.PayoutRequestBuilder updatedPayoutRequest = PayoutRequest.builder()
                    .escrowAddress(foundPayoutRequest.getEscrowAddress())
                    .paymentReference(foundPayoutRequest.getPaymentReference())
                    .payoutTxSignature(foundPayoutRequest.getPayoutTxSignature())
                    .created(foundPayoutRequest.getCreated())
                    .updated(LocalDateTime.now());
            if (payoutRequest.getPaymentReference() != null) {
                updatedPayoutRequest.paymentReference(payoutRequest.getPaymentReference());
            }
            if (payoutRequest.getPayoutTxSignature() != null) {
                updatedPayoutRequest.payoutTxSignature(payoutRequest.getPayoutTxSignature());
            }
            return payoutRequestRepository.save(updatedPayoutRequest.build());
        } else {
            return create(escrowAddress, payoutRequest);
        }
    }
}
