package com.SpringBoot.E_Commerce.E_Commerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

}
