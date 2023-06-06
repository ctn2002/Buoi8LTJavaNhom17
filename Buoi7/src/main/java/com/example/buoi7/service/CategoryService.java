package com.example.buoi7.service;

import com.example.buoi7.model.Category;
import com.example.buoi7.model.Product;
import com.example.buoi7.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> GetAll() {
        return categoryRepository.findAll();
    }

    public void Add(Category newCategory) {
        categoryRepository.save(newCategory);
    }

}
