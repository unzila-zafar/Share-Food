package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public abstract class DialogFilterBinding extends ViewDataBinding {
  @NonNull
  public final TextInputLayout addLocationLayout;

  @NonNull
  public final Button cancelButton;

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
  public final TextInputEditText searchEmailEdit;

  @NonNull
  public final TextInputEditText searchFooditemsEdit;

  @NonNull
  public final TextInputEditText searchLocationEdit;

  @NonNull
  public final TextInputEditText searchNameEdit;

  @NonNull
  public final TextInputEditText searchNumberEdit;

  @NonNull
  public final TextInputEditText searchPicktimeEdit;

  @NonNull
  public final TextInputEditText searchSufficientEdit;

  @NonNull
  public final Button searchbutton;

  @NonNull
  public final TextInputLayout sufficientForLayout;

  @NonNull
  public final TextView textTitle;

  protected DialogFilterBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextInputLayout addLocationLayout, Button cancelButton,
      TextInputLayout emailLayout, TextInputLayout fooditemsLayout, TextInputLayout nameLayout,
      TextInputLayout phoneLayout, TextInputLayout pickLayout, TextInputEditText searchEmailEdit,
      TextInputEditText searchFooditemsEdit, TextInputEditText searchLocationEdit,
      TextInputEditText searchNameEdit, TextInputEditText searchNumberEdit,
      TextInputEditText searchPicktimeEdit, TextInputEditText searchSufficientEdit,
      Button searchbutton, TextInputLayout sufficientForLayout, TextView textTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addLocationLayout = addLocationLayout;
    this.cancelButton = cancelButton;
    this.emailLayout = emailLayout;
    this.fooditemsLayout = fooditemsLayout;
    this.nameLayout = nameLayout;
    this.phoneLayout = phoneLayout;
    this.pickLayout = pickLayout;
    this.searchEmailEdit = searchEmailEdit;
    this.searchFooditemsEdit = searchFooditemsEdit;
    this.searchLocationEdit = searchLocationEdit;
    this.searchNameEdit = searchNameEdit;
    this.searchNumberEdit = searchNumberEdit;
    this.searchPicktimeEdit = searchPicktimeEdit;
    this.searchSufficientEdit = searchSufficientEdit;
    this.searchbutton = searchbutton;
    this.sufficientForLayout = sufficientForLayout;
    this.textTitle = textTitle;
  }

  @NonNull
  public static DialogFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogFilterBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.dialog_filter, root, attachToRoot, component);
  }

  @NonNull
  public static DialogFilterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogFilterBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.dialog_filter, null, false, component);
  }

  public static DialogFilterBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogFilterBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogFilterBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.dialog_filter);
  }
}
