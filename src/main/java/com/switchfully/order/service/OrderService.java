package com.switchfully.order.service;

import com.switchfully.order.api.mapper.ItemGroupMapper;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.item.ItemGroupDto;
import com.switchfully.order.domain.order.Order;


import com.switchfully.order.repository.OrderRepository;
import com.switchfully.order.repository.UserBasketRepository;
import com.switchfully.order.security.exceptions.CustomerDoesNotExistException;
import com.switchfully.order.security.exceptions.ItemBasketIsEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderService {

    private OrderRepository orderRepository;
    private final ItemGroupService itemGroupService;
    private final ItemService itemService;
    private final Logger orderServiceLogger = LoggerFactory.getLogger(OrderService.class);
    private final ItemGroupMapper itemGroupMapper;
    private UserBasketRepository userBasketRepository;


    @Autowired
    public OrderService(ItemService itemService, OrderRepository orderRepository, ItemGroupService itemGroupService, ItemGroupMapper itemGroupMapper, UserBasketRepository userBasketRepository) {

        this.itemService = itemService;
        this.orderRepository = orderRepository;
        this.itemGroupService = itemGroupService;

        this.itemGroupMapper = itemGroupMapper;
        this.userBasketRepository = userBasketRepository;
    }

    public double calculatePriceOfOrder(List<ItemGroup> itemGroupList) {
        double orderPrice = 0;
        for (ItemGroup itemGroup : itemGroupList) {
            orderPrice += itemGroupService.getItemGroupPrice(itemGroup);
        }
        return orderPrice;
    }

    public double calculateTotalPriceOfOrders(long customerId) {
        double totalPriceOfOrders = 0;
        for (Order order : orderRepository.findAll()) {
            if (order.getCustomerId()==(customerId)) {
                totalPriceOfOrders += order.getPrice();
            }
        }
        return totalPriceOfOrders;
    }


    public Order showOneOrder(long orderNumber) {
        orderServiceLogger.info("Show One Order ordernumber: " + orderNumber + " was executed");
        Optional<Order> optionalOrder = orderRepository.findById(orderNumber);
        if(optionalOrder.isEmpty()){
            throw new NullPointerException("order not found");
        }
        return optionalOrder.get();
    }

    public List<Order> showAllOrders() {
        orderServiceLogger.info("Show all orders was executed");
        return orderRepository.findAll().stream().collect(Collectors.toList());
    }

    public void addItemToBasket(long customerId, ItemGroupDto item) {
        userBasketRepository.addItemGroupToBasket(customerId, itemGroupMapper.mapItemGroupDtoToItemGroup(item));
    }

    public List<ItemGroupDto> showContentsOfBasket(long customerId) {
        if(!(userBasketRepository.getCompleteBasket().containsKey(customerId))) throw new CustomerDoesNotExistException("customer not found");
        if(userBasketRepository.getBasketForCustomer(customerId).isEmpty()) throw new ItemBasketIsEmptyException("Basket is empty");
        return itemGroupMapper.mapItemGroupListToItemGroupDtoList(userBasketRepository.getBasketForCustomer(customerId));
    }


    public void orderItems(long customerId) {

        List<ItemGroup> itemsFromBasket = new ArrayList<>();
        for (ItemGroup i : userBasketRepository.getBasketForCustomer(customerId)) {
            itemsFromBasket.add(i);
        }
        orderRepository.save(new Order(itemsFromBasket, customerId));

        orderRepository.findById(customerId).get().setPrice();

        userBasketRepository.emptyBasket(customerId);

        orderServiceLogger.info("A new Order has been placed by: " + customerId);
    }


}


