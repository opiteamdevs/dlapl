// Generated file. Do not modify.
package com.docedleite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;

public final class PerfilBinding {
    public final CoordinatorLayout Coordinator;
    public final AppBarLayout AppBar;
    public final Toolbar Toolbar;
    public final ScrollView vscroll2;
    public final LinearLayout linear20;
    public final LinearLayout linear21;
    public final ImageView imgAvatar;
    public final TextView txtDisplayName;
    public final TextView txtUsername;
    public final LinearLayout linear22;
    public final TextView txtFollowers;
    public final TextView txtCandys;
    public final Button btnSeguir;
    public final TextView txtStatusBadge;
    public final TextView txtBio;
    public final LinearLayout cardEdicao;
    public final TextView textview25;
    public final TextView textview26;
    public final EditText edEditDisplayName;
    public final TextView textview27;
    public final EditText edEditUsername;
    public final TextView textview28;
    public final EditText edEditAvatar;
    public final TextView textview29;
    public final EditText edEditBio;
    public final Button btnSalvarPerfil;
    public final TextView textview30;
    public final RecyclerView rvUserPosts;
    public final LinearLayout bottomNav;
    public final LinearLayout navFeed;
    public final TextView textview61;
    public final TextView textview62;
    public final LinearLayout navCriar;
    public final TextView textview63;
    public final TextView textview64;
    public final LinearLayout navPerfil;
    public final TextView textview65;
    public final TextView textview66;

    private PerfilBinding(CoordinatorLayout Coordinator, AppBarLayout AppBar, Toolbar Toolbar, ScrollView vscroll2, LinearLayout linear20, LinearLayout linear21, ImageView imgAvatar, TextView txtDisplayName, TextView txtUsername, LinearLayout linear22, TextView txtFollowers, TextView txtCandys, Button btnSeguir, TextView txtStatusBadge, TextView txtBio, LinearLayout cardEdicao, TextView textview25, TextView textview26, EditText edEditDisplayName, TextView textview27, EditText edEditUsername, TextView textview28, EditText edEditAvatar, TextView textview29, EditText edEditBio, Button btnSalvarPerfil, TextView textview30, RecyclerView rvUserPosts, LinearLayout bottomNav, LinearLayout navFeed, TextView textview61, TextView textview62, LinearLayout navCriar, TextView textview63, TextView textview64, LinearLayout navPerfil, TextView textview65, TextView textview66) {
        this.Coordinator = Coordinator;
        this.AppBar = AppBar;
        this.Toolbar = Toolbar;
        this.vscroll2 = vscroll2;
        this.linear20 = linear20;
        this.linear21 = linear21;
        this.imgAvatar = imgAvatar;
        this.txtDisplayName = txtDisplayName;
        this.txtUsername = txtUsername;
        this.linear22 = linear22;
        this.txtFollowers = txtFollowers;
        this.txtCandys = txtCandys;
        this.btnSeguir = btnSeguir;
        this.txtStatusBadge = txtStatusBadge;
        this.txtBio = txtBio;
        this.cardEdicao = cardEdicao;
        this.textview25 = textview25;
        this.textview26 = textview26;
        this.edEditDisplayName = edEditDisplayName;
        this.textview27 = textview27;
        this.edEditUsername = edEditUsername;
        this.textview28 = textview28;
        this.edEditAvatar = edEditAvatar;
        this.textview29 = textview29;
        this.edEditBio = edEditBio;
        this.btnSalvarPerfil = btnSalvarPerfil;
        this.textview30 = textview30;
        this.rvUserPosts = rvUserPosts;
        this.bottomNav = bottomNav;
        this.navFeed = navFeed;
        this.textview61 = textview61;
        this.textview62 = textview62;
        this.navCriar = navCriar;
        this.textview63 = textview63;
        this.textview64 = textview64;
        this.navPerfil = navPerfil;
        this.textview65 = textview65;
        this.textview66 = textview66;
    }

    public CoordinatorLayout getRoot() {
        return Coordinator;
    }

    public static PerfilBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PerfilBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.perfil, parent, false);
        if (attachToParent) parent.addView(root);
        return bind(root);
    }

    public static PerfilBinding bind(View view) {
        CoordinatorLayout Coordinator = (CoordinatorLayout) view;
        AppBarLayout AppBar = findChildViewById(view, R.id._app_bar);
        Toolbar Toolbar = findChildViewById(view, R.id._toolbar);
        ScrollView vscroll2 = findChildViewById(view, R.id.vscroll2);
        LinearLayout linear20 = findChildViewById(view, R.id.linear20);
        LinearLayout linear21 = findChildViewById(view, R.id.linear21);
        ImageView imgAvatar = findChildViewById(view, R.id.imgAvatar);
        TextView txtDisplayName = findChildViewById(view, R.id.txtDisplayName);
        TextView txtUsername = findChildViewById(view, R.id.txtUsername);
        LinearLayout linear22 = findChildViewById(view, R.id.linear22);
        TextView txtFollowers = findChildViewById(view, R.id.txtFollowers);
        TextView txtCandys = findChildViewById(view, R.id.txtCandys);
        Button btnSeguir = findChildViewById(view, R.id.btnSeguir);
        TextView txtStatusBadge = findChildViewById(view, R.id.txtStatusBadge);
        TextView txtBio = findChildViewById(view, R.id.txtBio);
        LinearLayout cardEdicao = findChildViewById(view, R.id.cardEdicao);
        TextView textview25 = findChildViewById(view, R.id.textview25);
        TextView textview26 = findChildViewById(view, R.id.textview26);
        EditText edEditDisplayName = findChildViewById(view, R.id.edEditDisplayName);
        TextView textview27 = findChildViewById(view, R.id.textview27);
        EditText edEditUsername = findChildViewById(view, R.id.edEditUsername);
        TextView textview28 = findChildViewById(view, R.id.textview28);
        EditText edEditAvatar = findChildViewById(view, R.id.edEditAvatar);
        TextView textview29 = findChildViewById(view, R.id.textview29);
        EditText edEditBio = findChildViewById(view, R.id.edEditBio);
        Button btnSalvarPerfil = findChildViewById(view, R.id.btnSalvarPerfil);
        TextView textview30 = findChildViewById(view, R.id.textview30);
        RecyclerView rvUserPosts = findChildViewById(view, R.id.rvUserPosts);
        LinearLayout bottomNav = findChildViewById(view, R.id.bottom_nav);
        LinearLayout navFeed = findChildViewById(view, R.id.nav_feed);
        TextView textview61 = findChildViewById(view, R.id.textview61);
        TextView textview62 = findChildViewById(view, R.id.textview62);
        LinearLayout navCriar = findChildViewById(view, R.id.nav_criar);
        TextView textview63 = findChildViewById(view, R.id.textview63);
        TextView textview64 = findChildViewById(view, R.id.textview64);
        LinearLayout navPerfil = findChildViewById(view, R.id.nav_perfil);
        TextView textview65 = findChildViewById(view, R.id.textview65);
        TextView textview66 = findChildViewById(view, R.id.textview66);

        if (AppBar == null || Toolbar == null || vscroll2 == null || linear20 == null || linear21 == null || imgAvatar == null || txtDisplayName == null || txtUsername == null || linear22 == null || txtFollowers == null || txtCandys == null || btnSeguir == null || txtStatusBadge == null || txtBio == null || cardEdicao == null || textview25 == null || textview26 == null || edEditDisplayName == null || textview27 == null || edEditUsername == null || textview28 == null || edEditAvatar == null || textview29 == null || edEditBio == null || btnSalvarPerfil == null || textview30 == null || rvUserPosts == null || bottomNav == null || navFeed == null || textview61 == null || textview62 == null || navCriar == null || textview63 == null || textview64 == null || navPerfil == null || textview65 == null || textview66 == null) {
             throw new IllegalStateException("Required views are missing");
        }

        return new PerfilBinding(Coordinator, AppBar, Toolbar, vscroll2, linear20, linear21, imgAvatar, txtDisplayName, txtUsername, linear22, txtFollowers, txtCandys, btnSeguir, txtStatusBadge, txtBio, cardEdicao, textview25, textview26, edEditDisplayName, textview27, edEditUsername, textview28, edEditAvatar, textview29, edEditBio, btnSalvarPerfil, textview30, rvUserPosts, bottomNav, navFeed, textview61, textview62, navCriar, textview63, textview64, navPerfil, textview65, textview66);
    }

    private static <T extends View> T findChildViewById(View rootView, int id) {
         if (rootView instanceof ViewGroup) {
              ViewGroup rootViewGroup = (ViewGroup) rootView;
              for (int i = 0; i < rootViewGroup.getChildCount(); i++) {
                   T view = rootViewGroup.getChildAt(i).findViewById(id);
                   if (view != null) return view;
              }
         }
         return null;
    }
}