package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto mapItemToItemDto(Item item) {
        return new ItemDto()
                .setName(item.getNameOfItem())
                .setItemId(item.getItemid())
                .setPrice(item.getPrice())
                .changeDescription(item.showDescription())
                .setAmountInStock(item.showAmountInStock());

    }

    public Item mapItemDtoToItem(ItemDto itemDto) {
        Item itemFromDto = new Item(itemDto.showName(),
                itemDto.showDescription(),
                itemDto.getPrice(),
                itemDto.ShowAmountInStock());
        itemFromDto.setName(itemDto.showName());
        return itemFromDto;
    }

}
