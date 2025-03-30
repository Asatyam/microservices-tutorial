package com.satyamagrawal.bookstore.orderservice.domain;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }

    public static OrderNotFoundException forOrderNumber(String orderNumber) {
        return new OrderNotFoundException("Order  with order number " + orderNumber + " not found");
    }
}
