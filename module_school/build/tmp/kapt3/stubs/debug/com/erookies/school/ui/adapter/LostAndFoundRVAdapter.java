package com.erookies.school.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/erookies/school/ui/adapter/LostAndFoundRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/erookies/school/ui/holder/LostAndFoundViewHolder;", "model", "Lcom/erookies/school/data/viewModel/LostAndFoundViewModel;", "(Lcom/erookies/school/data/viewModel/LostAndFoundViewModel;)V", "lostAndFoundItem", "", "Landroidx/lifecycle/MutableLiveData;", "Lcom/erookies/school/data/model/LostAndFoundItemData;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "module_school_debug"})
public final class LostAndFoundRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.erookies.school.ui.holder.LostAndFoundViewHolder> {
    private final java.util.List<androidx.lifecycle.MutableLiveData<com.erookies.school.data.model.LostAndFoundItemData>> lostAndFoundItem = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.erookies.school.ui.holder.LostAndFoundViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.erookies.school.ui.holder.LostAndFoundViewHolder holder, int position) {
    }
    
    public LostAndFoundRVAdapter(@org.jetbrains.annotations.NotNull()
    com.erookies.school.data.viewModel.LostAndFoundViewModel model) {
        super();
    }
}