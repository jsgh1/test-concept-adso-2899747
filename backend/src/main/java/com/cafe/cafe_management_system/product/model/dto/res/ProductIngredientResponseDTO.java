package com.cafe.cafe_management_system.product.model.dto.res;

import com.cafe.cafe_management_system.shared.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductIngredientResponseDTO extends BaseResponseDTO {

    @Schema(description = "Associated product ID", example = "1")
    private Long productId;

    @Schema(description = "Associated product name", example = "Espresso")
    private String productName;

    @Schema(description = "Associated ingredient ID", example = "1")
    private Long ingredientId;

    @Schema(description = "Associated ingredient name", example = "Coffee Beans")
    private String ingredientName;

    @Schema(description = "Quantity of ingredient needed", example = "50.00")
    private BigDecimal quantity;
}