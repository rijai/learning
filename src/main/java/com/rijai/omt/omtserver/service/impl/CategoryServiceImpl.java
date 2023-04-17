package com.rijai.omt.omtserver.service.impl;

import com.rijai.omt.omtserver.data.CategoryData;
import com.rijai.omt.omtserver.repository.CategoryRepository;
import com.rijai.omt.omtserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public CategoryData create(CategoryData CategoryData) {
        return categoryRepository.save(CategoryData);
    }

    @Override
    public List<CategoryData> getCategories() {
        List<CategoryData> list = new ArrayList<>();
        categoryRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public CategoryData get(int categoryId) {
        Optional<CategoryData> category =  categoryRepository.findById(categoryId);
        if(category.isEmpty()){
            return null;
        }
        else {
            return category.get();
        }
    }

    @Override
    public CategoryData update(CategoryData categoryData) {
        return categoryRepository.save(categoryData);
    }

    @Override
    public void delete(int orderId) {
        categoryRepository.deleteById(orderId);
    }

}
