package com.switchfully.order.service;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    private final ItemGroupService itemGroupService;
    private final OrderService orderService;
    private final ItemService itemService;
    private final UserService userService;

    @Autowired
    public BasketService(ItemGroupService itemGroupService, OrderService orderService, ItemService itemService, UserService userService) {
        this.itemGroupService = itemGroupService;
        this.orderService = orderService;
        this.itemService = itemService;
        this.userService = userService;
    }


}
