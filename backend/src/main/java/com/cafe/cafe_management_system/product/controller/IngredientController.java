package com.cafe.cafe_management_system.product.controller;

import com.cafe.cafe_management_system.product.iservice.IIngredientService;
import com.cafe.cafe_management_system.product.model.dto.req.IngredientRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.IngredientResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.Ingredient;
import com.cafe.cafe_management_system.shared.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingredients")
@Tag(name = "Ingredient", description = "Ingredient management operations")
public class IngredientController extends AbstractController<Ingredient, IngredientRequestDTO, IngredientResponseDTO, IIngredientService> {
    public IngredientController(IIngredientService service) {
        super(service, "Ingredient");
    }
}