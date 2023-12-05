package com.example.natv.models.dto.RequestDto1;

import lombok.Data;

import java.util.List;
@Data
public class ChannelListDto {
    String channelName;
    String logo;
    double pricePerLetter;
    List<DiscountsDto> discounts;

}
