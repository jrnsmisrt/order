package com.switchfully.order.service;

import com.switchfully.order.domain.order.Order;

import com.switchfully.order.repository.ItemGroupRepository;
import com.switchfully.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final ItemGroupRepository itemGroupRepository;
    private OrderRepository orderRepository;


    @Autowired
    public OrderService(ItemGroupRepository itemGroupRepository, OrderRepository orderRepository) {

        this.itemGroupRepository = itemGroupRepository;
        this.orderRepository=orderRepository;

    }

    public double getTotalPriceForOrder(int orderNumber){
        for(Order order : orderRepository.showListOfOrders()){
            if(order.getOrderNumber()==orderNumber){
                return order.getTotalPrice();
            }
        }
        return 0;
    }

    public Order showOneOrder(int orderNumber){
       return orderRepository.showOrderById(orderNumber);
    }


}
