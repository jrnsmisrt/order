package com.switchfully.order.repository;

import com.switchfully.order.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ItemRepository {
    private List<Item> listOfItems;

    public ItemRepository(){
        this.listOfItems = new ArrayList<>();
        fillRepositoryWithDummyItems();
    }

    public void addItem(Item item){
        listOfItems.add(item);
    }

    public List<Item> showListOfItems(){
        return listOfItems;
    }

    private void fillRepositoryWithDummyItems() {
        Item dummyItem1 = new Item("DummyItem1", "dummy dummy", 25, 100);
        Item dummyItem2 = new Item("DummyItem2", "dummy dummy", 30, 1000);
        Item dummyItem3 = new Item("DummyItem3", "dummy dummy", 45, 10000);
        Item dummyItem4 = new Item("DummyItem4", "dummy dummy", 60, 10);
        Item dummyItem5 = new Item("DummyItem5", "dummy dummy", 99, 1);
        listOfItems.add(dummyItem1);
        listOfItems.add(dummyItem2);
        listOfItems.add(dummyItem3);
        listOfItems.add(dummyItem4);
        listOfItems.add(dummyItem5);
    }

}
