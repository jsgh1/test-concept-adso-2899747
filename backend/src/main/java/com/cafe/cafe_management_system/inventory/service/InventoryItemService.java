package com.cafe.cafe_management_system.inventory.service;

import com.cafe.cafe_management_system.inventory.iservice.IInventoryItemService;
import com.cafe.cafe_management_system.inventory.model.dto.req.InventoryItemRequestDTO;
import com.cafe.cafe_management_system.inventory.model.dto.res.InventoryItemResponseDTO;
import com.cafe.cafe_management_system.inventory.model.entity.InventoryItem;
import com.cafe.cafe_management_system.inventory.repository.IInventoryItemRepository;
import com.cafe.cafe_management_system.product.model.entity.Ingredient;
import com.cafe.cafe_management_system.product.model.entity.Product;
import com.cafe.cafe_management_system.inventory.model.entity.Supplier;
import com.cafe.cafe_management_system.shared.AbstractService;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for InventoryItem entity operations.
 * Extends AbstractService to inherit common CRUD operations.
 */
@Service
public class InventoryItemService extends AbstractService<InventoryItem, InventoryItemRequestDTO, InventoryItemResponseDTO> implements IInventoryItemService {

    @Override
    protected IRepository<InventoryItem, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IInventoryItemRepository repository;

    @Override
    public InventoryItemResponseDTO mapToResDto(InventoryItem entity) {
        InventoryItemResponseDTO response = new InventoryItemResponseDTO();
        response.setId(entity.getId());
        response.setQuantity(entity.getQuantity());
        response.setUnitPrice(entity.getUnitPrice());

        if (entity.getSupplier() != null) {
            response.setSupplierId(entity.getSupplier().getId());
            response.setSupplierName(entity.getSupplier().getName());
        }

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
    public InventoryItem mapToEntity(InventoryItemRequestDTO request) {
        Supplier supplier = null;
        if (request.getSupplierId() != null) {
            supplier = new Supplier();
            supplier.setId(request.getSupplierId());
        }

        Product product = null;
        if (request.getProductId() != null) {
            product = new Product();
            product.setId(request.getProductId());
        }

        Ingredient ingredient = null;
        if (request.getIngredientId() != null) {
            ingredient = new Ingredient();
            ingredient.setId(request.getIngredientId());
        }

        InventoryItem entity = new InventoryItem();
        entity.setSupplier(supplier);
        entity.setProduct(product);
        entity.setIngredient(ingredient);
        entity.setQuantity(request.getQuantity());
        entity.setUnitPrice(request.getUnitPrice());
        return entity;
    }
}