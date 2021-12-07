package com.switchfully.order.api;

import com.switchfully.order.api.mapper.ItemMapper;
import com.switchfully.order.domain.item.ItemDto;
import com.switchfully.order.repository.ItemRepository;
import com.switchfully.order.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
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
