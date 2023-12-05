package com.example.natv.mappers;

import com.example.natv.models.dto.PriceDto;
import com.example.natv.models.entities.Price;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
    @Mapping(source = "channel.id", target = "channel")
    PriceDto priceToPriceDto(Price price);
    @InheritInverseConfiguration
    Price priceDtoToPrice(PriceDto priceDto);
}
