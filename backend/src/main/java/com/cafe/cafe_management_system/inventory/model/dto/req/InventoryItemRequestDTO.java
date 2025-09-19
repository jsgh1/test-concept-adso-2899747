package com.cafe.cafe_management_system.inventory.model.dto.req;

import com.cafe.cafe_management_system.shared.BaseRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class InventoryItemRequestDTO extends BaseRequestDTO {

    @NotNull(message = "Supplier ID cannot be null")
    @Schema(description = "ID of the associated supplier", example = "1")
    private Long supplierId;

    @Schema(description = "ID of the associated product", example = "1")
    private Long productId;

    @Schema(description = "ID of the associated ingredient", example = "1")
    private Long ingredientId;

    @NotNull(message = "Quantity cannot be null")
    @DecimalMin(value = "0.01", message = "Quantity must be greater than 0")
    @Schema(description = "Stock quantity", example = "100.00")
    private BigDecimal quantity;

    @DecimalMin(value = "0.01", message = "Unit price must be greater than 0")
    @Schema(description = "Unit price", example = "5.50")
    private BigDecimal unitPrice;
}