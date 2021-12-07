package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItemFromListWithId(String id){
        for(Item item : itemRepository.showListOfItems()){
            if(item.getItemid().equals(id)){
                return item;
            }

        }
        return null;
    }

    public void addItem(Item item){

        itemRepository.addItem(item);
    }
}
