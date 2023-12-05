package com.example.natv.services;

import com.example.natv.models.dto.OrderDto;
import com.example.natv.models.dto.RequestDto3.OrderRequest3;
import com.example.natv.models.entities.Order;

import java.util.List;

public interface OrderService {
    OrderDto save(OrderDto orderDto);
    OrderRequest3 saveOrder(OrderRequest3 orderrequest3);


    List<Order> findAll();
}
