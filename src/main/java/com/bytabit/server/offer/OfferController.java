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
    public Offer create(@RequestBody Offer offer) {
        return offerService.create(offer);
    }

    @RequestMapping(method = GET, produces = "application/json")
    public Iterable<Offer> read() throws IOException {
        return offerService.read();
    }

    @RequestMapping(path = "/{pubkey}", method = PUT, produces = "application/json", consumes = "application/json")
    public Offer update(@PathVariable String pubkey, @RequestBody Offer offer) {
        return offerService.update(pubkey, offer);
    }

    @RequestMapping(path = "/{pubkey}", method = DELETE, produces = "application/json")
    public Offer delete(@PathVariable String pubkey) {
        return offerService.delete(pubkey);
    }
}
