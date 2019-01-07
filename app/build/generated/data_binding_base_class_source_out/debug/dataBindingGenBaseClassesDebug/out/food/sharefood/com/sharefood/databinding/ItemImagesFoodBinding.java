package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public abstract class ItemImagesFoodBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageFood;

  protected ItemImagesFoodBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView imageFood) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageFood = imageFood;
  }

  @NonNull
  public static ItemImagesFoodBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemImagesFoodBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemImagesFoodBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.item_images_food, root, attachToRoot, component);
  }

  @NonNull
  public static ItemImagesFoodBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemImagesFoodBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemImagesFoodBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.item_images_food, null, false, component);
  }

  public static ItemImagesFoodBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemImagesFoodBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemImagesFoodBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.item_images_food);
  }
}
