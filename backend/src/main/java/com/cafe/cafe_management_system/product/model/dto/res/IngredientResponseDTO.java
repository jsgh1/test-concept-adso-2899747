package com.cafe.cafe_management_system.product.model.dto.res;

import com.cafe.cafe_management_system.shared.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IngredientResponseDTO extends BaseResponseDTO {

    @Schema(description = "Ingredient name", example = "Coffee Beans")
    private String name;

    @Schema(description = "Ingredient description", example = "High-quality Arabica coffee beans")
    private String description;

    @Schema(description = "Unit of measurement", example = "grams")
    private String unit;
}