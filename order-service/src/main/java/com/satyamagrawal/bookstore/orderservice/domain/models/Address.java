package com.satyamagrawal.bookstore.orderservice.domain.models;

import jakarta.validation.constraints.NotBlank;

public record Address(
        @NotBlank(message = "Delivery Address Line1 is required") String addressLine1,
        String addressLine2,
        @NotBlank(message = "Delivery City is required") String city,
        @NotBlank(message = "Delivery State is required") String state,
        @NotBlank(message = "Delivery Zip Code is required") String zipCode,
        @NotBlank(message = "Delivery Country is required") String country

) {
}
