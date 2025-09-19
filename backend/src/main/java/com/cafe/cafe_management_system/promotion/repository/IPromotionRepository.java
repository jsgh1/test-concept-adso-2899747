package com.cafe.cafe_management_system.promotion.repository;

import com.cafe.cafe_management_system.promotion.model.entity.Promotion;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPromotionRepository extends IRepository<Promotion, Long> {
    // Custom query methods can be added here if needed
}