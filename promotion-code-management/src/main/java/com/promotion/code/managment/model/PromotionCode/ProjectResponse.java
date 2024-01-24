package com.promotion.code.managment.model.PromotionCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProjectResponse
{
    String id;
    String name;
    Long quantity;
    List<PromotionCodeResponse> promotionCodes;
}
