package com.ecom.service;

import java.util.List;
import java.util.Optional;

import com.ecom.model.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {
    List<OrderItem> findAll();
    Optional<OrderItem> findById(Long id);
    OrderItem save(OrderItem orderItem);
    OrderItem update(Long id, OrderItem orderItem) throws Exception; // Throws exception if not found
    void delete(Long id);
}
