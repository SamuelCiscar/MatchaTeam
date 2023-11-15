package com.example.matchateam.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matchateam.Beans.ProductBean;
import com.example.matchateam.PanierActivity;
import com.example.matchateam.ProductCartItem;
import com.example.matchateam.databinding.RowProductBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends ListAdapter<ProductBean, ProductListAdapter.ViewHolder> {
    public ProductListAdapter() {
        super(new Comparator());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowProductBinding binding = RowProductBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ViewHolder holder, int position) {
        ProductBean item = getItem(position);

        String imageUrl = item.getImage_produit();
        Picasso.get().load(imageUrl).into(holder.binding.ivImgProduct);

        holder.binding.tvProduct.setText(item.getNom_produit());
        holder.binding.tvPrice.setText(item.getPrix_produit() + "€");

        // Configurer le Spinner avec un adaptateur pour les quantités disponibles
        List<Integer> quantities = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            quantities.add(i);
        }
        ArrayAdapter<Integer> quantityAdapter = new ArrayAdapter<>(holder.itemView.getContext(),
                android.R.layout.simple_spinner_item, quantities);
        holder.binding.spinnerQuantity.setAdapter(quantityAdapter);

        holder.binding.btAddCart.setOnClickListener(view -> {
            int selectedQuantity = (int) holder.binding.spinnerQuantity.getSelectedItem();
            // Calculer le prix total en fonction de la quantité sélectionnée et du prix unitaire du produit
            double totalPrice = selectedQuantity * item.getPrix_produit();
            ProductCartItem cartItem = new ProductCartItem(item, selectedQuantity, totalPrice);
            System.out.println(cartItem.getTotalPrice());
        });
    }

    // Classe qui stocke les composants graphiques d'une ligne
    static class ViewHolder extends RecyclerView.ViewHolder {
        RowProductBinding binding;

        public ViewHolder(RowProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    static class Comparator extends DiffUtil.ItemCallback<ProductBean> {

        @Override
        public boolean areItemsTheSame(@NonNull ProductBean oldItem, @NonNull ProductBean newItem) {
            return oldItem == newItem;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull ProductBean oldItem, @NonNull ProductBean newItem) {
            return oldItem.getNom_produit() == newItem.getNom_produit();
        }
    }
}