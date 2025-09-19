package com.cafe.cafe_management_system.parameterization.model.dto.req;

import com.cafe.cafe_management_system.shared.BaseRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoleRequestDTO extends BaseRequestDTO {

    @Schema(description = "Role name", example = "ADMIN")
    private String name;
}
