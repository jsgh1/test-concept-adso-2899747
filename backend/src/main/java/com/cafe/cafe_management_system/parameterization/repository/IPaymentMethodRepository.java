package com.cafe.cafe_management_system.parameterization.repository;

import com.cafe.cafe_management_system.parameterization.model.entity.PaymentMethod;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentMethodRepository extends IRepository<PaymentMethod, Long> {
    // Custom query methods can be added here if needed
}