package com.cafe.cafe_management_system.inventory.controller;

import com.cafe.cafe_management_system.inventory.iservice.ISupplierService;
import com.cafe.cafe_management_system.inventory.model.dto.req.SupplierRequestDTO;
import com.cafe.cafe_management_system.inventory.model.dto.res.SupplierResponseDTO;
import com.cafe.cafe_management_system.inventory.model.entity.Supplier;
import com.cafe.cafe_management_system.shared.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/suppliers")
@Tag(name = "Supplier", description = "Supplier management operations")
public class SupplierController extends AbstractController<Supplier, SupplierRequestDTO, SupplierResponseDTO, ISupplierService> {
    public SupplierController(ISupplierService service) {
        super(service, "Supplier");
    }
}