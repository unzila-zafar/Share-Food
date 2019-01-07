package food.sharefood.com.sharefood.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class ItemFoodListBinding extends ViewDataBinding {
  @NonNull
  public final CardView cardView;

  @NonNull
  public final RecyclerView imagesList;

  @NonNull
  public final TextView textCountValue;

  @NonNull
  public final TextView textDescription;

  @NonNull
  public final TextView textHeadingCount;

  @NonNull
  public final TextView textHeadingItems;

  @NonNull
  public final TextView textItemValues;

  @NonNull
  public final TextView textLocation;

  @NonNull
  public final TextView textTime;

  @NonNull
  public final TextView textView10;

  protected ItemFoodListBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, CardView cardView, RecyclerView imagesList, TextView textCountValue,
      TextView textDescription, TextView textHeadingCount, TextView textHeadingItems,
      TextView textItemValues, TextView textLocation, TextView textTime, TextView textView10) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cardView = cardView;
    this.imagesList = imagesList;
    this.textCountValue = textCountValue;
    this.textDescription = textDescription;
    this.textHeadingCount = textHeadingCount;
    this.textHeadingItems = textHeadingItems;
    this.textItemValues = textItemValues;
    this.textLocation = textLocation;
    this.textTime = textTime;
    this.textView10 = textView10;
  }

  @NonNull
  public static ItemFoodListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFoodListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFoodListBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.item_food_list, root, attachToRoot, component);
  }

  @NonNull
  public static ItemFoodListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFoodListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFoodListBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.item_food_list, null, false, component);
  }

  public static ItemFoodListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemFoodListBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemFoodListBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.item_food_list);
  }
}
