package com.rental.vehiclerental.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriberRequest {

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    private String email;
}
