// Generated file. Do not modify.
package com.docedleite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public final class MainBinding {
    public final RelativeLayout rootView;
    public final WebView webview1;
    public final RelativeLayout splashLayout;
    public final TextView textview1;

    private MainBinding(RelativeLayout rootView, WebView webview1, RelativeLayout splashLayout, TextView textview1) {
        this.rootView = rootView;
        this.webview1 = webview1;
        this.splashLayout = splashLayout;
        this.textview1 = textview1;
    }

    public RelativeLayout getRoot() {
        return rootView;
    }

    public static MainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.main, parent, false);
        if (attachToParent) parent.addView(root);
        return bind(root);
    }

    public static MainBinding bind(View view) {
        RelativeLayout rootView = (RelativeLayout) view;
        WebView webview1 = findChildViewById(view, R.id.webview1);
        RelativeLayout splashLayout = findChildViewById(view, R.id.splashLayout);
        TextView textview1 = findChildViewById(view, R.id.textview1);

        if (webview1 == null || splashLayout == null || textview1 == null) {
             throw new IllegalStateException("Required views are missing");
        }

        return new MainBinding(rootView, webview1, splashLayout, textview1);
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