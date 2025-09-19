package com.cafe.cafe_management_system.inventory.controller;

import com.cafe.cafe_management_system.inventory.iservice.IInventoryItemService;
import com.cafe.cafe_management_system.inventory.model.dto.req.InventoryItemRequestDTO;
import com.cafe.cafe_management_system.inventory.model.dto.res.InventoryItemResponseDTO;
import com.cafe.cafe_management_system.inventory.model.entity.InventoryItem;
import com.cafe.cafe_management_system.shared.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory-items")
@Tag(name = "Inventory Item", description = "Inventory item management operations")
public class InventoryItemController extends AbstractController<InventoryItem, InventoryItemRequestDTO, InventoryItemResponseDTO, IInventoryItemService> {
    public InventoryItemController(IInventoryItemService service) {
        super(service, "InventoryItem");
    }
}