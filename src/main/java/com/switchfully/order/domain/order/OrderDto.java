package com.switchfully.order.domain.order;

import com.switchfully.order.domain.item.ItemGroup;

import java.util.List;

public class OrderDto {

    private int orderNumber;
    private List<ItemGroup> listOfItemsToOrder;

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public OrderDto setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }
    public OrderDto setListOfItemsToOrder(List<ItemGroup> listOfItemsToOrder){
        this.listOfItemsToOrder=listOfItemsToOrder;
        return this;
    }

    public List<ItemGroup> getListOfItemsToOrder(){
        return listOfItemsToOrder;
    }


    @Override
    public String toString() {
        return "[ [ Order ]" +"\n"+
                "* OrderNumber=" + orderNumber  +"\n"+
                "* Items ordered" + listOfItemsToOrder +" ]";
    }
}
