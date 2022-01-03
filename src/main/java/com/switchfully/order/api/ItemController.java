package com.switchfully.order.api;

import com.switchfully.order.api.mapper.ItemMapper;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;
import com.switchfully.order.repository.ItemRepository;
import com.switchfully.order.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final ItemService itemService;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper, ItemRepository itemRepository) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
        this.itemRepository=itemRepository;
    }

    @GetMapping(produces="application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> viewAllItems(){
        return itemRepository.showListOfItems().stream()
                .map(itemMapper::mapItemToItemDto)
                .collect(Collectors.toList());
    }

    @GetMapping(produces="application/json", path="/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDto viewItem(@PathVariable long itemId){
        return itemMapper.mapItemToItemDto(itemService.getItemFromListWithId(itemId));
    }

    @GetMapping(produces="application/json", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody ItemDto item){
        itemService.addItem(itemMapper.mapItemDtoToItem(item));
    }

    /*@GetMapping(produces="application/json", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateItem(@RequestBody ItemDto item, String itemId){
        itemService.updateItem(itemMapper.mapItemDtoToItem(item),itemId);
    }*/

}
