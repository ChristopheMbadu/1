package com.example.exo4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private EditText txtprix, txtproduits;
    private RadioButton txtfruitetlegume, txtviandesubstitut, txtproduitlaitier, txtpatisserie;
    private ListView txtlisteviewproduit;
    private ArrayList<Produit> produits;
    private ProduitArrayAdapter adapter;
    private TextView txtTotalPrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        this.txtproduits = findViewById(R.id.txtProduits);
        this.txtprix = findViewById(R.id.txtprix);
        this.txtfruitetlegume = findViewById(R.id.txtFruitLegumes);
        this.txtviandesubstitut = findViewById(R.id.txtViandeSubstitut);
        this.txtproduitlaitier = findViewById(R.id.txtProduitlaitier);
        this.txtlisteviewproduit = findViewById(R.id.txtlisteViewProduits);
        this.txtpatisserie = findViewById(R.id.txtPatisserie);
        this.txtTotalPrix = findViewById(R.id.txtTotalPrix);

        produits = new ArrayList<>();
        adapter = new ProduitArrayAdapter(this, produits);
        txtlisteviewproduit.setAdapter(adapter);
    }

    public void statiqueajouteralaliste(View view) {
        String nom = txtproduits.getText().toString();
        String prixStr = txtprix.getText().toString();


        if (prixStr.isEmpty()) {
            txtprix.setError("Veuillez entrer un prix");
            return;
        }

        double prix = Double.parseDouble(prixStr);
        int categorie = 0;

        if (txtfruitetlegume.isChecked()) {
            categorie = 1;
        } else if (txtviandesubstitut.isChecked()) {
            categorie = 2;
        } else if (txtproduitlaitier.isChecked()) {
            categorie = 3;
        } else if (txtpatisserie.isChecked()) {
            categorie = 4;

        }
        else {

            return;
        }


        int imageResId = R.drawable.default_image;
        switch (categorie) {
            case 1:
                imageResId = R.drawable.fruits_legumes;
                break;
            case 2:
                imageResId = R.drawable.viande_substitut;
                break;
            case 3:
                imageResId = R.drawable.produit_laitier;
                break;
            case 4:
                imageResId = R.drawable.patisserie;
                break;
        }


        produits.add(new Produit(nom, prix, categorie, imageResId));


        Collections.sort(produits, new Comparator<Produit>() {
            @Override
            public int compare(Produit p1, Produit p2) {
                return Integer.compare(p1.getCategorie(), p2.getCategorie());
            }
        });


        adapter.notifyDataSetChanged();


        updateTotalPrice();


        txtproduits.setText("");
        txtprix.setText("");
    }

    private void updateTotalPrice() {
        double total = 0;
        for (Produit produit : produits) {
            total += produit.getPrix();
        }
        txtTotalPrix.setText("Total: " + total +"$");
    }
}