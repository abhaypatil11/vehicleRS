package com.rental.vehiclerental.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestimonialResponse {

    private Long id;

    private Long userId;

    private String userName;

    private String message;

    private Integer rating;

    private LocalDateTime createdAt;
}
