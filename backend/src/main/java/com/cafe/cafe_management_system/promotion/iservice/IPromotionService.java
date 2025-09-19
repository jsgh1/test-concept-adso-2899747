package com.cafe.cafe_management_system.promotion.iservice;

import com.cafe.cafe_management_system.promotion.model.dto.req.PromotionRequestDTO;
import com.cafe.cafe_management_system.promotion.model.dto.res.PromotionResponseDTO;
import com.cafe.cafe_management_system.promotion.model.entity.Promotion;
import com.cafe.cafe_management_system.shared.IService;

public interface IPromotionService extends IService<Promotion, PromotionRequestDTO, PromotionResponseDTO> {
    // Custom service methods can be added here if needed
}