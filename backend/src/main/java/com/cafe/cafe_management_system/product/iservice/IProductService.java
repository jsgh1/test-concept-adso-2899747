package com.cafe.cafe_management_system.product.iservice;

import com.cafe.cafe_management_system.product.model.dto.req.ProductRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.ProductResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.Product;
import com.cafe.cafe_management_system.shared.IService;

public interface IProductService extends IService<Product, ProductRequestDTO, ProductResponseDTO> {
    // Custom service methods can be added here if needed
}