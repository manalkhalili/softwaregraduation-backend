package com.soft.backend.service;

import com.soft.backend.entity.Product;
import com.soft.backend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public List<Product> findAll(){
        return productRepo.findAll();
    }
    public Product findById(long id){
        return productRepo.findById(id).orElse(null);
    }
    public Product save(Product product){
        return productRepo.save(product);
    }
}
