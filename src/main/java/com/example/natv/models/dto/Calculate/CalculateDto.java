package com.example.natv.models.dto.Calculate;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@RequiredArgsConstructor
public class CalculateDto {
    String text;

    int daysCount;

    long channelId;
    double price;

    double priceWithDiscount;

}
