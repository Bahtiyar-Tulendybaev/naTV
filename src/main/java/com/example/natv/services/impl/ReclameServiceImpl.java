package com.example.natv.services.impl;

import com.example.natv.mappers.BannerMapper;
import com.example.natv.models.dto.BannerDto;
import com.example.natv.models.entities.Banner;
import com.example.natv.repository.ReclameRepo;
import com.example.natv.services.ReclameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclameServiceImpl implements ReclameService {
    private final ReclameRepo bannerRepo;

    public ReclameServiceImpl(ReclameRepo bannerRepo) {
        this.bannerRepo = bannerRepo;
    }

    @Override
    public BannerDto save(BannerDto bannerDto) {
        Banner banner = BannerMapper.INSTANCE.bannerDtoToBanner(bannerDto);
        banner = bannerRepo.save(banner);
        bannerDto.setId(banner.getId());
        return bannerDto;

    }

    @Override
    public List<Banner> findAll() {
        return bannerRepo.findAll();
    }
}
