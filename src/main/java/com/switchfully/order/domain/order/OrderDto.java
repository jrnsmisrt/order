package com.switchfully.order.domain.order;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.user.User;

import java.util.List;

public class OrderDto {
    private long customerId;
    private double price;
    private long orderNumber;
    private List<ItemGroup> listOfItemsToOrder;
    private String itemGroups;

    public long getOrderNumber(){
        return this.orderNumber;
    }
    public OrderDto setOrderNumber(long orderNumber){
        this.orderNumber=orderNumber;
        return this;
    }

    public OrderDto setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    public List<ItemGroup> getListOfItemsToOrder(){
        return listOfItemsToOrder;
    }
    public long getCustomerId(){
        return customerId;
    }

    public OrderDto setPrice(double price){
        this.price=price;
        return this;
    }
    public double getPrice(){
        return price;
    }

    public OrderDto setListOfItemsToOrder(List<ItemGroup> listOfItemsToOrder) {
        this.listOfItemsToOrder=listOfItemsToOrder;
        return this;
    }
    public String getListOfItemGroups(){
        StringBuilder itemGroupsOfOrder = new StringBuilder();
        for(ItemGroup itemGroup : listOfItemsToOrder){
            itemGroupsOfOrder.append(itemGroup);
        }

        return itemGroupsOfOrder.toString().trim();
    }
    @Override
    public String toString() {
        return "Order: ("+orderNumber+")\n"+
                getListOfItemGroups()+"\n"+
                "Total price: "+getPrice();
    }


}
