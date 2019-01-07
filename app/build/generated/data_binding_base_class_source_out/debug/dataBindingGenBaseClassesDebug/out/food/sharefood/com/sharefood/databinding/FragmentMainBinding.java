package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentMainBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView foodList;

  protected FragmentMainBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView foodList) {
    super(_bindingComponent, _root, _localFieldCount);
    this.foodList = foodList;
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMainBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.fragment_main, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentMainBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.fragment_main, null, false, component);
  }

  public static FragmentMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentMainBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentMainBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.fragment_main);
  }
}
