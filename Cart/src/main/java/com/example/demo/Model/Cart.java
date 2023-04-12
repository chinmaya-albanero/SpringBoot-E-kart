package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CART")
public class Cart {
    private String id;
    private List<Product> products;
    private String userId;
    private BigDecimal totalPrice;
}
