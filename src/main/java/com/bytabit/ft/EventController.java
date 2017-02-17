package com.bytabit.ft;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    @Autowired
    private EventService eventService;

    private static ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = GET, produces = "application/json")
    public String getEvents(@RequestParam(required = false) String since) throws IOException {

        LocalDateTime sinceDateTime = null;
        if (since != null && since.length() > 0) {
            sinceDateTime = LocalDateTime.parse(since);
        }
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Event e : eventService.findAll(sinceDateTime)) {
            ObjectNode objectNode = e.getObjectNode();
            arrayNode.add(objectNode);
        }
        return arrayNode.toString();
    }

    @RequestMapping(method = POST, produces = "application/json", consumes = "application/json")
    public String postEvent(@RequestBody String json) throws IOException {

        return eventService.post(new Event(json)).getJson();
    }

}
