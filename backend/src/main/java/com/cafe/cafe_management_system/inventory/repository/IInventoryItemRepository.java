package com.cafe.cafe_management_system.inventory.repository;

import com.cafe.cafe_management_system.inventory.model.entity.InventoryItem;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventoryItemRepository extends IRepository<InventoryItem, Long> {
    // Custom query methods can be added here if needed
}