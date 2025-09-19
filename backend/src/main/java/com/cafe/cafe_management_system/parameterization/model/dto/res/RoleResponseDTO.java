package com.cafe.cafe_management_system.parameterization.model.dto.res;

import com.cafe.cafe_management_system.shared.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoleResponseDTO extends BaseResponseDTO {

    @Schema(description = "Role name", example = "ADMIN")
    private String name;
}
