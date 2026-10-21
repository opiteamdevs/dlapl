
package com.docedleite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CriarpostActivity extends AppCompatActivity {

    private CriarpostBinding binding;

    private static final String SUPABASE_URL =
            "https://aoenxxscghmtzzbarnyy.supabase.co";

    private static final String SUPABASE_KEY =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFvZW54eHNjZ2htdHp6YmFybnl5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3ODgxOTMxNjksImV4cCI6MjEwMzc2OTE2OX0.xpDzrKo9N5y27GSTiBYs7VI6nl0UtFjI9TLPG7ZSmUY";

    private final ExecutorService executor =
            Executors.newSingleThreadExecutor();

    private boolean publishing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = CriarpostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.Toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        binding.navFeed.setOnClickListener(v ->
                open(FeedActivity.class));

        binding.navPerfil.setOnClickListener(v ->
                open(PerfilActivity.class));

        binding.navCriar.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "Você já está na criação de posts.",
                        Toast.LENGTH_SHORT
                ).show()
        );

        binding.btnPublicar.setOnClickListener(v -> publicar());
    }

    private void publicar() {
        if (publishing) return;

        String content = binding.edTitulo.getText() == null
                ? ""
                : binding.edTitulo.getText().toString().trim();

        if (content.isEmpty()) {
            binding.edTitulo.setError(
                    "Escreva algo antes de publicar."
            );
            return;
        }

        publishing = true;
        binding.btnPublicar.setEnabled(false);

        executor.execute(() -> {
            HttpURLConnection connection = null;

            try {
                URL url = new URL(
                        SUPABASE_URL + "/rest/v1/posts"
                );

                connection = (HttpURLConnection)
                        url.openConnection();

                connection.setRequestMethod("POST");
                connection.setConnectTimeout(15000);
                connection.setReadTimeout(15000);
                connection.setDoOutput(true);

                connection.setRequestProperty(
                        "apikey", SUPABASE_KEY
                );

                connection.setRequestProperty(
                        "Authorization", "Bearer " + SUPABASE_KEY
                );

                connection.setRequestProperty(
                        "Content-Type", "application/json"
                );

                connection.setRequestProperty(
                        "Prefer", "return=minimal"
                );

                JSONObject body = new JSONObject();
                body.put("content", content);

                byte[] data = body.toString()
                        .getBytes(StandardCharsets.UTF_8);

                try (OutputStream output =
                             connection.getOutputStream()) {
                    output.write(data);
                }

                int status = connection.getResponseCode();

                runOnUiThread(() -> {
                    publishing = false;
                    binding.btnPublicar.setEnabled(true);

                    if (status >= 200 && status < 300) {
                        binding.edTitulo.setText("");

                        Toast.makeText(
                                this,
                                "Post publicado!",
                                Toast.LENGTH_LONG
                        ).show();
                    } else {
                        Toast.makeText(
                                this,
                                "Falha ao publicar (HTTP "
                                        + status
                                        + "). Verifique a tabela, as colunas e as políticas RLS.",
                                Toast.LENGTH_LONG
                        ).show();
                    }
                });

            } catch (Exception e) {
                runOnUiThread(() -> {
                    publishing = false;
                    binding.btnPublicar.setEnabled(true);

                    Toast.makeText(
                            this,
                            "Erro de conexão com o Supabase.",
                            Toast.LENGTH_LONG
                    ).show();
                });

            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        });
    }

    private void open(Class<?> activity) {
        startActivity(new Intent(this, activity));
        finish();
    }

    @Override
    protected void onDestroy() {
        executor.shutdownNow();
        super.onDestroy();
    }
                            }
