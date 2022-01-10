package com.switchfully.order.service;

import com.switchfully.order.api.mapper.ItemGroupMapper;
import com.switchfully.order.api.mapper.OrderMapper;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.item.ItemGroupDto;
import com.switchfully.order.domain.order.Order;


import com.switchfully.order.domain.order.OrderDto;
import com.switchfully.order.repository.OrderRepository;
import com.switchfully.order.repository.UserBasketRepository;
import com.switchfully.order.security.exceptions.CustomerDoesNotExistException;
import com.switchfully.order.security.exceptions.ItemBasketIsEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemGroupService itemGroupService;
    private final ItemService itemService;
    private final Logger orderServiceLogger = LoggerFactory.getLogger(OrderService.class);
    private final ItemGroupMapper itemGroupMapper;
    private final OrderMapper orderMapper;
    private UserBasketRepository userBasketRepository;


    @Autowired
    public OrderService(ItemService itemService, OrderRepository orderRepository, ItemGroupService itemGroupService, ItemGroupMapper itemGroupMapper, OrderMapper orderMapper, UserBasketRepository userBasketRepository) {

        this.itemService = itemService;
        this.orderRepository = orderRepository;
        this.itemGroupService = itemGroupService;
        this.itemGroupMapper = itemGroupMapper;
        this.orderMapper = orderMapper;
        this.userBasketRepository = userBasketRepository;
    }

    public double calculatePriceOfOrder(List<ItemGroup> itemGroupList) {
        double orderPrice = 0;
        for (ItemGroup itemGroup : itemGroupList) {
            orderPrice += itemGroupService.getItemGroupPrice(itemGroup);
        }
        return orderPrice;
    }

    public double calculateTotalPriceOfOrders(long customerId) {
        double totalPriceOfOrders = 0;
        for (Order order : orderRepository.findAll()) {
            if (order.getCustomerId() == (customerId)) {
                totalPriceOfOrders += order.getPrice();
            }
        }
        return totalPriceOfOrders;
    }


    public OrderDto viewOrder(long orderNumber) {
        Optional<Order> optionalOrder = orderRepository.findById(orderNumber);
        if (optionalOrder.isEmpty()) throw new NullPointerException("Order has not been found");
        else return orderMapper.mapOrderToOrderDto(orderRepository.findById(orderNumber).get());
    }

    public List<OrderDto> showAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::mapOrderToOrderDto)
                .collect(Collectors.toList());
    }

    public OrderDto placeOrder(long customerId, List<ItemGroup> itemsToOrder) {
        Order placedOrder = new Order(itemsToOrder, customerId);

        orderRepository.save(placedOrder);
        orderServiceLogger.info("A new Order has been placed by: " + customerId);
        return orderMapper.mapOrderToOrderDto(placedOrder);
    }


}


