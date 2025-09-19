package com.cafe.cafe_management_system.product.model.entity;

import com.cafe.cafe_management_system.shared.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cafe_table", schema = "product_schema")
@Data
@EqualsAndHashCode(callSuper = true)
public class CafeTable extends BaseEntity {

    @Column(name = "table_number", nullable = false, unique = true)
    @NotNull(message = "Table number cannot be null")
    @Min(value = 1, message = "Table number must be greater than 0")
    @Schema(description = "Table number in the café", example = "5")
    private Integer tableNumber;

    @Column(name = "capacity", nullable = false)
    @NotNull(message = "Capacity cannot be null")
    @Min(value = 1, message = "Capacity must be at least 1")
    @Max(value = 20, message = "Capacity cannot exceed 20")
    @Schema(description = "Maximum number of seats at the table", example = "4")
    private Integer capacity;

    @Column(name = "location", length = 100)
    @Size(max = 100, message = "Location cannot exceed 100 characters")
    @Schema(description = "Location of the table in the café", example = "Window side")
    private String location;

    @Column(name = "is_active", nullable = false)
    @Schema(description = "Whether the table is active/available", example = "true")
    private Boolean isActive = true;
}