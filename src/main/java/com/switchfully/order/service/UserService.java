package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.repository.ItemRepository;
import com.switchfully.order.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public UserService(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item){

        itemRepository.addItem(item);
    }

}
