package com.pribadi.blog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "previlage")

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Previlage {
    @Id
    @GeneratedValue
    private Integer id;
    private String previlage;
    private String description;
}
