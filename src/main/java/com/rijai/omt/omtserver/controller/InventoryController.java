package com.rijai.omt.omtserver.controller;

import com.rijai.omt.omtserver.data.InventoryData;
import com.rijai.omt.omtserver.data.InventoryData;
import com.rijai.omt.omtserver.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InventoryController {
    @Autowired
    InventoryService inventoryService;


    @PutMapping("/inventory")
    public ResponseEntity<InventoryData> create(@RequestBody InventoryData inventoryData){
        InventoryData newInventory = new InventoryData();
        try {
            newInventory = inventoryService.create(inventoryData);
            return ResponseEntity.ok(newInventory);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newInventory);
        }
    }

    @PostMapping("/inventory")
    public ResponseEntity<InventoryData> update(@RequestBody InventoryData inventoryData){
        InventoryData newInventory = new InventoryData();
        try {
            newInventory = inventoryService.update(inventoryData);
            return ResponseEntity.ok(newInventory);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newInventory);
        }
    }

    @DeleteMapping("/inventory/inventoryId")
    public ResponseEntity<Integer> delete(@PathVariable int inventoryId){
        try {
            inventoryService.delete(inventoryId);
            return ResponseEntity.ok(inventoryId);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(inventoryId);
        }
    }

    @GetMapping("/{productId}/inventories")
    public ResponseEntity<List<InventoryData>> listInventoriesByProductId(@PathVariable int productId){
        try {
            List<InventoryData> inventories = inventoryService.getInventories(productId);
            return ResponseEntity.ok(inventories);
        } catch(Exception ex){
            List<InventoryData> inventories = new ArrayList<>();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(inventories);
        }
    }


    @GetMapping("/{productId}/inventories")
    public ResponseEntity<List<InventoryData>> getProductCategories(@PathVariable int productId)
    {
        var headers = new HttpHeaders();
        try {
            List<InventoryData> inventories = inventoryService.getInventories(productId);
            return ResponseEntity.ok().headers(headers).body(inventories);
        }
        catch( Exception ex)
        {
            return new ResponseEntity<List<InventoryData>> (
                    headers,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

}
