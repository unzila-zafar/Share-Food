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

public abstract class ActivitySearchBinding extends ViewDataBinding {
  @NonNull
  public final ImageView filterBtn;

  @NonNull
  public final Toolbar searchToolbar;

  @NonNull
  public final TextView title;

  protected ActivitySearchBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView filterBtn, Toolbar searchToolbar, TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.filterBtn = filterBtn;
    this.searchToolbar = searchToolbar;
    this.title = title;
  }

  @NonNull
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySearchBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_search, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySearchBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_search, null, false, component);
  }

  public static ActivitySearchBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySearchBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySearchBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.activity_search);
  }
}
