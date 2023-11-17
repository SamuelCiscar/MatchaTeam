package com.example.matchateam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matchateam.Adapters.CartItemAdapter;
import com.example.matchateam.Beans.CommandeBean;
import com.example.matchateam.databinding.ActivityPanierBinding;
import com.google.gson.Gson;

import java.util.List;

public class PanierActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityPanierBinding binding;
    private EditText editTextPhone;
    private EditText etprenom;
    private EditText etName;

    private RecyclerView recyclerView;
    private CartItemAdapter cartItemAdapter;

    private TextView textViewPrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPanierBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtenez votre RecyclerView à partir de votre layout XML
        recyclerView = binding.rcViewPanier;

        // Configurez le LayoutManager pour le RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialisez l'adaptateur pour le RecyclerView
        cartItemAdapter = new CartItemAdapter(); // Vous devrez passer des données à l'adaptateur ici
        recyclerView.setAdapter(cartItemAdapter);

        // Autres initialisations
        textViewPrix = binding.prixUpdt;
        editTextPhone = binding.editTextPhone;
        etprenom = binding.etprenom;
        etName = binding.etName;

        binding.logohome.setOnClickListener(this);
        binding.btnValidate.setOnClickListener(this);

        // Obtenez les éléments du panier depuis CartManager (exemple)
        CartManager cartManager = CartManager.getInstance();
        List<ProductCartItem> cartItems = cartManager.getCartItems();

        // Passez les éléments du panier à l'adaptateur
        cartItemAdapter.setCartItems(cartItems);

        // Mettez à jour le prix total une fois que les éléments sont chargés
        updateTotalPrice();
    }

    // Méthode pour mettre à jour le prix total et le TextView
    public void updateTotalPrice() {
        double totalPrice = calculateTotalPrice(); // Méthode pour calculer le prix total
        String formattedPrice = String.format("%.2f", totalPrice); // Formater le prix

        // Mettre à jour le TextView avec le nouveau prix total
        textViewPrix.setText(formattedPrice + " €");
    }

    // Méthode pour calculer le prix total des produits dans le panier
    private double calculateTotalPrice() {
        double total = 0;

        // Traversez la liste des produits pour obtenir le prix total
        for (ProductCartItem item : cartItemAdapter.getCartItems()) {
            total += item.getTotalPrice();
        }

        return total;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.bt_delProd) {
            // Obtenez la position de l'élément à supprimer
            int position = recyclerView.getChildAdapterPosition((View) v.getParent());

            // Supprimez l'élément du panier à la position donnée
            cartItemAdapter.getCartItems().remove(position);
            cartItemAdapter.notifyItemRemoved(position);

            // Mettez à jour le prix total
            updateTotalPrice();
        }
        if (v == binding.logohome) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        if (v == binding.btnValidate) {
            String nom = etName.getText().toString().trim();
            String prenom = etprenom.getText().toString().trim();
            String telephone = editTextPhone.getText().toString().trim();

            if (!nom.isEmpty() && !prenom.isEmpty() && !telephone.isEmpty()) {
                // Si tous les champs sont remplis, créer une nouvelle commande
                CommandeBean commande = new CommandeBean();
                commande.setNom_commande(nom);
                commande.setPrenom_commande(prenom);
                commande.setTelephone_commande(telephone);
                commande.setPrix_total_commande(calculateTotalPrice());
                List<ProductCartItem> produits = cartItemAdapter.getCartItems();
                commande.setProduits(produits);
                // Convertir la commande en JSON
                String commandeJson = new Gson().toJson(commande);

                System.out.println(commandeJson);

                // Envoyer la commande au serveur
                new Thread(() -> {
                    try {
                        String response = RequestUtils.sendCommand(commandeJson);
                        runOnUiThread(() -> {
                            if (response != null) {
                                // Afficher un message de succès
                                Toast.makeText(this, "Votre commande a été envoyée", Toast.LENGTH_SHORT).show();

                                // Vider le contenu des EditText
                                etName.setText("");
                                etprenom.setText("");
                                editTextPhone.setText("");
                            } else {
                                // Afficher un message d'erreur
                                Toast.makeText(this, "Erreur lors de l'envoi de la commande", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        runOnUiThread(() -> {
                            // Afficher un message d'erreur en cas d'exception
                            Toast.makeText(this, "Erreur lors de l'envoi de la commande", Toast.LENGTH_SHORT).show();
                        });
                    }
                }).start();
            } else {
                // Si l'un des champs est vide, afficher un message demandant de remplir tous les champs
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            }
        }
    }
}