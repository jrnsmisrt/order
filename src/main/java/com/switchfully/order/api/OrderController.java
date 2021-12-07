package com.switchfully.order.api;

import com.switchfully.order.api.mapper.ItemGroupMapper;
import com.switchfully.order.api.mapper.OrderMapper;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.item.ItemGroupDto;
import com.switchfully.order.repository.OrderRepository;
import com.switchfully.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ItemGroupMapper itemGroupMapper;

    public OrderController(OrderService orderService, OrderRepository orderRepository, OrderMapper orderMapper, ItemGroupMapper itemGroupMapper) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.itemGroupMapper=itemGroupMapper;
    }

    @GetMapping(produces="application/json", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void orderItems(@RequestBody List<ItemGroupDto> itemsToOrder){
        orderService.orderItems(itemsToOrder.stream()
                .map(itemGroupMapper::mapItemGroupDtoToItemGroup)
                .collect(Collectors.toList()));
    }


}
