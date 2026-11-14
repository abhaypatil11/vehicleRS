package com.rental.vehiclerental.dto;

import com.rental.vehiclerental.enums.BookingStatus;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookingStatusRequest {

    @NotNull(message = "Booking status is required")
    private BookingStatus status;
}
