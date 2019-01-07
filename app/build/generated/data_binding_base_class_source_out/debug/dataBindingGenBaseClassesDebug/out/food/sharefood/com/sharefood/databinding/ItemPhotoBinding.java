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

public abstract class ItemPhotoBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView;

  protected ItemPhotoBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView imageView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView = imageView;
  }

  @NonNull
  public static ItemPhotoBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemPhotoBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemPhotoBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.item_photo, root, attachToRoot, component);
  }

  @NonNull
  public static ItemPhotoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemPhotoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemPhotoBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.item_photo, null, false, component);
  }

  public static ItemPhotoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemPhotoBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemPhotoBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.item_photo);
  }
}
