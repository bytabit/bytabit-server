package com.bytabit.server.trade;

import com.bytabit.server.offer.BuyRequest;
import com.bytabit.server.offer.SellOffer;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Trade {

    private String escrowAddress;

    private SellOffer sellOffer;

    private BuyRequest buyRequest;

    private PaymentRequest paymentRequest;

    private PayoutRequest payoutRequest;

    private PayoutCompleted payoutCompleted;

    private ArbitrateRequest arbitrateRequest;
}
