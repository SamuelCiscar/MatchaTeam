package com.example.matchateam.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matchateam.PanierActivity;
import com.example.matchateam.ProductCartItem;
import com.example.matchateam.R;

import java.util.ArrayList;
import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {
    private List<ProductCartItem> cartItems = new ArrayList<>();
    private OnDeleteItemClickListener onDeleteItemClickListener;

    public CartItemAdapter() {
    }

    public interface OnDeleteItemClickListener {
        void onDeleteItemClicked(int position);
    }

    public void setOnDeleteItemClickListener(OnDeleteItemClickListener listener) {
        this.onDeleteItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product_cmd, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductCartItem cartItem = cartItems.get(position);

        holder.tvProduct.setText(cartItem.getProduct().getNom_produit());
        holder.etQty.setText(String.valueOf(cartItem.getQuantity()));
        holder.txtPrix.setText(String.valueOf(cartItem.getTotalPrice()));

        holder.btDelProd.setOnClickListener(v -> {
            cartItems.remove(position);
            notifyDataSetChanged();



            if (onDeleteItemClickListener != null) {
                onDeleteItemClickListener.onDeleteItemClicked(position);
            }

            // Mettez à jour le prix total après la suppression de l'élément
            ((PanierActivity) holder.itemView.getContext()).updateTotalPrice();
        });
    }

    // Ajouter une méthode pour supprimer un élément du panier
    public void deleteItem(int position) {
        cartItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public void setCartItems(List<ProductCartItem> items) {
        this.cartItems = items;
        notifyDataSetChanged();
    }

    public List<ProductCartItem> getCartItems() {
        return cartItems;
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
