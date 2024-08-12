package com.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "CANCELLATIONS")
public class CancellationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancellation_seq")
    @SequenceGenerator(name = "cancellation_seq", sequenceName = "CANCELLATION_SEQ", allocationSize = 1)
    @Column(name = "CANCELLATION_ID", nullable = false)
    private Long cancellationId;

    @Column(name = "RESERVATION_ID", nullable = false)
    private String reservationId;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "CANCELED_AT")
    private Timestamp canceledAt;

    @Column(name = "REFUND_AMOUNT")
    private BigDecimal refundAmount;

    @Column(name = "REFUND_CURRENCY")
    private String refundCurrency;

    @Column(name = "REFUND_TRANSACTION_ID")
    private String refundTransactionId;

    @Column(name = "REFUND_METHOD")
    private String refundMethod;

    @Column(name = "CANCELLATION_FEE_AMOUNT")
    private BigDecimal cancellationFeeAmount;

    @Column(name = "CANCELLATION_FEE_CURRENCY")
    private String cancellationFeeCurrency;

    public Long getCancellationId() {
        return cancellationId;
    }

    public void setCancellationId(Long cancellationId) {
        this.cancellationId = cancellationId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Timestamp getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Timestamp canceledAt) {
        this.canceledAt = canceledAt;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundCurrency() {
        return refundCurrency;
    }

    public void setRefundCurrency(String refundCurrency) {
        this.refundCurrency = refundCurrency;
    }

    public String getRefundTransactionId() {
        return refundTransactionId;
    }

    public void setRefundTransactionId(String refundTransactionId) {
        this.refundTransactionId = refundTransactionId;
    }

    public String getRefundMethod() {
        return refundMethod;
    }

    public void setRefundMethod(String refundMethod) {
        this.refundMethod = refundMethod;
    }

    public BigDecimal getCancellationFeeAmount() {
        return cancellationFeeAmount;
    }

    public void setCancellationFeeAmount(BigDecimal cancellationFeeAmount) {
        this.cancellationFeeAmount = cancellationFeeAmount;
    }

    public String getCancellationFeeCurrency() {
        return cancellationFeeCurrency;
    }

    public void setCancellationFeeCurrency(String cancellationFeeCurrency) {
        this.cancellationFeeCurrency = cancellationFeeCurrency;
    }
}
