package com.cafe.cafe_management_system.product.service;

import com.cafe.cafe_management_system.product.iservice.IProductService;
import com.cafe.cafe_management_system.product.model.dto.req.ProductRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.ProductResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.Category;
import com.cafe.cafe_management_system.product.model.entity.Product;
import com.cafe.cafe_management_system.product.repository.IProductRepository;
import com.cafe.cafe_management_system.shared.AbstractService;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for Product entity operations.
 * Extends AbstractService to inherit common CRUD operations.
 */
@Service
public class ProductService extends AbstractService<Product, ProductRequestDTO, ProductResponseDTO> implements IProductService {

    @Override
    protected IRepository<Product, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IProductRepository repository;

    @Override
    public ProductResponseDTO mapToResDto(Product entity) {
        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setPrice(entity.getPrice());
        
        if (entity.getCategory() != null) {
            response.setCategoryId(entity.getCategory().getId());
            response.setCategoryName(entity.getCategory().getName());
        }
        
        return response;
    }

    @Override
    public Product mapToEntity(ProductRequestDTO request) {
        Category category = new Category();
        category.setId(request.getCategoryId());
        
        Product entity = new Product();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setPrice(request.getPrice());
        entity.setCategory(category);
        return entity;
    }
}