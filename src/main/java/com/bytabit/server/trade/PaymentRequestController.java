package com.bytabit.server.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/v1/trades/{escrowAddress}/paymentRequest")
class PaymentRequestController {

    private final PaymentRequestService paymentRequestService;

    @Autowired
    public PaymentRequestController(PaymentRequestService paymentRequestService) {
        this.paymentRequestService = paymentRequestService;
    }

    @RequestMapping(method = POST, produces = "application/json", consumes = "application/json")
    public PaymentRequest create(@PathVariable String escrowAddress, @RequestBody PaymentRequest paymentRequest) {
        return paymentRequestService.create(escrowAddress, paymentRequest);
    }

    @RequestMapping(method = GET, produces = "application/json")
    public PaymentRequest read(@PathVariable String escrowAddress) {
        return paymentRequestService.read(escrowAddress);
    }

    @RequestMapping(method = PUT, produces = "application/json", consumes = "application/json")
    public PaymentRequest update(@PathVariable String escrowAddress, @RequestBody PaymentRequest paymentRequest) {
        return paymentRequestService.update(escrowAddress, paymentRequest);
    }
}
