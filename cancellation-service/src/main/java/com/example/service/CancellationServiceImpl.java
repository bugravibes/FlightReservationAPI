package com.example.service;

import com.example.entity.CancellationEntity;
import com.example.entity.ReservationEntity;
import com.example.model.ReservationCancellationRequest;
import com.example.model.ReservationCancellationResponse;
import com.example.repository.CancellationRepository;
import com.example.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class CancellationServiceImpl implements CancellationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CancellationRepository cancellationRepository;

    @Override
    @Transactional
    public ReservationCancellationResponse cancelReservation(ReservationCancellationRequest request) {
        ReservationEntity reservationEntity = reservationRepository.findByReservationId(request.getCancellation_request().getReservation_id());
        if (reservationEntity != null) {
            reservationEntity.setStatus("CS");
            reservationRepository.save(reservationEntity);

            CancellationEntity cancellationEntity = new CancellationEntity();
            cancellationEntity.setReservationId(reservationEntity.getReservationId());
            cancellationEntity.setReason(request.getCancellation_request().getReason());
            cancellationEntity.setCanceledAt(Timestamp.valueOf(LocalDateTime.now()));
            // Dummy values for refund and cancellation fee
            cancellationEntity.setRefundAmount(new BigDecimal("350.00"));
            cancellationEntity.setRefundCurrency("USD");
            cancellationEntity.setRefundTransactionId("RF123456789");
            cancellationEntity.setRefundMethod("credit_card");
            cancellationEntity.setCancellationFeeAmount(new BigDecimal("50.00"));
            cancellationEntity.setCancellationFeeCurrency("USD");

            cancellationRepository.save(cancellationEntity);

            ReservationCancellationResponse response = new ReservationCancellationResponse();
            ReservationCancellationResponse.CancellationResponse cancellationResponse = new ReservationCancellationResponse.CancellationResponse();
            ReservationCancellationResponse.Refund refund = new ReservationCancellationResponse.Refund();
            ReservationCancellationResponse.CancellationFee cancellationFee = new ReservationCancellationResponse.CancellationFee();

            refund.setAmount(350.00);
            refund.setCurrency("USD");
            refund.setTransactionId("RF123456789");
            refund.setMethod("credit_card");

            cancellationFee.setAmount(50.00);
            cancellationFee.setCurrency("USD");

            cancellationResponse.setReservationId(reservationEntity.getReservationId());
            cancellationResponse.setStatus("canceled");
            cancellationResponse.setRefund(refund);
            cancellationResponse.setCancellationFee(cancellationFee);
            cancellationResponse.setCanceledAt(ZonedDateTime.now(ZoneId.systemDefault()));

            response.setCancellationResponse(cancellationResponse);
            return response;
        } else {
            throw new RuntimeException("Reservation not found");
        }
    }
}
