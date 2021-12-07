package com.switchfully.order.domain.order;

import com.switchfully.order.domain.item.ItemGroup;

import java.util.List;

public class Order {
    private int orderNumber;
    private static int orderCounter;
    private double totalPrice;
    private List<ItemGroup> listOfItemsToOrder;

    public Order(List<ItemGroup> itemsToOrder) {
        this.listOfItemsToOrder=itemsToOrder;
        orderCounter++;
        orderNumber=orderCounter;
    }
    public int getOrderNumber(){
        return this.orderNumber;
    }



    public double getTotalPrice() {

        for(ItemGroup itemGroup: listOfItemsToOrder){
            totalPrice+=itemGroup.getItemGroupPrice();
        }

        return totalPrice;
    }

    public List<ItemGroup> getListOfItemsToOrder(){
        return listOfItemsToOrder;
    }


    @Override
    public String toString() {
        return "[ [ Order ]" +"\n"+
                "* OrderNumber=" + orderNumber  +"\n"+
                "* Items ordered" + listOfItemsToOrder +"\n"+
                "* TotalPrice=" + totalPrice+" EUR  ]";
    }
}
