package com.cafe.cafe_management_system.product.service;

import com.cafe.cafe_management_system.product.iservice.ICategoryService;
import com.cafe.cafe_management_system.product.model.dto.req.CategoryRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.CategoryResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.Category;
import com.cafe.cafe_management_system.product.repository.ICategoryRepository;
import com.cafe.cafe_management_system.shared.AbstractService;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for Category entity operations.
 * Extends AbstractService to inherit common CRUD operations.
 */
@Service
public class CategoryService extends AbstractService<Category, CategoryRequestDTO, CategoryResponseDTO> implements ICategoryService {

    @Override
    protected IRepository<Category, Long> getRepository() {
        return repository;
    }

    @Autowired
    private ICategoryRepository repository;

    @Override
    public CategoryResponseDTO mapToResDto(Category entity) {
        CategoryResponseDTO response = new CategoryResponseDTO();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        return response;
    }

    @Override
    public Category mapToEntity(CategoryRequestDTO request) {
        Category entity = new Category();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }
}