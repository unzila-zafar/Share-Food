package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class ActivityViewFoodPostBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatCheckBox checkBox1;

  @NonNull
  public final RecyclerView imagesPostList;

  @NonNull
  public final ConstraintLayout layoutFood;

  @NonNull
  public final ConstraintLayout layoutLocation;

  @NonNull
  public final ConstraintLayout layoutPickup;

  @NonNull
  public final ConstraintLayout layoutSharing;

  @NonNull
  public final ConstraintLayout layoutSufficient;

  @NonNull
  public final PostToolbarBinding postBar;

  @NonNull
  public final TextView textHeadingLocation;

  @NonNull
  public final TextView textLocation;

  @NonNull
  public final TextView textPickupItems;

  @NonNull
  public final TextView textPickupTime;

  @NonNull
  public final TextView textPostItemValues;

  @NonNull
  public final TextView textPostItems;

  @NonNull
  public final TextView textSharing;

  @NonNull
  public final TextView textSharingHeading;

  @NonNull
  public final TextView textSufficientHeading;

  @NonNull
  public final TextView valueSufficent;

  @NonNull
  public final TextView viewMap;

  protected ActivityViewFoodPostBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, AppCompatCheckBox checkBox1, RecyclerView imagesPostList,
      ConstraintLayout layoutFood, ConstraintLayout layoutLocation, ConstraintLayout layoutPickup,
      ConstraintLayout layoutSharing, ConstraintLayout layoutSufficient, PostToolbarBinding postBar,
      TextView textHeadingLocation, TextView textLocation, TextView textPickupItems,
      TextView textPickupTime, TextView textPostItemValues, TextView textPostItems,
      TextView textSharing, TextView textSharingHeading, TextView textSufficientHeading,
      TextView valueSufficent, TextView viewMap) {
    super(_bindingComponent, _root, _localFieldCount);
    this.checkBox1 = checkBox1;
    this.imagesPostList = imagesPostList;
    this.layoutFood = layoutFood;
    this.layoutLocation = layoutLocation;
    this.layoutPickup = layoutPickup;
    this.layoutSharing = layoutSharing;
    this.layoutSufficient = layoutSufficient;
    this.postBar = postBar;
    setContainedBinding(this.postBar);;
    this.textHeadingLocation = textHeadingLocation;
    this.textLocation = textLocation;
    this.textPickupItems = textPickupItems;
    this.textPickupTime = textPickupTime;
    this.textPostItemValues = textPostItemValues;
    this.textPostItems = textPostItems;
    this.textSharing = textSharing;
    this.textSharingHeading = textSharingHeading;
    this.textSufficientHeading = textSufficientHeading;
    this.valueSufficent = valueSufficent;
    this.viewMap = viewMap;
  }

  @NonNull
  public static ActivityViewFoodPostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityViewFoodPostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityViewFoodPostBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_view_food_post, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityViewFoodPostBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityViewFoodPostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityViewFoodPostBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_view_food_post, null, false, component);
  }

  public static ActivityViewFoodPostBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityViewFoodPostBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityViewFoodPostBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.activity_view_food_post);
  }
}
