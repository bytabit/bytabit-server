package com.bytabit.ft;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.converter.HttpMessageNotReadableException;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDateTime;

@Entity
public class Event {

    private static ObjectMapper mapper = new ObjectMapper();

    protected Event() {
    }

    public Event(String json) throws IOException {
        this(json, LocalDateTime.now());
    }

    public Event(String json, LocalDateTime posted) throws IOException {

        this.json = json;
        ObjectNode objectNode = getObjectNode();
        // make sure json event has type and posted property
        if (objectNode.has("type") && objectNode.has("posted")) {
            objectNode.put("posted", posted.toString());
            this.json = objectNode.toString();
            this.posted = posted;
        } else {
            throw new HttpMessageNotReadableException(json);
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String json;

    @Column
    private LocalDateTime posted;

    public Long getId() {
        return id;
    }

    public String getJson() {
        return json;
    }

    public LocalDateTime getPosted() {
        return posted;
    }

    public ObjectNode getObjectNode() throws IOException {
        return (ObjectNode) mapper.readTree(json);
    }
}
