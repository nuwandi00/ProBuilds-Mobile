// Generated by view binder compiler. Do not edit!
package com.example.kelineyt.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.kelineyt.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CartProductItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView imageCartProduct;

  @NonNull
  public final CircleImageView imageCartProductColor;

  @NonNull
  public final CircleImageView imageCartProductSize;

  @NonNull
  public final ImageView imageMinus;

  @NonNull
  public final ImageView imagePlus;

  @NonNull
  public final View topLine;

  @NonNull
  public final TextView tvCartProductQuantity;

  @NonNull
  public final TextView tvCartProductSize;

  @NonNull
  public final TextView tvProductCartName;

  @NonNull
  public final TextView tvProductCartPrice;

  private CartProductItemBinding(@NonNull CardView rootView, @NonNull ImageView imageCartProduct,
      @NonNull CircleImageView imageCartProductColor, @NonNull CircleImageView imageCartProductSize,
      @NonNull ImageView imageMinus, @NonNull ImageView imagePlus, @NonNull View topLine,
      @NonNull TextView tvCartProductQuantity, @NonNull TextView tvCartProductSize,
      @NonNull TextView tvProductCartName, @NonNull TextView tvProductCartPrice) {
    this.rootView = rootView;
    this.imageCartProduct = imageCartProduct;
    this.imageCartProductColor = imageCartProductColor;
    this.imageCartProductSize = imageCartProductSize;
    this.imageMinus = imageMinus;
    this.imagePlus = imagePlus;
    this.topLine = topLine;
    this.tvCartProductQuantity = tvCartProductQuantity;
    this.tvCartProductSize = tvCartProductSize;
    this.tvProductCartName = tvProductCartName;
    this.tvProductCartPrice = tvProductCartPrice;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CartProductItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CartProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.cart_product_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CartProductItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageCartProduct;
      ImageView imageCartProduct = ViewBindings.findChildViewById(rootView, id);
      if (imageCartProduct == null) {
        break missingId;
      }

      id = R.id.imageCartProductColor;
      CircleImageView imageCartProductColor = ViewBindings.findChildViewById(rootView, id);
      if (imageCartProductColor == null) {
        break missingId;
      }

      id = R.id.imageCartProductSize;
      CircleImageView imageCartProductSize = ViewBindings.findChildViewById(rootView, id);
      if (imageCartProductSize == null) {
        break missingId;
      }

      id = R.id.imageMinus;
      ImageView imageMinus = ViewBindings.findChildViewById(rootView, id);
      if (imageMinus == null) {
        break missingId;
      }

      id = R.id.imagePlus;
      ImageView imagePlus = ViewBindings.findChildViewById(rootView, id);
      if (imagePlus == null) {
        break missingId;
      }

      id = R.id.topLine;
      View topLine = ViewBindings.findChildViewById(rootView, id);
      if (topLine == null) {
        break missingId;
      }

      id = R.id.tvCartProductQuantity;
      TextView tvCartProductQuantity = ViewBindings.findChildViewById(rootView, id);
      if (tvCartProductQuantity == null) {
        break missingId;
      }

      id = R.id.tvCartProductSize;
      TextView tvCartProductSize = ViewBindings.findChildViewById(rootView, id);
      if (tvCartProductSize == null) {
        break missingId;
      }

      id = R.id.tvProductCartName;
      TextView tvProductCartName = ViewBindings.findChildViewById(rootView, id);
      if (tvProductCartName == null) {
        break missingId;
      }

      id = R.id.tvProductCartPrice;
      TextView tvProductCartPrice = ViewBindings.findChildViewById(rootView, id);
      if (tvProductCartPrice == null) {
        break missingId;
      }

      return new CartProductItemBinding((CardView) rootView, imageCartProduct,
          imageCartProductColor, imageCartProductSize, imageMinus, imagePlus, topLine,
          tvCartProductQuantity, tvCartProductSize, tvProductCartName, tvProductCartPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
