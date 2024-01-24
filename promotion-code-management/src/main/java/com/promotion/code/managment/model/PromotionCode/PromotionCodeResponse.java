package com.promotion.code.managment.model.PromotionCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PromotionCodeResponse
{
    String code;
    String status;
    String information;
}
