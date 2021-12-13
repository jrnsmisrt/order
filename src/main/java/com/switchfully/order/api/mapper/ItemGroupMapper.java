package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.item.ItemGroupDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemGroupMapper {

    public ItemGroupDto mapItemGroupToItemGroupDto(ItemGroup itemGroup) {
        return new ItemGroupDto()
                .setItem(itemGroup.getItem())
                .changeShippingDate(itemGroup.getShippingDate())
                .setAmount(itemGroup.getAmount())
                .setItemGroupPrice(itemGroup.getItemGroupPrice());
    }

    public ItemGroup mapItemGroupDtoToItemGroup(ItemGroupDto itemGroupDto) {
        return new ItemGroup(itemGroupDto.getItem(),
                itemGroupDto.getShippingDate(),
                itemGroupDto.getAmount());

    }

    public List<ItemGroup> mapItemGroupDtoListToItemGroupList(List<ItemGroupDto> itemGroupDtoList) {
        List<ItemGroup> itemGroupList = new ArrayList<>();
        for (ItemGroupDto itemGroupDto : itemGroupDtoList) {
            itemGroupList.add(mapItemGroupDtoToItemGroup(itemGroupDto));
        }
        return itemGroupList;
    }

    public List<ItemGroupDto> mapItemGroupListToItemGroupDtoList(List<ItemGroup> itemGroupList) {
        List<ItemGroupDto> itemGroupDtolist = new ArrayList<>();
        for (ItemGroup itemGroup : itemGroupList) {
            itemGroupDtolist.add(mapItemGroupToItemGroupDto(itemGroup));
        }
        return itemGroupDtolist;
    }

}
