package com.rijai.omt.omtserver.repository;

import com.rijai.omt.omtserver.data.ProductData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductData, Integer> {
    List<ProductData> findProductDataByCategoryId(int categoryId);
}
