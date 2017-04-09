package com.bytabit.server.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private SellOfferRepository sellOfferRepository;

    @Autowired
    private BuyRequestRepository buyRequestRepository;

    public SellOffer create(SellOffer sellOffer) {
        sellOffer.setCreated(LocalDateTime.now());
        sellOffer.setUpdated(LocalDateTime.now());
        return sellOfferRepository.save(sellOffer);
    }

    public BuyRequest create(BuyRequest buyRequest) {
        buyRequest.setCreated(LocalDateTime.now());
        buyRequest.setUpdated(LocalDateTime.now());
        return buyRequestRepository.save(buyRequest);
    }

    public Iterable<SellOffer> read() {
        return sellOfferRepository.findByDeletedIsNull();
    }

    public SellOffer update(String sellerEscrowPubkey, SellOffer sellOffer) {
        Optional<SellOffer> saved = sellOfferRepository.findOneBySellerEscrowPubKeyAndDeletedIsNull(sellerEscrowPubkey)
                .map(o -> {
                    if (sellOffer.getCurrencyCode() != null) {
                        o.setCurrencyCode(sellOffer.getCurrencyCode());
                    }
                    if (sellOffer.getPaymentMethod() != null) {
                        o.setPaymentMethod(sellOffer.getPaymentMethod());
                    }
                    if (sellOffer.getMinAmount() != null) {
                        o.setMinAmount(sellOffer.getMinAmount());
                    }
                    if (sellOffer.getMaxAmount() != null) {
                        o.setMaxAmount(sellOffer.getMaxAmount());
                    }
                    if (sellOffer.getPrice() != null) {
                        o.setPrice(sellOffer.getPrice());
                    }
                    o.setUpdated(LocalDateTime.now());
                    return sellOfferRepository.save(o);
                });

        // TODO get or throw once exception handling in place
        return saved.orElseGet(null);
    }

    public SellOffer delete(String sellerEscrowPubkey) {
        Optional<SellOffer> saved = sellOfferRepository.findOneBySellerEscrowPubKeyAndDeletedIsNull(sellerEscrowPubkey)
                .map(o -> {
                    o.setDeleted(LocalDateTime.now());
                    return sellOfferRepository.save(o);
                });

        // TODO get or throw once exception handling in place
        return saved.orElseGet(null);
    }
}
