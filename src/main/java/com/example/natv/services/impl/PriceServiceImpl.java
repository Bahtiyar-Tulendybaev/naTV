package com.example.natv.services.impl;

import com.example.natv.mappers.PriceMapper;
import com.example.natv.models.dto.PriceDto;
import com.example.natv.models.entities.Price;
import com.example.natv.repository.PriceRepo;
import com.example.natv.services.PriceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    private final PriceRepo priceRepo;
    public PriceServiceImpl(PriceRepo priceRepo) {
        this.priceRepo = priceRepo;
    }
    @Override
    public PriceDto save(PriceDto priceDto) {
        Price price = PriceMapper.INSTANCE.priceDtoToPrice(priceDto);
        price = priceRepo.save(price);
        priceDto.setId(price.getId());
        return priceDto;
    }
    @Override
    public List<Price> findAll() {
        return priceRepo.findAll();
    }
}
