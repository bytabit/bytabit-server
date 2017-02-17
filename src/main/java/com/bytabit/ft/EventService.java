package com.bytabit.ft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public Event post(Event event) {
        return eventRepo.save(event);
    }

    public Iterable<Event> findAll(LocalDateTime since) {
        if (since == null) {
            return eventRepo.findAll();
        } else {
            return eventRepo.findSince(since);
        }
    }
}
