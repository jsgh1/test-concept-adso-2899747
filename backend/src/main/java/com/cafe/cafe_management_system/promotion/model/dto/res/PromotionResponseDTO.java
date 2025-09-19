package com.cafe.cafe_management_system.promotion.model.dto.res;

import com.cafe.cafe_management_system.promotion.model.entity.Promotion.DiscountType;
import com.cafe.cafe_management_system.shared.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class PromotionResponseDTO extends BaseResponseDTO {

    @Schema(description = "Promotion name", example = "Summer Sale")
    private String name;

    @Schema(description = "Promotion description", example = "20% off on all beverages")
    private String description;

    @Schema(description = "Discount type", example = "PERCENTAGE")
    private DiscountType discountType;

    @Schema(description = "Discount value", example = "20.00")
    private BigDecimal discountValue;

    @Schema(description = "Promotion start date", example = "2023-06-01")
    private LocalDate startDate;

    @Schema(description = "Promotion end date", example = "2023-08-31")
    private LocalDate endDate;

    @Schema(description = "Whether the promotion is active", example = "true")
    private Boolean active;
}