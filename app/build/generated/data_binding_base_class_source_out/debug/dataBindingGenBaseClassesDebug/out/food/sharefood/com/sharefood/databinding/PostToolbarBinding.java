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

public abstract class PostToolbarBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageEdit;

  @NonNull
  public final ImageView imageRemove;

  @NonNull
  public final Toolbar postToolbar;

  @NonNull
  public final TextView toolbarTitle;

  protected PostToolbarBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView imageEdit, ImageView imageRemove, Toolbar postToolbar,
      TextView toolbarTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageEdit = imageEdit;
    this.imageRemove = imageRemove;
    this.postToolbar = postToolbar;
    this.toolbarTitle = toolbarTitle;
  }

  @NonNull
  public static PostToolbarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PostToolbarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PostToolbarBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.post_toolbar, root, attachToRoot, component);
  }

  @NonNull
  public static PostToolbarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PostToolbarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PostToolbarBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.post_toolbar, null, false, component);
  }

  public static PostToolbarBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PostToolbarBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PostToolbarBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.post_toolbar);
  }
}
