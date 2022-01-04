package com.switchfully.order.api;

import com.switchfully.order.api.mapper.OrderMapper;
import com.switchfully.order.domain.order.OrderDto;
import com.switchfully.order.repository.OrderRepository;
import com.switchfully.order.service.OrderService;
import com.switchfully.order.service.ReportService;
import com.switchfully.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/reports")
public class ReportController {
    private final ReportService reportService;
    private final OrderMapper orderMapper;

    @Autowired
    public ReportController(ReportService reportService, OrderMapper orderMapper) {
        this.reportService = reportService;
        this.orderMapper = orderMapper;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String viewAllReportsOfOrder() {
        List<OrderDto> allOrdersReportList =  reportService.viewAllReportsOfOrders().stream()
                .map(orderMapper::mapOrderToOrderDto)
                .sorted()
                .collect(Collectors.toList());

        return allOrdersReportList.toString();
    }

    @GetMapping(produces = "application/json")
    @RequestMapping(path = "/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public String viewReportOfOrdersByCustomer(@PathVariable long customerId) {
        return reportService.viewReportOfOrdersByCustomer(customerId).stream()
                .map(orderMapper::mapOrderToOrderDto)
                .toList().toString();
    }
}
