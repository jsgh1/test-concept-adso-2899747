package com.cafe.cafe_management_system.promotion.controller;

import com.cafe.cafe_management_system.promotion.iservice.IPromotionService;
import com.cafe.cafe_management_system.promotion.model.dto.req.PromotionRequestDTO;
import com.cafe.cafe_management_system.promotion.model.dto.res.PromotionResponseDTO;
import com.cafe.cafe_management_system.promotion.model.entity.Promotion;
import com.cafe.cafe_management_system.shared.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promotions")
@Tag(name = "Promotion", description = "Promotion management operations")
public class PromotionController extends AbstractController<Promotion, PromotionRequestDTO, PromotionResponseDTO, IPromotionService> {
    public PromotionController(IPromotionService service) {
        super(service, "Promotion");
    }
}