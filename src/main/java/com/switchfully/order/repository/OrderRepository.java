package com.switchfully.order.repository;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.user.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> listOfOrders;

    public OrderRepository() {
        this.listOfOrders = new ArrayList<>();
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

    public void addOrderItemsToRepository(List<ItemGroup> listOfItems, User customer){
        listOfOrders.add(new Order(listOfItems,customer));
    }

    private void fillRepositoryWithDummyOrders(){
        List<ItemGroup> dummyOrderList = new ArrayList<>();
        User dummyCustomer = new User("Dummy1", "Customer1", "customer1@order.com", "orderstreet 2, Brussels", "020");
        LocalDate shippingDate = LocalDate.now();
        ItemGroup dummyItemGroup1 = new ItemGroup("DMMYITM1", shippingDate.plusDays(1), 2);
        ItemGroup dummyItemGroup2 = new ItemGroup("DMMYITM2", shippingDate.plusDays(1) ,1);
        ItemGroup dummyItemGroup3 = new ItemGroup("DMMYITM3", shippingDate.plusDays(1), 6);
        ItemGroup dummyItemGroup4 = new ItemGroup("DMMYITM4", shippingDate.plusDays(1), 5);
        ItemGroup dummyItemGroup5 = new ItemGroup("DMMYITM5", shippingDate.plusDays(1), 20);
        dummyOrderList.add(dummyItemGroup1);
        dummyOrderList.add(dummyItemGroup2);
        dummyOrderList.add(dummyItemGroup3);
        dummyOrderList.add(dummyItemGroup4);
        dummyOrderList.add(dummyItemGroup5);
        Order dummyOrder = new Order(dummyOrderList, dummyCustomer);

        listOfOrders.add(dummyOrder);
    }

}
