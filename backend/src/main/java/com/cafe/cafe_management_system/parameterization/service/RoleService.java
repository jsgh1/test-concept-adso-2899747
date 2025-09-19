package com.cafe.cafe_management_system.parameterization.service;

import com.cafe.cafe_management_system.parameterization.model.dto.req.RoleRequestDTO;
import com.cafe.cafe_management_system.parameterization.model.dto.res.RoleResponseDTO;
import com.cafe.cafe_management_system.parameterization.iservice.IRoleService;
import com.cafe.cafe_management_system.parameterization.model.entity.Role;
import com.cafe.cafe_management_system.parameterization.repository.IRoleRepository;
import com.cafe.cafe_management_system.shared.AbstractService;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for Role entity operations.
 * Extends AbstractService to inherit common CRUD operations.
 */
@Service
public class RoleService extends AbstractService<Role, RoleRequestDTO, RoleResponseDTO> implements IRoleService {

    @Override
    protected IRepository<Role, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IRoleRepository repository;

    @Override
    public RoleResponseDTO mapToResDto(Role entity) {
        RoleResponseDTO response = new RoleResponseDTO();
        response.setId(entity.getId());
        response.setName(entity.getName());
        return response;
    }

    @Override
    public Role mapToEntity(RoleRequestDTO request) {
        Role entity = new Role();
        entity.setName(request.getName());
        return entity;
    }
}
