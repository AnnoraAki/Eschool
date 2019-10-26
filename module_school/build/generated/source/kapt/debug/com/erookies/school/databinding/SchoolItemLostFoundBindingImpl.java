package com.erookies.school.databinding;
import com.erookies.school.R;
import com.erookies.school.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class SchoolItemLostFoundBindingImpl extends SchoolItemLostFoundBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.school_item_user_avatar, 4);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public SchoolItemLostFoundBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private SchoolItemLostFoundBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.Button) bindings[2]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[4]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.schoolItemContent.setTag(null);
        this.schoolItemTagButton.setTag(null);
        this.schoolItemUserName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.item == variableId) {
            setItem((com.erookies.school.data.model.LostAndFoundItemData) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.erookies.school.data.model.LostAndFoundItemData Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        java.lang.String itemTagTag = null;
        com.erookies.school.data.model.Tag itemTag = null;
        com.erookies.school.data.model.LostAndFoundItemData item = mItem;
        java.lang.String itemContent = null;
        java.lang.String itemUserUsername = null;
        com.erookies.lib_common.User itemUser = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.tag
                    itemTag = item.getTag();
                    // read item.content
                    itemContent = item.getContent();
                    // read item.user
                    itemUser = item.getUser();
                }


                if (itemTag != null) {
                    // read item.tag.tag
                    itemTagTag = itemTag.getTag();
                }
                if (itemUser != null) {
                    // read item.user.username
                    itemUserUsername = itemUser.getUsername();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.schoolItemContent, itemContent);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.schoolItemTagButton, itemTagTag);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.schoolItemUserName, itemUserUsername);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}