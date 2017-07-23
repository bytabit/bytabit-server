package com.bytabit.server.trade;

import com.bytabit.server.offer.BuyRequest;
import com.bytabit.server.offer.BuyRequestService;
import com.bytabit.server.offer.SellOffer;
import com.bytabit.server.offer.SellOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TradeService {

    @Autowired
    private SellOfferService sellOfferService;

    @Autowired
    private BuyRequestService buyRequestService;

    @Autowired
    private PaymentRequestService paymentRequestService;

    @Autowired
    private PayoutRequestService payoutRequestService;

    @Autowired
    private PayoutCompletedService payoutCompletedService;

    @Autowired
    private ArbitrateRequestService arbitrateRequestService;

    public Trade read(String escrowAddress) {

        BuyRequest buyRequest = buyRequestService.read(escrowAddress);

        if (null != buyRequest && null != buyRequest.getSellerEscrowPubKey()
                && !buyRequest.getSellerEscrowPubKey().isEmpty()) {

            SellOffer sellOffer = sellOfferService.read(buyRequest.getSellerEscrowPubKey());
            PaymentRequest paymentRequest = paymentRequestService.read(escrowAddress);
            PayoutRequest payoutRequest = payoutRequestService.read(escrowAddress);
            PayoutCompleted payoutCompleted = payoutCompletedService.read(escrowAddress);
            ArbitrateRequest arbitrateRequest = arbitrateRequestService.read(escrowAddress);

            return Trade.builder()
                    .escrowAddress(buyRequest.getEscrowAddress())
                    .buyRequest(buyRequest)
                    .sellOffer(sellOffer)
                    .paymentRequest(paymentRequest)
                    .payoutRequest(payoutRequest)
                    .payoutCompleted(payoutCompleted)
                    .arbitrateRequest(arbitrateRequest)
                    .build();
        }

        return null;
    }
}
