package com.example.natv.mappers;

import com.example.natv.models.dto.BannerDto;
import com.example.natv.models.entities.Banner;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper

public interface BannerMapper {
    BannerMapper INSTANCE = Mappers.getMapper(BannerMapper.class);
    BannerDto bannerToBannerDto(Banner banner);
    @InheritInverseConfiguration
    Banner bannerDtoToBanner(BannerDto bannerDto);
}
