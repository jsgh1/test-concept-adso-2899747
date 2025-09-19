package com.cafe.cafe_management_system.product.iservice;

import com.cafe.cafe_management_system.product.model.dto.req.CafeTableRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.CafeTableResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.CafeTable;
import com.cafe.cafe_management_system.shared.IService;

public interface ITableService extends IService<CafeTable, CafeTableRequestDTO, CafeTableResponseDTO> {
    // Custom service methods can be added here if needed
}