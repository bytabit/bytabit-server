package com.bytabit.server.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BuyRequestService {

    private final BuyRequestRepository buyRequestRepository;

    @Autowired
    public BuyRequestService(BuyRequestRepository buyRequestRepository) {
        this.buyRequestRepository = buyRequestRepository;
    }

    public BuyRequest create(String sellerEscrowPubkey, BuyRequest buyRequest) {
        assert (sellerEscrowPubkey.equals(buyRequest.getSellerEscrowPubKey()));

        BuyRequest newBuyRequest = BuyRequest.builder()
                .escrowAddress(buyRequest.getEscrowAddress())
                .btcAmount(buyRequest.getBtcAmount())
                .buyerEscrowPubKey(buyRequest.getBuyerEscrowPubKey())
                .buyerProfilePubKey(buyRequest.getBuyerProfilePubKey())
                .buyerPayoutAddress(buyRequest.getBuyerPayoutAddress())
                .sellerEscrowPubKey(buyRequest.getSellerEscrowPubKey())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now()).build();
        return buyRequestRepository.save(newBuyRequest);
    }

    public BuyRequest read(String escrowAddress) {
        return buyRequestRepository.findOne(escrowAddress);
    }

    public List<BuyRequest> readForOffer(String sellerEscrowPubKey) {
        return buyRequestRepository.findBySellerEscrowPubKey(sellerEscrowPubKey);
    }

    public void delete(String buyerEscrowPubKey) {
        buyRequestRepository.deleteByBuyerEscrowPubKey(buyerEscrowPubKey);
    }

    public void deleteForSellOffer(String sellerEscrowPubKey) {
        buyRequestRepository.deleteBySellerEscrowPubKey(sellerEscrowPubKey);
    }
}
