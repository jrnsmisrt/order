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

    public Item getItemFromListWithId(long id){
        for(Item item : itemRepository.findAll()){
            if(item.getItemid()==id){
                return item;
            }

        }
        return null;
    }

    public double getItemPriceFromList(long itemId){
        return getItemFromListWithId(itemId).getPrice();
    }

    public void addItem(Item item){
        itemRepository.save(item);
    }

    public void updateItem(Item updateItem, long itemId){
        for(Item item : itemRepository.findAll()){
            if(item.getItemid()==itemId){
                item.changeDescription(updateItem.showDescription());
                item.changeNameOfItem(updateItem.getNameOfItem());
                item.changePriceOfItem(updateItem.getPrice());
                item.changeAmountOfItem(updateItem.showAmountInStock());
            }
        }
    }
}
