package com.cafe.cafe_management_system.product.iservice;

import com.cafe.cafe_management_system.product.model.dto.req.ProductIngredientRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.ProductIngredientResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.ProductIngredient;
import com.cafe.cafe_management_system.shared.IService;

public interface IProductIngredientService extends IService<ProductIngredient, ProductIngredientRequestDTO, ProductIngredientResponseDTO> {
    // Custom service methods can be added here if needed
}