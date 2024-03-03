package com.turkcell.pairproject1.controllers;

import com.turkcell.pairproject1.entities.Product;
import com.turkcell.pairproject1.requests.ProductSaveRequest;
import com.turkcell.pairproject1.requests.ProductUpdateRequest;
import com.turkcell.pairproject1.services.abstracts.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product add(@RequestBody ProductSaveRequest request) {
        return productService.save(request);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody ProductUpdateRequest request) {
        return productService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }
}
