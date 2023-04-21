package com.rijai.omt.omtserver.controller;

import com.rijai.omt.omtserver.data.ProductData;
import com.rijai.omt.omtserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @PutMapping("/product")
    public ResponseEntity<ProductData> create(@RequestBody ProductData productData){
        ProductData newProduct = new ProductData();
        try {
            newProduct = productService.create(productData);
            return ResponseEntity.ok(newProduct);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newProduct);
        }
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductData>> listProducts(){
        List<ProductData> products = new ArrayList<>();
        try {
            products = productService.getProducts();
            return ResponseEntity.ok(products);
        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(products);
        }
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<ProductData>> listProducts(@PathVariable int categoryId){
        List<ProductData> products = new ArrayList<>();
        try {
            products = productService.getProducts(categoryId);
            return ResponseEntity.ok(products);
        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(products);
        }
    }
}
