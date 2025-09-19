package com.cafe.cafe_management_system.product.model.dto.req;

import com.cafe.cafe_management_system.shared.BaseRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductIngredientRequestDTO extends BaseRequestDTO {

    @NotNull(message = "Product ID cannot be null")
    @Schema(description = "Associated product ID", example = "1")
    private Long productId;

    @NotNull(message = "Ingredient ID cannot be null")
    @Schema(description = "Associated ingredient ID", example = "1")
    private Long ingredientId;

    @NotNull(message = "Quantity cannot be null")
    @DecimalMin(value = "0.01", message = "Quantity must be greater than 0")
    @Schema(description = "Quantity of ingredient needed", example = "50.00")
    private BigDecimal quantity;
}