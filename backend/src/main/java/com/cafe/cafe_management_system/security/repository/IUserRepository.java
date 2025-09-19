package com.cafe.cafe_management_system.security.repository;

import com.cafe.cafe_management_system.security.model.entity.User;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends IRepository<User, Long> {
}
