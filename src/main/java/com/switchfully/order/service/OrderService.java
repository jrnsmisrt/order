package com.switchfully.order.service;

import com.switchfully.order.domain.item.ItemGroup;
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
    private ItemGroupService itemGroupService;


    @Autowired
    public OrderService(ItemGroupRepository itemGroupRepository, OrderRepository orderRepository, ItemGroupService itemGroupService) {

        this.itemGroupRepository = itemGroupRepository;
        this.orderRepository=orderRepository;
        this.itemGroupService=itemGroupService;

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
       return orderRepository.showOrderById(orderNumber);
    }

    public List<Order> showAllOrders(){
        return orderRepository.showListOfOrders();
    }

    public void orderItems(List<ItemGroup> itemsToOrder){
        orderRepository.addOrderItemsToRepository(itemsToOrder);
    }


}
