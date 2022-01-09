package com.switchfully.order.service;

import com.switchfully.order.api.mapper.ItemMapper;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;
import com.switchfully.order.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemDto> getAllItems() {
        return itemRepository.findAll().stream()
                .map(item -> itemMapper.mapItemToItemDto(item))
                .collect(Collectors.toList());
    }

    public Item getItemFromListWithId(long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isEmpty()) {
            return null;
        } else return optionalItem.get();
    }

    public double getItemPriceFromList(long itemId) {
        return getItemFromListWithId(itemId).getPrice();
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public void updateItem(Item updateItem, long itemId) {
        if (itemRepository.existsById(itemId)) {
            for (Item item : itemRepository.findAll()) {
                if (item.getItemid() == itemId) {
                    item.changeDescription(updateItem.showDescription());
                    item.changeNameOfItem(updateItem.getNameOfItem());
                    item.changePriceOfItem(updateItem.getPrice());
                    item.changeAmountOfItem(updateItem.showAmountInStock());
                }
            }
        }
    }
}
