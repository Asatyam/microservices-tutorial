package com.satyamagrawal.bookstore.catalogservice.web.controllers;

import com.satyamagrawal.bookstore.catalogservice.domain.PagedResult;
import com.satyamagrawal.bookstore.catalogservice.domain.Product;
import com.satyamagrawal.bookstore.catalogservice.domain.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNumber ) {
        return productService.getProducts(pageNumber);
    }
}
