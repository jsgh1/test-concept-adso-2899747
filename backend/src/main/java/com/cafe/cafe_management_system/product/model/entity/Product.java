package com.cafe.cafe_management_system.product.model.entity;

import com.cafe.cafe_management_system.product.model.entity.Category;
import com.cafe.cafe_management_system.shared.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Table(name = "product", schema = "product_schema")
@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Schema(description = "Product name", example = "Espresso")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    @Schema(description = "Product description", example = "A rich and bold espresso coffee")
    private String description;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Schema(description = "Product price", example = "2.50")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @Schema(description = "Product category")
    private Category category;
}
