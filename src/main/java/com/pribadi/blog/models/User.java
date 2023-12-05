package com.pribadi.blog.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;
    private String email;
    private String noHp;
    @JsonIgnore
    private String password;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createAt;
    private String createBy;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date updateAt;
    private String updateby;

//    @JoinColumn(name = "role")
//    private List<Role> role;

//    @JoinColumn(name = "previlage")
//    private List<Previlage> previlage;
}
