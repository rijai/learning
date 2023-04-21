package com.rijai.omt.omtserver.service.impl;

import com.rijai.omt.omtserver.data.ItemData;
import com.rijai.omt.omtserver.data.OrderData;
import com.rijai.omt.omtserver.data.ProductData;
import com.rijai.omt.omtserver.repository.ProductRepository;
import com.rijai.omt.omtserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public ProductData create(ProductData productData) {
        return productRepository.save(productData);
    }

    @Override
    public List<ProductData> getProducts(int categoryId) {
        List<ProductData> productList = new ArrayList<>();
        productRepository.findProductDataByCategoryId(categoryId).forEach(productList::add);
        return productList;
    }

    @Override
    public List<ProductData> getProducts() {
        List<ProductData> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);
        return productList;
    }

    @Override
    public ProductData get(int productId) {
        Optional<ProductData> productData = productRepository.findById(productId);
        if(productData.isEmpty()){
            return null;
        }
        else {
            return productData.get();
        }
    }

    @Override
    public ProductData update(ProductData productData) {
        return productRepository.save(productData);
    }

    @Override
    public void delete(int productId) {
        productRepository.deleteById(productId);
    }
}
