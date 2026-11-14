package com.rental.vehiclerental.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContactInquiryResponse {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String subject;

    private String message;

    private boolean resolved;

    private LocalDateTime createdAt;
}
