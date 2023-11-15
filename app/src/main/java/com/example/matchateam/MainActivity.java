package com.example.matchateam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.matchateam.Adapters.ProductListAdapter;
import com.example.matchateam.Beans.ProductBean;
import com.example.matchateam.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btCart.setOnClickListener(this);

        new Thread(() -> {
            try {
                // Méthode de test
                testGetAllProducts();
                // Appel de la méthode getAllProducts depuis la classe RequestUtils
                List<ProductBean> productBeans = RequestUtils.getAllProducts();

                if (productBeans != null) {
                    runOnUiThread(() -> {
                        ProductListAdapter adapter = new ProductListAdapter();
                        binding.rvProducts.setAdapter(adapter);
                    });
                } else {
                    System.out.println("Erreur lors de la récupération des produits");
                }
            } catch (final Exception e) {
                e.printStackTrace();
                System.err.println("Erreur: " + e.getMessage());
            }
        }).start();
    }

    @Override
    public void onClick(View v){
        if(v == binding.btCart){
            Intent intent = new Intent(this, PanierActivity.class);
            startActivity(intent);
        }
    }


    // Méthode de test pour simuler l'appel à getAllProducts
    private void testGetAllProducts() {
        try {
            List<ProductBean> productList = RequestUtils.getAllProducts();
            // Traiter les données reçues ici:
            for (ProductBean product : productList) {
                // Afficher chaque produit:
                System.out.println("MainActivity - Product: " + product.getNom_produit());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("MainActivity - Error fetching products from server" + e.getMessage());
        }
    }
}