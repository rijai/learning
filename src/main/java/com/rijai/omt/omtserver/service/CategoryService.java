package com.rijai.omt.omtserver.service;

import com.rijai.omt.omtserver.data.CategoryData;
import java.util.List;

public interface CategoryService {
    CategoryData create(CategoryData categoryData);
    List<CategoryData> getCategories();
    CategoryData get(int categoryId);
    CategoryData update(CategoryData categoryData);
    void delete(int orderId);
}
