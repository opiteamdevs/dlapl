// Generated file. Do not modify.
package com.docedleite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class PostitemBinding {
    public final LinearLayout rootView;
    public final LinearLayout linearCard;
    public final LinearLayout linear4;
    public final TextView txtCreator;
    public final TextView txtDate;
    public final TextView txtTitle;
    public final View view5;
    public final LinearLayout linear6;
    public final TextView txtLikes;
    public final TextView txtComments;

    private PostitemBinding(LinearLayout rootView, LinearLayout linearCard, LinearLayout linear4, TextView txtCreator, TextView txtDate, TextView txtTitle, View view5, LinearLayout linear6, TextView txtLikes, TextView txtComments) {
        this.rootView = rootView;
        this.linearCard = linearCard;
        this.linear4 = linear4;
        this.txtCreator = txtCreator;
        this.txtDate = txtDate;
        this.txtTitle = txtTitle;
        this.view5 = view5;
        this.linear6 = linear6;
        this.txtLikes = txtLikes;
        this.txtComments = txtComments;
    }

    public LinearLayout getRoot() {
        return rootView;
    }

    public static PostitemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PostitemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.postitem, parent, false);
        if (attachToParent) parent.addView(root);
        return bind(root);
    }

    public static PostitemBinding bind(View view) {
        LinearLayout rootView = (LinearLayout) view;
        LinearLayout linearCard = findChildViewById(view, R.id.linear_card);
        LinearLayout linear4 = findChildViewById(view, R.id.linear4);
        TextView txtCreator = findChildViewById(view, R.id.txt_creator);
        TextView txtDate = findChildViewById(view, R.id.txt_date);
        TextView txtTitle = findChildViewById(view, R.id.txt_title);
        View view5 = findChildViewById(view, R.id.view5);
        LinearLayout linear6 = findChildViewById(view, R.id.linear6);
        TextView txtLikes = findChildViewById(view, R.id.txt_likes);
        TextView txtComments = findChildViewById(view, R.id.txt_comments);

        if (linearCard == null || linear4 == null || txtCreator == null || txtDate == null || txtTitle == null || view5 == null || linear6 == null || txtLikes == null || txtComments == null) {
             throw new IllegalStateException("Required views are missing");
        }

        return new PostitemBinding(rootView, linearCard, linear4, txtCreator, txtDate, txtTitle, view5, linear6, txtLikes, txtComments);
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