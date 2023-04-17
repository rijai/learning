package com.rijai.omt.omtserver.repository;

import com.rijai.omt.omtserver.data.InventoryData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryRepository extends CrudRepository<InventoryData, Integer> {
    List<InventoryData> findAllByProductId(int productId);

    @Override
    void deleteById(Integer inventoryId);
}
