package com.erookies.school.databinding;
import com.erookies.school.R;
import com.erookies.school.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class SchoolFragmentLostFoundBindingImpl extends SchoolFragmentLostFoundBinding implements com.erookies.school.generated.callback.OnRefreshListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.school_id_card_button, 2);
        sViewsWithIds.put(R.id.school_digital_button, 3);
        sViewsWithIds.put(R.id.school_daily_goods_button, 4);
        sViewsWithIds.put(R.id.school_others_button, 5);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    @Nullable
    private final androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public SchoolFragmentLostFoundBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private SchoolFragmentLostFoundBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[4]
            , (android.widget.Button) bindings[3]
            , (android.widget.Button) bindings[2]
            , (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) bindings[0]
            , (android.widget.Button) bindings[5]
            );
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.schoolLandfRefreshLayout.setTag(null);
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
            setViewModel((com.erookies.school.data.viewModel.LostAndFoundViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.erookies.school.data.viewModel.LostAndFoundViewModel ViewModel) {
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
                return onChangeViewModelIsRefreshing((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsRefreshing(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelIsRefreshing, int fieldId) {
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
        java.lang.Boolean viewModelIsRefreshingGetValue = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsRefreshingGetValue = false;
        com.erookies.school.data.viewModel.LostAndFoundViewModel viewModel = mViewModel;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsRefreshing = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.isRefreshing
                    viewModelIsRefreshing = viewModel.isRefreshing();
                }
                updateLiveDataRegistration(0, viewModelIsRefreshing);


                if (viewModelIsRefreshing != null) {
                    // read viewModel.isRefreshing.getValue()
                    viewModelIsRefreshingGetValue = viewModelIsRefreshing.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.isRefreshing.getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelIsRefreshingGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIsRefreshingGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.schoolLandfRefreshLayout.setRefreshing(androidxDatabindingViewDataBindingSafeUnboxViewModelIsRefreshingGetValue);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.schoolLandfRefreshLayout.setOnRefreshListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnRefresh(int sourceId ) {
        // localize variables for thread safety
        // viewModel
        com.erookies.school.data.viewModel.LostAndFoundViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.getItemDataList();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isRefreshing
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}