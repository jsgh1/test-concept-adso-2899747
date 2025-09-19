package com.cafe.cafe_management_system.inventory.model.dto.res;

import com.cafe.cafe_management_system.shared.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class InventoryItemResponseDTO extends BaseResponseDTO {

    @Schema(description = "ID of the associated supplier", example = "1")
    private Long supplierId;

    @Schema(description = "Name of the associated supplier", example = "Coffee Beans Inc.")
    private String supplierName;

    @Schema(description = "ID of the associated product", example = "1")
    private Long productId;

    @Schema(description = "Name of the associated product", example = "Espresso")
    private String productName;

    @Schema(description = "ID of the associated ingredient", example = "1")
    private Long ingredientId;

    @Schema(description = "Name of the associated ingredient", example = "Coffee Beans")
    private String ingredientName;

    @Schema(description = "Stock quantity", example = "100.00")
    private BigDecimal quantity;

    @Schema(description = "Unit price", example = "5.50")
    private BigDecimal unitPrice;
}