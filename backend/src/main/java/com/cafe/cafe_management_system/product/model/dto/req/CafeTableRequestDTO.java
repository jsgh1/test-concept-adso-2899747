package com.cafe.cafe_management_system.product.model.dto.req;

import com.cafe.cafe_management_system.shared.BaseRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CafeTableRequestDTO extends BaseRequestDTO {

    @NotNull(message = "Table number cannot be null")
    @Min(value = 1, message = "Table number must be greater than 0")
    @Schema(description = "Table number in the café", example = "5")
    private Integer tableNumber;

    @NotNull(message = "Capacity cannot be null")
    @Min(value = 1, message = "Capacity must be at least 1")
    @Max(value = 20, message = "Capacity cannot exceed 20")
    @Schema(description = "Maximum number of seats at the table", example = "4")
    private Integer capacity;

    @Size(max = 100, message = "Location cannot exceed 100 characters")
    @Schema(description = "Location of the table in the café", example = "Window side")
    private String location;

    @Schema(description = "Whether the table is active/available", example = "true")
    private Boolean isActive = true;
}