package com.ecom;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecom.model.OrderItem;
import com.ecom.repository.OrderItemRepository;
import com.ecom.service.impl.OrderItemServiceImpl;

public class OrderItemServiceImplTest {

    @Mock
    private OrderItemRepository orderItemRepository;

    @InjectMocks
    private OrderItemServiceImpl orderItemService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Prepare
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem());
        when(orderItemRepository.findAll()).thenReturn(orderItems);

        // Execute
        List<OrderItem> result = orderItemService.findAll();

        // Verify
        assertEquals(orderItems, result);
    }

    @Test
    public void testFindById() {
        // Prepare
        Long id = 1L;
        OrderItem orderItem = new OrderItem();
        when(orderItemRepository.findById(id)).thenReturn(Optional.of(orderItem));

        // Execute
        Optional<OrderItem> result = orderItemService.findById(id);

        // Verify
        assertEquals(Optional.of(orderItem), result);
    }

    @Test
    public void testSave() {
        // Prepare
        OrderItem orderItem = new OrderItem();
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);

        // Execute
        OrderItem result = orderItemService.save(orderItem);

        // Verify
        assertEquals(orderItem, result);
    }

    @Test
    public void testUpdate() {
        // Prepare
        Long id = 1L;
        OrderItem existingOrderItem = new OrderItem();
        OrderItem updatedOrderItem = new OrderItem();
        updatedOrderItem.setQuantity(5); // Updated quantity
        when(orderItemRepository.findById(id)).thenReturn(Optional.of(existingOrderItem));
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(updatedOrderItem);

        // Execute
        OrderItem result = orderItemService.update(id, updatedOrderItem);

        // Verify
        assertEquals(updatedOrderItem, result);
        assertEquals(5, result.getQuantity()); // Ensure quantity is updated
    }

    @Test
    public void testDelete() {
        // Prepare
        Long id = 1L;
        OrderItem orderItem = new OrderItem();
        when(orderItemRepository.findById(id)).thenReturn(Optional.of(orderItem));

        // Execute
        orderItemService.delete(id);

        // Verify
        verify(orderItemRepository, times(1)).delete(orderItem);
    }
}
