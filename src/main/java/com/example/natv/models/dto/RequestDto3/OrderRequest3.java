package com.example.natv.models.dto.RequestDto3;

import com.example.natv.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest3 {

    String clientEmail;

    String clientFio;

    String clientPhone;
    String text;
    double totalPrice;
    @JsonProperty("status")
    Status status;
    List<ChannelsList> channelsList;

}
