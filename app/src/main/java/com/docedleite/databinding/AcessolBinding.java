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

public final class AcessolBinding {
    public final CoordinatorLayout Coordinator;
    public final AppBarLayout AppBar;
    public final Toolbar Toolbar;
    public final TextView textview2;
    public final EditText edEmail;
    public final EditText edSenha;
    public final Button btnEntrar;
    public final Button btnIrCadastro;

    private AcessolBinding(CoordinatorLayout Coordinator, AppBarLayout AppBar, Toolbar Toolbar, TextView textview2, EditText edEmail, EditText edSenha, Button btnEntrar, Button btnIrCadastro) {
        this.Coordinator = Coordinator;
        this.AppBar = AppBar;
        this.Toolbar = Toolbar;
        this.textview2 = textview2;
        this.edEmail = edEmail;
        this.edSenha = edSenha;
        this.btnEntrar = btnEntrar;
        this.btnIrCadastro = btnIrCadastro;
    }

    public CoordinatorLayout getRoot() {
        return Coordinator;
    }

    public static AcessolBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AcessolBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.acessol, parent, false);
        if (attachToParent) parent.addView(root);
        return bind(root);
    }

    public static AcessolBinding bind(View view) {
        CoordinatorLayout Coordinator = (CoordinatorLayout) view;
        AppBarLayout AppBar = findChildViewById(view, R.id._app_bar);
        Toolbar Toolbar = findChildViewById(view, R.id._toolbar);
        TextView textview2 = findChildViewById(view, R.id.textview2);
        EditText edEmail = findChildViewById(view, R.id.ed_email);
        EditText edSenha = findChildViewById(view, R.id.ed_senha);
        Button btnEntrar = findChildViewById(view, R.id.btn_entrar);
        Button btnIrCadastro = findChildViewById(view, R.id.btn_ir_cadastro);

        if (AppBar == null || Toolbar == null || textview2 == null || edEmail == null || edSenha == null || btnEntrar == null || btnIrCadastro == null) {
             throw new IllegalStateException("Required views are missing");
        }

        return new AcessolBinding(Coordinator, AppBar, Toolbar, textview2, edEmail, edSenha, btnEntrar, btnIrCadastro);
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