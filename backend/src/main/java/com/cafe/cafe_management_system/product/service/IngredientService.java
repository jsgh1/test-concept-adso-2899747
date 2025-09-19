package com.cafe.cafe_management_system.product.service;

import com.cafe.cafe_management_system.product.iservice.IIngredientService;
import com.cafe.cafe_management_system.product.model.dto.req.IngredientRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.IngredientResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.Ingredient;
import com.cafe.cafe_management_system.product.repository.IIngredientRepository;
import com.cafe.cafe_management_system.shared.AbstractService;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for Ingredient entity operations.
 * Extends AbstractService to inherit common CRUD operations.
 */
@Service
public class IngredientService extends AbstractService<Ingredient, IngredientRequestDTO, IngredientResponseDTO> implements IIngredientService {

    @Override
    protected IRepository<Ingredient, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IIngredientRepository repository;

    @Override
    public IngredientResponseDTO mapToResDto(Ingredient entity) {
        IngredientResponseDTO response = new IngredientResponseDTO();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setUnit(entity.getUnit());
        return response;
    }

    @Override
    public Ingredient mapToEntity(IngredientRequestDTO request) {
        Ingredient entity = new Ingredient();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setUnit(request.getUnit());
        return entity;
    }
}