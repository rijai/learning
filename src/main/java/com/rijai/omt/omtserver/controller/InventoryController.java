package com.rijai.omt.omtserver.controller;

import com.rijai.omt.omtserver.data.InventoryData;
import com.rijai.omt.omtserver.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping("/:productId/list-inventories")
    public ResponseEntity<List<InventoryData>> listInventoriesByProductId(@PathVariable int productId){
        try {
            List<InventoryData> inventories = inventoryService.getInventories(productId);
            return ResponseEntity.ok(inventories);
        } catch(Exception ex){
            List<InventoryData> inventories = new ArrayList<>();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(inventories);
        }
    }


    @RequestMapping("/list-inventories/:productid")
    public ResponseEntity<List<InventoryData>> getProductCategories(@PathVariable int productid)
    {
        var headers = new HttpHeaders();

        try {
            List<InventoryData> inventories = inventoryService.getInventories(productid);
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
