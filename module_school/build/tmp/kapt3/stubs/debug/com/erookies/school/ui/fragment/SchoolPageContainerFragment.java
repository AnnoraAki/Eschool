package com.erookies.school.ui.fragment;

import java.lang.System;

@com.alibaba.android.arouter.facade.annotation.Route(path = "/school/entry")
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0007J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u001cH\u0002J\u0006\u0010%\u001a\u00020\u001cJ\b\u0010&\u001a\u00020\u001cH\u0002J\u0012\u0010\'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010)2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00064"}, d2 = {"Lcom/erookies/school/ui/fragment/SchoolPageContainerFragment;", "Lcom/erookies/lib_common/base/BaseFragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/erookies/school/databinding/SchoolFragmentContainerBinding;", "fragments", "", "Landroidx/fragment/app/Fragment;", "getFragments", "()Ljava/util/List;", "lfTextButton", "Landroid/widget/TextView;", "getLfTextButton", "()Landroid/widget/TextView;", "spTextButton", "getSpTextButton", "viewModel", "Lcom/erookies/school/data/viewModel/SchoolPageContainerViewModel;", "getViewModel", "()Lcom/erookies/school/data/viewModel/SchoolPageContainerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "changeButtonStatus", "", "bool", "", "clickMenu", "event", "Lcom/erookies/lib_common/event/ClickMenuEvent;", "getFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "init", "initConstants", "observe", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "module_school_debug"})
public final class SchoolPageContainerFragment extends com.erookies.lib_common.base.BaseFragment implements android.view.View.OnClickListener {
    private com.erookies.school.databinding.SchoolFragmentContainerBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<androidx.fragment.app.Fragment> fragments = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    private final android.widget.TextView getSpTextButton() {
        return null;
    }
    
    private final android.widget.TextView getLfTextButton() {
        return null;
    }
    
    private final androidx.viewpager.widget.ViewPager getViewPager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.fragment.app.Fragment> getFragments() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModelProvider.Factory getFactory() {
        return null;
    }
    
    private final com.erookies.school.data.viewModel.SchoolPageContainerViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    private final void changeButtonStatus(boolean bool) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void clickMenu(@org.jetbrains.annotations.NotNull()
    com.erookies.lib_common.event.ClickMenuEvent event) {
    }
    
    public final void initConstants() {
    }
    
    public SchoolPageContainerFragment() {
        super();
    }
}