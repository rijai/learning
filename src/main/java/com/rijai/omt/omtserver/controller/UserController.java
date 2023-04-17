package com.rijai.omt.omtserver.controller;

import com.rijai.omt.omtserver.data.InventoryData;
import com.rijai.omt.omtserver.data.UserData;
import com.rijai.omt.omtserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @PutMapping("/user")
    public ResponseEntity<UserData> create(@RequestBody UserData userData){
        UserData newUser = new UserData();
        try {
            newUser = userService.create(userData);
            return ResponseEntity.ok(newUser);
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newUser);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserData>> listUsers(){
        List<UserData> users = new ArrayList<>();
        try {
            users = userService.getUsers();
            return ResponseEntity.ok(users);
        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(users);
        }
    }
}


