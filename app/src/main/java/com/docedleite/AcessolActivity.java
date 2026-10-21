package com.docedleite;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class AcessolActivity extends AppCompatActivity {
	
	private AcessolBinding binding;
	private String Email = "";
	private double Password = 0;
	private String Pass = "";
	private HashMap<String, Object> mapHeader = new HashMap<>();
	private HashMap<String, Object> mapBody = new HashMap<>();
	private String Senha = "";
	
	private RequestNetwork dlservers;
	private RequestNetwork.RequestListener _dlservers_request_listener;
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		binding = AcessolBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		setSupportActionBar(binding.Toolbar);
		getSupportActionBar().setHomeButtonEnabled(true);
		binding.Toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		dlservers = new RequestNetwork(this);
		
		binding.btnEntrar.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		binding.btnEntrar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Email = binding.edEmail.getText().toString().trim();
				Senha = binding.edSenha.getText().toString().trim();
				
				android.content.SharedPreferences sp = getSharedPreferences("SessaoDL", MODE_PRIVATE);
				android.content.SharedPreferences.Editor editor = sp.edit();
				editor.putString("email", Email);
				editor.putString("senha", Senha);
				editor.commit();
				
				mapHeader.clear();
				mapHeader.put("apikey", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFvZW54eHNjZ2htdHp6YmFybnl5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3ODgxOTMxNjksImV4cCI6MjEwMzc2OTE2OX0.xpDzrKo9N5y27GSTiBYs7VI6nl0UtFjI9TLPG7ZSmUY");
				mapHeader.put("Content-Type", "application/json");
				dlservers.setHeaders(mapHeader);
				mapBody.clear();
				mapBody.put("email", Email);
				mapBody.put("password", Senha);
				dlservers.startRequestNetwork(RequestNetworkController.POST, "https://aoenxxscghmtzzbarnyy.supabase.co/auth/v1/token?grant_type=password", "login", _dlservers_request_listener);
			}
		});
		
		binding.btnIrCadastro.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), AcessocActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		_dlservers_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (_tag.equals("login")) {
					Toast.makeText(getApplicationContext(), "Login efetuado com sucesso! 🍮", Toast.LENGTH_SHORT).show();
					
					intent.setClass(getApplicationContext(), FeedActivity.class);
					startActivity(intent);
					finish();
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				if (_tag.equals("login")) {
					Toast.makeText(getApplicationContext(), "Erro ao entrar! Verifica o teu email ou senha. 🛑", Toast.LENGTH_LONG).show();
				}
			}
		};
	}
	
	private void initializeLogic() {
		// Remove a seta de voltar da Toolbar padrão
		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(false);
			getSupportActionBar().setHomeButtonEnabled(false);
		}
		
	}
	
}
