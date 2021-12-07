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
                .setTotalPrice(order.getTotalPrice());

    }

    public Order mapOrderDtoToOrder(OrderDto orderDto){
        return null;

    }
}
