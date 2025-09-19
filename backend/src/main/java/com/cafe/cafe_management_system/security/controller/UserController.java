package com.cafe.cafe_management_system.security.controller;

import com.cafe.cafe_management_system.security.iservice.IUserService;
import com.cafe.cafe_management_system.security.model.dto.req.UserRequestDTO;
import com.cafe.cafe_management_system.security.model.dto.res.UserResponseDTO;
import com.cafe.cafe_management_system.security.model.entity.User;
import com.cafe.cafe_management_system.shared.AbstractController;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController<User, UserRequestDTO, UserResponseDTO, IUserService> {

    public UserController(IUserService service) {
        super(service, "User");
    }
}
