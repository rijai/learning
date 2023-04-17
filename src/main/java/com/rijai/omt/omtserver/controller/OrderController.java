package com.rijai.omt.omtserver.controller;

import com.rijai.omt.omtserver.data.InventoryData;
import com.rijai.omt.omtserver.data.OrderData;
import com.rijai.omt.omtserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;
    @GetMapping("/:customerId/list-orders")
    public ResponseEntity<List<OrderData>> listOrdersByCustomerId(@PathVariable int customerId){
        List<OrderData> orders = new ArrayList<>();
        try {
            orders = orderService.getOrders(customerId);
            return ResponseEntity.ok(orders);
        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(orders);
        }
    }
}
