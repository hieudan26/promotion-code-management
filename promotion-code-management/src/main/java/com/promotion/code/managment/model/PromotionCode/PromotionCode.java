package com.promotion.code.managment.model.PromotionCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PromotionCode
{
    String id;
    String projectName;
    List<CodePart> pattern;
    Long quantity;
}
