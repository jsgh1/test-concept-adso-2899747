package com.cafe.cafe_management_system.shared;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public abstract class BaseResponseDTO {
    @Schema(description = "Unique identifier of the entity", example = "1")
    private Long id;
}
