package com.erookies.school.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.erookies.school.data.viewModel.SchoolPageContainerViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class SchoolFragmentContainerBinding extends ViewDataBinding {
  @NonNull
  public final View divider;

  @NonNull
  public final TextView schoolLandfSwitchButton;

  @NonNull
  public final ViewPager schoolPageListContainer;

  @NonNull
  public final TextView schoolSearchSwitchButton;

  @Bindable
  protected SchoolPageContainerViewModel mViewModel;

  protected SchoolFragmentContainerBinding(Object _bindingComponent, View _root,
      int _localFieldCount, View divider, TextView schoolLandfSwitchButton,
      ViewPager schoolPageListContainer, TextView schoolSearchSwitchButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.divider = divider;
    this.schoolLandfSwitchButton = schoolLandfSwitchButton;
    this.schoolPageListContainer = schoolPageListContainer;
    this.schoolSearchSwitchButton = schoolSearchSwitchButton;
  }

  public abstract void setViewModel(@Nullable SchoolPageContainerViewModel viewModel);

  @Nullable
  public SchoolPageContainerViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static SchoolFragmentContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.school_fragment_container, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SchoolFragmentContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SchoolFragmentContainerBinding>inflateInternal(inflater, com.erookies.school.R.layout.school_fragment_container, root, attachToRoot, component);
  }

  @NonNull
  public static SchoolFragmentContainerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.school_fragment_container, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SchoolFragmentContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SchoolFragmentContainerBinding>inflateInternal(inflater, com.erookies.school.R.layout.school_fragment_container, null, false, component);
  }

  public static SchoolFragmentContainerBinding bind(@NonNull View view) {
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
  public static SchoolFragmentContainerBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (SchoolFragmentContainerBinding)bind(component, view, com.erookies.school.R.layout.school_fragment_container);
  }
}
