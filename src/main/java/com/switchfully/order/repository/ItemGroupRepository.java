package com.switchfully.order.repository;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemGroup;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemGroupRepository {
    private List<ItemGroup> listOfItemGroups;
    private final ItemRepository itemRepository;

    public ItemGroupRepository(ItemRepository itemRepository) {
        this.listOfItemGroups = new ArrayList<>();
        fillRepositoryWithDummyItemGroups();
        this.itemRepository=itemRepository;
    }

    public List<ItemGroup> getListOfItemGroups(){
        return listOfItemGroups;
    }

    private void fillRepositoryWithDummyItemGroups() {
        LocalDate shippingDate = LocalDate.now();
        Item dummyItem1 = new Item("dummyItem1","dummy",10,2);
        ItemGroup dummyItemGroup1 = new ItemGroup(dummyItem1, shippingDate.plusDays(1), 2);
        ItemGroup dummyItemGroup2 = new ItemGroup(dummyItem1, shippingDate.plusDays(1), 10);

        listOfItemGroups.add(dummyItemGroup1);
        listOfItemGroups.add(dummyItemGroup2);

    }

}
