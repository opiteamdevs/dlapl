// Generated file. Do not modify.
package com.docedleite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public final class CriarpostBinding {
    public final CoordinatorLayout Coordinator;
    public final AppBarLayout AppBar;
    public final Toolbar Toolbar;
    public final ScrollView vscrollCriar;
    public final LinearLayout linear23;
    public final LinearLayout linear24;
    public final TextView textview35;
    public final TextView textview36;
    public final EditText edTitulo;
    public final CheckBox checkDdlAd;
    public final CheckBox checkAnon;
    public final Button btnPublicar;
    public final LinearLayout bottomNav;
    public final LinearLayout navFeed;
    public final TextView textview37;
    public final TextView textview38;
    public final LinearLayout navCriar;
    public final TextView textview39;
    public final TextView textview40;
    public final LinearLayout navPerfil;
    public final TextView textview41;
    public final TextView textview42;

    private CriarpostBinding(CoordinatorLayout Coordinator, AppBarLayout AppBar, Toolbar Toolbar, ScrollView vscrollCriar, LinearLayout linear23, LinearLayout linear24, TextView textview35, TextView textview36, EditText edTitulo, CheckBox checkDdlAd, CheckBox checkAnon, Button btnPublicar, LinearLayout bottomNav, LinearLayout navFeed, TextView textview37, TextView textview38, LinearLayout navCriar, TextView textview39, TextView textview40, LinearLayout navPerfil, TextView textview41, TextView textview42) {
        this.Coordinator = Coordinator;
        this.AppBar = AppBar;
        this.Toolbar = Toolbar;
        this.vscrollCriar = vscrollCriar;
        this.linear23 = linear23;
        this.linear24 = linear24;
        this.textview35 = textview35;
        this.textview36 = textview36;
        this.edTitulo = edTitulo;
        this.checkDdlAd = checkDdlAd;
        this.checkAnon = checkAnon;
        this.btnPublicar = btnPublicar;
        this.bottomNav = bottomNav;
        this.navFeed = navFeed;
        this.textview37 = textview37;
        this.textview38 = textview38;
        this.navCriar = navCriar;
        this.textview39 = textview39;
        this.textview40 = textview40;
        this.navPerfil = navPerfil;
        this.textview41 = textview41;
        this.textview42 = textview42;
    }

    public CoordinatorLayout getRoot() {
        return Coordinator;
    }

    public static CriarpostBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CriarpostBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.criarpost, parent, false);
        if (attachToParent) parent.addView(root);
        return bind(root);
    }

    public static CriarpostBinding bind(View view) {
        CoordinatorLayout Coordinator = (CoordinatorLayout) view;
        AppBarLayout AppBar = findChildViewById(view, R.id._app_bar);
        Toolbar Toolbar = findChildViewById(view, R.id._toolbar);
        ScrollView vscrollCriar = findChildViewById(view, R.id.vscrollCriar);
        LinearLayout linear23 = findChildViewById(view, R.id.linear23);
        LinearLayout linear24 = findChildViewById(view, R.id.linear24);
        TextView textview35 = findChildViewById(view, R.id.textview35);
        TextView textview36 = findChildViewById(view, R.id.textview36);
        EditText edTitulo = findChildViewById(view, R.id.edTitulo);
        CheckBox checkDdlAd = findChildViewById(view, R.id.checkDdlAd);
        CheckBox checkAnon = findChildViewById(view, R.id.checkAnon);
        Button btnPublicar = findChildViewById(view, R.id.btnPublicar);
        LinearLayout bottomNav = findChildViewById(view, R.id.bottom_nav);
        LinearLayout navFeed = findChildViewById(view, R.id.nav_feed);
        TextView textview37 = findChildViewById(view, R.id.textview37);
        TextView textview38 = findChildViewById(view, R.id.textview38);
        LinearLayout navCriar = findChildViewById(view, R.id.nav_criar);
        TextView textview39 = findChildViewById(view, R.id.textview39);
        TextView textview40 = findChildViewById(view, R.id.textview40);
        LinearLayout navPerfil = findChildViewById(view, R.id.nav_perfil);
        TextView textview41 = findChildViewById(view, R.id.textview41);
        TextView textview42 = findChildViewById(view, R.id.textview42);

        if (AppBar == null || Toolbar == null || vscrollCriar == null || linear23 == null || linear24 == null || textview35 == null || textview36 == null || edTitulo == null || checkDdlAd == null || checkAnon == null || btnPublicar == null || bottomNav == null || navFeed == null || textview37 == null || textview38 == null || navCriar == null || textview39 == null || textview40 == null || navPerfil == null || textview41 == null || textview42 == null) {
             throw new IllegalStateException("Required views are missing");
        }

        return new CriarpostBinding(Coordinator, AppBar, Toolbar, vscrollCriar, linear23, linear24, textview35, textview36, edTitulo, checkDdlAd, checkAnon, btnPublicar, bottomNav, navFeed, textview37, textview38, navCriar, textview39, textview40, navPerfil, textview41, textview42);
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