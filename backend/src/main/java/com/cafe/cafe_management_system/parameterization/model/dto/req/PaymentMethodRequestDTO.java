package com.cafe.cafe_management_system.parameterization.model.dto.req;

import com.cafe.cafe_management_system.shared.BaseRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentMethodRequestDTO extends BaseRequestDTO {

    @NotBlank(message = "Payment method name cannot be blank")
    @Size(min = 2, max = 50, message = "Payment method name must be between 2 and 50 characters")
    @Schema(description = "Name of the payment method", example = "Credit Card")
    private String name;

    @Size(max = 200, message = "Description cannot exceed 200 characters")
    @Schema(description = "Description of the payment method", example = "Visa, Mastercard, American Express")
    private String description;

    @Schema(description = "Whether the payment method is active", example = "true")
    private Boolean isActive = true;

    @DecimalMin(value = "0.0", message = "Processing fee cannot be negative")
    @DecimalMax(value = "100.0", message = "Processing fee cannot exceed 100%")
    @Schema(description = "Processing fee percentage for this payment method", example = "2.5")
    private Double processingFee = 0.0;
}