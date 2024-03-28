package com.ecom.service.impl;

import com.ecom.model.OrderItem;
import com.ecom.repository.OrderItemRepository;
import com.ecom.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem update(Long id, OrderItem orderItemDetails) {
        return orderItemRepository.findById(id).map(orderItem -> {
            orderItem.setProduct(orderItemDetails.getProduct());
            orderItem.setQuantity(orderItemDetails.getQuantity());
            return orderItemRepository.save(orderItem);
        }).orElseThrow(() -> new RuntimeException("OrderItem not found for this id :: " + id));
    }

    @Override
    public void delete(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found for this id :: " + id));
        orderItemRepository.delete(orderItem);
    }
}
