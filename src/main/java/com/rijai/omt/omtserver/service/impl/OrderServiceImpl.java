package com.rijai.omt.omtserver.service.impl;

import com.rijai.omt.omtserver.data.OrderData;
import com.rijai.omt.omtserver.repository.OrderRepository;
import com.rijai.omt.omtserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderData create(OrderData orderData) {
        return orderRepository.save(orderData);
    }

    @Override
    public List<OrderData> getOrders(int customerId) {
        return orderRepository.findOrdersByCustomerId(customerId);
    }

    @Override
    public Optional<OrderData> get(int orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public OrderData update(OrderData orderData) {

        return orderRepository.save(orderData);
    }

    @Override
    public void delete(int orderId) {
        orderRepository.deleteById(orderId);
    }
}
