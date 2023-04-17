package com.rijai.omt.omtserver.service.impl;

import com.rijai.omt.omtserver.data.InventoryData;
import com.rijai.omt.omtserver.repository.InventoryRepository;
import com.rijai.omt.omtserver.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;
    @Override
    public InventoryData create(InventoryData inventoryData) {
        return inventoryRepository.save(inventoryData);
    }

    @Override
    public List<InventoryData> getInventories(int productId) {
        return inventoryRepository.findAllByProductId(productId);
    }

    @Override
    public Optional<InventoryData> get(int inventoryId) {
        return inventoryRepository.findById(inventoryId);
    }

    @Override
    public InventoryData update(InventoryData inventoryData) {
        return inventoryRepository.save(inventoryData);
    }

    @Override
    public void delete(int inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }
}
