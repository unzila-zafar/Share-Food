package food.sharefood.com.sharefood;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import food.sharefood.com.sharefood.databinding.ActivityAddPostBindingImpl;
import food.sharefood.com.sharefood.databinding.ActivityForgotBindingImpl;
import food.sharefood.com.sharefood.databinding.ActivityImagePreviewBindingImpl;
import food.sharefood.com.sharefood.databinding.ActivityLoginBindingImpl;
import food.sharefood.com.sharefood.databinding.ActivityMainBindingImpl;
import food.sharefood.com.sharefood.databinding.ActivityMapBindingImpl;
import food.sharefood.com.sharefood.databinding.ActivitySearchBindingImpl;
import food.sharefood.com.sharefood.databinding.ActivitySettingsBindingImpl;
import food.sharefood.com.sharefood.databinding.ActivitySignupBindingImpl;
import food.sharefood.com.sharefood.databinding.ActivityViewFoodPostBindingImpl;
import food.sharefood.com.sharefood.databinding.AppToolbarBindingImpl;
import food.sharefood.com.sharefood.databinding.DialogFilterBindingImpl;
import food.sharefood.com.sharefood.databinding.DialogPasswordBindingImpl;
import food.sharefood.com.sharefood.databinding.FragmentMainBindingImpl;
import food.sharefood.com.sharefood.databinding.ItemFoodListBindingImpl;
import food.sharefood.com.sharefood.databinding.ItemImagesFoodBindingImpl;
import food.sharefood.com.sharefood.databinding.ItemPhotoBindingImpl;
import food.sharefood.com.sharefood.databinding.PostToolbarBindingImpl;
import food.sharefood.com.sharefood.databinding.ProgressLayoutBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYADDPOST = 1;

  private static final int LAYOUT_ACTIVITYFORGOT = 2;

  private static final int LAYOUT_ACTIVITYIMAGEPREVIEW = 3;

  private static final int LAYOUT_ACTIVITYLOGIN = 4;

  private static final int LAYOUT_ACTIVITYMAIN = 5;

  private static final int LAYOUT_ACTIVITYMAP = 6;

  private static final int LAYOUT_ACTIVITYSEARCH = 7;

  private static final int LAYOUT_ACTIVITYSETTINGS = 8;

  private static final int LAYOUT_ACTIVITYSIGNUP = 9;

  private static final int LAYOUT_ACTIVITYVIEWFOODPOST = 10;

  private static final int LAYOUT_APPTOOLBAR = 11;

  private static final int LAYOUT_DIALOGFILTER = 12;

  private static final int LAYOUT_DIALOGPASSWORD = 13;

  private static final int LAYOUT_FRAGMENTMAIN = 14;

  private static final int LAYOUT_ITEMFOODLIST = 15;

  private static final int LAYOUT_ITEMIMAGESFOOD = 16;

  private static final int LAYOUT_ITEMPHOTO = 17;

  private static final int LAYOUT_POSTTOOLBAR = 18;

  private static final int LAYOUT_PROGRESSLAYOUT = 19;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(19);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.activity_add_post, LAYOUT_ACTIVITYADDPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.activity_forgot, LAYOUT_ACTIVITYFORGOT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.activity_image_preview, LAYOUT_ACTIVITYIMAGEPREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.activity_map, LAYOUT_ACTIVITYMAP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.activity_search, LAYOUT_ACTIVITYSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.activity_settings, LAYOUT_ACTIVITYSETTINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.activity_signup, LAYOUT_ACTIVITYSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.activity_view_food_post, LAYOUT_ACTIVITYVIEWFOODPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.app_toolbar, LAYOUT_APPTOOLBAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.dialog_filter, LAYOUT_DIALOGFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.dialog_password, LAYOUT_DIALOGPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.fragment_main, LAYOUT_FRAGMENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.item_food_list, LAYOUT_ITEMFOODLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.item_images_food, LAYOUT_ITEMIMAGESFOOD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.item_photo, LAYOUT_ITEMPHOTO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.post_toolbar, LAYOUT_POSTTOOLBAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(food.sharefood.com.sharefood.R.layout.progress_layout, LAYOUT_PROGRESSLAYOUT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYADDPOST: {
          if ("layout/activity_add_post_0".equals(tag)) {
            return new ActivityAddPostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_add_post is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYFORGOT: {
          if ("layout/activity_forgot_0".equals(tag)) {
            return new ActivityForgotBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_forgot is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYIMAGEPREVIEW: {
          if ("layout/activity_image_preview_0".equals(tag)) {
            return new ActivityImagePreviewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_image_preview is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAP: {
          if ("layout/activity_map_0".equals(tag)) {
            return new ActivityMapBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_map is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSEARCH: {
          if ("layout/activity_search_0".equals(tag)) {
            return new ActivitySearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_search is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSETTINGS: {
          if ("layout/activity_settings_0".equals(tag)) {
            return new ActivitySettingsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_settings is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSIGNUP: {
          if ("layout/activity_signup_0".equals(tag)) {
            return new ActivitySignupBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_signup is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYVIEWFOODPOST: {
          if ("layout/activity_view_food_post_0".equals(tag)) {
            return new ActivityViewFoodPostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_view_food_post is invalid. Received: " + tag);
        }
        case  LAYOUT_APPTOOLBAR: {
          if ("layout/app_toolbar_0".equals(tag)) {
            return new AppToolbarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for app_toolbar is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGFILTER: {
          if ("layout/dialog_filter_0".equals(tag)) {
            return new DialogFilterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_filter is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGPASSWORD: {
          if ("layout/dialog_password_0".equals(tag)) {
            return new DialogPasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_password is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAIN: {
          if ("layout/fragment_main_0".equals(tag)) {
            return new FragmentMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMFOODLIST: {
          if ("layout/item_food_list_0".equals(tag)) {
            return new ItemFoodListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_food_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMIMAGESFOOD: {
          if ("layout/item_images_food_0".equals(tag)) {
            return new ItemImagesFoodBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_images_food is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPHOTO: {
          if ("layout/item_photo_0".equals(tag)) {
            return new ItemPhotoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_photo is invalid. Received: " + tag);
        }
        case  LAYOUT_POSTTOOLBAR: {
          if ("layout/post_toolbar_0".equals(tag)) {
            return new PostToolbarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for post_toolbar is invalid. Received: " + tag);
        }
        case  LAYOUT_PROGRESSLAYOUT: {
          if ("layout/progress_layout_0".equals(tag)) {
            return new ProgressLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for progress_layout is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(19);

    static {
      sKeys.put("layout/activity_add_post_0", food.sharefood.com.sharefood.R.layout.activity_add_post);
      sKeys.put("layout/activity_forgot_0", food.sharefood.com.sharefood.R.layout.activity_forgot);
      sKeys.put("layout/activity_image_preview_0", food.sharefood.com.sharefood.R.layout.activity_image_preview);
      sKeys.put("layout/activity_login_0", food.sharefood.com.sharefood.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", food.sharefood.com.sharefood.R.layout.activity_main);
      sKeys.put("layout/activity_map_0", food.sharefood.com.sharefood.R.layout.activity_map);
      sKeys.put("layout/activity_search_0", food.sharefood.com.sharefood.R.layout.activity_search);
      sKeys.put("layout/activity_settings_0", food.sharefood.com.sharefood.R.layout.activity_settings);
      sKeys.put("layout/activity_signup_0", food.sharefood.com.sharefood.R.layout.activity_signup);
      sKeys.put("layout/activity_view_food_post_0", food.sharefood.com.sharefood.R.layout.activity_view_food_post);
      sKeys.put("layout/app_toolbar_0", food.sharefood.com.sharefood.R.layout.app_toolbar);
      sKeys.put("layout/dialog_filter_0", food.sharefood.com.sharefood.R.layout.dialog_filter);
      sKeys.put("layout/dialog_password_0", food.sharefood.com.sharefood.R.layout.dialog_password);
      sKeys.put("layout/fragment_main_0", food.sharefood.com.sharefood.R.layout.fragment_main);
      sKeys.put("layout/item_food_list_0", food.sharefood.com.sharefood.R.layout.item_food_list);
      sKeys.put("layout/item_images_food_0", food.sharefood.com.sharefood.R.layout.item_images_food);
      sKeys.put("layout/item_photo_0", food.sharefood.com.sharefood.R.layout.item_photo);
      sKeys.put("layout/post_toolbar_0", food.sharefood.com.sharefood.R.layout.post_toolbar);
      sKeys.put("layout/progress_layout_0", food.sharefood.com.sharefood.R.layout.progress_layout);
    }
  }
}
