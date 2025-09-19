package com.cafe.cafe_management_system.parameterization.iservice;

import com.cafe.cafe_management_system.parameterization.model.dto.req.RoleRequestDTO;
import com.cafe.cafe_management_system.parameterization.model.dto.res.RoleResponseDTO;
import com.cafe.cafe_management_system.parameterization.model.entity.Role;
import com.cafe.cafe_management_system.shared.IService;

/**
 * Service interface for Role entity operations.
 * Extends the base IService interface for common CRUD operations.
 */
public interface IRoleService extends IService<Role, RoleRequestDTO, RoleResponseDTO> {

    RoleResponseDTO mapToResDto(Role entity);

    Role mapToEntity(RoleRequestDTO request);
}
