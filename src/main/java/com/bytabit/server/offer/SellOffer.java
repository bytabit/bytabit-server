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
public class SellOffer {

    @Id
    private String sellerEscrowPubKey;

    @Column(nullable = false)
    private String sellerProfilePubKey;

    @Column(nullable = false)
    private String arbitratorProfilePubKey;

    @Column(nullable = false)
    private String currencyCode;

    @Column(nullable = false)
    private String paymentMethod;

    @Column
    private BigDecimal minAmount;

    @Column
    private BigDecimal maxAmount;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;
}

