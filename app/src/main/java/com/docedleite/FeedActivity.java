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
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.material.appbar.AppBarLayout;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class FeedActivity extends AppCompatActivity {
	
	private FeedBinding binding;
	private HashMap<String, Object> map = new HashMap<>();
	private double limit = 0;
	private String urlPosts = "";
	
	private ArrayList<HashMap<String, Object>> listPosts = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap_profiles = new ArrayList<>();
	
	private RequestNetwork dlservers;
	private RequestNetwork.RequestListener _dlservers_request_listener;
	private Intent i = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		binding = FeedBinding.inflate(getLayoutInflater());
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
		
		binding.navCriar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), CriarpostActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		binding.navPerfil.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), PerfilActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_dlservers_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				// Variável global na Activity para guardar os perfis
				// (Se preferires, podes criar uma ListMap chamada 'listmap_profiles' no Sketchware)
				
				if (_tag.equals("getProfilesMap")) {
					try {
						java.lang.reflect.Type typeProf = new com.google.gson.reflect.TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType();
						
						// Guarda os perfis recebidos numa variável acessível
						listmap_profiles = new com.google.gson.Gson().fromJson(_response, typeProf);
						
						// Agora que já temos os perfis carregados, busca os posts do feed
						HashMap<String, Object> mapHeader = new HashMap<>();
						mapHeader.put("via-proxy", "via-proxy");
						mapHeader.put("Content-Type", "application/json");
						dlservers.setHeaders(mapHeader);
						
						dlservers.startRequestNetwork(
						RequestNetworkController.GET, 
						"https://server.docedleite.com.br/rest/v1/posts?select=*&order=created_at.desc", 
						"getPostsFeed", 
						_dlservers_request_listener
						);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				if (_tag.equals("getPostsFeed")) {
					try {
						listmap.clear();
						
						java.lang.reflect.Type typePosts = new com.google.gson.reflect.TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType();
						ArrayList<HashMap<String, Object>> postsRecebidos = new com.google.gson.Gson().fromJson(_response, typePosts);
						
						if (postsRecebidos != null) {
							int contadorAnuncios = 0;
							
							for (int i = 0; i < postsRecebidos.size(); i++) {
								listmap.add(postsRecebidos.get(i));
								
								// Injeta 1 anúncio a cada 5 posts (máximo de 3 anúncios)
								if ((i + 1) % 5 == 0 && contadorAnuncios < 3) {
									contadorAnuncios++;
									
									HashMap<String, Object> anuncioItem = new HashMap<>();
									anuncioItem.put("isAnuncio", true);
									anuncioItem.put("title", "📢 Anúncio DL #" + contadorAnuncios + ": Apoie a nossa rede social e ganhe beneficios exclusivos! 🍮✨");
									anuncioItem.put("creator", "sistema_dl");
									anuncioItem.put("created_at", "Patrocinado");
									
									listmap.add(anuncioItem);
								}
							}
							
							androidx.recyclerview.widget.RecyclerView rvFeed = (androidx.recyclerview.widget.RecyclerView) findViewById(getResources().getIdentifier("recyclerview1", "id", getPackageName()));
							if (rvFeed != null && rvFeed.getAdapter() != null) {
								rvFeed.getAdapter().notifyDataSetChanged();
							} else if (rvFeed != null) {
								rvFeed.setAdapter(new Recyclerview1Adapter(listmap));
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "Erro de Acesso.");
			}
		};
	}
	
	private void initializeLogic() {
		setTitle("🍮 Doce de Leite");
		
		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(false);
			getSupportActionBar().setHomeButtonEnabled(false);
		}
		
		androidx.recyclerview.widget.RecyclerView rvFeed = (androidx.recyclerview.widget.RecyclerView) findViewById(getResources().getIdentifier("recyclerview1", "id", getPackageName()));
		if (rvFeed != null) {
			rvFeed.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
		}
		
		HashMap<String, Object> mapHeader = new HashMap<>();
		mapHeader.put("via-proxy", "via-proxy");
		mapHeader.put("Content-Type", "application/json");
		dlservers.setHeaders(mapHeader);
		
		// 1. Busca todos os perfis primeiro para mapear os @usernames corretos
		dlservers.startRequestNetwork(
		RequestNetworkController.GET, 
		"https://server.docedleite.com.br/rest/v1/profiles?select=id,username,is_verified,is_plus,isTeam", 
		"getProfilesMap", 
		_dlservers_request_listener
		);
		
		// Barra de Navegação Inferior
		final android.content.SharedPreferences sp = getSharedPreferences("SessaoDL", MODE_PRIVATE);
		final String emailSessao = sp.getString("email", "");
		
		android.view.View btnNavCriar = findViewById(getResources().getIdentifier("nav_criar", "id", getPackageName()));
		android.view.View btnNavPerfil = findViewById(getResources().getIdentifier("nav_perfil", "id", getPackageName()));
		
		if (btnNavCriar != null) {
			btnNavCriar.setOnClickListener(new android.view.View.OnClickListener() {
				@Override
				public void onClick(android.view.View v) {
					if (emailSessao.isEmpty()) {
						Toast.makeText(getApplicationContext(), "Faz login para publicar no DL! 🍮", Toast.LENGTH_SHORT).show();
						Intent intent = new Intent();
						intent.setClassName(getPackageName(), getPackageName() + ".AcessolActivity");
						startActivity(intent);
					} else {
						Intent intent = new Intent();
						intent.setClassName(getPackageName(), getPackageName() + ".CriarpostActivity");
						startActivity(intent);
						finish();
					}
				}
			});
		}
		
		if (btnNavPerfil != null) {
			btnNavPerfil.setOnClickListener(new android.view.View.OnClickListener() {
				@Override
				public void onClick(android.view.View v) {
					if (emailSessao.isEmpty()) {
						Toast.makeText(getApplicationContext(), "Faz login para ver o teu perfil! 🍮", Toast.LENGTH_SHORT).show();
						Intent intent = new Intent();
						intent.setClassName(getPackageName(), getPackageName() + ".AcessolActivity");
						startActivity(intent);
					} else {
						Intent intent = new Intent();
						intent.setClassName(getPackageName(), getPackageName() + ".PerfilActivity");
						startActivity(intent);
						finish();
					}
				}
			});
		}
		
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.postitem, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			PostitemBinding binding = PostitemBinding.bind(_view);
			
			try {
				if (_position < listmap.size()) {
					final java.util.HashMap<String, Object> _item = listmap.get(_position);
					
					android.widget.TextView txtTitle = (android.widget.TextView) _view.findViewById(getResources().getIdentifier("txt_title", "id", getPackageName()));
					android.widget.TextView txtCreator = (android.widget.TextView) _view.findViewById(getResources().getIdentifier("txt_creator", "id", getPackageName()));
					android.widget.TextView txtDate = (android.widget.TextView) _view.findViewById(getResources().getIdentifier("txt_date", "id", getPackageName()));
					android.widget.TextView txtLikes = (android.widget.TextView) _view.findViewById(getResources().getIdentifier("txt_likes", "id", getPackageName()));
					android.widget.TextView txtComments = (android.widget.TextView) _view.findViewById(getResources().getIdentifier("txt_comments", "id", getPackageName()));
					android.widget.LinearLayout linearCard = (android.widget.LinearLayout) _view.findViewById(getResources().getIdentifier("linear_card", "id", getPackageName()));
					
					boolean isAnuncio = _item.containsKey("isAnuncio") && Boolean.parseBoolean(_item.get("isAnuncio").toString());
					boolean isAnon = _item.containsKey("isAnon") && Boolean.parseBoolean(_item.get("isAnon").toString());
					
					if (isAnuncio) {
						// Estilo do Anúncio
						if (linearCard != null) linearCard.setBackgroundColor(android.graphics.Color.parseColor("#FFFDE7"));
						if (txtCreator != null) txtCreator.setText("📢 Anúncio Oficial DL");
						if (txtTitle != null) txtTitle.setText(_item.get("title").toString());
						if (txtDate != null) txtDate.setText("Patrocinado ⭐");
						if (txtLikes != null) txtLikes.setText("👍 Patrocínio");
						if (txtComments != null) txtComments.setText("🚀 Saiba mais");
					} else {
						// Post Normal
						if (linearCard != null) linearCard.setBackgroundColor(android.graphics.Color.parseColor("#FFFFFF"));
						
						if (_item.containsKey("title") && _item.get("title") != null) {
							if (txtTitle != null) txtTitle.setText(_item.get("title").toString());
						}
						
						if (isAnon) {
							if (txtCreator != null) txtCreator.setText("@anonimo 🕵️‍♂️");
						} else {
							String creatorId = _item.containsKey("creator") && _item.get("creator") != null ? _item.get("creator").toString() : "";
							String usernameEncontrado = "utilizador";
							String selos = "";
							
							// Procura o @username real do usuário na tabela profiles baixada
							if (listmap_profiles != null) {
								for (int j = 0; j < listmap_profiles.size(); j++) {
									java.util.HashMap<String, Object> prof = listmap_profiles.get(j);
									if (prof.containsKey("id") && prof.get("id") != null && prof.get("id").toString().equals(creatorId)) {
										if (prof.containsKey("username") && prof.get("username") != null) {
											usernameEncontrado = prof.get("username").toString();
										}
										boolean isVerif = prof.containsKey("is_verified") && Boolean.parseBoolean(prof.get("is_verified").toString());
										boolean isPlu = prof.containsKey("is_plus") && Boolean.parseBoolean(prof.get("is_plus").toString());
										boolean isT = prof.containsKey("isTeam") && Boolean.parseBoolean(prof.get("isTeam").toString());
										
										if (isVerif) selos += " ✔️";
										if (isPlu) selos += " 🍮👑";
										if (isT) selos += " 🛠️";
										break;
									}
								}
							}
							
							if (txtCreator != null) txtCreator.setText("@" + usernameEncontrado + selos);
						}
						
						if (_item.containsKey("created_at") && _item.get("created_at") != null) {
							String data = _item.get("created_at").toString();
							if (txtDate != null) txtDate.setText(data.length() >= 10 ? data.substring(0, 10) : data);
						}
						
						int likesCount = 0;
						if (_item.containsKey("like") && _item.get("like") instanceof java.util.ArrayList) {
							likesCount = ((java.util.ArrayList<?>) _item.get("like")).size();
						}
						if (txtLikes != null) txtLikes.setText("❤️ " + likesCount);
						
						int commentsCount = 0;
						if (_item.containsKey("comments") && _item.get("comments") instanceof java.util.ArrayList) {
							commentsCount = ((java.util.ArrayList<?>) _item.get("comments")).size();
						}
						if (txtComments != null) txtComments.setText("💬 " + commentsCount);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
}
