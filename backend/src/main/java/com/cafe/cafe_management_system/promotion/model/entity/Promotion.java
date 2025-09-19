package com.cafe.cafe_management_system.promotion.model.entity;

import com.cafe.cafe_management_system.shared.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "promotion", schema = "promotion_schema")
@Data
@EqualsAndHashCode(callSuper = true)
public class Promotion extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Schema(description = "Promotion name", example = "Summer Sale")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    @Schema(description = "Promotion description", example = "20% off on all beverages")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type", nullable = false)
    @NotNull(message = "Discount type cannot be null")
    @Schema(description = "Discount type", example = "PERCENTAGE")
    private DiscountType discountType;

    @Column(name = "discount_value", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "Discount value cannot be null")
    @Schema(description = "Discount value", example = "20.00")
    private BigDecimal discountValue;

    @Column(name = "start_date", nullable = false)
    @NotNull(message = "Start date cannot be null")
    @Schema(description = "Promotion start date", example = "2023-06-01")
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    @NotNull(message = "End date cannot be null")
    @Schema(description = "Promotion end date", example = "2023-08-31")
    private LocalDate endDate;

    @Column(name = "active", nullable = false)
    @Schema(description = "Whether the promotion is active", example = "true")
    private Boolean active = true;

    public enum DiscountType {
        PERCENTAGE, FIXED
    }
}
