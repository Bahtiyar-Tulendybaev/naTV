package com.example.natv.controllers;

import com.example.natv.models.dto.Calculate.CalculateDto;
import com.example.natv.models.dto.RequestDto1.ChannelListDto;
import com.example.natv.services.ChannelService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channel")
public class GetChannelListController {
    private final ChannelService channelService;

    public GetChannelListController(ChannelService channelService) {

        this.channelService = channelService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<?> calculate(@RequestBody CalculateDto calculateDto) {
        return ResponseEntity.ok(channelService. calculate(calculateDto));
    }


}
