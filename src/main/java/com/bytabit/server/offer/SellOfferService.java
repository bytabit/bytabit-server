package com.bytabit.server.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class SellOfferService {

    private final SellOfferRepository sellOfferRepository;

    @Autowired
    public SellOfferService(SellOfferRepository sellOfferRepository) {
        this.sellOfferRepository = sellOfferRepository;
    }

    public SellOffer create(SellOffer sellOffer) {
        SellOffer newSellOffer = SellOffer.builder()
                .sellerProfilePubKey(sellOffer.getSellerProfilePubKey())
                .sellerEscrowPubKey(sellOffer.getSellerEscrowPubKey())
                .arbitratorProfilePubKey(sellOffer.getArbitratorProfilePubKey())
                .currencyCode(sellOffer.getCurrencyCode())
                .paymentMethod(sellOffer.getPaymentMethod())
                .price(sellOffer.getPrice())
                .minAmount(sellOffer.getMinAmount())
                .maxAmount(sellOffer.getMaxAmount())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
        return sellOfferRepository.save(newSellOffer);
    }

    public Iterable<SellOffer> read() {
        return sellOfferRepository.findAll();
    }

    public SellOffer update(String sellerEscrowPubkey, SellOffer sellOffer) {
        assert (sellerEscrowPubkey.equals(sellOffer.getSellerEscrowPubKey()));
        SellOffer foundSellOffer = sellOfferRepository.findOne(sellerEscrowPubkey);
        if (foundSellOffer != null) {
            SellOffer.SellOfferBuilder updatedSellOffer = SellOffer.builder();
            updatedSellOffer
                    .sellerProfilePubKey(foundSellOffer.getSellerProfilePubKey())
                    .sellerEscrowPubKey(foundSellOffer.getSellerEscrowPubKey())
                    .arbitratorProfilePubKey(foundSellOffer.getArbitratorProfilePubKey())
                    .currencyCode(foundSellOffer.getCurrencyCode())
                    .paymentMethod(foundSellOffer.getPaymentMethod())
                    .price(foundSellOffer.getPrice())
                    .minAmount(foundSellOffer.getMinAmount())
                    .maxAmount(foundSellOffer.getMaxAmount())
                    .created(foundSellOffer.getCreated())
                    .updated(LocalDateTime.now());

            if (sellOffer.getCurrencyCode() != null) {
                updatedSellOffer.currencyCode(sellOffer.getCurrencyCode());
            }
            if (sellOffer.getPaymentMethod() != null) {
                updatedSellOffer.paymentMethod(sellOffer.getPaymentMethod());
            }
            if (sellOffer.getMinAmount() != null) {
                updatedSellOffer.minAmount(sellOffer.getMinAmount());
            }
            if (sellOffer.getMaxAmount() != null) {
                updatedSellOffer.maxAmount(sellOffer.getMaxAmount());
            }
            if (sellOffer.getPrice() != null) {
                updatedSellOffer.price(sellOffer.getPrice());
            }
            return sellOfferRepository.save(updatedSellOffer.build());
        } else {
            return create(sellOffer);
        }
    }

    public void delete(String sellerEscrowPubkey) {
        sellOfferRepository.delete(sellerEscrowPubkey);
    }
}
