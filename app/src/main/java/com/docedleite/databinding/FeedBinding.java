// Generated file. Do not modify.
package com.docedleite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;

public final class FeedBinding {
    public final CoordinatorLayout Coordinator;
    public final AppBarLayout AppBar;
    public final Toolbar Toolbar;
    public final LinearLayout linear24;
    public final RecyclerView recyclerview1;
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

    private FeedBinding(CoordinatorLayout Coordinator, AppBarLayout AppBar, Toolbar Toolbar, LinearLayout linear24, RecyclerView recyclerview1, LinearLayout bottomNav, LinearLayout navFeed, TextView textview37, TextView textview38, LinearLayout navCriar, TextView textview39, TextView textview40, LinearLayout navPerfil, TextView textview41, TextView textview42) {
        this.Coordinator = Coordinator;
        this.AppBar = AppBar;
        this.Toolbar = Toolbar;
        this.linear24 = linear24;
        this.recyclerview1 = recyclerview1;
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

    public static FeedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FeedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.feed, parent, false);
        if (attachToParent) parent.addView(root);
        return bind(root);
    }

    public static FeedBinding bind(View view) {
        CoordinatorLayout Coordinator = (CoordinatorLayout) view;
        AppBarLayout AppBar = findChildViewById(view, R.id._app_bar);
        Toolbar Toolbar = findChildViewById(view, R.id._toolbar);
        LinearLayout linear24 = findChildViewById(view, R.id.linear24);
        RecyclerView recyclerview1 = findChildViewById(view, R.id.recyclerview1);
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

        if (AppBar == null || Toolbar == null || linear24 == null || recyclerview1 == null || bottomNav == null || navFeed == null || textview37 == null || textview38 == null || navCriar == null || textview39 == null || textview40 == null || navPerfil == null || textview41 == null || textview42 == null) {
             throw new IllegalStateException("Required views are missing");
        }

        return new FeedBinding(Coordinator, AppBar, Toolbar, linear24, recyclerview1, bottomNav, navFeed, textview37, textview38, navCriar, textview39, textview40, navPerfil, textview41, textview42);
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