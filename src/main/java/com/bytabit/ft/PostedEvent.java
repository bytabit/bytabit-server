package com.bytabit.ft;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDateTime;

@Entity
@Table(name = "event", indexes = {@Index(name = "event_posted", columnList = "posted", unique = false)})
public class PostedEvent implements Cloneable {

    private static ObjectMapper mapper = new ObjectMapper();

    protected PostedEvent() {
    }

    public PostedEvent(String type, String data) throws IOException {
        this(type, data, LocalDateTime.now());
    }

    public PostedEvent(String type, String data, LocalDateTime posted) {
        this.type = type;
        this.data = data;
        this.posted = posted;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String type;

    @Column
    private String data;

    @Column
    private LocalDateTime posted;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public LocalDateTime getPosted() {
        return posted;
    }

    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }
}
