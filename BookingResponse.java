package com.rental.vehiclerental.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.rental.vehiclerental.enums.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookingResponse {

    private Long id;

    private Long userId;

    private String userName;

    private Long vehicleId;

    private String vehicleName;

    private LocalDate pickupDate;

    private LocalDate returnDate;

    private BigDecimal dailyRate;

    private BigDecimal totalAmount;

    private BookingStatus status;

    private LocalDateTime bookingDate;
}
