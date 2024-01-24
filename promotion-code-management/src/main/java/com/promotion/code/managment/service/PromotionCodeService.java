package com.promotion.code.managment.service;
import com.promotion.code.managment.model.PromotionCode.CodePart;
import com.promotion.code.managment.model.PromotionCode.PromotionCode;
import com.promotion.code.managment.model.PromotionCode.PromotionCodeResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PromotionCodeService {
    private static final Map<String, String> typeMap =
        Map.of("ALPHABET","ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "NUMBERS", "0123456789",
            "UNDERSCORE", "_",
            "SLASH", "-",
            "DOT", ".");

    public PromotionCodeResponse generatePromotionCode(PromotionCode promotionCode) {
        StringBuilder code = new StringBuilder();
        for (CodePart part : promotionCode.getPattern()) {
            if (typeMap.containsKey(part.getType().toUpperCase())) {
                code.append(generateRandom(typeMap.get(part.getType().toUpperCase()).toCharArray(), part.getQuantity()));
            } else {
                throw new IllegalArgumentException("Invalid code part type: " + part.getType());
            }
        }

        return PromotionCodeResponse.builder().code(code.toString()).build();
    }

    private String generateRandom(char[] characters, int length) {
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            result.append(characters[ThreadLocalRandom.current().nextInt(characters.length)]);
        }

        return result.toString();
    }
}