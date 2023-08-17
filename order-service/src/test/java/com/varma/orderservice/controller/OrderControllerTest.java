package com.varma.orderservice.controller;

import com.varma.orderservice.dto.OrderLineItemsDto;
import com.varma.orderservice.dto.OrderRequest;
import com.varma.orderservice.service.OrderService;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    @DisplayName("Should throw an exception when the order request is invalid")
    void placeOrderWhenOrderRequestIsInvalidThenThrowException() {
        List<OrderLineItemsDto> orderLineItems = List.of(
                new OrderLineItemsDto(1L, "SKU123", new BigDecimal("10.00"), 2),
                new OrderLineItemsDto(2L, "SKU456", new BigDecimal("20.00"), 3)
        );
        OrderRequest orderRequest = new OrderRequest(orderLineItems);

        doThrow(ConstraintViolationException.class)
                .when(orderService)
                .placeOrder(orderRequest);

        assertThrows(ConstraintViolationException.class, () -> {
            orderController.placeOrder(orderRequest);
        });

        verify(orderService, times(1)).placeOrder(orderRequest);
    }

    @Test
    @DisplayName("Should place the order successfully when the order request is valid")
    void placeOrderWhenOrderRequestIsValid() {
        // Create a valid order request
        List<OrderLineItemsDto> orderLineItems = List.of(
                new OrderLineItemsDto(1L, "SKU123", new BigDecimal("10.00"), 2),
                new OrderLineItemsDto(2L, "SKU456", new BigDecimal("20.00"), 1)
        );
        OrderRequest orderRequest = new OrderRequest(orderLineItems);

        // Mock the behavior of the orderService
        doNothing().when(orderService).placeOrder(orderRequest);

        // Call the placeOrder method of the orderController
        String result = orderController.placeOrder(orderRequest);

        // Verify that the orderService's placeOrder method was called once
        verify(orderService, times(1)).placeOrder(orderRequest);

        // Verify that the result is "order placed successfully"
        assertEquals("order placed successfully", result);
    }

}