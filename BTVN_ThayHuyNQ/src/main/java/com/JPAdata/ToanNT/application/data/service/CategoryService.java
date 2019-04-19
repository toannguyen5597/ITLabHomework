package com.JPAdata.ToanNT.application.data.service;

import com.JPAdata.ToanNT.application.data.model.Category;
import com.JPAdata.ToanNT.application.data.repository.CategoryRepository;
import com.JPAdata.ToanNT.application.data.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TypeRepository typeRepository;

    public List<Category> findByType(int type) {
        return categoryRepository.findByType(type);
    }

    public Category getOneByName(String name) {
        return categoryRepository.findByName(name);
    }

    public boolean update(Category category) {
        try {
            categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

}
