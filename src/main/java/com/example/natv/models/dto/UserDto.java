package com.example.natv.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserDto {
    long id;
    String fio;
    String role;
    String login;
    String email;
    String phone;
    @JsonProperty("user_status")
    boolean userStatus;
}
