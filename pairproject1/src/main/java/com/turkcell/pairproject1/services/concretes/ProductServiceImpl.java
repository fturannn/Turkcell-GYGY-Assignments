package com.turkcell.pairproject1.services.concretes;

import com.turkcell.pairproject1.entities.Product;
import com.turkcell.pairproject1.repositories.abstracts.ProductRepository;
import com.turkcell.pairproject1.requests.ProductSaveRequest;
import com.turkcell.pairproject1.requests.ProductUpdateRequest;
import com.turkcell.pairproject1.services.abstracts.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(int id) {
        Product product = productRepository.findById(id);

        if(product == null) {
            throw new RuntimeException("İlgili Id'ye sahip ürün bulunamadı!");
        }

        return product;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(ProductSaveRequest request) {
        return productRepository.save(request);
    }

    @Override
    public Product update(int id, ProductUpdateRequest request) {
        return productRepository.update(id, request);
    }

    @Override
    public void delete(int id) {
        Product product = productRepository.findById(id);

        if(product == null) {
            throw new RuntimeException("İlgili Id'ye sahip ürün bulunamadı!");
        }

        productRepository.delete(id);
    }
}
