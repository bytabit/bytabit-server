package com.bytabit.server.offer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class BuyRequest {

    protected BuyRequest() {
    }

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

    @Column
    private LocalDateTime deleted;

    public String getBuyerEscrowPubKey() {
        return buyerEscrowPubKey;
    }

    public void setBuyerEscrowPubKey(String buyerEscrowPubKey) {
        this.buyerEscrowPubKey = buyerEscrowPubKey;
    }

    public String getSellerEscrowPubKey() {
        return sellerEscrowPubKey;
    }

    public void setSellerEscrowPubKey(String sellerEscrowPubKey) {
        this.sellerEscrowPubKey = sellerEscrowPubKey;
    }

    public BigDecimal getBtcAmount() {
        return btcAmount;
    }

    public void setBtcAmount(BigDecimal btcAmount) {
        this.btcAmount = btcAmount;
    }

    public String getBuyerProfilePubKey() {
        return buyerProfilePubKey;
    }

    public void setBuyerProfilePubKey(String buyerProfilePubKey) {
        this.buyerProfilePubKey = buyerProfilePubKey;
    }

    public String getBuyerPayoutAddress() {
        return buyerPayoutAddress;
    }

    public void setBuyerPayoutAddress(String buyerPayoutAddress) {
        this.buyerPayoutAddress = buyerPayoutAddress;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getDeleted() {
        return deleted;
    }

    public void setDeleted(LocalDateTime deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BuyRequest{");
        sb.append("buyerEscrowPubKey='").append(buyerEscrowPubKey).append('\'');
        sb.append(", sellerEscrowPubKey='").append(sellerEscrowPubKey).append('\'');
        sb.append(", btcAmount=").append(btcAmount);
        sb.append(", buyerProfilePubKey='").append(buyerProfilePubKey).append('\'');
        sb.append(", buyerPayoutAddress='").append(buyerPayoutAddress).append('\'');
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", deleted=").append(deleted);
        sb.append('}');
        return sb.toString();
    }
}

