package com.switchfully.order.service;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.repository.ItemRepository;
import com.switchfully.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private OrderRepository orderRepository;
    private ItemRepository itemRepository;
    private ItemGroupService itemGroupService;
    private List<ItemGroup> basket;


    @Autowired
    public CustomerService(OrderRepository orderRepository, ItemGroupService itemGroupService, ItemRepository itemRepository) {

        this.orderRepository = orderRepository;
        this.itemGroupService = itemGroupService;
        this.itemRepository = itemRepository;
        this.basket = new ArrayList<>();
    }

    public void addToBasket(String itemId, int amount) {
        for(Item item : itemRepository.showListOfItems()){
            if(item.getItemid().equals(itemId)){
                basket.add(itemGroupService.createItemGroup(item, amount));

            }
        }

    }

    public void placeOrder(Customer customer) {
        Order thisOrder = new Order(this.basket, customer);
        orderRepository.showListOfOrders().add(thisOrder);

    }


    public void clearBasket() {
        this.basket.clear();
    }

    public List<ItemGroup> showBasket() {
        return this.basket;
    }

    public List<Order> viewReportOfOrders(Customer customer){
        return orderRepository.showListOfOrders().stream()
                .sorted(Comparator.comparingInt(Order::getOrderNumber))
                .collect(Collectors.toList());
    }

    public void reOrderExistingOrder(int orderNumber, Customer customer){
        Order reOrder = orderRepository.showOrderById(orderNumber);
        orderRepository.showListOfOrders().add(reOrder);
    }

}
