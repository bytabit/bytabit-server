package com.bytabit.server.trade;

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
public class PayoutCompleted {

    @Id
    private String escrowAddress;

    @Column(nullable = false)
    private String payoutTxHash;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;
}
