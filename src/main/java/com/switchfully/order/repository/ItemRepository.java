package com.switchfully.order.repository;

import com.switchfully.order.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ItemRepository {
    private List<Item> listOfItems;

    public void addItem(Item item){
        listOfItems.add(item);
    }

    public List<Item> showListOfItems(){
        return listOfItems;
    }

}
