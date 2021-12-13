package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.order.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDto mapOrderToOrderDto(Order order){
        return new OrderDto()
                .setListOfItemsToOrder(order.getListOfItemsToOrder())
                .setOrderNumber(order.getOrderNumber())
                .setCustomerId(order.getCustomerId())
                .setPrice(order.getPrice());

    }

    public Order mapOrderDtoToOrder(OrderDto orderDto){
        return new Order(orderDto.getListOfItemsToOrder(), orderDto.getCustomerId());

    }
}
