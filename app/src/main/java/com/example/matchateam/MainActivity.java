package com.example.matchateam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.matchateam.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btCart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == binding.btCart){
            Intent intent = new Intent(this, PanierActivity.class);
            startActivity(intent);
        }
    }
}