package com.switchfully.order.service;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private OrderService orderService;
    private OrderRepository orderRepository;
    private ItemGroupService itemGroupService;
    private List<ItemGroup> basket;

    @Autowired
    public CustomerService(OrderService orderService,OrderRepository orderRepository, ItemGroupService itemGroupService) {
        this.orderService=orderService;
        this.orderRepository = orderRepository;
        this.itemGroupService=itemGroupService;
        this.basket = new ArrayList<>();
    }

    public void addToBasket(Item item, int amount){
        basket.add(itemGroupService.createItemGroup(item, amount));
    }

    public Order placeOrder(Customer customer){
        return orderService.placeOrder(this.basket, customer);

    }
    public void clearBasket(){
        this.basket.clear();
    }

    public List<ItemGroup> showBasket(){
        return this.basket;
    }

}
