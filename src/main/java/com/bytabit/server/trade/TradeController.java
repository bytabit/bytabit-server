package com.bytabit.server.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/v1/trades")
class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @RequestMapping(value = "/{escrowAddress}", method = GET, produces = "application/json")
    public Trade read(@PathVariable String escrowAddress) {
        return tradeService.read(escrowAddress);
    }

    @RequestMapping(method = GET, produces = "application/json")
    public List<Trade> readAll(@RequestParam(name = "arbitratorProfilePubKey") String arbitratorProfilePubKey) {
        return tradeService.readAll(arbitratorProfilePubKey);
    }
}
