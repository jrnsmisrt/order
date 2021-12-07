package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.order.OrderDto;

public class OrderMapper {

    public OrderDto mapOrderToOrderDto(Order order){
        return new OrderDto()
                .setListOfItemsToOrder(order.getListOfItemsToOrder())
                .setOrderNumber(order.getOrderNumber())
                .setTotalPrice(order.getTotalPrice())
                .setCustomer(order.getCustomer());
    }

    public Order mapOrderDtoToOrder(OrderDto orderDto){
        return new Order(orderDto.getListOfItemsToOrder(),
                orderDto.getCustomer());
    }
}
