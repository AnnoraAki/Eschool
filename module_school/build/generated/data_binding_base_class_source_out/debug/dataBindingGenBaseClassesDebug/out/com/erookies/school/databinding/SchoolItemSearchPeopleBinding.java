package com.erookies.school.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.erookies.school.data.model.ItemData;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class SchoolItemSearchPeopleBinding extends ViewDataBinding {
  @NonNull
  public final TextView schoolSpItemContent;

  @NonNull
  public final LinearLayout schoolSpItemImageGroup;

  @NonNull
  public final Button schoolSpItemTagButton;

  @NonNull
  public final CircleImageView schoolSpItemUserAvatar;

  @NonNull
  public final TextView schoolSpItemUserName;

  @Bindable
  protected ItemData mItem;

  protected SchoolItemSearchPeopleBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView schoolSpItemContent, LinearLayout schoolSpItemImageGroup,
      Button schoolSpItemTagButton, CircleImageView schoolSpItemUserAvatar,
      TextView schoolSpItemUserName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.schoolSpItemContent = schoolSpItemContent;
    this.schoolSpItemImageGroup = schoolSpItemImageGroup;
    this.schoolSpItemTagButton = schoolSpItemTagButton;
    this.schoolSpItemUserAvatar = schoolSpItemUserAvatar;
    this.schoolSpItemUserName = schoolSpItemUserName;
  }

  public abstract void setItem(@Nullable ItemData item);

  @Nullable
  public ItemData getItem() {
    return mItem;
  }

  @NonNull
  public static SchoolItemSearchPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.school_item_search_people, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SchoolItemSearchPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SchoolItemSearchPeopleBinding>inflateInternal(inflater, com.erookies.school.R.layout.school_item_search_people, root, attachToRoot, component);
  }

  @NonNull
  public static SchoolItemSearchPeopleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.school_item_search_people, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SchoolItemSearchPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SchoolItemSearchPeopleBinding>inflateInternal(inflater, com.erookies.school.R.layout.school_item_search_people, null, false, component);
  }

  public static SchoolItemSearchPeopleBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static SchoolItemSearchPeopleBinding bind(@NonNull View view, @Nullable Object component) {
    return (SchoolItemSearchPeopleBinding)bind(component, view, com.erookies.school.R.layout.school_item_search_people);
  }
}
