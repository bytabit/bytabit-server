package com.bytabit.server.offer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/v1/offers")
public class OfferController {

    private final OfferService offerService;

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
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
    public SellOffer delete(@PathVariable String sellerEscrowPubkey) {
        return offerService.delete(sellerEscrowPubkey);
    }
}
