package com.promotion.code.managment.service;

import com.promotion.code.managment.model.PromotionCode.ProjectResponse;
import com.promotion.code.managment.model.PromotionCode.PromotionCode;
import com.promotion.code.managment.model.PromotionCode.PromotionCodeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProjectService
{
    private final PromotionCodeService promotionCodeService;

    public ProjectResponse createProjects(PromotionCode promotionCode)
    {
        long startTime = System.nanoTime();

        List<PromotionCodeResponse> promotionCodes = new ArrayList<>();
        for(int i = 0; i < promotionCode.getQuantity(); i++)
        {
            promotionCodes.add(promotionCodeService.generatePromotionCode(promotionCode));
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  // compute the duration in nanoseconds

        log.info("Execution time in nanoseconds: " + duration);
        log.info("Execution time in milliseconds: " + duration / 1000000);
        return ProjectResponse.builder().name(promotionCode.getProjectName()).quantity(promotionCode.getQuantity()).promotionCodes(promotionCodes).build();
    }
}
