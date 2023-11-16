package com.example.matchateam.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matchateam.ProductCartItem;
import com.example.matchateam.R;

import java.util.ArrayList;
import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {
    // Initialisation de la liste cartItems
    private List<ProductCartItem> cartItems = new ArrayList<>();

    public CartItemAdapter() {
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product_cmd, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Récupérer l'élément du panier à la position donnée
        ProductCartItem cartItem = cartItems.get(position);

        // Mettre à jour les vues de ViewHolder avec les données du produit du panier
        holder.tvProduct.setText(cartItem.getProduct().getNom_produit());
        holder.etQty.setText(String.valueOf(cartItem.getQuantity()));
        holder.txtPrix.setText(String.valueOf(cartItem.getTotalPrice()));

        // Ajoutez ici la logique pour supprimer un élément du panier lorsqu'on clique sur le bouton de suppression
        holder.btDelProd.setOnClickListener(v -> {
            // Supprimer l'élément du panier
            cartItems.remove(position);
            notifyDataSetChanged(); // Actualiser l'affichage après la suppression
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public void setCartItems(List<ProductCartItem> items) {
        this.cartItems = items;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvProduct;
        TextView etQty;
        TextView txtPrix;
        ImageView btDelProd;

        public ViewHolder(View itemView) {
            super(itemView);
            tvProduct = itemView.findViewById(R.id.tv_Product);
            etQty = itemView.findViewById(R.id.etQty);
            txtPrix = itemView.findViewById(R.id.txtPrix);
            btDelProd = itemView.findViewById(R.id.bt_delProd);
        }
    }
}
