package com.cafe.cafe_management_system.product.controller;

import com.cafe.cafe_management_system.product.iservice.IProductService;
import com.cafe.cafe_management_system.product.model.dto.req.ProductRequestDTO;
import com.cafe.cafe_management_system.product.model.dto.res.ProductResponseDTO;
import com.cafe.cafe_management_system.product.model.entity.Product;
import com.cafe.cafe_management_system.shared.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController extends AbstractController<Product, ProductRequestDTO, ProductResponseDTO, IProductService> {

    public ProductController(IProductService service) {
        super(service, "Product");
    }

}
