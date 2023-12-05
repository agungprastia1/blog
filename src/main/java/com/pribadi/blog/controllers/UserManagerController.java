package com.pribadi.blog.controllers;

import com.pribadi.blog.dto.UserRequest;
import com.pribadi.blog.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;

@RestController
@RequestMapping("/api/users")
public class UserManagerController {
    @Autowired
    private UserManagerService userManagerService;
    @PostMapping("/multiple")
    public ResponseEntity<?> multiple(@RequestBody UserRequest request) throws Exception {
        return userManagerService.multiple(request);
    }
}
