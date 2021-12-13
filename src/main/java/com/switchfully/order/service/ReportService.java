package com.switchfully.order.service;

import com.switchfully.order.domain.order.Order;
import com.switchfully.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private final OrderRepository orderRepository;
    private final ItemGroupService itemGroupService;
    private final ItemService itemService;
    private final Logger orderServiceLogger = LoggerFactory.getLogger(OrderService.class);


    @Autowired
    public ReportService(ItemService itemService, OrderRepository orderRepository, ItemGroupService itemGroupService) {

        this.itemService = itemService;
        this.orderRepository = orderRepository;
        this.itemGroupService = itemGroupService;

    }

    public List<Order> viewAllReportsOfOrders() {

        return orderRepository.showListOfOrders().stream()
                .sorted()
                .toList();
    }


    public List<Order> viewReportOfOrdersByCustomer(String customerId) {
        return orderRepository.showListOfOrders().stream()
                .filter(order -> order.getCustomerId().equals(customerId))
                .toList();


    }
}
