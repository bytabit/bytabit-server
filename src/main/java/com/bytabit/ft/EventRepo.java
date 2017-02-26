package com.bytabit.ft;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface EventRepo extends CrudRepository<PostedEvent, Long> {

    @Query("SELECT e FROM PostedEvent e WHERE e.posted > :since")
    Iterable<PostedEvent> findSince(@Param("since") LocalDateTime since);
}
