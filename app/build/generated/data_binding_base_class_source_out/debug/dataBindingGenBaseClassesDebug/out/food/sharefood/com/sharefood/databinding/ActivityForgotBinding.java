package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public abstract class ActivityForgotBinding extends ViewDataBinding {
  @NonNull
  public final Button btnCancel;

  @NonNull
  public final Button btnOk;

  @NonNull
  public final TextInputEditText editForgotEmail;

  @NonNull
  public final TextInputLayout emailForgot;

  @NonNull
  public final TextView textView;

  protected ActivityForgotBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnCancel, Button btnOk, TextInputEditText editForgotEmail,
      TextInputLayout emailForgot, TextView textView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnCancel = btnCancel;
    this.btnOk = btnOk;
    this.editForgotEmail = editForgotEmail;
    this.emailForgot = emailForgot;
    this.textView = textView;
  }

  @NonNull
  public static ActivityForgotBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityForgotBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityForgotBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_forgot, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityForgotBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityForgotBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityForgotBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_forgot, null, false, component);
  }

  public static ActivityForgotBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityForgotBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityForgotBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.activity_forgot);
  }
}
