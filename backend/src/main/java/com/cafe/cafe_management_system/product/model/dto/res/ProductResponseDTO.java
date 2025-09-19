package com.cafe.cafe_management_system.product.model.dto.res;

import com.cafe.cafe_management_system.shared.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductResponseDTO extends BaseResponseDTO {

    @Schema(description = "Product name", example = "Espresso")
    private String name;

    @Schema(description = "Product description", example = "A rich and bold espresso coffee")
    private String description;

    @Schema(description = "Product price", example = "2.50")
    private BigDecimal price;

    @Schema(description = "Product category ID", example = "1")
    private Long categoryId;

    @Schema(description = "Product category name", example = "Beverages")
    private String categoryName;
}