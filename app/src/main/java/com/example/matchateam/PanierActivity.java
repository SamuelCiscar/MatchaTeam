package com.example.matchateam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matchateam.Adapters.CartItemAdapter;
import com.example.matchateam.databinding.ActivityPanierBinding;

import java.util.List;

public class PanierActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityPanierBinding binding;
    private EditText editTextPhone;
    private EditText etprenom;
    private EditText etName;

    private RecyclerView recyclerView;
    private CartItemAdapter cartItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
        binding = ActivityPanierBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        editTextPhone = binding.editTextPhone;
        etprenom = binding.etprenom;
        etName = binding.etName;

        binding.logohome.setOnClickListener(this);
        binding.btnValidate.setOnClickListener(this);

        // Récupérez votre RecyclerView à partir de votre layout XML
        recyclerView = binding.rcViewPanier;

        // Configurez le LayoutManager pour le RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialisez l'adaptateur pour le RecyclerView
        cartItemAdapter = new CartItemAdapter(); // Vous devrez passer des données à l'adaptateur ici
        recyclerView.setAdapter(cartItemAdapter);


        // Obtenez les éléments du panier depuis CartManager (exemple)
        CartManager cartManager = CartManager.getInstance();
        List<ProductCartItem> cartItems = cartManager.getCartItems();

        // Passez les éléments du panier à l'adaptateur
        cartItemAdapter.setCartItems(cartItems);

        recyclerView.setAdapter(cartItemAdapter);
    }


    @Override
    public void onClick(View v) {
        if (v == binding.logohome) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        if (v == binding.btnValidate) {
            String nom = etName.getText().toString().trim();
            String prenom = etprenom.getText().toString().trim();
            String telephone = editTextPhone.getText().toString().trim();

            if (!nom.isEmpty() && !prenom.isEmpty() && !telephone.isEmpty()) {
                // Si tous les champs sont remplis, afficher le toast de validation
                Toast.makeText(this, "Votre commande est validée", Toast.LENGTH_SHORT).show();
                // Vider le contenu des EditText
                etName.setText("");
                etprenom.setText("");
                editTextPhone.setText("");
            } else {
                // Si l'un des champs est vide, afficher un message demandant de remplir tous les champs
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();

            }
        }
    }
}