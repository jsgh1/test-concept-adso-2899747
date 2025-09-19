package com.cafe.cafe_management_system.product.service;

import com.cafe.cafe_management_system.product.iservice.ITableService;
import com.cafe.cafe_management_system.product.model.dto.req.CafeTableRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.CafeTableResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.CafeTable;
import com.cafe.cafe_management_system.product.repository.ITableRepository;
import com.cafe.cafe_management_system.shared.AbstractService;
import com.cafe.cafe_management_system.shared.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for Table entity operations.
 * Extends AbstractService to inherit common CRUD operations.
 */
@Service
public class TableService extends AbstractService<CafeTable, CafeTableRequestDTO, CafeTableResponseDTO> implements ITableService {

    @Override
    protected IRepository<CafeTable, Long> getRepository() {
        return repository;
    }

    @Autowired
    private ITableRepository repository;

    @Override
    public CafeTableResponseDTO mapToResDto(CafeTable entity) {
        CafeTableResponseDTO response = new CafeTableResponseDTO();
        response.setId(entity.getId());
        response.setTableNumber(entity.getTableNumber());
        response.setCapacity(entity.getCapacity());
        response.setLocation(entity.getLocation());
        response.setIsActive(entity.getIsActive());
        return response;
    }

    @Override
    public CafeTable mapToEntity(CafeTableRequestDTO request) {
        CafeTable entity = new CafeTable();
        entity.setTableNumber(request.getTableNumber());
        entity.setCapacity(request.getCapacity());
        entity.setLocation(request.getLocation());
        entity.setIsActive(request.getIsActive());
        return entity;
    }
}