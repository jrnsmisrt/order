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
        price=getPrice();
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

    public void setPrice(){
        double orderPrice = 0;
        for(ItemGroup itemGroup : getListOfItemsToOrder()){
           orderPrice+=itemGroup.getItemGroupPrice();
        }
        this.price=orderPrice;
    }
    public double getPrice(){
        setPrice();
        return price;
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
