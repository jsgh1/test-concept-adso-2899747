package com.cafe.cafe_management_system.parameterization.controller;

import com.cafe.cafe_management_system.parameterization.iservice.IPaymentMethodService;
import com.cafe.cafe_management_system.parameterization.model.dto.req.PaymentMethodRequestDTO;
import com.cafe.cafe_management_system.parameterization.model.dto.res.PaymentMethodResponseDTO;
import com.cafe.cafe_management_system.parameterization.model.entity.PaymentMethod;
import com.cafe.cafe_management_system.shared.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment-methods")
@Tag(name = "Payment Method", description = "Payment method management operations")
public class PaymentMethodController extends AbstractController<PaymentMethod, PaymentMethodRequestDTO, PaymentMethodResponseDTO, IPaymentMethodService> {
    public PaymentMethodController(IPaymentMethodService service) {
        super(service, "PaymentMethod");
    }
}