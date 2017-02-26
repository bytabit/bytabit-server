package com.bytabit.ft;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    public Iterable<PostedEvent> getEvents(@RequestParam(required = false) String since) throws IOException {

        LocalDateTime sinceDateTime = null;
        if (since != null && since.length() > 0) {
            sinceDateTime = LocalDateTime.parse(since);
        }
        return eventService.findAll(sinceDateTime);
    }

    @RequestMapping(method = POST, produces = "application/json", consumes = "application/json")
    public PostedEvent postEvent(@RequestBody PostedEvent postedEvent) throws IOException {
        return eventService.post(postedEvent);
    }

}
