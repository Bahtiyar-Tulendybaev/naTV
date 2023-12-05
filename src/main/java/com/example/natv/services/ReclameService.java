package com.example.natv.services;

import com.example.natv.models.dto.BannerDto;
import com.example.natv.models.entities.Banner;

import java.util.List;


public interface ReclameService {
    BannerDto save(BannerDto bannerDto);

    List<Banner> findAll();
}
