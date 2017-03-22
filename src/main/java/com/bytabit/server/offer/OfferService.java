package com.bytabit.server.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;


    public Offer create(Offer offer) {
        offer.setCreated(LocalDateTime.now());
        offer.setUpdated(LocalDateTime.now());
        return offerRepository.save(offer);
    }

    public Iterable<Offer> read() {
        return offerRepository.findByDeletedIsNull();
    }

    public Offer update(String pubkey, Offer offer) {
        Optional<Offer> saved = offerRepository.findOneByPubKeyAndDeletedIsNull(pubkey)
                .map(o -> {
                    if (offer.getCurrencyCode() != null) {
                        o.setCurrencyCode(offer.getCurrencyCode());
                    }
                    if (offer.getPaymentMethod() != null) {
                        o.setPaymentMethod(offer.getPaymentMethod());
                    }
                    if (offer.getMinAmount() != null) {
                        o.setMinAmount(offer.getMinAmount());
                    }
                    if (offer.getMaxAmount() != null) {
                        o.setMaxAmount(offer.getMaxAmount());
                    }
                    if (offer.getPrice() != null) {
                        o.setPrice(offer.getPrice());
                    }
                    o.setUpdated(LocalDateTime.now());
                    return offerRepository.save(o);
                });

        // TODO get or throw once exception handling in place
        return saved.orElseGet(null);
    }

    public Offer delete(String pubkey) {
        Optional<Offer> saved = offerRepository.findOneByPubKeyAndDeletedIsNull(pubkey)
                .map(o -> {
                    o.setDeleted(LocalDateTime.now());
                    return offerRepository.save(o);
                });

        // TODO get or throw once exception handling in place
        return saved.orElseGet(null);
    }
}