package com.promotion.code.managment.controller;

import com.promotion.code.managment.model.PromotionCode.ProjectResponse;
import com.promotion.code.managment.model.PromotionCode.PromotionCode;
import com.promotion.code.managment.service.ProjectService;
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
@RequestMapping("/project")
public class ProjectController
{
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectResponse> loginRequest(@Valid @RequestBody PromotionCode promotionCode) {

        final ProjectResponse projectResponse = projectService.createProjects(promotionCode);

        return ResponseEntity.ok(projectResponse);
    }
}
