package com.switchfully.order.service;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.user.User;
import com.switchfully.order.repository.ItemGroupRepository;
import com.switchfully.order.repository.OrderRepository;
import com.switchfully.order.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderServicetest {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemGroupService itemGroupService;
    @Autowired
    ItemGroupRepository itemGroupRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    void whenOrderingItems_AssertThatSaidItemsIsAddedToRepository(){
        orderService.addItemToBasket("DMMYTM3", 2, userService.viewAllCustomers().get(3).getUserId().toString());

        orderService.orderItems(userService.viewAllCustomers().get(3).getUserId().toString());

        Assertions.assertThat(orderRepository.showListOfOrders()).contains(orderService.showAllOrders().get(1));

    }

}