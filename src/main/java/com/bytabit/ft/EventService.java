package com.bytabit.ft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public PostedEvent post(PostedEvent postedEvent) {
        postedEvent.setPosted(LocalDateTime.now());
        return eventRepo.save(postedEvent);
    }

    public Iterable<PostedEvent> findAll(LocalDateTime since) {
        if (since == null) {
            return eventRepo.findAll();
        } else {
            return eventRepo.findSince(since);
        }
    }
}
