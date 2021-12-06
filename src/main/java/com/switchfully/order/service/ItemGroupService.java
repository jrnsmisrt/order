package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemGroupService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemGroupService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemGroup createItemGroup(Item item, int amount){
        return new ItemGroup(item.getItemid(), amount);
    }
}
