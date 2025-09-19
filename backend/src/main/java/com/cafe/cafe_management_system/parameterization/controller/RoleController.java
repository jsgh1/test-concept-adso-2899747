package com.cafe.cafe_management_system.parameterization.controller;

import com.cafe.cafe_management_system.parameterization.model.dto.req.RoleRequestDTO;
import com.cafe.cafe_management_system.parameterization.model.dto.res.RoleResponseDTO;
import com.cafe.cafe_management_system.parameterization.model.entity.Role;
import com.cafe.cafe_management_system.parameterization.iservice.IRoleService;
import com.cafe.cafe_management_system.shared.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController extends AbstractController<Role, RoleRequestDTO, RoleResponseDTO, IRoleService> {

    public RoleController(IRoleService service) {
        super(service, "Role");
    }
}
