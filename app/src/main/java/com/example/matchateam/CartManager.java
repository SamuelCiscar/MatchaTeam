package com.example.matchateam;

import com.example.matchateam.Beans.ProductBean;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private List<ProductCartItem> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public List<ProductCartItem> getCartItems() {
        return cartItems;
    }

    public void addToCart(ProductBean product, int quantity, double totalPrice) {
        ProductCartItem cartItem = new ProductCartItem(product, quantity, totalPrice);
        cartItems.add(cartItem);
    }
}