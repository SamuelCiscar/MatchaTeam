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

    // Getters et setters pour accéder et modifier les attributs

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}