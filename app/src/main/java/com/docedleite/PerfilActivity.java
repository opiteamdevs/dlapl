package com.docedleite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/** Basic profile screen entry point; profile persistence requires a backend integration. */
public class PerfilActivity extends AppCompatActivity {
    private PerfilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = PerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.Toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        binding.navFeed.setOnClickListener(v -> open(FeedActivity.class));
        binding.navCriar.setOnClickListener(v -> open(CriarpostActivity.class));
        binding.navPerfil.setOnClickListener(v -> Toast.makeText(this, "Você já está no perfil.", Toast.LENGTH_SHORT).show());
        binding.btnSalvarPerfil.setOnClickListener(v -> Toast.makeText(this, "Salvar perfil ainda precisa ser conectado à API.", Toast.LENGTH_LONG).show());
    }

    private void open(Class<?> activity) {
        startActivity(new Intent(this, activity));
        finish();
    }
}
