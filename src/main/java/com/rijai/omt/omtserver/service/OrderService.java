package com.rijai.omt.omtserver.service;

import com.rijai.omt.omtserver.data.OrderData;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderData create(OrderData orderData);
    List<OrderData> getOrders(int customerId);
    OrderData  get(int orderId);
    OrderData update(OrderData orderData);
    void delete(int orderId);
}
