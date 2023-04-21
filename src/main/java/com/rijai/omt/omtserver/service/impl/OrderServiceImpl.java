package com.rijai.omt.omtserver.service.impl;

import com.rijai.omt.omtserver.OrderStatus;
import com.rijai.omt.omtserver.data.OrderData;
import com.rijai.omt.omtserver.repository.OrderRepository;
import com.rijai.omt.omtserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderData create(OrderData orderData) {
        orderData.setDateOrdered(new Date());
        orderData.setStatus(OrderStatus.Created);
        return orderRepository.save(orderData);
    }

    @Override
    public List<OrderData> getOrders(int customerId) {
        return orderRepository.findOrdersByCustomerId(customerId);
    }

    @Override
    public OrderData get(int orderId) {
        Optional<OrderData>  orderData = orderRepository.findById(orderId);
        if(orderData.isEmpty()){
            return null;
        }
        else {
            return orderData.get();
        }
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
