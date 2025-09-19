package com.cafe.cafe_management_system.security.service;

import com.cafe.cafe_management_system.parameterization.model.entity.Role;
import com.cafe.cafe_management_system.security.iservice.IUserService;
import com.cafe.cafe_management_system.security.model.dto.req.UserRequestDTO;
import com.cafe.cafe_management_system.security.model.dto.res.UserResponseDTO;
import com.cafe.cafe_management_system.security.model.entity.User;
import com.cafe.cafe_management_system.security.repository.IUserRepository;
import com.cafe.cafe_management_system.shared.AbstractService;
import com.cafe.cafe_management_system.shared.IRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService extends AbstractService<User, UserRequestDTO, UserResponseDTO> implements IUserService {

    @Override
    protected IRepository<User, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IUserRepository repository;

    @Override
    public UserResponseDTO mapToResDto(User entity) {
        log.debug("Mapping User entity to UserResponseDTO: {}", entity.getId());
        UserResponseDTO response = new UserResponseDTO();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setRoleId(entity.getRole().getId());
        response.setActive(entity.getActive());
        log.debug("Successfully mapped User entity to UserResponseDTO");
        return response;
    }

    @Override
    public User mapToEntity(UserRequestDTO request) {
        log.debug("Mapping UserRequestDTO to User entity: {}", request.getUsername());
        Role role = new Role();
        role.setId(request.getRoleId());

        User entity = new User();
        entity.setUsername(request.getUsername());
        entity.setPassword(request.getPassword());
        entity.setRole(role);
        entity.setActive(request.getActive());

        log.debug("Successfully mapped UserRequestDTO to User entity");
        return entity;
    }
}
