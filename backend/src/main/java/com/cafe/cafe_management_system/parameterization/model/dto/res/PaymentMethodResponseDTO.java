package com.cafe.cafe_management_system.parameterization.model.dto.res;

import com.cafe.cafe_management_system.shared.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentMethodResponseDTO extends BaseResponseDTO {

    @Schema(description = "Name of the payment method", example = "Credit Card")
    private String name;

    @Schema(description = "Description of the payment method", example = "Visa, Mastercard, American Express")
    private String description;

    @Schema(description = "Whether the payment method is active", example = "true")
    private Boolean isActive;

    @Schema(description = "Processing fee percentage for this payment method", example = "2.5")
    private Double processingFee;
}