package com.bytabit.server.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/v1/trades/{escrowAddress}/payoutRequest")
class PayoutRequestController {

    private final PayoutRequestService payoutRequestService;

    @Autowired
    public PayoutRequestController(PayoutRequestService payoutRequestService) {
        this.payoutRequestService = payoutRequestService;
    }

    @RequestMapping(method = POST, produces = "application/json", consumes = "application/json")
    public PayoutRequest create(@PathVariable String escrowAddress, @RequestBody PayoutRequest payoutRequest) {
        return payoutRequestService.create(escrowAddress, payoutRequest);
    }

    @RequestMapping(method = GET, produces = "application/json")
    public PayoutRequest read(@PathVariable String escrowAddress) {
        return payoutRequestService.read(escrowAddress);
    }

    @RequestMapping(method = PUT, produces = "application/json", consumes = "application/json")
    public PayoutRequest update(@PathVariable String escrowAddress, @RequestBody PayoutRequest payoutRequest) {
        return payoutRequestService.update(escrowAddress, payoutRequest);
    }
}
