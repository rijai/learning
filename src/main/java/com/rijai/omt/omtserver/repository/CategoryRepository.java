package com.rijai.omt.omtserver.repository;

import com.rijai.omt.omtserver.data.CategoryData;
import com.rijai.omt.omtserver.data.ItemData;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryData, Integer> {

}
