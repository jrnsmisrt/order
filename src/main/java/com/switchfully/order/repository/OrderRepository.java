package com.switchfully.order.repository;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.user.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Repository
public class OrderRepository {
    private List<Order> listOfOrders;
    private HashMap<String, ItemGroup> basket;
    private ItemGroupRepository itemGroupRepository;

    public OrderRepository(ItemGroupRepository itemGroupRepository) {
        this.listOfOrders = new ArrayList<>();
        this.itemGroupRepository=itemGroupRepository;
        this.basket= new HashMap<>();
        fillRepositoryWithDummyOrders();
    }

    public List<Order> showListOfOrders() {
        return listOfOrders;
    }

    public Order showOrderById(int orderNumber) {
        for (Order order : listOfOrders) {
            if (order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        return null;
    }
    public List<ItemGroup> showBasket(String customerId){
        return basket.entrySet().stream()
                .filter(key -> basket.containsKey(customerId))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public void addOrderItemsToRepository(List<ItemGroup> listOfItems, String customerId){
        listOfOrders.add(new Order(listOfItems, customerId));
    }
    public void addItemGroupToBasket(ItemGroup itemGroup, String customerId){
        basket.put(customerId, itemGroup);
    }
    public HashMap<String,ItemGroup> getBasket(){
        return basket;
    }

    private void fillRepositoryWithDummyOrders(){
        List<ItemGroup> dummyOrderList = new ArrayList<>();
        User dummyCustomer = new User("Dummy1", "Customer1", "customer1@order.com", "orderstreet 2, Brussels", "020");
        LocalDate shippingDate = LocalDate.now();
        Item dummyItem5 = new Item("Dummyitem5", "dummy dummy", 99, 1);
        ItemGroup dummyItemGroup = new ItemGroup(dummyItem5,shippingDate,5);

        dummyOrderList.add(dummyItemGroup);
        dummyOrderList.add(dummyItemGroup);

        Order dummyOrder = new Order(dummyOrderList, Long.toString(dummyCustomer.getUserId()));

        listOfOrders.add(dummyOrder);
    }

}
