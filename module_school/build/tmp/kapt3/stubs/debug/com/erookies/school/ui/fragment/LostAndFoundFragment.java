package com.erookies.school.ui.fragment;

import java.lang.System;

/**
 * Create by Koalak.
 * Time: 2019-10-20
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\u0012\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010\'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/erookies/school/ui/fragment/LostAndFoundFragment;", "Lcom/erookies/lib_common/base/BaseFragment;", "Landroid/view/View$OnClickListener;", "()V", "adapter", "Lcom/erookies/school/ui/adapter/LostAndFoundRVAdapter;", "binding", "Lcom/erookies/school/databinding/SchoolFragmentLostFoundBinding;", "buttons", "Ljava/util/HashMap;", "", "Landroid/widget/Button;", "cardButton", "getCardButton", "()Landroid/widget/Button;", "dailyButton", "getDailyButton", "digitalButton", "getDigitalButton", "othersButton", "getOthersButton", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getSwipeRefreshLayout", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "viewModel", "Lcom/erookies/school/data/viewModel/LostAndFoundViewModel;", "getFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "init", "", "observe", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "module_school_debug"})
public final class LostAndFoundFragment extends com.erookies.lib_common.base.BaseFragment implements android.view.View.OnClickListener {
    private com.erookies.school.data.viewModel.LostAndFoundViewModel viewModel;
    private com.erookies.school.databinding.SchoolFragmentLostFoundBinding binding;
    private final java.util.HashMap<java.lang.String, android.widget.Button> buttons = null;
    private com.erookies.school.ui.adapter.LostAndFoundRVAdapter adapter;
    private java.util.HashMap _$_findViewCache;
    
    private final android.widget.Button getCardButton() {
        return null;
    }
    
    private final android.widget.Button getDigitalButton() {
        return null;
    }
    
    private final android.widget.Button getDailyButton() {
        return null;
    }
    
    private final android.widget.Button getOthersButton() {
        return null;
    }
    
    private final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    private final androidx.swiperefreshlayout.widget.SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void init() {
    }
    
    private final void observe() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModelProvider.Factory getFactory() {
        return null;
    }
    
    public LostAndFoundFragment() {
        super();
    }
}