package com.cafe.cafe_management_system.inventory.iservice;

import com.cafe.cafe_management_system.inventory.model.dto.req.InventoryItemRequestDTO;
import com.cafe.cafe_management_system.inventory.model.dto.res.InventoryItemResponseDTO;
import com.cafe.cafe_management_system.inventory.model.entity.InventoryItem;
import com.cafe.cafe_management_system.shared.IService;

public interface IInventoryItemService extends IService<InventoryItem, InventoryItemRequestDTO, InventoryItemResponseDTO> {
    // Custom service methods can be added here if needed
}