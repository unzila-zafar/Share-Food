package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class AppToolbarBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageSearch;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView toolbarTitle;

  protected AppToolbarBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView imageSearch, Toolbar toolbar, TextView toolbarTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageSearch = imageSearch;
    this.toolbar = toolbar;
    this.toolbarTitle = toolbarTitle;
  }

  @NonNull
  public static AppToolbarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static AppToolbarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<AppToolbarBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.app_toolbar, root, attachToRoot, component);
  }

  @NonNull
  public static AppToolbarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static AppToolbarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<AppToolbarBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.app_toolbar, null, false, component);
  }

  public static AppToolbarBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static AppToolbarBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (AppToolbarBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.app_toolbar);
  }
}
