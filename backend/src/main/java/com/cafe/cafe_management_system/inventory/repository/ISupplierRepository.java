package com.cafe.cafe_management_system.inventory.repository;

import com.cafe.cafe_management_system.inventory.model.entity.Supplier;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplierRepository extends IRepository<Supplier, Long> {
    // Custom query methods can be added here if needed
}