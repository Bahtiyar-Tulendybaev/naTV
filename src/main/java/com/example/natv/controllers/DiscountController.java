package com.example.natv.controllers;

import com.example.natv.models.dto.DiscountDto;
import com.example.natv.models.entities.Discount;
import com.example.natv.services.DiscountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {
    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }


    @PostMapping("/save")
    public DiscountDto save(@RequestBody DiscountDto discountDto) {
        return discountService.save(discountDto);
    }

    @GetMapping("/findAll")
    public List<Discount> findAll(){
        return discountService.findAll();
    }
}
