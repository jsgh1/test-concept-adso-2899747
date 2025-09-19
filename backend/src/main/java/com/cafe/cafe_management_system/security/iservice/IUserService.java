package com.cafe.cafe_management_system.security.iservice;

import com.cafe.cafe_management_system.security.model.dto.req.UserRequestDTO;
import com.cafe.cafe_management_system.security.model.dto.res.UserResponseDTO;
import com.cafe.cafe_management_system.security.model.entity.User;
import com.cafe.cafe_management_system.shared.IService;

public interface IUserService extends IService<User, UserRequestDTO, UserResponseDTO> {
}
