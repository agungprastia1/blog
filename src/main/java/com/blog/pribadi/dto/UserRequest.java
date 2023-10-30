package com.blog.pribadi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String action;
    private String name;
    private String userName;
    private String password;
    private String email;
    private List<String> role;
}
