package com.example.natv.mappers;

import com.example.natv.models.dto.OrderDto;
import com.example.natv.models.entities.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    @Mapping(target = "channelId", source = "channel.id")
    @Mapping(target = "textId", source = "text.id")
    @Mapping(target = "bannerId", source = "banner.id")
    OrderDto orderToOrderDto(Order order);
    @InheritInverseConfiguration
    Order orderDtoToOrder(OrderDto orderDto);
}
