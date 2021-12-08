package com.switchfully.order.repository;

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


    private void fillRepositoryWithDummyItemGroups() {
        LocalDate shippingDate = LocalDate.now();
        ItemGroup dummyItemGroup1 = new ItemGroup("DMMYTM1", shippingDate.plusDays(1), 2);
        ItemGroup dummyItemGroup2 = new ItemGroup("DMMYTM2", shippingDate.plusDays(1), 1);
        ItemGroup dummyItemGroup3 = new ItemGroup("DMMYTM3", shippingDate.plusDays(1), 6);
        ItemGroup dummyItemGroup4 = new ItemGroup("DMMYTM4", shippingDate.plusDays(1), 5);
        ItemGroup dummyItemGroup5 = new ItemGroup("DMMYTM5", shippingDate.plusDays(1), 20);

        dummyItemGroup1.setItemGroupPrice(25*100);
        dummyItemGroup2.setItemGroupPrice(30*1000);
        dummyItemGroup3.setItemGroupPrice(45*10000);
        dummyItemGroup4.setItemGroupPrice(60*10);
        dummyItemGroup5.setItemGroupPrice(99);

        listOfItemGroups.add(dummyItemGroup1);
        listOfItemGroups.add(dummyItemGroup2);
        listOfItemGroups.add(dummyItemGroup3);
        listOfItemGroups.add(dummyItemGroup4);
        listOfItemGroups.add(dummyItemGroup5);
    }

}
