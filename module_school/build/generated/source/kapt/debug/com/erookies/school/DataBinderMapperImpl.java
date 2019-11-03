package com.erookies.school;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.erookies.school.databinding.SchoolActivityDetailBindingImpl;
import com.erookies.school.databinding.SchoolActivityMainBindingImpl;
import com.erookies.school.databinding.SchoolFragmentContainerBindingImpl;
import com.erookies.school.databinding.SchoolFragmentLostFoundBindingImpl;
import com.erookies.school.databinding.SchoolFragmentSearchPeopleBindingImpl;
import com.erookies.school.databinding.SchoolItemLostFoundBindingImpl;
import com.erookies.school.databinding.SchoolItemSearchPeopleBindingImpl;
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
  private static final int LAYOUT_SCHOOLACTIVITYDETAIL = 1;

  private static final int LAYOUT_SCHOOLACTIVITYMAIN = 2;

  private static final int LAYOUT_SCHOOLFRAGMENTCONTAINER = 3;

  private static final int LAYOUT_SCHOOLFRAGMENTLOSTFOUND = 4;

  private static final int LAYOUT_SCHOOLFRAGMENTSEARCHPEOPLE = 5;

  private static final int LAYOUT_SCHOOLITEMLOSTFOUND = 6;

  private static final int LAYOUT_SCHOOLITEMSEARCHPEOPLE = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.erookies.school.R.layout.school_activity_detail, LAYOUT_SCHOOLACTIVITYDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.erookies.school.R.layout.school_activity_main, LAYOUT_SCHOOLACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.erookies.school.R.layout.school_fragment_container, LAYOUT_SCHOOLFRAGMENTCONTAINER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.erookies.school.R.layout.school_fragment_lost_found, LAYOUT_SCHOOLFRAGMENTLOSTFOUND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.erookies.school.R.layout.school_fragment_search_people, LAYOUT_SCHOOLFRAGMENTSEARCHPEOPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.erookies.school.R.layout.school_item_lost_found, LAYOUT_SCHOOLITEMLOSTFOUND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.erookies.school.R.layout.school_item_search_people, LAYOUT_SCHOOLITEMSEARCHPEOPLE);
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
        case  LAYOUT_SCHOOLACTIVITYDETAIL: {
          if ("layout/school_activity_detail_0".equals(tag)) {
            return new SchoolActivityDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for school_activity_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_SCHOOLACTIVITYMAIN: {
          if ("layout/school_activity_main_0".equals(tag)) {
            return new SchoolActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for school_activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_SCHOOLFRAGMENTCONTAINER: {
          if ("layout/school_fragment_container_0".equals(tag)) {
            return new SchoolFragmentContainerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for school_fragment_container is invalid. Received: " + tag);
        }
        case  LAYOUT_SCHOOLFRAGMENTLOSTFOUND: {
          if ("layout/school_fragment_lost_found_0".equals(tag)) {
            return new SchoolFragmentLostFoundBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for school_fragment_lost_found is invalid. Received: " + tag);
        }
        case  LAYOUT_SCHOOLFRAGMENTSEARCHPEOPLE: {
          if ("layout/school_fragment_search_people_0".equals(tag)) {
            return new SchoolFragmentSearchPeopleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for school_fragment_search_people is invalid. Received: " + tag);
        }
        case  LAYOUT_SCHOOLITEMLOSTFOUND: {
          if ("layout/school_item_lost_found_0".equals(tag)) {
            return new SchoolItemLostFoundBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for school_item_lost_found is invalid. Received: " + tag);
        }
        case  LAYOUT_SCHOOLITEMSEARCHPEOPLE: {
          if ("layout/school_item_search_people_0".equals(tag)) {
            return new SchoolItemSearchPeopleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for school_item_search_people is invalid. Received: " + tag);
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
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "item");
      sKeys.put(2, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/school_activity_detail_0", com.erookies.school.R.layout.school_activity_detail);
      sKeys.put("layout/school_activity_main_0", com.erookies.school.R.layout.school_activity_main);
      sKeys.put("layout/school_fragment_container_0", com.erookies.school.R.layout.school_fragment_container);
      sKeys.put("layout/school_fragment_lost_found_0", com.erookies.school.R.layout.school_fragment_lost_found);
      sKeys.put("layout/school_fragment_search_people_0", com.erookies.school.R.layout.school_fragment_search_people);
      sKeys.put("layout/school_item_lost_found_0", com.erookies.school.R.layout.school_item_lost_found);
      sKeys.put("layout/school_item_search_people_0", com.erookies.school.R.layout.school_item_search_people);
    }
  }
}
