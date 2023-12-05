package com.example.natv.services;

import com.example.natv.models.dto.Calculate.CalculateDto;
import com.example.natv.models.dto.ChannelDto;
import com.example.natv.models.dto.RequestDto1.ChannelListDto;
import com.example.natv.models.entities.Channel;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ChannelService {
    ChannelDto save(ChannelDto channelDto);

    List<ChannelListDto> findAll(Pageable pageable);
    CalculateDto calculate(CalculateDto calculateDto);

    Optional<Channel> findById(Long id);
}
