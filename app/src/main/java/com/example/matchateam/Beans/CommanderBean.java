
package com.example.matchateam.Beans;

public class CommanderBean {
    private int id_commande;
    private int id_produit;
    private int quantite;

    // Constructeur par défaut
    public CommanderBean() {
        // Initialise les valeurs par défaut ou utilisez les setters pour les initialiser
    }

    // Setters et Getters pour chaque attribut

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
