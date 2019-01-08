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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import de.hdodenhof.circleimageview.CircleImageView;

public abstract class ActivitySignupBinding extends ViewDataBinding {
  @NonNull
  public final TextInputEditText addressEdit;

  @NonNull
  public final TextInputLayout addressLayout;

  @NonNull
  public final Button buttonSignup;

  @NonNull
  public final TextInputLayout confirmLayout;

  @NonNull
  public final TextInputEditText confirmPwdEdit;

  @NonNull
  public final TextInputEditText emailEdit;

  @NonNull
  public final TextInputLayout emailLayout;

  @NonNull
  public final ImageView imageEditPic;

  @NonNull
  public final TextInputEditText nameEdit;

  @NonNull
  public final TextInputLayout nameLayout;

  @NonNull
  public final TextInputLayout passwordLayout;

  @NonNull
  public final FrameLayout picLayout;

  @NonNull
  public final CircleImageView profileImage;

  @NonNull
  public final TextInputEditText signupPassword;

  @NonNull
  public final Spinner spinner;

  protected ActivitySignupBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextInputEditText addressEdit, TextInputLayout addressLayout,
      Button buttonSignup, TextInputLayout confirmLayout, TextInputEditText confirmPwdEdit,
      TextInputEditText emailEdit, TextInputLayout emailLayout, ImageView imageEditPic,
      TextInputEditText nameEdit, TextInputLayout nameLayout, TextInputLayout passwordLayout,
      FrameLayout picLayout, CircleImageView profileImage, TextInputEditText signupPassword,
      Spinner spinner) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addressEdit = addressEdit;
    this.addressLayout = addressLayout;
    this.buttonSignup = buttonSignup;
    this.confirmLayout = confirmLayout;
    this.confirmPwdEdit = confirmPwdEdit;
    this.emailEdit = emailEdit;
    this.emailLayout = emailLayout;
    this.imageEditPic = imageEditPic;
    this.nameEdit = nameEdit;
    this.nameLayout = nameLayout;
    this.passwordLayout = passwordLayout;
    this.picLayout = picLayout;
    this.profileImage = profileImage;
    this.signupPassword = signupPassword;
    this.spinner = spinner;
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySignupBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_signup, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySignupBinding>inflate(inflater, food.sharefood.com.sharefood.R.layout.activity_signup, null, false, component);
  }

  public static ActivitySignupBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySignupBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySignupBinding)bind(component, view, food.sharefood.com.sharefood.R.layout.activity_signup);
  }
}
