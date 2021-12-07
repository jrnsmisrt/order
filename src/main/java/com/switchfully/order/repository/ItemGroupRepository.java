package com.switchfully.order.repository;

import com.switchfully.order.domain.item.ItemGroup;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemGroupRepository {
    private List<ItemGroup> listOfItemGroups;

    public ItemGroupRepository(){
        this.listOfItemGroups=new ArrayList<>();
        fillRepositoryWithDummyItemGroups();
    }

    public List<ItemGroup> getListOfItemGroups(){
        return listOfItemGroups;
    }

    private void fillRepositoryWithDummyItemGroups(){
       ItemGroup dummyItemGroup1 = new ItemGroup("DMMYITM1", 2);
       ItemGroup dummyItemGroup2 = new ItemGroup("DMMYITM2", 1);
       ItemGroup dummyItemGroup3 = new ItemGroup("DMMYITM3", 6);
       ItemGroup dummyItemGroup4 = new ItemGroup("DMMYITM4", 5);
       ItemGroup dummyItemGroup5 = new ItemGroup("DMMYITM5", 20);

       listOfItemGroups.add(dummyItemGroup1);
       listOfItemGroups.add(dummyItemGroup2);
       listOfItemGroups.add(dummyItemGroup3);
       listOfItemGroups.add(dummyItemGroup4);
       listOfItemGroups.add(dummyItemGroup5);
    }

}
