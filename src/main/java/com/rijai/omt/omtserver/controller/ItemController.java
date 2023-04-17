package com.rijai.omt.omtserver.controller;

import com.rijai.omt.omtserver.data.ItemData;
import com.rijai.omt.omtserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {
    @Autowired
    ItemService itemService;


    @PutMapping("/item")
    public ResponseEntity<ItemData> create(@RequestBody ItemData itemData){
        ItemData newItem;
        try {
            newItem = itemService.create(itemData);
            return ResponseEntity.ok(newItem);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(itemData);
        }
    }

    @PostMapping("/item")
    public ResponseEntity<ItemData> update(@RequestBody ItemData itemData){
        ItemData newItem;
        try {
            newItem = itemService.update(itemData);
            return ResponseEntity.ok(newItem);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(itemData);
        }
    }

    @DeleteMapping ("/item/{itemId}")
    public ResponseEntity<Integer> delete(@PathVariable int itemId){
        try {
            itemService.delete(itemId);
            return ResponseEntity.ok(itemId);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(itemId);
        }
    }

    @GetMapping("/{orderId}/items")
    public ResponseEntity<List<ItemData>> listItemsByOrderId(@PathVariable int orderId){
        List<ItemData> items = new ArrayList<>();
        try {
            items = itemService.getItems(orderId);
            return ResponseEntity.ok(items);
        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(items);
        }
    }

}
