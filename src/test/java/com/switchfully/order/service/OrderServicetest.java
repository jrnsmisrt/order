package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.item.ItemGroupDto;
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

//    @Test
//    void whenOrderingItems_AssertThatSaidItemsIsAddedToRepository(){
//        ItemGroupDto itemDtoMock = new ItemGroupDto().setItem(new Item("test","test", 20, 10)).setAmount(2).changeShippingDate(LocalDate.parse("2021-02-01"));
//        orderService.addItemToBasket("2", itemDtoMock);
//
//        orderService.orderItems(Long.toString(userService.viewAllCustomers().get(3).getUserId()));
//
//        Assertions.assertThat(orderRepository.showListOfOrders()).contains(orderService.showAllOrders().get(1));
//
//    }

}
