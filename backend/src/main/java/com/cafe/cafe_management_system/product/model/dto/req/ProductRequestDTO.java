package com.cafe.cafe_management_system.product.model.dto.req;

import com.cafe.cafe_management_system.shared.BaseRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductRequestDTO extends BaseRequestDTO {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Schema(description = "Product name", example = "Espresso")
    private String name;

    @Schema(description = "Product description", example = "A rich and bold espresso coffee")
    private String description;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Schema(description = "Product price", example = "2.50")
    private BigDecimal price;

    @NotNull(message = "Category ID cannot be null")
    @Schema(description = "Product category ID", example = "1")
    private Long categoryId;
}