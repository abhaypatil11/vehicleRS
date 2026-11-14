package com.rental.vehiclerental.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubscriberResponse {

    private Long id;

    private String email;

    private boolean active;

    private LocalDateTime subscribedAt;
}
