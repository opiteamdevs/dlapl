// Generated file. Do not modify.
package com.docedleite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public final class ComentariosBinding {
    public final CoordinatorLayout Coordinator;
    public final AppBarLayout AppBar;
    public final Toolbar Toolbar;

    private ComentariosBinding(CoordinatorLayout Coordinator, AppBarLayout AppBar, Toolbar Toolbar) {
        this.Coordinator = Coordinator;
        this.AppBar = AppBar;
        this.Toolbar = Toolbar;
    }

    public CoordinatorLayout getRoot() {
        return Coordinator;
    }

    public static ComentariosBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ComentariosBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.comentarios, parent, false);
        if (attachToParent) parent.addView(root);
        return bind(root);
    }

    public static ComentariosBinding bind(View view) {
        CoordinatorLayout Coordinator = (CoordinatorLayout) view;
        AppBarLayout AppBar = findChildViewById(view, R.id._app_bar);
        Toolbar Toolbar = findChildViewById(view, R.id._toolbar);

        if (AppBar == null || Toolbar == null) {
             throw new IllegalStateException("Required views are missing");
        }

        return new ComentariosBinding(Coordinator, AppBar, Toolbar);
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