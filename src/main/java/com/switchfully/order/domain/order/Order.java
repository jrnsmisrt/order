package com.switchfully.order.domain.order;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderNumber;
    @Column(name = "fk_customer_id")
    private long customerId;
    @Column(name = "price")
    private double price;
    @Transient
    private String orderedItems;
    @Transient
    private List<ItemGroup> listOfItemsToOrder;

    public Order(List<ItemGroup> itemsToOrder, long customerId) {
        this.customerId = customerId;
        this.price = getPrice();
        this.orderedItems=itemsToOrder.toString();
    }

    public Order() {

    }

    public long getOrderNumber() {
        return this.orderNumber;
    }

    public List<ItemGroup> getListOfItemsToOrder() {
        return listOfItemsToOrder;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setPrice() {
        double orderPrice = 0;
        for (ItemGroup itemGroup : getListOfItemsToOrder()) {
            orderPrice += itemGroup.getItemGroupPrice();
        }
        this.price = orderPrice;
    }

    public double getPrice() {
        setPrice();
        return price;
    }
/*
    public String getListOfItemGroups() {
        StringBuilder itemGroupsOfOrder = new StringBuilder();
        for (ItemGroup itemGroup : listOfItemsToOrder) {
            itemGroupsOfOrder.append(itemGroup);
        }

        return itemGroupsOfOrder.toString().trim();
    }

    @Override
    public String toString() {
        return "Order: (" + orderNumber + ")\n" +
                getListOfItemGroups() + "\n" +
                "Total price: " + getPrice();
    }*/
}
