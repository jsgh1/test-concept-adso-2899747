package com.cafe.cafe_management_system.product.controller;

import com.cafe.cafe_management_system.product.iservice.ICategoryService;
import com.cafe.cafe_management_system.product.model.dto.req.CategoryRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.CategoryResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.Category;
import com.cafe.cafe_management_system.shared.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category", description = "Product category management operations")
public class CategoryController extends AbstractController<Category, CategoryRequestDTO, CategoryResponseDTO, ICategoryService> {
    public CategoryController(ICategoryService service) {
        super(service, "Category");
    }
}