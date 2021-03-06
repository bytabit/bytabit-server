package com.bytabit.server.profile;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
@Table
public class Profile {

    @Id
    private String pubKey;

    @Column(nullable = false)
    @Builder.Default
    private Boolean isArbitrator = false;

    @Column
    private String name;

    @Column
    private String phoneNum;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;
}
