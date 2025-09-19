package com.cafe.cafe_management_system.product.repository;

import com.cafe.cafe_management_system.product.model.entity.CafeTable;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITableRepository extends IRepository<CafeTable, Long> {
    // Custom query methods can be added here if needed
}