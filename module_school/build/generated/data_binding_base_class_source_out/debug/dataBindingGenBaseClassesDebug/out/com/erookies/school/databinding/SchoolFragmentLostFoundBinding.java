package com.erookies.school.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.erookies.school.data.viewModel.LostAndFoundViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class SchoolFragmentLostFoundBinding extends ViewDataBinding {
  @NonNull
  public final Button schoolDailyGoodsButton;

  @NonNull
  public final Button schoolDigitalButton;

  @NonNull
  public final Button schoolIdCardButton;

  @NonNull
  public final SwipeRefreshLayout schoolLandfRefreshLayout;

  @NonNull
  public final Button schoolOthersButton;

  @Bindable
  protected LostAndFoundViewModel mViewModel;

  protected SchoolFragmentLostFoundBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Button schoolDailyGoodsButton, Button schoolDigitalButton,
      Button schoolIdCardButton, SwipeRefreshLayout schoolLandfRefreshLayout,
      Button schoolOthersButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.schoolDailyGoodsButton = schoolDailyGoodsButton;
    this.schoolDigitalButton = schoolDigitalButton;
    this.schoolIdCardButton = schoolIdCardButton;
    this.schoolLandfRefreshLayout = schoolLandfRefreshLayout;
    this.schoolOthersButton = schoolOthersButton;
  }

  public abstract void setViewModel(@Nullable LostAndFoundViewModel viewModel);

  @Nullable
  public LostAndFoundViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static SchoolFragmentLostFoundBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.school_fragment_lost_found, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SchoolFragmentLostFoundBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SchoolFragmentLostFoundBinding>inflateInternal(inflater, com.erookies.school.R.layout.school_fragment_lost_found, root, attachToRoot, component);
  }

  @NonNull
  public static SchoolFragmentLostFoundBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.school_fragment_lost_found, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SchoolFragmentLostFoundBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SchoolFragmentLostFoundBinding>inflateInternal(inflater, com.erookies.school.R.layout.school_fragment_lost_found, null, false, component);
  }

  public static SchoolFragmentLostFoundBinding bind(@NonNull View view) {
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
  public static SchoolFragmentLostFoundBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (SchoolFragmentLostFoundBinding)bind(component, view, com.erookies.school.R.layout.school_fragment_lost_found);
  }
}
