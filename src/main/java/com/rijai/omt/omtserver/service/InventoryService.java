package com.rijai.omt.omtserver.service;

import com.rijai.omt.omtserver.data.InventoryData;
import java.util.List;
import java.util.Optional;

public interface InventoryService {
    InventoryData create(InventoryData inventoryData);
    List<InventoryData> getInventories(int productId);
    Optional<InventoryData> get(int inventoryDataId);
    InventoryData update(InventoryData inventoryData);
    void delete(int inventoryId);
}
