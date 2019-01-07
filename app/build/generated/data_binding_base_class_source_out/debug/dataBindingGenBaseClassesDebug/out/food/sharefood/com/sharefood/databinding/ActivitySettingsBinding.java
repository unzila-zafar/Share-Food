package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class ActivitySettingsBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final ConstraintLayout passwordLayout;

  @NonNull
  public final ConstraintLayout profileLayout;

  @NonNull
  public final TextView textLanguage;

  @NonNull
  public final TextView textLocation;

  @NonNull
  public final TextView textUserName;

  @NonNull
  public final TextView textView4;

  protected ActivitySettingsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView imageView, ImageView imageView3, ImageView imageView4,
      ConstraintLayout passwordLayout, ConstraintLayout profileLayout, TextView textLanguage,
      TextView textLocation, TextView textUserName, TextView textView4) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView = imageView;
    this.imageView3 = imageView3;
    this.imageView4 = imageView4;
    this.passwordLayout = passwordLayout;
    this.profileLayout = profileLayout;
    this.textLanguage = textLanguage;
    this.textLocation = textLocation;
    this.textUserName = textUserName;
    this.textView4 = textView4;
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySettingsBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_settings, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySettingsBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_settings, null, false, component);
  }

  public static ActivitySettingsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySettingsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySettingsBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.activity_settings);
  }
}
