package com.switchfully.order.repository;

import com.switchfully.order.domain.item.ItemGroup;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemGroupRepository {
    private List<ItemGroup> listOfItemGroups;

    public ItemGroupRepository() {
        this.listOfItemGroups = new ArrayList<>();
        fillRepositoryWithDummyItemGroups();
    }

    public List<ItemGroup> getListOfItemGroups() {
        return listOfItemGroups;
    }

    private void fillRepositoryWithDummyItemGroups() {
        LocalDate shippingDate = LocalDate.now();
        ItemGroup dummyItemGroup1 = new ItemGroup("DMMYITM1", shippingDate.plusDays(1), 2);
        ItemGroup dummyItemGroup2 = new ItemGroup("DMMYITM2", shippingDate.plusDays(1), 1);
        ItemGroup dummyItemGroup3 = new ItemGroup("DMMYITM3", shippingDate.plusDays(1), 6);
        ItemGroup dummyItemGroup4 = new ItemGroup("DMMYITM4", shippingDate.plusDays(1), 5);
        ItemGroup dummyItemGroup5 = new ItemGroup("DMMYITM5", shippingDate.plusDays(1), 20);

        listOfItemGroups.add(dummyItemGroup1);
        listOfItemGroups.add(dummyItemGroup2);
        listOfItemGroups.add(dummyItemGroup3);
        listOfItemGroups.add(dummyItemGroup4);
        listOfItemGroups.add(dummyItemGroup5);
    }

}
