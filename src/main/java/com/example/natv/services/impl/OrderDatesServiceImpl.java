package com.example.natv.services.impl;

import com.example.natv.mappers.OrderDatesMapper;
import com.example.natv.models.dto.OrderDatesDto;
import com.example.natv.models.entities.OrderDates;
import com.example.natv.repository.OrderDatesRepo;
import com.example.natv.services.OrderDatesService;
import org.springframework.stereotype.Service;

@Service
public class OrderDatesServiceImpl implements OrderDatesService {
    private final OrderDatesRepo orderDatesRepo;

    public OrderDatesServiceImpl(OrderDatesRepo orderDatesRepo) {
        this.orderDatesRepo = orderDatesRepo;
    }

    @Override
    public OrderDatesDto save(OrderDatesDto orderDatesDto) {
        OrderDates orderDates = OrderDatesMapper.INSTANCE.orderDatesDtoToOrderDates(orderDatesDto);
        orderDates = orderDatesRepo.save(orderDates);
        orderDatesDto.setId(orderDates.getId());
        return orderDatesDto;
    }
}
