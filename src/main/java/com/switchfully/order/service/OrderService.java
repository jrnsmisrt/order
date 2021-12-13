package com.switchfully.order.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.order.Order;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.repository.ItemGroupRepository;
import com.switchfully.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemGroupService itemGroupService;
    private final ItemService itemService;
    private final Logger orderServiceLogger = LoggerFactory.getLogger(OrderService.class);


    @Autowired
    public OrderService(ItemService itemService, OrderRepository orderRepository, ItemGroupService itemGroupService) {

        this.itemService = itemService;
        this.orderRepository = orderRepository;
        this.itemGroupService = itemGroupService;

    }

    public double calculatePriceOfOrder(List<ItemGroup> itemGroupList) {
        double orderPrice = 0;
        for (ItemGroup itemGroup : itemGroupList) {
            orderPrice += itemGroupService.getItemGroupPrice(itemGroup);
        }
        return orderPrice;
    }

    public double calculateTotalPriceOfOrders(String customerId) {
        double totalPriceOfOrders = 0;
        for (Order order : orderRepository.showListOfOrders()) {
            if (order.getCustomerId().equals(customerId)) {
                totalPriceOfOrders += order.getPrice();
            }
        }
        return totalPriceOfOrders;
    }


    public Order showOneOrder(int orderNumber) {
        orderServiceLogger.info("Show One Order ordernumber: " + orderNumber + " was executed");
        return orderRepository.showOrderById(orderNumber);
    }

    public List<Order> showAllOrders() {
        orderServiceLogger.info("Show all orders was executed");
        return orderRepository.showListOfOrders();
    }

    public void addItemToBasket(String itemId, int amount, String customerId) {
        Item basketItem = itemService.getItemFromListWithId(itemId);
        ItemGroup thisItemGroup = new ItemGroup(basketItem, itemGroupService.calculateShippingDate(itemId), 2);
        orderRepository.addItemGroupToBasket(thisItemGroup, customerId);

    }

    public double orderItems(String customerId) {
        List<ItemGroup> itemsFromBasket = new ArrayList<>();
        double orderPrice = calculatePriceOfOrder(itemsFromBasket);

        for (HashMap.Entry<String, ItemGroup> entry : orderRepository.getBasket().entrySet()) {
            if (entry.getKey().equals(customerId)) {

                itemsFromBasket.add(entry.getValue());

            }
        }
        orderRepository.addOrderItemsToRepository(itemsFromBasket, customerId);

        orderServiceLogger.info("A new Order has been placed by: " + customerId);
        return orderPrice;
    }

    public String viewReportOfOrders(String customerId) {
        List<Order> orderReportList = orderRepository.showListOfOrders().stream()
                .filter(order -> order.getCustomerId().equals(customerId))
                .collect(Collectors.toList());

        return "Report Of Orders:: \n" +
                orderReportList + "\n" +
                "Total Price Of Orders :" + calculateTotalPriceOfOrders(customerId);


    }


}
