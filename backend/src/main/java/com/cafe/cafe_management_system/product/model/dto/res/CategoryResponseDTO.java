package com.cafe.cafe_management_system.product.model.dto.res;

import com.cafe.cafe_management_system.shared.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryResponseDTO extends BaseResponseDTO {

    @Schema(description = "Category name", example = "Beverages")
    private String name;

    @Schema(description = "Category description", example = "Hot and cold beverages")
    private String description;
}