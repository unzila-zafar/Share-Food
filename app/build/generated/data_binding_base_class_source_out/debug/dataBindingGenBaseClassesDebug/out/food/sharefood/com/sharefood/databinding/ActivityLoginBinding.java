package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class ActivityLoginBinding extends ViewDataBinding {
  @NonNull
  public final Button buttonFB;

  @NonNull
  public final ConstraintLayout buttonLayout;

  @NonNull
  public final Button buttonSignIn;

  @NonNull
  public final TextInputEditText email;

  @NonNull
  public final TextInputLayout emailLayout;

  @NonNull
  public final TextView forgetText;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ConstraintLayout midLayout;

  @NonNull
  public final TextInputEditText password;

  @NonNull
  public final TextInputLayout passwordLayout;

  @NonNull
  public final TextView textOr;

  @NonNull
  public final TextView textRegister;

  @NonNull
  public final TextView textSignwith;

  @NonNull
  public final ConstraintLayout topLayout;

  protected ActivityLoginBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button buttonFB, ConstraintLayout buttonLayout, Button buttonSignIn,
      TextInputEditText email, TextInputLayout emailLayout, TextView forgetText,
      ImageView imageView, ConstraintLayout midLayout, TextInputEditText password,
      TextInputLayout passwordLayout, TextView textOr, TextView textRegister, TextView textSignwith,
      ConstraintLayout topLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.buttonFB = buttonFB;
    this.buttonLayout = buttonLayout;
    this.buttonSignIn = buttonSignIn;
    this.email = email;
    this.emailLayout = emailLayout;
    this.forgetText = forgetText;
    this.imageView = imageView;
    this.midLayout = midLayout;
    this.password = password;
    this.passwordLayout = passwordLayout;
    this.textOr = textOr;
    this.textRegister = textRegister;
    this.textSignwith = textSignwith;
    this.topLayout = topLayout;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLoginBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_login, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLoginBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_login, null, false, component);
  }

  public static ActivityLoginBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityLoginBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityLoginBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.activity_login);
  }
}
