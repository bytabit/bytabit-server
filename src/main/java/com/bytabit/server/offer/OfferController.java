package com.bytabit.server.offer;

import com.bytabit.server.profile.Profile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Iterable<Offer> retrieve() throws IOException {
        return offerService.retrieve();
    }

    @RequestMapping(path = "/{pubkey}", method = PUT, produces = "application/json", consumes = "application/json")
    public Offer update(@PathVariable String pubkey, @RequestBody Offer offer) {
        return offerService.update(pubkey, offer);
    }
}
