package com.example.matchateam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.matchateam.databinding.ActivityPanierBinding;

public class PanierActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityPanierBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
        binding = ActivityPanierBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.logohome.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v == binding.logohome){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }
}
}
