package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash("Product")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Product implements Serializable {
    @Id
    @Indexed
    private String id;
    private String name;
    private double price;
}
