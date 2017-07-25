package com.bytabit.server.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/v1/arbitrateRequests/{arbitratorProfilePubKey}")
class ArbitrateRequestController {

    private final ArbitrateRequestService arbitrateRequestService;

    @Autowired
    public ArbitrateRequestController(ArbitrateRequestService arbitrateRequestService) {
        this.arbitrateRequestService = arbitrateRequestService;
    }

    @RequestMapping(method = POST, produces = "application/json", consumes = "application/json")
    public ArbitrateRequest create(@PathVariable String arbitratorProfilePubKey, @RequestBody ArbitrateRequest arbitrateRequest) {
        return arbitrateRequestService.create(arbitratorProfilePubKey, arbitrateRequest);
    }

    @RequestMapping(method = GET, produces = "application/json")
    public List<ArbitrateRequest> read(@PathVariable String arbitratorProfilePubKey) {
        return arbitrateRequestService.readForArbitrator(arbitratorProfilePubKey);
    }

    @RequestMapping(value = "/{escrowAddress}", method = GET, produces = "application/json")
    public ArbitrateRequest read(@PathVariable String arbitratorProfilePubKey,
                                 @PathVariable String escrowAddress) {
        // TODO verify returned ArbitratorRequest is for arbitratorProfilePubKey
        return arbitrateRequestService.read(escrowAddress);
    }
}
