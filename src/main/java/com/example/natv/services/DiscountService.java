package com.example.natv.services;

import com.example.natv.models.dto.DiscountDto;
import com.example.natv.models.entities.Discount;

import java.util.List;

public interface DiscountService {
    DiscountDto save(DiscountDto discountDto);

    List<Discount> findAll();


}
