package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class ActivityMainBinding extends ViewDataBinding {
  @NonNull
  public final FloatingActionButton floatingActionButton;

  @NonNull
  public final FrameLayout fragmentFrame;

  @NonNull
  public final AppToolbarBinding mainToolbar;

  @NonNull
  public final TabLayout tabsMain;

  protected ActivityMainBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FloatingActionButton floatingActionButton, FrameLayout fragmentFrame,
      AppToolbarBinding mainToolbar, TabLayout tabsMain) {
    super(_bindingComponent, _root, _localFieldCount);
    this.floatingActionButton = floatingActionButton;
    this.fragmentFrame = fragmentFrame;
    this.mainToolbar = mainToolbar;
    setContainedBinding(this.mainToolbar);;
    this.tabsMain = tabsMain;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMainBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMainBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_main, null, false, component);
  }

  public static ActivityMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMainBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMainBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.activity_main);
  }
}
