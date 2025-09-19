package com.cafe.cafe_management_system.product.iservice;

import com.cafe.cafe_management_system.product.model.dto.req.CategoryRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.CategoryResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.Category;
import com.cafe.cafe_management_system.shared.IService;

public interface ICategoryService extends IService<Category, CategoryRequestDTO, CategoryResponseDTO> {
    // Custom service methods can be added here if needed
}