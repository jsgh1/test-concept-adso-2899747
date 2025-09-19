package com.cafe.cafe_management_system.parameterization.repository;

import com.cafe.cafe_management_system.parameterization.model.entity.Role;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Role entity operations.
 * Extends the base IRepository interface for common CRUD operations.
 */
@Repository
public interface IRoleRepository extends IRepository<Role, Long> {
    // Additional custom query methods can be added here if needed
}
