package com.example.natv.mappers;

import com.example.natv.models.dto.ChannelDto;
import com.example.natv.models.entities.Channel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ChannelMapper {
   ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);
    ChannelDto channelToChannelDto(Channel channel);
    @InheritInverseConfiguration
    Channel channelDtoToChannel(ChannelDto channelDto);

}
