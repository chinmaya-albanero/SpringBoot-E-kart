package com.example.demo.Controller;

import com.example.demo.Model.Cart;
import com.example.demo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping

    public Cart createCart(@RequestParam String userId) {
        return cartService.createCart(userId);
    }

    @GetMapping("/{userId}")
    public Cart getCartByUserId(@PathVariable String userId) {
        return cartService.getCartByUserId(userId);
    }

    @PutMapping("/{userId}/products/{productId}")
    public Cart addProductToCart(@PathVariable String userId, @PathVariable String productId) {
        return cartService.addProductToCart(userId, productId);
    }

    @DeleteMapping("/{userId}")
    public void clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
    }
}
