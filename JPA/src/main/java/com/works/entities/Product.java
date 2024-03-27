package com.works.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(unique = true, length = 200)
    private String title;

    private Integer price;

    @Column(length = 300)
    private String sort;

    @Column(length = 1000)
    private String detail;

}
