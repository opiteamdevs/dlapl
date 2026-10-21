package com.docedleite;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
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
import java.util.regex.*;
import org.json.*;

public class ComentariosActivity extends AppCompatActivity {
	
	private ComentariosBinding binding;
	
	private RequestNetwork dlservers;
	private RequestNetwork.RequestListener _dlservers_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		binding = ComentariosBinding.inflate(getLayoutInflater());
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
		
		_dlservers_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		final String postId = getIntent().getStringExtra("post_id");
		
		androidx.recyclerview.widget.RecyclerView rvComments = (androidx.recyclerview.widget.RecyclerView) findViewById(getResources().getIdentifier("recyclerview_comments", "id", getPackageName()));
		if (rvComments != null) {
			rvComments.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
		}
		// Remove a seta de voltar da Toolbar padrão
		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(false);
			getSupportActionBar().setHomeButtonEnabled(false);
		}
		
		
		android.widget.EditText edComentarioTemp = (android.widget.EditText) findViewById(getResources().getIdentifier("edComentario", "id", getPackageName()));
		if (edComentarioTemp == null) {
			edComentarioTemp = (android.widget.EditText) findViewById(getResources().getIdentifier("edittext1", "id", getPackageName()));
		}
		final android.widget.EditText edComentario = edComentarioTemp;
		
		android.view.View btnEnviar = findViewById(getResources().getIdentifier("btnEnviar", "id", getPackageName()));
		if (btnEnviar == null) {
			btnEnviar = findViewById(getResources().getIdentifier("btn_enviar", "id", getPackageName()));
		}
		
		if (btnEnviar != null) {
			btnEnviar.setOnClickListener(new android.view.View.OnClickListener() {
				@Override
				public void onClick(android.view.View v) {
					if (edComentario != null) {
						String texto = edComentario.getText().toString().trim();
						if (!texto.isEmpty()) {
							android.content.SharedPreferences sp = getSharedPreferences("SessaoDL", MODE_PRIVATE);
							String usernameSalvo = sp.getString("username", sp.getString("email", "arthurcaofc"));
							
							HashMap<String, Object> mapHeader = new HashMap<>();
							mapHeader.put("via-proxy", "via-proxy");
							mapHeader.put("Content-Type", "application/json");
							dlservers.setHeaders(mapHeader);
							
							HashMap<String, Object> mapBody = new HashMap<>();
							mapBody.put("post_id", postId);
							mapBody.put("username", usernameSalvo);
							mapBody.put("content", texto);
							
							dlservers.startRequestNetwork(
							RequestNetworkController.POST, 
							"https://server.docedleite.com.br/rest/v1/comments", 
							"enviarComentario", 
							_dlservers_request_listener
							);
							
							edComentario.setText("");
							Toast.makeText(getApplicationContext(), "Enviando comentário... 🍮", Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(getApplicationContext(), "Escreve algo antes de enviar! 🍮", Toast.LENGTH_SHORT).show();
						}
					} else {
						Toast.makeText(getApplicationContext(), "Erro: Campo de texto não encontrado!", Toast.LENGTH_LONG).show();
					}
				}
			});
		}
		
	}
	
}
