package com.rijai.omt.omtserver.repository;

import com.rijai.omt.omtserver.data.ItemData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository  extends CrudRepository<ItemData, Integer> {
    List<ItemData> findAllByOrderId(int orderId);
}
