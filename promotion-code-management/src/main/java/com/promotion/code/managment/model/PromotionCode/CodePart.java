package com.promotion.code.managment.model.PromotionCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CodePart
{
    String type;
    Integer quantity;
    String caseType;
}
