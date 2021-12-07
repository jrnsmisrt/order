package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.item.ItemGroupDto;
import org.springframework.stereotype.Component;

@Component
public class ItemGroupMapper {

    public ItemGroupDto mapItemGroupToItemGroupDto(ItemGroup itemGroup) {
        return new ItemGroupDto()
                .setItemid(itemGroup.getItemId())
                .setAmount(itemGroup.getAmount());
    }

    public ItemGroup mapItemGroupDtoToItemGroup(ItemGroupDto itemGroupDto){
        return new ItemGroup(itemGroupDto.getItemGroupId(),
                itemGroupDto.getAmount());
    }

}
