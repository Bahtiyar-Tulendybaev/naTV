package com.example.natv.controllers;

import com.example.natv.models.dto.RequestDto3.OrderRequest3;
import com.example.natv.models.entities.Order;
import com.example.natv.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/save")
    public OrderRequest3 save(@RequestBody OrderRequest3 orderRequest3) {
        return orderService.saveOrder(orderRequest3);
    }
    @GetMapping("/findAll")
    public List<Order> findAll(){
        return orderService.findAll();
    }
}
