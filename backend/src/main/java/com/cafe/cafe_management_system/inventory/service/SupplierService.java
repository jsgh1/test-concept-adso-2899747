package com.cafe.cafe_management_system.inventory.service;

import com.cafe.cafe_management_system.inventory.iservice.ISupplierService;
import com.cafe.cafe_management_system.inventory.model.dto.req.SupplierRequestDTO;
import com.cafe.cafe_management_system.inventory.model.dto.res.SupplierResponseDTO;
import com.cafe.cafe_management_system.inventory.model.entity.Supplier;
import com.cafe.cafe_management_system.inventory.repository.ISupplierRepository;
import com.cafe.cafe_management_system.shared.AbstractService;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for Supplier entity operations.
 * Extends AbstractService to inherit common CRUD operations.
 */
@Service
public class SupplierService extends AbstractService<Supplier, SupplierRequestDTO, SupplierResponseDTO> implements ISupplierService {

    @Override
    protected IRepository<Supplier, Long> getRepository() {
        return repository;
    }

    @Autowired
    private ISupplierRepository repository;

    @Override
    public SupplierResponseDTO mapToResDto(Supplier entity) {
        SupplierResponseDTO response = new SupplierResponseDTO();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setContactPerson(entity.getContactPerson());
        response.setPhone(entity.getPhone());
        response.setEmail(entity.getEmail());
        response.setAddress(entity.getAddress());
        return response;
    }

    @Override
    public Supplier mapToEntity(SupplierRequestDTO request) {
        Supplier entity = new Supplier();
        entity.setName(request.getName());
        entity.setContactPerson(request.getContactPerson());
        entity.setPhone(request.getPhone());
        entity.setEmail(request.getEmail());
        entity.setAddress(request.getAddress());
        return entity;
    }
}