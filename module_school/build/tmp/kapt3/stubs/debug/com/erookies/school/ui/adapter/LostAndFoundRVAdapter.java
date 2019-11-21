package com.erookies.school.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0016\u0010\u0015\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/erookies/school/ui/adapter/LostAndFoundRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/erookies/school/ui/holder/LostAndFoundViewHolder;", "model", "Lcom/erookies/school/data/viewModel/LostAndFoundViewModel;", "(Lcom/erookies/school/data/viewModel/LostAndFoundViewModel;)V", "lostAndFoundItem", "", "Lcom/erookies/school/data/model/ItemData;", "dataChanged", "", "list", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateItem", "module_school_debug"})
public final class LostAndFoundRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.erookies.school.ui.holder.LostAndFoundViewHolder> {
    private final java.util.List<com.erookies.school.data.model.ItemData> lostAndFoundItem = null;
    
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
    
    private final void updateItem(java.util.List<com.erookies.school.data.model.ItemData> list) {
    }
    
    public final void dataChanged(@org.jetbrains.annotations.Nullable()
    java.util.List<com.erookies.school.data.model.ItemData> list) {
    }
    
    public LostAndFoundRVAdapter(@org.jetbrains.annotations.NotNull()
    com.erookies.school.data.viewModel.LostAndFoundViewModel model) {
        super();
    }
}