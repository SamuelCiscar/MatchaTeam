package com.example.matchateam.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matchateam.Beans.ProductBean;
import com.example.matchateam.databinding.RowProductBinding;

public class ProductListAdapter extends ListAdapter<ProductBean, ProductListAdapter.ViewHolder> {
    public ProductListAdapter(){
        super(new Comparator());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        RowProductBinding binding = RowProductBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ViewHolder holder, int position) {

    }

    // Classe qui stocke les composants graphiques d'une ligne
    static class ViewHolder extends RecyclerView.ViewHolder{
        RowProductBinding binding;

        public ViewHolder(RowProductBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    static class Comparator extends DiffUtil.ItemCallback<ProductBean>{

        @Override
        public boolean areItemsTheSame(@NonNull ProductBean oldItem, @NonNull ProductBean newItem){
            return oldItem == newItem;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull ProductBean oldItem, @NonNull ProductBean newItem){
            return oldItem.getNom_produit() == newItem.getNom_produit();
        }
    }
}