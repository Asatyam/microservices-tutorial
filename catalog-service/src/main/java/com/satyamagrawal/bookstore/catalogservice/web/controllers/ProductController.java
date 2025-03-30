package com.satyamagrawal.bookstore.catalogservice.web.controllers;

import com.satyamagrawal.bookstore.catalogservice.domain.PagedResult;
import com.satyamagrawal.bookstore.catalogservice.domain.Product;
import com.satyamagrawal.bookstore.catalogservice.domain.ProductNotFoundException;
import com.satyamagrawal.bookstore.catalogservice.domain.ProductService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{code}")
    ResponseEntity<Product> getProduct(@PathVariable String code) {
        return productService.getProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(code));
    }
}
