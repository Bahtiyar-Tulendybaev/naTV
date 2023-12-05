package com.example.natv.controllers;

import com.example.natv.models.dto.BannerDto;
import com.example.natv.models.entities.Banner;
import com.example.natv.services.ReclameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banner")
public class ReclameController {
    private final ReclameService bannerService;

    public ReclameController(ReclameService bannerService) {
        this.bannerService = bannerService;
    }
    @PostMapping("/save")
    BannerDto save(@RequestBody BannerDto bannerDto) {
        return bannerService.save(bannerDto);

    }
    @GetMapping("/findAll")
    public List<Banner> findAll(){
        return bannerService.findAll();
    }
}
