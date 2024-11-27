package com.example.exo4;

public class Produit {
    private String nom;
    private double prix;
    private int categorie;
    private int imageResId;

    public Produit(String nom, double prix, int categorie, int imageResId) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.imageResId = imageResId;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getCategorie() {
        return categorie;
    }

    public int getImageResId() {
        return imageResId;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}