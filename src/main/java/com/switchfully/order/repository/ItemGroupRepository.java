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
    }

    public List<ItemGroup> getListOfItemGroups(){
        return listOfItemGroups;
    }

}
