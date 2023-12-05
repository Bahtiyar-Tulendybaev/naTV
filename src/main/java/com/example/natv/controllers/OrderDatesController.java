package com.example.natv.controllers;

import com.example.natv.models.dto.OrderDatesDto;
import com.example.natv.services.OrderDatesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orderDates")
public class OrderDatesController {
    private final OrderDatesService orderDatesService;

    public OrderDatesController(OrderDatesService orderDatesService) {
        this.orderDatesService = orderDatesService;
    }
    @PostMapping("/save")
    public OrderDatesDto save(@RequestBody OrderDatesDto orderDatesDto) {
        return orderDatesService.save(orderDatesDto);

    }
}
