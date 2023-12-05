package com.example.natv.services.impl;

import com.example.natv.mappers.DiscountMapper;
import com.example.natv.models.dto.DiscountDto;
import com.example.natv.models.entities.Discount;
import com.example.natv.repository.ChannelRepo;
import com.example.natv.repository.DiscountRepo;
import com.example.natv.services.ChannelService;
import com.example.natv.services.DiscountService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepo discountRepo;
    private final ChannelService channelService;
    private final ChannelRepo channelRepo;

    public DiscountServiceImpl(DiscountRepo discountRepo, ChannelService channelService, ChannelRepo channelRepo) {
        this.discountRepo = discountRepo;
        this.channelService = channelService;
        this.channelRepo = channelRepo;
    }

    @Override
    public DiscountDto save(DiscountDto discountDto) {
        Discount discount = DiscountMapper.INSTANCE.discountDtoToDiscount(discountDto);
        discount = discountRepo.save(discount);
        discountDto.setStartDate(discount.getStartDate());
        discountDto.setEndDate(discount.getEndDate());

        return discountDto;
    }

    @Override
    public List<Discount> findAll() {
        return discountRepo.findAll();
    }




}
