package com.satyamagrawal.bookstore.orderservice.domain;

import com.satyamagrawal.bookstore.orderservice.domain.models.CreateOrderRequest;
import com.satyamagrawal.bookstore.orderservice.domain.models.OrderStatus;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class OrderMapper {

    static OrderEntity convertToEntity(CreateOrderRequest request) {
        OrderEntity newOrder = new OrderEntity();
        newOrder.setOrderNumber(UUID.randomUUID().toString());
        newOrder.setStatus(OrderStatus.NEW);
        newOrder.setCustomer(request.customer());
        newOrder.setDeliveryAddress(request.deliveryAddress());
        Set<OrderItemEntity> orderItems = new HashSet<>();
        for (var item : request.items()) {
            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setCode(item.code());
            orderItem.setName(item.name());
            orderItem.setPrice(item.price());
            orderItem.setQuantity(item.quantity());
            orderItem.setOrder(newOrder);
            orderItems.add(orderItem);
        }
        newOrder.setOrderItems(orderItems);
        return newOrder;
    }
}
