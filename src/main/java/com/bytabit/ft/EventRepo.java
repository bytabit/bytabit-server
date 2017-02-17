package com.bytabit.ft;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface EventRepo extends CrudRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.posted > :since")
    Iterable<Event> findSince(@Param("since") LocalDateTime since);
}
