package com.example.natv.services;

import com.example.natv.models.dto.PriceDto;
import com.example.natv.models.entities.Price;

import java.util.List;

public interface PriceService {
    PriceDto save(PriceDto priceDto);
    List<Price> findAll();
}
