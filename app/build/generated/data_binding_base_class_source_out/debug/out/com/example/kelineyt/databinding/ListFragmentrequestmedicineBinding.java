// Generated by view binder compiler. Do not edit!
package com.example.kelineyt.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.kelineyt.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ListFragmentrequestmedicineBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final TextView medcontact;

  @NonNull
  public final TextView medemail;

  @NonNull
  public final ImageView medlist;

  @NonNull
  public final TextView medname;

  private ListFragmentrequestmedicineBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageView4, @NonNull TextView medcontact, @NonNull TextView medemail,
      @NonNull ImageView medlist, @NonNull TextView medname) {
    this.rootView = rootView;
    this.imageView4 = imageView4;
    this.medcontact = medcontact;
    this.medemail = medemail;
    this.medlist = medlist;
    this.medname = medname;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListFragmentrequestmedicineBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListFragmentrequestmedicineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_fragmentrequestmedicine, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListFragmentrequestmedicineBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.medcontact;
      TextView medcontact = ViewBindings.findChildViewById(rootView, id);
      if (medcontact == null) {
        break missingId;
      }

      id = R.id.medemail;
      TextView medemail = ViewBindings.findChildViewById(rootView, id);
      if (medemail == null) {
        break missingId;
      }

      id = R.id.medlist;
      ImageView medlist = ViewBindings.findChildViewById(rootView, id);
      if (medlist == null) {
        break missingId;
      }

      id = R.id.medname;
      TextView medname = ViewBindings.findChildViewById(rootView, id);
      if (medname == null) {
        break missingId;
      }

      return new ListFragmentrequestmedicineBinding((ConstraintLayout) rootView, imageView4,
          medcontact, medemail, medlist, medname);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}