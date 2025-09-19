package com.cafe.cafe_management_system.inventory.model.entity;

import com.cafe.cafe_management_system.product.model.entity.Ingredient;
import com.cafe.cafe_management_system.product.model.entity.Product;
import com.cafe.cafe_management_system.shared.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Table(name = "inventory_item", schema = "inventory_schema")
@Data
@EqualsAndHashCode(callSuper = true)
public class InventoryItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    @Schema(description = "Associated supplier")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @Schema(description = "Associated product")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    @Schema(description = "Associated ingredient")
    private Ingredient ingredient;

    @Column(name = "quantity", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "Quantity cannot be null")
    @DecimalMin(value = "0.01", message = "Quantity must be greater than 0")
    @Schema(description = "Stock quantity", example = "100.00")
    private BigDecimal quantity;

    @Column(name = "unit_price", precision = 10, scale = 2)
    @DecimalMin(value = "0.01", message = "Unit price must be greater than 0")
    @Schema(description = "Unit price", example = "5.50")
    private BigDecimal unitPrice;
}
