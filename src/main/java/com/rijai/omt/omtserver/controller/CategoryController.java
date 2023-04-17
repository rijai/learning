package com.rijai.omt.omtserver.controller;

import com.rijai.omt.omtserver.data.CategoryData;
import com.rijai.omt.omtserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PutMapping("/category")
    public ResponseEntity<CategoryData> create(@RequestBody CategoryData categoryData){
        CategoryData newCategory = new CategoryData();
        try {
            newCategory = categoryService.create(categoryData);
            return ResponseEntity.ok(newCategory);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newCategory);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryData>> listCategories(){
        List<CategoryData> categorys = new ArrayList<>();
        try {
            categorys = categoryService.getCategories();
            return ResponseEntity.ok(categorys);
        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categorys);
        }
    }

}
