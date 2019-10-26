package com.erookies.school.databinding;
import com.erookies.school.R;
import com.erookies.school.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class SchoolFragmentSearchPeopleBindingImpl extends SchoolFragmentSearchPeopleBinding implements com.erookies.school.generated.callback.OnRefreshListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    @Nullable
    private final androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public SchoolFragmentSearchPeopleBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 1, sIncludes, sViewsWithIds));
    }
    private SchoolFragmentSearchPeopleBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) bindings[0]
            );
        this.schoolSearchPeopleRefresh.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.erookies.school.generated.callback.OnRefreshListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.erookies.school.data.viewModel.SPViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.erookies.school.data.viewModel.SPViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelIsRefresh((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsRefresh(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelIsRefresh, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.Boolean viewModelIsRefreshGetValue = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsRefreshGetValue = false;
        com.erookies.school.data.viewModel.SPViewModel viewModel = mViewModel;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsRefresh = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.isRefresh
                    viewModelIsRefresh = viewModel.isRefresh();
                }
                updateLiveDataRegistration(0, viewModelIsRefresh);


                if (viewModelIsRefresh != null) {
                    // read viewModel.isRefresh.getValue()
                    viewModelIsRefreshGetValue = viewModelIsRefresh.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.isRefresh.getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelIsRefreshGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIsRefreshGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.schoolSearchPeopleRefresh.setRefreshing(androidxDatabindingViewDataBindingSafeUnboxViewModelIsRefreshGetValue);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.schoolSearchPeopleRefresh.setOnRefreshListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnRefresh(int sourceId ) {
        // localize variables for thread safety
        // viewModel
        com.erookies.school.data.viewModel.SPViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.createTestData();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isRefresh
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}