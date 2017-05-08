package com.bytabit.server.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/v1/offers")
class SellOfferController {

    private final SellOfferService offerService;

    private final BuyRequestService buyRequestService;

    @Autowired
    public SellOfferController(SellOfferService offerService, BuyRequestService buyRequestService) {
        this.offerService = offerService;
        this.buyRequestService = buyRequestService;
    }

    @RequestMapping(method = POST, produces = "application/json", consumes = "application/json")
    public SellOffer create(@RequestBody SellOffer sellOffer) {
        return offerService.create(sellOffer);
    }

    @RequestMapping(method = GET, produces = "application/json")
    public Iterable<SellOffer> read() throws IOException {
        return offerService.read();
    }

    @RequestMapping(path = "/{sellerEscrowPubkey}", method = PUT, produces = "application/json", consumes = "application/json")
    public SellOffer update(@PathVariable String sellerEscrowPubkey, @RequestBody SellOffer sellOffer) {
        return offerService.update(sellerEscrowPubkey, sellOffer);
    }

    @RequestMapping(path = "/{sellerEscrowPubkey}", method = DELETE, produces = "application/json")
    public void delete(@PathVariable String sellerEscrowPubkey) {
        buyRequestService.deleteForSellOffer(sellerEscrowPubkey);
        offerService.delete(sellerEscrowPubkey);
    }
}
