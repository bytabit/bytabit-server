package com.bytabit.server.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;


    public SellOffer create(SellOffer sellOffer) {
        sellOffer.setCreated(LocalDateTime.now());
        sellOffer.setUpdated(LocalDateTime.now());
        return offerRepository.save(sellOffer);
    }

    public Iterable<SellOffer> read() {
        return offerRepository.findByDeletedIsNull();
    }

    public SellOffer update(String sellerEscrowPubkey, SellOffer sellOffer) {
        Optional<SellOffer> saved = offerRepository.findOneBySellerEscrowPubKeyAndDeletedIsNull(sellerEscrowPubkey)
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
                    return offerRepository.save(o);
                });

        // TODO get or throw once exception handling in place
        return saved.orElseGet(null);
    }

    public SellOffer delete(String sellerEscrowPubkey) {
        Optional<SellOffer> saved = offerRepository.findOneBySellerEscrowPubKeyAndDeletedIsNull(sellerEscrowPubkey)
                .map(o -> {
                    o.setDeleted(LocalDateTime.now());
                    return offerRepository.save(o);
                });

        // TODO get or throw once exception handling in place
        return saved.orElseGet(null);
    }
}
