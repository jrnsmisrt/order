package com.switchfully.order.service;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.order.Order;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.repository.ItemGroupRepository;
import com.switchfully.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final ItemGroupRepository itemGroupRepository;
    private final OrderRepository orderRepository;
    private final ItemGroupService itemGroupService;
    private final UserService userService;
    private final Logger orderServiceLogger= LoggerFactory.getLogger(OrderService.class);


    @Autowired
    public OrderService(ItemGroupRepository itemGroupRepository, OrderRepository orderRepository, ItemGroupService itemGroupService, UserService userService) {

        this.itemGroupRepository = itemGroupRepository;
        this.orderRepository=orderRepository;
        this.itemGroupService=itemGroupService;
        this.userService=userService;

    }

    public double getTotalPriceForOrder(int orderNumber){
        double totalPriceForOrder=0;
        for(Order order : orderRepository.showListOfOrders()){
            if(order.getOrderNumber()==orderNumber){
               totalPriceForOrder += getItemGroupPriceFromOrder(order);
            }
        }
        return totalPriceForOrder;
    }

    public double getTotalPriceForAllOrders(){
        double totalPriceAllOrders=0;
        for(Order order: orderRepository.showListOfOrders()){
            totalPriceAllOrders+=getTotalPriceForOrder(order.getOrderNumber());
        }
        return totalPriceAllOrders;
    }

    private double getItemGroupPriceFromOrder(Order order) {
        double itemGroupPrice=0;
        for(ItemGroup itemGroup : order.getListOfItemsToOrder()){
            itemGroupPrice+=itemGroupService.getItemGroupPrice(itemGroup);
        }
        return itemGroupPrice;
    }

    public Order showOneOrder(int orderNumber){
        orderServiceLogger.info("Show One Order ordernumber: "+orderNumber+" was executed");
       return orderRepository.showOrderById(orderNumber);
    }

    public List<Order> showAllOrders(){
        orderServiceLogger.info("Show all orders was executed");
        return orderRepository.showListOfOrders();
    }

    public void orderItems(List<ItemGroup> itemsToOrder, String customerId){
        User thisCustomer= userService.getUserById(customerId);
        orderRepository.addOrderItemsToRepository(itemsToOrder, thisCustomer);
        orderServiceLogger.info("A new Order has been placed by: "+thisCustomer.getUserId());
    }


}
