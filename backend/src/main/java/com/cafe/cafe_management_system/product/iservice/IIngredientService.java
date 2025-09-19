package com.cafe.cafe_management_system.product.iservice;

import com.cafe.cafe_management_system.product.model.dto.req.IngredientRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.IngredientResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.Ingredient;
import com.cafe.cafe_management_system.shared.IService;

public interface IIngredientService extends IService<Ingredient, IngredientRequestDTO, IngredientResponseDTO> {
    // Custom service methods can be added here if needed
}