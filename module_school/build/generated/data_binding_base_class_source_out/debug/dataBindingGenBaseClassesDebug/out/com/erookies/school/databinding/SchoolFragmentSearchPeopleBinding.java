package com.erookies.school.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.erookies.school.data.viewModel.SPViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class SchoolFragmentSearchPeopleBinding extends ViewDataBinding {
  @NonNull
  public final SwipeRefreshLayout schoolSearchPeopleRefresh;

  @Bindable
  protected SPViewModel mViewModel;

  protected SchoolFragmentSearchPeopleBinding(Object _bindingComponent, View _root,
      int _localFieldCount, SwipeRefreshLayout schoolSearchPeopleRefresh) {
    super(_bindingComponent, _root, _localFieldCount);
    this.schoolSearchPeopleRefresh = schoolSearchPeopleRefresh;
  }

  public abstract void setViewModel(@Nullable SPViewModel viewModel);

  @Nullable
  public SPViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static SchoolFragmentSearchPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.school_fragment_search_people, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static SchoolFragmentSearchPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<SchoolFragmentSearchPeopleBinding>inflateInternal(inflater, com.erookies.school.R.layout.school_fragment_search_people, root, attachToRoot, component);
  }

  @NonNull
  public static SchoolFragmentSearchPeopleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.school_fragment_search_people, null, false, component)
   */
  @NonNull
  @Deprecated
  public static SchoolFragmentSearchPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<SchoolFragmentSearchPeopleBinding>inflateInternal(inflater, com.erookies.school.R.layout.school_fragment_search_people, null, false, component);
  }

  public static SchoolFragmentSearchPeopleBinding bind(@NonNull View view) {
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
  public static SchoolFragmentSearchPeopleBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (SchoolFragmentSearchPeopleBinding)bind(component, view, com.erookies.school.R.layout.school_fragment_search_people);
  }
}
