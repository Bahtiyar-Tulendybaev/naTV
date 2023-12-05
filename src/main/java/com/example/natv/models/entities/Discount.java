package com.example.natv.models.entities;

import com.example.natv.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_discount")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    double discount;
    @JsonProperty("start_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date startDate;
    @JsonProperty("end_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date endDate;
    @JsonProperty("discount_days")
    int discountDays;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channel;

    @PrePersist
    void startEndDate() {
        startDate = new Date();
        endDate = new DateUtil().getInstance().getEndDate();
    }


}
