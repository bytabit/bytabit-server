package com.bytabit.server.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/v1/trades/{escrowAddress}/payoutCompleted")
class PayoutCompletedController {

    private final PayoutCompletedService payoutCompletedService;

    @Autowired
    public PayoutCompletedController(PayoutCompletedService payoutCompletedService) {
        this.payoutCompletedService = payoutCompletedService;
    }

    @RequestMapping(method = POST, produces = "application/json", consumes = "application/json")
    public PayoutCompleted create(@PathVariable String escrowAddress, @RequestBody PayoutCompleted payoutCompleted) {
        return payoutCompletedService.create(escrowAddress, payoutCompleted);
    }

    @RequestMapping(method = GET, produces = "application/json")
    public PayoutCompleted read(@PathVariable String escrowAddress) {
        return payoutCompletedService.read(escrowAddress);
    }

    @RequestMapping(method = PUT, produces = "application/json", consumes = "application/json")
    public PayoutCompleted update(@PathVariable String escrowAddress, @RequestBody PayoutCompleted payoutCompleted) {
        return payoutCompletedService.update(escrowAddress, payoutCompleted);
    }
}
