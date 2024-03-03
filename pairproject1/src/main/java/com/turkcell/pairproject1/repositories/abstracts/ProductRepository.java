package com.turkcell.pairproject1.repositories.abstracts;

import com.turkcell.pairproject1.entities.Product;
import com.turkcell.pairproject1.requests.ProductSaveRequest;
import com.turkcell.pairproject1.requests.ProductUpdateRequest;

import java.util.List;

public interface ProductRepository {

    Product findById(int id);
    List<Product> findAll();
    Product save(ProductSaveRequest request);
    Product update(int id, ProductUpdateRequest request);
    void delete(int id);
}
