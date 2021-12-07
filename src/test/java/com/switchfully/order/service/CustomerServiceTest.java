package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.*;

import java.util.List;

@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;
    @Autowired
    ItemGroupService itemGroupService;
    @Autowired
    ItemService itemService;


    @Test
    void whenAddingItemToBasket_BasketShouldHoldSaidItem(){
        //
    }
}
