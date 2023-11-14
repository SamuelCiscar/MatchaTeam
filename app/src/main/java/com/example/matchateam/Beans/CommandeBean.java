


package com.example.matchateam.Beans;

import java.util.Date;

public class CommandeBean {
    private int id_commande;
    private String telephone_commande;
    private String nom_commande;
    private String prenom_commande;
    private double prix_total_commande;
    private Date date_commande;

    // Constructeur par défaut
    public CommandeBean() {
        // Initialise les valeurs par défaut ou utilisez les setters pour les initialiser
    }

    // Setters et Getters pour chaque attribut

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

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

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }
}

