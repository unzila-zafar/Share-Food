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

public abstract class ActivityImagePreviewBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageBack;

  @NonNull
  public final ImageView imagePreview;

  protected ActivityImagePreviewBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView imageBack, ImageView imagePreview) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageBack = imageBack;
    this.imagePreview = imagePreview;
  }

  @NonNull
  public static ActivityImagePreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityImagePreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityImagePreviewBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_image_preview, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityImagePreviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityImagePreviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityImagePreviewBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_image_preview, null, false, component);
  }

  public static ActivityImagePreviewBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityImagePreviewBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityImagePreviewBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.activity_image_preview);
  }
}
