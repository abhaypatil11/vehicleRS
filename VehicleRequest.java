package com.rental.vehiclerental.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleRequest {

    @NotBlank(message = "Vehicle name is required")
    private String name;

    @NotNull(message = "Brand ID is required")
    private Long brandId;

    private String modelYear;

    private String fuelType;

    private String transmission;

    @NotNull(message = "Seating capacity is required")
    @Min(value = 1, message = "Seating capacity must be at least 1")
    private Integer seatingCapacity;

    private String color;

    @NotNull(message = "Price per day is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero")
    private BigDecimal pricePerDay;

    @Size(max = 2000, message = "Description cannot exceed 2000 characters")
    private String description;

    private String imageUrl;
}
