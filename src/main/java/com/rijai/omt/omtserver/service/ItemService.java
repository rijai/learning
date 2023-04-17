package com.rijai.omt.omtserver.service;

import com.rijai.omt.omtserver.data.ItemData;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    ItemData create(ItemData itemData);
    List<ItemData> getItems(int orderId);
     ItemData get(int itemDataId);
    ItemData update(ItemData itemData);
    void delete(int itemId);
}
