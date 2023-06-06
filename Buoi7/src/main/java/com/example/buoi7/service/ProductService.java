package com.example.buoi7.service;

import com.example.buoi7.model.Product;
import com.example.buoi7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> GetAll() {
        return productRepository.findAll();
    }

    public Product get(int id) {
        return productRepository.findById(id).get();
    }

    public void edit(Product editProduct) {
        productRepository.save(editProduct);
    }

    public void add(Product newProduct) {
        productRepository.save(newProduct);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
