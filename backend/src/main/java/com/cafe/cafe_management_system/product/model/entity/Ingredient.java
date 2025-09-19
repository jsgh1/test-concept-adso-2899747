package com.cafe.cafe_management_system.product.model.entity;

import com.cafe.cafe_management_system.shared.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "ingredient", schema = "product_schema")
@Data
@EqualsAndHashCode(callSuper = true)
public class Ingredient extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Schema(description = "Ingredient name", example = "Coffee Beans")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    @Schema(description = "Ingredient description", example = "High-quality Arabica coffee beans")
    private String description;

    @Column(name = "unit", nullable = false, length = 20)
    @NotBlank(message = "Unit cannot be blank")
    @Schema(description = "Unit of measurement", example = "grams")
    private String unit;
}
