package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;

public class ItemMapper {

    public ItemDto mapItemToItemDto(Item item){
        return new ItemDto()
                .setName(item.getNameOfItem())
                .setItemId(item.getItemid())
                .setPrice(item.getPrice())
                .changeDescription(item.showDescription())
                .setAmountInStock(item.showAmountInStock());

    }

    public Item mapItemDtoToItem(ItemDto itemDto){
        return new Item(itemDto.showName(),
                itemDto.showDescription(),
                itemDto.getPrice(),
                itemDto.ShowAmountInStock());
    }

}
