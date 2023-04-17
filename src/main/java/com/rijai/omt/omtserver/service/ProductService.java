package com.rijai.omt.omtserver.service;

import com.rijai.omt.omtserver.data.ProductData;
import com.rijai.omt.omtserver.data.OrderData;

import java.util.List;

public interface ProductService {
    ProductData create(ProductData productData);
    List<ProductData> getProducts(int categoryId);
    ProductData get(int productId);
    ProductData update(ProductData productData);
    void delete(int productId);
}
