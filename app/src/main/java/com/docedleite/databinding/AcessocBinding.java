// Generated file. Do not modify.
package com.docedleite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public final class AcessocBinding {
    public final CoordinatorLayout Coordinator;
    public final AppBarLayout AppBar;
    public final Toolbar Toolbar;
    public final TextView textview4;
    public final EditText edUsername;
    public final EditText edEmailCad;
    public final EditText edSenhaCad;
    public final Button btnCadastrar;
    public final Button btnVoltarLogin;

    private AcessocBinding(CoordinatorLayout Coordinator, AppBarLayout AppBar, Toolbar Toolbar, TextView textview4, EditText edUsername, EditText edEmailCad, EditText edSenhaCad, Button btnCadastrar, Button btnVoltarLogin) {
        this.Coordinator = Coordinator;
        this.AppBar = AppBar;
        this.Toolbar = Toolbar;
        this.textview4 = textview4;
        this.edUsername = edUsername;
        this.edEmailCad = edEmailCad;
        this.edSenhaCad = edSenhaCad;
        this.btnCadastrar = btnCadastrar;
        this.btnVoltarLogin = btnVoltarLogin;
    }

    public CoordinatorLayout getRoot() {
        return Coordinator;
    }

    public static AcessocBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AcessocBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.acessoc, parent, false);
        if (attachToParent) parent.addView(root);
        return bind(root);
    }

    public static AcessocBinding bind(View view) {
        CoordinatorLayout Coordinator = (CoordinatorLayout) view;
        AppBarLayout AppBar = findChildViewById(view, R.id._app_bar);
        Toolbar Toolbar = findChildViewById(view, R.id._toolbar);
        TextView textview4 = findChildViewById(view, R.id.textview4);
        EditText edUsername = findChildViewById(view, R.id.ed_username);
        EditText edEmailCad = findChildViewById(view, R.id.ed_email_cad);
        EditText edSenhaCad = findChildViewById(view, R.id.ed_senha_cad);
        Button btnCadastrar = findChildViewById(view, R.id.btn_cadastrar);
        Button btnVoltarLogin = findChildViewById(view, R.id.btn_voltar_login);

        if (AppBar == null || Toolbar == null || textview4 == null || edUsername == null || edEmailCad == null || edSenhaCad == null || btnCadastrar == null || btnVoltarLogin == null) {
             throw new IllegalStateException("Required views are missing");
        }

        return new AcessocBinding(Coordinator, AppBar, Toolbar, textview4, edUsername, edEmailCad, edSenhaCad, btnCadastrar, btnVoltarLogin);
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