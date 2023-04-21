package com.rijai.omt.omtserver.controller;

import com.rijai.omt.omtserver.data.UserData;
import com.rijai.omt.omtserver.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private static Logger logger = LogManager.getLogger(UserController.class);

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

    @GetMapping("/users/{email}")
    public ResponseEntity<UserData> getUserByEmail(@PathVariable String email){
        UserData user  = null;
        logger.info("UserController::getUserByEmail Email: " + email);
        try {
            user = userService.getUserByEmail(email);
            return ResponseEntity.ok(user);
        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }
    }
}


