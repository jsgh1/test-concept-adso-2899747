package com.cafe.cafe_management_system.product.model.dto.req;

import com.cafe.cafe_management_system.shared.BaseRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IngredientRequestDTO extends BaseRequestDTO {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Schema(description = "Ingredient name", example = "Coffee Beans")
    private String name;

    @Schema(description = "Ingredient description", example = "High-quality Arabica coffee beans")
    private String description;

    @NotBlank(message = "Unit cannot be blank")
    @Schema(description = "Unit of measurement", example = "grams")
    private String unit;
}