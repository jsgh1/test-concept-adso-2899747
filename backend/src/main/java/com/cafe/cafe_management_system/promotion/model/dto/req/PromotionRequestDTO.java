package com.cafe.cafe_management_system.promotion.model.dto.req;

import com.cafe.cafe_management_system.promotion.model.entity.Promotion.DiscountType;
import com.cafe.cafe_management_system.shared.BaseRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class PromotionRequestDTO extends BaseRequestDTO {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Schema(description = "Promotion name", example = "Summer Sale")
    private String name;

    @Schema(description = "Promotion description", example = "20% off on all beverages")
    private String description;

    @NotNull(message = "Discount type cannot be null")
    @Schema(description = "Discount type", example = "PERCENTAGE")
    private DiscountType discountType;

    @NotNull(message = "Discount value cannot be null")
    @Schema(description = "Discount value", example = "20.00")
    private BigDecimal discountValue;

    @NotNull(message = "Start date cannot be null")
    @Schema(description = "Promotion start date", example = "2023-06-01")
    private LocalDate startDate;

    @NotNull(message = "End date cannot be null")
    @Schema(description = "Promotion end date", example = "2023-08-31")
    private LocalDate endDate;

    @Schema(description = "Whether the promotion is active", example = "true")
    private Boolean active = true;
}