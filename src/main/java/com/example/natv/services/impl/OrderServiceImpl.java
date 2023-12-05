package com.example.natv.services.impl;

import com.example.natv.mappers.OrderMapper;
import com.example.natv.models.dto.OrderDto;
import com.example.natv.models.dto.RequestDto3.ChannelsList;
import com.example.natv.models.dto.RequestDto3.OrderRequest3;
import com.example.natv.models.entities.*;
import com.example.natv.models.enums.Status;
import com.example.natv.repository.*;
import com.example.natv.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final TextRepo textRepo;
    private final PriceRepo priceRepo;
    private final ChannelRepo channelRepo;
    private final DiscountRepo discountRepo;
    private final OrderDatesRepo orderDatesRepo;


    public OrderServiceImpl(OrderRepo orderRepo, TextRepo textRepo, PriceRepo priceRepo, ChannelRepo channelRepo, DiscountRepo discountRepo, OrderDatesRepo orderDatesRepo) {
        this.orderRepo = orderRepo;
        this.textRepo = textRepo;
        this.priceRepo = priceRepo;
        this.channelRepo = channelRepo;
        this.discountRepo = discountRepo;
        this.orderDatesRepo = orderDatesRepo;
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        Order order = OrderMapper.INSTANCE.orderDtoToOrder(orderDto);
        order = orderRepo.save(order);
        orderDto.setId(order.getId());

        return orderDto;
    }

    @Override
    public OrderRequest3 saveOrder(OrderRequest3 orderrequest3) {
        OrderRequest3 response = new OrderRequest3();
        List<ChannelsList> channelsLists = orderrequest3.getChannelsList();
        List<ChannelsList> responseList = new ArrayList<>();

        double totalSum = 0;
        for (int i = 0; i < channelsLists.size(); i++) {
            ChannelsList chanList = new ChannelsList();
            chanList.setChannelId(channelsLists.get(i).getChannelId());
            double price = priceRepo.getPricePerSymbol((long) chanList.getChannelId());
            for (int j = 0; j < channelsLists.get(i).getDays().stream().count(); j++) {
                List<Date> days = channelsLists.get(i).getDays();
                chanList.setDays(days);
            }
            chanList.setPrice(orderrequest3.getText().replaceAll(" ", "").length() * price * chanList.getDays().size());
            totalSum += chanList.getPrice();
            List<Discount> discounts = discountRepo.getDiscounts((long) chanList.getChannelId());
            double discount = 0;
            for (int j = 0; j < discounts.size(); j++) {
                if (chanList.getDays().size() >= discounts.get(j).getDiscountDays()) {
                    discount = discounts.get(j).getDiscount();
                    break;
                }
            }
            chanList.setPriceWithDiscount(chanList.getPrice() - (chanList.getPrice() * discount / 100));
            responseList.add(chanList);
        }

        Text text = new Text();
        text.setText(orderrequest3.getText());
        text.setSymbolCount(orderrequest3.getText().replaceAll(" ", "").length());
        textRepo.save(text);
        for (int i = 0; i < channelsLists.size(); i++) {
            Order order = new Order();
            order.setClientEmail(orderrequest3.getClientEmail());
            order.setClientFio(orderrequest3.getClientFio());
            order.setClientPhone(orderrequest3.getClientPhone());
            order.setText(text);
            order.setStatus(Status.CREATED);
            Channel channel = new Channel();
            channel.setId((long) channelsLists.get(i).getChannelId());
            order.setChannel(channel);
            order.setOrderSum(responseList.get(i).getPriceWithDiscount());
            orderRepo.save(order);
            for (int j = 0; j < channelsLists.get(i).getDays().size(); j++) {
                OrderDates orderDates = new OrderDates();
                orderDates.setDays(channelsLists.get(i).getDays().get(j));
                orderDates.setOrder(order);
                orderDatesRepo.save(orderDates);
            }

        }

        response.setClientEmail(orderrequest3.getClientEmail());
        response.setClientPhone(orderrequest3.getClientPhone());
        response.setClientFio(orderrequest3.getClientFio());
        response.setText(orderrequest3.getText());
        response.setStatus(Status.CREATED);
        response.setTotalPrice(totalSum);
        response.setChannelsList(responseList);


        return response;
    }
    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }
}
