package com.switchfully.order.repository;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.security.exceptions.ItemBasketIsEmptyException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserBasketRepository {
    private HashMap<String, List<ItemGroup>> basket;


    public UserBasketRepository() {
        this.basket = new HashMap<>();
    }

    public HashMap<String, List<ItemGroup>> getCompleteBasket() {
        return basket;
    }

    public List<ItemGroup> getBasketForCustomer(String customerId) {
//        if(!basket.containsKey(customerId)){
//            throw new NullPointerException("Customer not found");
//        }
        return basket.get(customerId);
    }

    public void addItemGroupToBasket(String customerId, ItemGroup itemGroup) {
        if (!basket.containsKey(customerId)) {
            List<ItemGroup> newItemGroupList = new ArrayList<>();
            newItemGroupList.add(itemGroup);
            basket.put(customerId, newItemGroupList);
        } else {
            basket.get(customerId).add(itemGroup);
            }
        }


    public void removeItemGroupFromBasket(String customerId, ItemGroup itemGroup) {
        for (List<ItemGroup> i : basket.values()) {
            if (!basket.get(customerId).contains(itemGroup)) {
                throw new NullPointerException("Item not found");
            }
            basket.get(customerId).remove(itemGroup);
        }
    }

    public void emptyBasket(String customerId) {
        for (List<ItemGroup> i : basket.values()) {

            if (basket.get(customerId).isEmpty()) {
                throw new ItemBasketIsEmptyException("Can not empty the basket when the basket is already empty");
            } else {
                basket.get(customerId).clear();
            }
        }
    }

}
