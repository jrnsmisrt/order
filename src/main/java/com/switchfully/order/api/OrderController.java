package com.switchfully.order.api;

import com.switchfully.order.api.mapper.ItemGroupMapper;
import com.switchfully.order.api.mapper.OrderMapper;
import com.switchfully.order.api.mapper.UserMapper;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.item.ItemGroupDto;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.order.OrderDto;
import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.UserDto;
import com.switchfully.order.repository.OrderRepository;
import com.switchfully.order.service.OrderService;
import com.switchfully.order.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;
    private final ItemGroupMapper itemGroupMapper;
    private final UserService userService;

    public OrderController(OrderService orderService, UserService userService, OrderRepository orderRepository, OrderMapper orderMapper, ItemGroupMapper itemGroupMapper, UserMapper userMapper) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.itemGroupMapper = itemGroupMapper;
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> viewAllOrders() {
        return orderService.showAllOrders().stream()
                .map(orderMapper::mapOrderToOrderDto)
                .collect(Collectors.toList());
    }

    @GetMapping(produces = "application/json", path = "/{orderNumber}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto viewOrder(@PathVariable int orderNumber) {
        return orderMapper.mapOrderToOrderDto(orderRepository.showOrderById(orderNumber));
    }

    @PostMapping(produces = "application/json", path = "/confirm-order/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public void orderItems(@PathVariable String customerId) {
        orderService.orderItems(customerId);
    }

    @GetMapping(produces = "application/json", path = "/basket/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemGroupDto> showContentsOfBasket(@PathVariable String customerId) {
        return orderService.showContentsOfBasket(customerId);
    }

    @PostMapping(produces = "application/json", consumes = "application/json", path = "/basket/{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ItemGroupDto> addItemToBasket(@PathVariable String customerId, @RequestBody ItemGroupDto item) {
        orderService.addItemToBasket(customerId, item);
        return orderService.showContentsOfBasket(customerId);
    }


}
