package com.blog.pribadi.controller;

import com.blog.pribadi.dto.UserRequest;
import com.blog.pribadi.model.User;
import com.blog.pribadi.service.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
@Slf4j
public class UserManagementController {
    @Autowired
    private UserManagementService userManagementService;

    @RequestMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserRequest request){
        return  userManagementService.multiple(request);
    }

}
