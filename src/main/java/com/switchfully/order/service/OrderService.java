package com.switchfully.order.service;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.repository.CustomerRepository;
import com.switchfully.order.repository.ItemGroupRepository;
import com.switchfully.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final CustomerRepository customerRepository;
    private final ItemGroupRepository itemGroupRepository;
    private OrderRepository orderRepository;
    private CustomerService customerService;

    @Autowired
    public OrderService(CustomerRepository customerRepository, ItemGroupRepository itemGroupRepository, OrderRepository orderRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.itemGroupRepository = itemGroupRepository;
        this.orderRepository=orderRepository;
        this.customerService=customerService;
    }

    public double getTotalPriceForOrder(int orderNumber){
        for(Order order : orderRepository.showListOfOrders()){
            if(order.getOrderNumber()==orderNumber){
                return order.getTotalPrice();
            }
        }
        return 0;
    }

    public Order placeOrder(List<ItemGroup> itemBasket, Customer customer){
        Order thisOrder = new Order(itemBasket, customer);
        orderRepository.showListOfOrders().add(thisOrder);
        customerService.showBasket().clear();
        return showOneOrder(thisOrder.getOrderNumber());
    }

    public Order showOneOrder(int orderNumber){
       return orderRepository.showOrderById(orderNumber);
    }


}
