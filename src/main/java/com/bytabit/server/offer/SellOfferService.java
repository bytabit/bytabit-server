package com.bytabit.server.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SellOfferService {

    @Autowired
    private SellOfferRepository sellOfferRepository;

    public SellOffer create(SellOffer sellOffer) {
        sellOffer.setCreated(LocalDateTime.now());
        sellOffer.setUpdated(LocalDateTime.now());
        return sellOfferRepository.save(sellOffer);
    }

    public Iterable<SellOffer> read() {
        return sellOfferRepository.findAll();
    }

    public SellOffer update(String sellerEscrowPubkey, SellOffer sellOffer) {
        SellOffer saved = sellOfferRepository.findOne(sellerEscrowPubkey);
        if (saved != null) {
            if (sellOffer.getCurrencyCode() != null) {
                saved.setCurrencyCode(sellOffer.getCurrencyCode());
            }
            if (sellOffer.getPaymentMethod() != null) {
                saved.setPaymentMethod(sellOffer.getPaymentMethod());
            }
            if (sellOffer.getMinAmount() != null) {
                saved.setMinAmount(sellOffer.getMinAmount());
            }
            if (sellOffer.getMaxAmount() != null) {
                saved.setMaxAmount(sellOffer.getMaxAmount());
            }
            if (sellOffer.getPrice() != null) {
                saved.setPrice(sellOffer.getPrice());
            }
            saved.setUpdated(LocalDateTime.now());
            return sellOfferRepository.save(saved);
        }
        // TODO get or throw once exception handling in place
        return saved;
    }

    public void delete(String sellerEscrowPubkey) {
        sellOfferRepository.delete(sellerEscrowPubkey);
    }
}
