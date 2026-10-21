package com.docedleite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/** Basic screen entry point; connect publishing to the API before production release. */
public class CriarpostActivity extends AppCompatActivity {
    private CriarpostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CriarpostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.Toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        binding.navFeed.setOnClickListener(v -> open(FeedActivity.class));
        binding.navPerfil.setOnClickListener(v -> open(PerfilActivity.class));
        binding.navCriar.setOnClickListener(v -> Toast.makeText(this, "Você já está na criação de posts.", Toast.LENGTH_SHORT).show());
        binding.btnPublicar.setOnClickListener(v -> {
            String content = binding.edTitulo.getText() == null ? "" : binding.edTitulo.getText().toString().trim();
            if (content.isEmpty()) {
                binding.edTitulo.setError("Escreva algo antes de publicar.");
                return;
            }
            Toast.makeText(this, "A publicação ainda precisa ser conectada à API.", Toast.LENGTH_LONG).show();
        });
    }

    private void open(Class<?> activity) {
        startActivity(new Intent(this, activity));
        finish();
    }
}
