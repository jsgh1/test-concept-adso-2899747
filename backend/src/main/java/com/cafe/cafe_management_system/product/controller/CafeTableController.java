package com.cafe.cafe_management_system.product.controller;

import com.cafe.cafe_management_system.product.iservice.ITableService;
import com.cafe.cafe_management_system.product.model.dto.req.CafeTableRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.CafeTableResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.CafeTable;
import com.cafe.cafe_management_system.shared.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tables")
@Tag(name = "Table", description = "Cafe table management operations")
public class CafeTableController extends AbstractController<CafeTable, CafeTableRequestDTO, CafeTableResponseDTO, ITableService> {
    public CafeTableController(ITableService service) {
        super(service, "Table");
    }
}