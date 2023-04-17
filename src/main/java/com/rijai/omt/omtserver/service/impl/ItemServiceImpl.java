package com.rijai.omt.omtserver.service.impl;

import com.rijai.omt.omtserver.data.ItemData;
import com.rijai.omt.omtserver.repository.ItemRepository;
import com.rijai.omt.omtserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Override
    public ItemData create(ItemData itemData) {
        return  itemRepository.save(itemData);
    }

    @Override
    public List<ItemData> getItems(int orderId) {

        return itemRepository.findAllByOrderId(orderId);
    }

    @Override
    public Optional<ItemData> get(int itemId) {
        return itemRepository.findById(itemId);
    }

    @Override
    public ItemData update(ItemData itemData) {
        return itemRepository.save(itemData);
    }

    @Override
    public void delete(int itemId) {
        itemRepository.deleteById(itemId);
    }
}
