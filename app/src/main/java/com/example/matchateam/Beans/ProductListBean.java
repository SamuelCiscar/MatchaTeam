package com.example.matchateam.Beans;

public class ProductListBean {
    private ProductBean product;
    private int quantity;

    public ProductListBean(ProductBean product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductListBean() {
    }

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
}
