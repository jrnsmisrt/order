package com.switchfully.order.domain.basket;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemGroup;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<ItemGroup> basket;
    private Customer customer;

    public Basket(Customer customer){
        this.basket=new ArrayList<>();
        this.customer=customer;
    }

    public void addItemGroupToBasket(ItemGroup itemgroup){
        basket.add(itemgroup);
    }

    public void removeItemGroupFromBasket(ItemGroup itemGroup){
        basket.remove(itemGroup);
    }
}
