package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.repository.ItemGroupRepository;
import com.switchfully.order.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ItemGroupService {
    private final ItemRepository itemRepository;
    private final ItemGroupRepository itemGroupRepository;
    private final ItemService itemService;


    @Autowired
    public ItemGroupService(ItemRepository itemRepository, ItemService itemService, ItemGroupRepository itemGroupRepository) {
        this.itemRepository = itemRepository;
        this.itemGroupRepository = itemGroupRepository;
        this.itemService = itemService;
    }


    public ItemGroup createItemGroup(String itemId, int amount) {
        return new ItemGroup(itemId, calculateShippingDate(itemId),amount);
    }

    public LocalDate calculateShippingDate(String itemId) {
        LocalDate shippingDate = LocalDate.now();
        if(itemService.getItemFromListWithId(itemId).showAmountInStock()>0){
            return shippingDate.plusDays(1);
        }else{
            return shippingDate.plusDays(7);
        }
    }

    public double calculateItemGroupPrice(ItemGroup itemGroup) {
        double price = itemGroup.getAmount()*itemService.getItemPriceFromList(itemGroup.getItemId());
        itemGroup.setItemGroupPrice(price);
        return price;
    }

}
