package com.varma.orderservice.service;

import com.varma.orderservice.dto.OrderLineItemsDto;
import com.varma.orderservice.dto.OrderRequest;
import com.varma.orderservice.entity.Order;
import com.varma.orderservice.entity.OrderLineItems;
import com.varma.orderservice.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.orderLineItemsDto()
                .stream().map(orderLineItemsDto -> mapToDto(orderLineItemsDto)).toList();

        order.setOrderLineItems(orderLineItems);
        orderRepository.save(order);

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
       return new OrderLineItems(
                orderLineItemsDto.id(),
                orderLineItemsDto.skuCode(),
                orderLineItemsDto.price(),
                orderLineItemsDto.quantity()
        );

    }
}
