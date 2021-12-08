package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemServiceTest {
    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;

    @Test
    void givenItemId_WhenGettingItemFromListWithId_AssertCorrectItemIsReturned() {
        String givenItemId = "DMMYTM1";
        Item testItem = new Item("DummyItem1", "dummy dummy", 25, 100);
        Assertions.assertThat(itemService.getItemFromListWithId(givenItemId)).isEqualTo(testItem);
    }

    @Test
    void givenNewItem_WhenAddingItem_AssertItemIsAddedToRepository() {
        Item testItem = new Item("testItem", "testItem", 20, 1);
        itemService.addItem(testItem);
        Assertions.assertThat(itemRepository.showListOfItems()).contains(testItem);
    }

    @Test
    void givenUpdateParameters_WhenUpdatingItem_AssertUpdatedItemContainsGivenParameters(){
        Item testItem = new Item("testItem", "testItem", 20, 1);
        itemService.updateItem(testItem,"DMMYTM1");
        Assertions.assertThat(itemService.getItemFromListWithId("DMMYTM1")).isEqualTo(testItem);
    }
}
