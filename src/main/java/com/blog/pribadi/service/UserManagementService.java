package com.blog.pribadi.service;

import com.blog.pribadi.dto.UserRequest;
import com.blog.pribadi.model.Role;
import com.blog.pribadi.model.User;
import com.blog.pribadi.model.UserRole;
import com.blog.pribadi.repository.RoleRepository;
import com.blog.pribadi.repository.UserRepository;
import com.blog.pribadi.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service
public class UserManagementService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public ResponseEntity<?> multiple(UserRequest request){
        switch (request.getAction().toLowerCase(Locale.ROOT)){
            case "create":
                User user = User.builder()
                        .name(request.getName())
                        .username(request.getUserName())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .createAt(new Date())
                        .createdBy("agung")
                        .build();
                List<Long> idRole = new ArrayList<>();
                UserRole userRole = new UserRole();
               for (String data : request.getRole()){
                   Role role = Role.builder()
                           .role(data)
                           .createBy("Agung")
                           .createdAt(new Date()).build();
                   var id = roleRepository.save(role).getId();

                  userRole.setRoleId(id);
                   userRoleRepository.save(userRole);
               }
               user.setUserRole(userRole);
               userRepository.save(user);
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
