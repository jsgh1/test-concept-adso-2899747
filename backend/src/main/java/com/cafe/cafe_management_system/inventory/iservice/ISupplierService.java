package com.cafe.cafe_management_system.inventory.iservice;

import com.cafe.cafe_management_system.inventory.model.dto.req.SupplierRequestDTO;
import com.cafe.cafe_management_system.inventory.model.dto.res.SupplierResponseDTO;
import com.cafe.cafe_management_system.inventory.model.entity.Supplier;
import com.cafe.cafe_management_system.shared.IService;

public interface ISupplierService extends IService<Supplier, SupplierRequestDTO, SupplierResponseDTO> {
    // Custom service methods can be added here if needed
}