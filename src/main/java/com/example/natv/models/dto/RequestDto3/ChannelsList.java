package com.example.natv.models.dto.RequestDto3;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelsList {
    int channelId;
    @JsonFormat(pattern = "dd.MM.yyyy")
    List<Date> days;
    double price;
    double priceWithDiscount;


}
