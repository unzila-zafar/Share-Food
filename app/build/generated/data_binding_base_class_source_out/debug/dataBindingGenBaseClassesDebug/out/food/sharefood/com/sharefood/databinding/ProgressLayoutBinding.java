package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public abstract class ProgressLayoutBinding extends ViewDataBinding {
  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RelativeLayout progressLayout;

  protected ProgressLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ProgressBar progressBar, RelativeLayout progressLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.progressBar = progressBar;
    this.progressLayout = progressLayout;
  }

  @NonNull
  public static ProgressLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ProgressLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ProgressLayoutBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.progress_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ProgressLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ProgressLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ProgressLayoutBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.progress_layout, null, false, component);
  }

  public static ProgressLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ProgressLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ProgressLayoutBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.progress_layout);
  }
}
