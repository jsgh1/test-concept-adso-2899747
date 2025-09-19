package com.cafe.cafe_management_system.parameterization.service;

import com.cafe.cafe_management_system.parameterization.iservice.IPaymentMethodService;
import com.cafe.cafe_management_system.parameterization.model.dto.req.PaymentMethodRequestDTO;
import com.cafe.cafe_management_system.parameterization.model.dto.res.PaymentMethodResponseDTO;
import com.cafe.cafe_management_system.parameterization.model.entity.PaymentMethod;
import com.cafe.cafe_management_system.parameterization.repository.IPaymentMethodRepository;
import com.cafe.cafe_management_system.shared.AbstractService;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for PaymentMethod entity operations.
 * Extends AbstractService to inherit common CRUD operations.
 */
@Service
public class PaymentMethodService extends AbstractService<PaymentMethod, PaymentMethodRequestDTO, PaymentMethodResponseDTO> implements IPaymentMethodService {

    @Override
    protected IRepository<PaymentMethod, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IPaymentMethodRepository repository;

    @Override
    public PaymentMethodResponseDTO mapToResDto(PaymentMethod entity) {
        PaymentMethodResponseDTO response = new PaymentMethodResponseDTO();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setIsActive(entity.getIsActive());
        response.setProcessingFee(entity.getProcessingFee());
        return response;
    }

    @Override
    public PaymentMethod mapToEntity(PaymentMethodRequestDTO request) {
        PaymentMethod entity = new PaymentMethod();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setIsActive(request.getIsActive());
        entity.setProcessingFee(request.getProcessingFee());
        return entity;
    }
}