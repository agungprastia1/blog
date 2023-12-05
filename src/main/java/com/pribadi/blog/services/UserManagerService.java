package com.pribadi.blog.services;

import com.pribadi.blog.dto.UserRequest;
import com.pribadi.blog.models.User;
import com.pribadi.blog.repository.UserRepository;
import com.pribadi.blog.util.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class UserManagerService {
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<?> multiple(UserRequest request) throws Exception {
        if (request != null && Validator.isNotNullOrEmpty(request.getAction())){
            String pass = request.getPassword();
            User user = new User();
            switch (request.getAction()){
                case "create":
                     user = User.builder()
                            .name(request.getName())
                            .createAt(new Date())
                            .createBy("up.getName()")
                            .email(request.getEmail())
                            .password(pass)
                            .noHp(request.getNoHp())
                            .build();

                    userRepository.save(user);
                    break;
                case "update":
                    if (Validator.isNullOrEmpty(request.getId()))
                        throw new RuntimeException("Id Tidak bole kosong");

                    user = userRepository.findById(request.getId()).get();
                    if (user == null){
                        throw new RuntimeException("User Id Not Found");
                    }

                    user.setName(request.getName());
                    user.setEmail(request.getEmail());
                    user.setPassword(pass);
                    user.setUpdateby("up.getName()");
                    user.setUpdateAt(new Date());

                    userRepository.save(user);
                    break;
                case "delete":
                    if (Validator.isNullOrEmpty(request.getId()))
                        throw new RuntimeException("Id Tidak bole kosong");

                    user = userRepository.findById(request.getId()).get();
                    if (user == null){
                        throw new RuntimeException("User Id Not Found");
                    }

                    userRepository.delete(user);
                    break;
                default:
                    throw new Exception("Action tidak Sesuai");
            }
            return  ResponseEntity.ok(user);
        }
        return ResponseEntity.ofNullable("Actioan tidak boleh kosong");
    }
}
