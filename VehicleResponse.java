package com.rental.vehiclerental.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VehicleResponse {

    private Long id;

    private String name;

    private Long brandId;

    private String brandName;

    private String modelYear;

    private String fuelType;

    private String transmission;

    private Integer seatingCapacity;

    private String color;

    private BigDecimal pricePerDay;

    private String description;

    private String imageUrl;

    private boolean available;
}
