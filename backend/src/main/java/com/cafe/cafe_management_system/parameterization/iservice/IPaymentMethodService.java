package com.cafe.cafe_management_system.parameterization.iservice;

import com.cafe.cafe_management_system.parameterization.model.dto.req.PaymentMethodRequestDTO;
import com.cafe.cafe_management_system.parameterization.model.dto.res.PaymentMethodResponseDTO;
import com.cafe.cafe_management_system.parameterization.model.entity.PaymentMethod;
import com.cafe.cafe_management_system.shared.IService;

public interface IPaymentMethodService extends IService<PaymentMethod, PaymentMethodRequestDTO, PaymentMethodResponseDTO> {
    // Custom service methods can be added here if needed
}