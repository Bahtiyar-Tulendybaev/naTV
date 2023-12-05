package com.example.natv.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_channel")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JsonProperty("channel_name")
    String channelName;
    @JsonProperty("created_day")
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date createdDate;
    @JsonProperty("channel_status")
    boolean channelStatus;
    @JsonProperty("logo_path")
    String logoPath;

    @PrePersist
    void onCreatedDay() {
        createdDate = new Date();
    }

}
