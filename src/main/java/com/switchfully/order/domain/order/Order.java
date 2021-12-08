package com.switchfully.order.domain.order;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.user.User;

import java.util.List;

public class Order {
    private String customerId;
    private double price;
    private int orderNumber;
    private static int orderCounter;
    private List<ItemGroup> listOfItemsToOrder;

    public Order(List<ItemGroup> itemsToOrder, String customerId) {
        this.listOfItemsToOrder=itemsToOrder;
        this.customerId=customerId;
        orderCounter++;
        orderNumber=orderCounter;
        price=0;
    }
    public int getOrderNumber(){
        return this.orderNumber;
    }
    public List<ItemGroup> getListOfItemsToOrder(){
        return listOfItemsToOrder;
    }
    public String getCustomerId(){
        return customerId;
    }

    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "[ [ Order ]" +"\n"+
                "* OrderNumber=" + orderNumber  +"\n"+
                "* Items ordered" + listOfItemsToOrder +" ]";
    }
}
