package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public abstract class ActivityAddPostBinding extends ViewDataBinding {
  @NonNull
  public final TextInputEditText addEmailEdit;

  @NonNull
  public final TextInputEditText addFooditemsEdit;

  @NonNull
  public final TextInputEditText addLocationEdit;

  @NonNull
  public final TextInputLayout addLocationLayout;

  @NonNull
  public final TextInputEditText addNameEdit;

  @NonNull
  public final TextInputEditText addNumberEdit;

  @NonNull
  public final RecyclerView addPhotoList;

  @NonNull
  public final TextInputEditText addPicktimeEdit;

  @NonNull
  public final TextInputEditText addSufficientEdit;

  @NonNull
  public final AppToolbarBinding addToolbar;

  @NonNull
  public final Button buttonAdd;

  @NonNull
  public final TextInputLayout emailLayout;

  @NonNull
  public final TextInputLayout fooditemsLayout;

  @NonNull
  public final TextInputLayout nameLayout;

  @NonNull
  public final TextInputLayout phoneLayout;

  @NonNull
  public final TextInputLayout pickLayout;

  @NonNull
  public final TextInputLayout sufficientForLayout;

  protected ActivityAddPostBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextInputEditText addEmailEdit, TextInputEditText addFooditemsEdit,
      TextInputEditText addLocationEdit, TextInputLayout addLocationLayout,
      TextInputEditText addNameEdit, TextInputEditText addNumberEdit, RecyclerView addPhotoList,
      TextInputEditText addPicktimeEdit, TextInputEditText addSufficientEdit,
      AppToolbarBinding addToolbar, Button buttonAdd, TextInputLayout emailLayout,
      TextInputLayout fooditemsLayout, TextInputLayout nameLayout, TextInputLayout phoneLayout,
      TextInputLayout pickLayout, TextInputLayout sufficientForLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addEmailEdit = addEmailEdit;
    this.addFooditemsEdit = addFooditemsEdit;
    this.addLocationEdit = addLocationEdit;
    this.addLocationLayout = addLocationLayout;
    this.addNameEdit = addNameEdit;
    this.addNumberEdit = addNumberEdit;
    this.addPhotoList = addPhotoList;
    this.addPicktimeEdit = addPicktimeEdit;
    this.addSufficientEdit = addSufficientEdit;
    this.addToolbar = addToolbar;
    setContainedBinding(this.addToolbar);;
    this.buttonAdd = buttonAdd;
    this.emailLayout = emailLayout;
    this.fooditemsLayout = fooditemsLayout;
    this.nameLayout = nameLayout;
    this.phoneLayout = phoneLayout;
    this.pickLayout = pickLayout;
    this.sufficientForLayout = sufficientForLayout;
  }

  @NonNull
  public static ActivityAddPostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAddPostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAddPostBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_add_post, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAddPostBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAddPostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAddPostBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_add_post, null, false, component);
  }

  public static ActivityAddPostBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityAddPostBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityAddPostBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.activity_add_post);
  }
}
