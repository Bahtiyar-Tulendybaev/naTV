package com.example.natv.controllers;

import com.example.natv.models.dto.PriceDto;
import com.example.natv.models.entities.Price;
import com.example.natv.services.PriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/price")
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }
    @PostMapping("/save")
    public PriceDto save(@RequestBody PriceDto priceDto) {
        return priceService.save(priceDto);
    }
    @GetMapping("/findAll")
    public List<Price> findAll(){
        return priceService.findAll();
    }


}
