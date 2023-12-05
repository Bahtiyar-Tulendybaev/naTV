package com.example.natv.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class OrderDto {
    long id;
    @JsonProperty("created_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date createdDate;
    @JsonProperty("client_email")
    String clientEmail;
    @JsonProperty("client_fio")
    String clientFio;
    @JsonProperty("client_phone")
    String clientPhone;
    @JsonProperty("order_status")
    boolean orderStatus;
    @JsonProperty("order_sum")
    double orderSum;
    @JsonProperty("channel_id")
    int channelId;
    @JsonProperty("text_id")
    int textId;
    @JsonProperty("banner_id")
    int bannerId;
}
