package com.example.natv.models.entities;

import com.example.natv.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated (EnumType.STRING)
    Status status;
    @JsonProperty("order_sum")
    double orderSum;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channel;
    @ManyToOne
    @JoinColumn(name = "text_id")
    Text text;
    @ManyToOne
    @JoinColumn(name = "banner_id")
    Banner banner;

    @PrePersist
    void startEndDate() {
        createdDate = new Date();
    }

}
