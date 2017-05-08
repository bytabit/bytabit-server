package com.bytabit.server.offer;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
@Table
public class BuyRequest {

    @Id
    private String buyerEscrowPubKey;

    @Column(nullable = false)
    private String sellerEscrowPubKey;

    @Column(nullable = false, precision = 20, scale = 8)
    private BigDecimal btcAmount;

    @Column(nullable = false)
    private String buyerProfilePubKey;

    @Column(nullable = false)
    private String buyerPayoutAddress;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;
}

