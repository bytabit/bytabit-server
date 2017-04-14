package com.bytabit.server.offer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/v1/offers")
public class BuyRequestController {

    private final BuyRequestService buyRequestService;

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public BuyRequestController(BuyRequestService buyRequestService) {
        this.buyRequestService = buyRequestService;
    }

    @RequestMapping(method = POST, path = "/{sellerEscrowPubkey}/buyRequests", produces = "application/json", consumes = "application/json")
    public BuyRequest createBuyRequest(@PathVariable String sellerEscrowPubkey, @RequestBody BuyRequest buyRequest) {
        return buyRequestService.create(buyRequest);
    }
}
