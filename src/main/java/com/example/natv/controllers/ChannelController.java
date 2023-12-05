package com.example.natv.controllers;

import com.example.natv.models.dto.ChannelDto;
import com.example.natv.models.dto.RequestDto1.ChannelListDto;
import com.example.natv.models.entities.Channel;
import com.example.natv.services.ChannelService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/channel")
public class ChannelController {
    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }
    @PostMapping("/save")
    ChannelDto save(@RequestBody ChannelDto channelDto) {
        return channelService.save(channelDto);
    }

    @GetMapping("/find")
    public List<ChannelListDto> findAll(Pageable pageable) {

        return channelService.findAll(pageable);
    }
    @GetMapping("/findById")
    public Optional<Channel> findById(@RequestParam Long id) {

        return channelService.findById(id);
    }


}
