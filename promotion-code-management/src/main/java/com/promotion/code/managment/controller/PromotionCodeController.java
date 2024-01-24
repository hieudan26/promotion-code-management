package com.promotion.code.managment.controller;

import com.promotion.code.managment.model.PromotionCode.PromotionCode;
import com.promotion.code.managment.model.PromotionCode.PromotionCodeResponse;
import com.promotion.code.managment.service.PromotionCodeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/promotion-code")
public class PromotionCodeController
{
    private final PromotionCodeService promotionCodeService;

    @PostMapping
    public ResponseEntity<PromotionCodeResponse> loginRequest(@Valid @RequestBody PromotionCode promotionCode) {

        final PromotionCodeResponse promotionCodeResponse = promotionCodeService.generatePromotionCode(promotionCode);

        return ResponseEntity.ok(promotionCodeResponse);
    }
}
