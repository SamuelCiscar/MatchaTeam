


package com.example.matchateam.Beans;

import com.example.matchateam.ProductCartItem;

import java.util.List;

public class CommandeBean {
    private String telephone_commande;
    private String nom_commande;
    private String prenom_commande;
    private double prix_total_commande;

    private List<ProductCartItem> produits; // Ajout de la liste de produits

    public List<ProductCartItem> getProduits() {
        return produits;
    }

    public void setProduits(List<ProductCartItem> produits) {
        this.produits = produits;
    }

    // Constructeur par défaut
    public CommandeBean() {
        // Initialise les valeurs par défaut
    }

    // Setters et Getters pour chaque attribut
    public String getTelephone_commande() {
        return telephone_commande;
    }

    public void setTelephone_commande(String telephone_commande) {
        this.telephone_commande = telephone_commande;
    }

    public String getNom_commande() {
        return nom_commande;
    }

    public void setNom_commande(String nom_commande) {
        this.nom_commande = nom_commande;
    }

    public String getPrenom_commande() {
        return prenom_commande;
    }

    public void setPrenom_commande(String prenom_commande) {
        this.prenom_commande = prenom_commande;
    }

    public double getPrix_total_commande() {
        return prix_total_commande;
    }

    public void setPrix_total_commande(double prix_total_commande) {
        this.prix_total_commande = prix_total_commande;
    }
}
