package com.example.exo4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProduitArrayAdapter extends ArrayAdapter<Produit> {
    private final Context context;
    private final List<Produit> produits;

    public ProduitArrayAdapter(Context context, List<Produit> produits) {
        super(context, R.layout.mon_layout, produits);
        this.context = context;
        this.produits = produits;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.mon_layout, parent, false);

        TextView nomProduit = rowView.findViewById(R.id.nomProduit);
        TextView prixProduit = rowView.findViewById(R.id.prixProduit);
        TextView categorieProduit = rowView.findViewById(R.id.categorieProduit);
        ImageView imageProduit = rowView.findViewById(R.id.imageProduit);

        Produit produit = produits.get(position);
        nomProduit.setText(produit.getNom());
        prixProduit.setText(String.valueOf(produit.getPrix()));
        categorieProduit.setText(String.valueOf(produit.getCategorie()));
        imageProduit.setImageResource(produit.getImageResId());
        return rowView;
    }
}