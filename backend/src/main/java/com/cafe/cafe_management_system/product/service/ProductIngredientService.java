package com.cafe.cafe_management_system.product.service;

import com.cafe.cafe_management_system.product.iservice.IProductIngredientService;
import com.cafe.cafe_management_system.product.model.dto.req.ProductIngredientRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.ProductIngredientResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.Ingredient;
import com.cafe.cafe_management_system.product.model.entity.Product;
import com.cafe.cafe_management_system.product.model.entity.ProductIngredient;
import com.cafe.cafe_management_system.product.repository.IProductIngredientRepository;
import com.cafe.cafe_management_system.shared.AbstractService;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for ProductIngredient entity operations.
 * Extends AbstractService to inherit common CRUD operations.
 */
@Service
public class ProductIngredientService extends AbstractService<ProductIngredient, ProductIngredientRequestDTO, ProductIngredientResponseDTO> implements IProductIngredientService {

    @Override
    protected IRepository<ProductIngredient, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IProductIngredientRepository repository;

    @Override
    public ProductIngredientResponseDTO mapToResDto(ProductIngredient entity) {
        ProductIngredientResponseDTO response = new ProductIngredientResponseDTO();
        response.setId(entity.getId());
        response.setQuantity(entity.getQuantity());
        
        if (entity.getProduct() != null) {
            response.setProductId(entity.getProduct().getId());
            response.setProductName(entity.getProduct().getName());
        }
        
        if (entity.getIngredient() != null) {
            response.setIngredientId(entity.getIngredient().getId());
            response.setIngredientName(entity.getIngredient().getName());
        }
        
        return response;
    }

    @Override
    public ProductIngredient mapToEntity(ProductIngredientRequestDTO request) {
        Product product = new Product();
        product.setId(request.getProductId());
        
        Ingredient ingredient = new Ingredient();
        ingredient.setId(request.getIngredientId());
        
        ProductIngredient entity = new ProductIngredient();
        entity.setProduct(product);
        entity.setIngredient(ingredient);
        entity.setQuantity(request.getQuantity());
        return entity;
    }
}