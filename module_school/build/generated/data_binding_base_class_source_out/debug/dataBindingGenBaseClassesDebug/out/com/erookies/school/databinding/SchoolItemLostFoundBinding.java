package com.erookies.school.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.erookies.school.data.model.ItemData;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class SchoolItemLostFoundBinding extends ViewDataBinding {
  @NonNull
  public final TextView schoolItemContent;

  @NonNull
  public final RecyclerView schoolItemPictures;

  @NonNull
  public final Button schoolItemTagButton;

  @NonNull
  public final CircleImageView schoolItemUserAvatar;

  @NonNull
  public final TextView schoolItemUserName;

  @Bindable
  protected ItemData mItem;

  protected SchoolItemLostFoundBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView schoolItemContent, RecyclerView schoolItemPictures, Button schoolItemTagButton,
      CircleImageView schoolItemUserAvatar, TextView schoolItemUserName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.schoolItemContent = schoolItemContent;
    this.schoolItemPictures = schoolItemPictures;
    this.schoolItemTagButton = schoolItemTagButton;
    this.schoolItemUserAvatar = schoolItemUserAvatar;
    this.schoolItemUserName = schoolItemUserName;
  }

  public abstract void setItem(@Nullable ItemData item);

  @Nullable
  public ItemData getItem() {
    return mItem;
  }

  @NonNull
  public static SchoolItemLostFoundBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.school_item_lost_found, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SchoolItemLostFoundBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SchoolItemLostFoundBinding>inflateInternal(inflater, com.erookies.school.R.layout.school_item_lost_found, root, attachToRoot, component);
  }

  @NonNull
  public static SchoolItemLostFoundBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.school_item_lost_found, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SchoolItemLostFoundBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SchoolItemLostFoundBinding>inflateInternal(inflater, com.erookies.school.R.layout.school_item_lost_found, null, false, component);
  }

  public static SchoolItemLostFoundBinding bind(@NonNull View view) {
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
  public static SchoolItemLostFoundBinding bind(@NonNull View view, @Nullable Object component) {
    return (SchoolItemLostFoundBinding)bind(component, view, com.erookies.school.R.layout.school_item_lost_found);
  }
}
