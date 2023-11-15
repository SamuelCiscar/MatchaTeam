package com.example.matchateam.Beans;

public class ProductBean {
    private int id_produit;
    private double prix_produit;
    private String nomProduit;
    private String image_produit;

    // Constructeur par défaut
    public ProductBean() {
    }

    // Getter & Setter

    public int getId_produit() {
        return id_produit;
    }
    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public double getPrix_produit() {
        return prix_produit;
    }
    public void setPrix_produit(double prix_produit) {
        this.prix_produit = prix_produit;
    }

    public String getNom_produit() {
        return nomProduit;
    }
    public void setNom_produit(String nom_produit) {
        this.nomProduit = nom_produit;
    }

    public String getImage_produit() {
        return image_produit;
    }
    public void setImage_produit(String image_produit) {
        this.image_produit = image_produit;
    }
}
