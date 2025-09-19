package com.cafe.cafe_management_system.product.controller;

import com.cafe.cafe_management_system.product.iservice.IProductIngredientService;
import com.cafe.cafe_management_system.product.model.dto.req.ProductIngredientRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.ProductIngredientResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.ProductIngredient;
import com.cafe.cafe_management_system.product.service.ProductService;
import com.cafe.cafe_management_system.shared.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-ingredients")
@Tag(name = "Product Ingredient", description = "Product ingredient relationship management operations")
public class ProductIngredientController extends AbstractController<ProductIngredient, ProductIngredientRequestDTO, ProductIngredientResponseDTO, IProductIngredientService> {
    public ProductIngredientController(IProductIngredientService service) {
        super(service, "ProductIngredient");
    }
}