package com.example.demo.Service;

import com.example.demo.Model.Cart;
import com.example.demo.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class CartService {
    @Autowired

    private CartRepository cartRepository;

    public Cart createCart(String userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProducts(new ArrayList<>());
        cart.setTotalPrice(BigDecimal.ZERO);
        return cartRepository.save(cart);
    }

    public Cart getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart addProductToCart(String userId, String productId) {
        Cart cart = getCartByUserId(userId);
        Product product = productService.getProductById(productId);
        cart.getProducts().add(product);
        cart.setTotalPrice(cart.getTotalPrice().add(product.getPrice()));
        return cartRepository.save(cart);
    }

    public void clearCart(String userId) {
        Cart cart = getCartByUserId(userId);
        cart.getProducts().clear();
        cart.setTotalPrice(BigDecimal.ZERO);
        cartRepository.save(cart);
    }
}
