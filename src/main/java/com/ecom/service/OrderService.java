package com.ecom.service;

import java.util.List;
import java.util.Optional;

import com.ecom.model.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
}
