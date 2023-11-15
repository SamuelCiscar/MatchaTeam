package com.example.matchateam;

import com.example.matchateam.Beans.ProductBean;

public class ProductCartItem {
    private ProductBean product; // Détails du produit
    private int quantity; // Quantité sélectionnée
    private double totalPrice; // Prix total (quantité * prix unitaire)

    public ProductCartItem(ProductBean product, int quantity, double totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public ProductBean getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}