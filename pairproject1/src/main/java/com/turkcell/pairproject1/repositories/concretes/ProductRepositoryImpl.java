package com.turkcell.pairproject1.repositories.concretes;

import com.turkcell.pairproject1.entities.Product;
import com.turkcell.pairproject1.repositories.abstracts.ProductRepository;
import com.turkcell.pairproject1.requests.ProductSaveRequest;
import com.turkcell.pairproject1.requests.ProductUpdateRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> productList;

    public ProductRepositoryImpl(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public Product findById(int id) {
        return productList.
                stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product save(ProductSaveRequest request) {
        Product product = new Product();
        product.setId(request.id());
        product.setName(request.name());
        product.setUnitPrice(request.unitPrice());
        product.setStock(request.stock());
        product.setDescription(request.description());
        product.setPhotoUrl(request.photoUrl());
        product.setCategory(request.category());
        productList.add(product);
        return product;
    }

    @Override
    public Product update(int id, ProductUpdateRequest request) {
        Product product = this.findById(id);
        product.setName(request.name());
        product.setUnitPrice(request.unitPrice());
        product.setStock(request.stock());
        product.setDescription(request.description());
        product.setPhotoUrl(request.photoUrl());
        return product;
    }

    @Override
    public void delete(int id) {
        Product product = this.findById(id);
        productList.remove(product);
    }
}
