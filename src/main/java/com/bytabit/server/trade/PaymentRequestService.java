package com.bytabit.server.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class PaymentRequestService {

    @Autowired
    private PaymentRequestRepository paymentRequestRepository;

    public PaymentRequest create(String escrowAddress, PaymentRequest paymentRequest) {
        assert (escrowAddress.equals(paymentRequest.getEscrowAddress()));
        PaymentRequest newPaymentRequest = PaymentRequest.builder()
                .escrowAddress(paymentRequest.getEscrowAddress())
                .fundingTxHash(paymentRequest.getFundingTxHash())
                .paymentDetails(paymentRequest.getPaymentDetails())
                .refundAddress(paymentRequest.getRefundAddress())
                .refundTxSignature(paymentRequest.getRefundTxSignature())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
        return paymentRequestRepository.save(newPaymentRequest);
    }

    public PaymentRequest read(String escrowAddress) {
        return paymentRequestRepository.findOne(escrowAddress);
    }

    public PaymentRequest update(String escrowAddress, PaymentRequest paymentRequest) {
        assert (escrowAddress.equals(paymentRequest.getEscrowAddress()));
        PaymentRequest foundPaymentRequest = paymentRequestRepository.findOne(escrowAddress);
        if (foundPaymentRequest != null) {
            PaymentRequest.PaymentRequestBuilder updatedPaymentRequest = PaymentRequest.builder()
                    .escrowAddress(foundPaymentRequest.getEscrowAddress())
                    .fundingTxHash(foundPaymentRequest.getFundingTxHash())
                    .paymentDetails(foundPaymentRequest.getPaymentDetails())
                    .refundAddress(foundPaymentRequest.getRefundAddress())
                    .refundTxSignature(foundPaymentRequest.getRefundTxSignature())
                    .created(foundPaymentRequest.getCreated())
                    .updated(LocalDateTime.now());

            if (paymentRequest.getFundingTxHash() != null) {
                updatedPaymentRequest.fundingTxHash(paymentRequest.getFundingTxHash());
            }
            if (paymentRequest.getPaymentDetails() != null) {
                updatedPaymentRequest.paymentDetails(paymentRequest.getPaymentDetails());
            }
            if (paymentRequest.getRefundAddress() != null) {
                updatedPaymentRequest.refundAddress(paymentRequest.getRefundAddress());
            }
            if (paymentRequest.getRefundTxSignature() != null) {
                updatedPaymentRequest.refundTxSignature(paymentRequest.getRefundTxSignature());
            }
            return paymentRequestRepository.save(updatedPaymentRequest.build());
        } else {
            return create(escrowAddress, paymentRequest);
        }
    }
}
