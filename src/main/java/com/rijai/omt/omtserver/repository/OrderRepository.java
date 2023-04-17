package com.rijai.omt.omtserver.repository;

import com.rijai.omt.omtserver.data.OrderData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderData, Integer> {
    List<OrderData> findOrdersByCustomerId(int customerId);
}
