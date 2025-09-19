package com.cafe.cafe_management_system.promotion.service;

import com.cafe.cafe_management_system.promotion.iservice.IPromotionService;
import com.cafe.cafe_management_system.promotion.model.dto.req.PromotionRequestDTO;
import com.cafe.cafe_management_system.promotion.model.dto.res.PromotionResponseDTO;
import com.cafe.cafe_management_system.promotion.model.entity.Promotion;
import com.cafe.cafe_management_system.promotion.repository.IPromotionRepository;
import com.cafe.cafe_management_system.shared.AbstractService;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for Promotion entity operations.
 * Extends AbstractService to inherit common CRUD operations.
 */
@Service
public class PromotionService extends AbstractService<Promotion, PromotionRequestDTO, PromotionResponseDTO> implements IPromotionService {

    @Override
    protected IRepository<Promotion, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IPromotionRepository repository;

    @Override
    public PromotionResponseDTO mapToResDto(Promotion entity) {
        PromotionResponseDTO response = new PromotionResponseDTO();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setDiscountType(entity.getDiscountType());
        response.setDiscountValue(entity.getDiscountValue());
        response.setStartDate(entity.getStartDate());
        response.setEndDate(entity.getEndDate());
        response.setActive(entity.getActive());
        return response;
    }

    @Override
    public Promotion mapToEntity(PromotionRequestDTO request) {
        Promotion entity = new Promotion();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setDiscountType(request.getDiscountType());
        entity.setDiscountValue(request.getDiscountValue());
        entity.setStartDate(request.getStartDate());
        entity.setEndDate(request.getEndDate());
        entity.setActive(request.getActive());
        return entity;
    }
}