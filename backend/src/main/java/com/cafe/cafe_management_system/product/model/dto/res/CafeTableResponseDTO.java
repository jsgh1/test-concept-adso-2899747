package com.cafe.cafe_management_system.product.model.dto.res;

import com.cafe.cafe_management_system.shared.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CafeTableResponseDTO extends BaseResponseDTO {

    @Schema(description = "Table number in the café", example = "5")
    private Integer tableNumber;

    @Schema(description = "Maximum number of seats at the table", example = "4")
    private Integer capacity;

    @Schema(description = "Location of the table in the café", example = "Window side")
    private String location;

    @Schema(description = "Whether the table is active/available", example = "true")
    private Boolean isActive;
}