package com.switchfully.order.repository;

import com.switchfully.order.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> listOfOrders;

    public OrderRepository() {
        this.listOfOrders=new ArrayList<>();
    }

    public List<Order> showListOfOrders(){
        return listOfOrders;
    }

    public Order showOrderById(int orderNumber){
        for(Order order : listOfOrders){
            if(order.getOrderNumber()==orderNumber){
                return order;
            }
        }
        return null;
    }

}
