package com.rijai.omt.omtserver.controller;

import com.rijai.omt.omtserver.model.AuthToken;
import com.rijai.omt.omtserver.model.Credential;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Controller
public class AuthorizationController {

    @PostMapping("/api-clients")
    ResponseEntity<HashMap<String,String>> getAuthToken(@RequestBody Credential credential){
        String clientName = credential.getClientName();
        String clientEmail = credential.getClientEmail();

        HashMap token = new HashMap<String, String>();
        token.put("accessToken", "Bearer " + "a5b0dd1043e0e01125a2f1db8cbe98d4748f4cc661c3c0bb11755502f9781aee");
        return ResponseEntity.ok(token);
    }
}
