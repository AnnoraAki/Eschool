package com.erookies.school.data.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\u000e\u0010\u000bR&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00060\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000b\u00a8\u0006\u001e"}, d2 = {"Lcom/erookies/school/data/viewModel/SPViewModel;", "Lcom/erookies/lib_common/base/BaseViewModel;", "repository", "Lcom/erookies/school/data/repository/SearchPeopleRepository;", "(Lcom/erookies/school/data/repository/SearchPeopleRepository;)V", "currentUser", "Landroidx/lifecycle/MutableLiveData;", "Lcom/erookies/lib_common/bean/User;", "getCurrentUser", "()Landroidx/lifecycle/MutableLiveData;", "setCurrentUser", "(Landroidx/lifecycle/MutableLiveData;)V", "isRefresh", "", "setRefresh", "items", "", "Lcom/erookies/school/data/model/SearchPeopleItemData;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "userMutableList", "getUserMutableList", "setUserMutableList", "createTestData", "", "name", "", "content", "module_school_debug"})
public final class SPViewModel extends com.erookies.lib_common.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.erookies.lib_common.bean.User>> userMutableList;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.erookies.lib_common.bean.User> currentUser;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<androidx.lifecycle.MutableLiveData<com.erookies.school.data.model.SearchPeopleItemData>> items;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isRefresh;
    private final com.erookies.school.data.repository.SearchPeopleRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.erookies.lib_common.bean.User>> getUserMutableList() {
        return null;
    }
    
    public final void setUserMutableList(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.erookies.lib_common.bean.User>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.erookies.lib_common.bean.User> getCurrentUser() {
        return null;
    }
    
    public final void setCurrentUser(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.erookies.lib_common.bean.User> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.lifecycle.MutableLiveData<com.erookies.school.data.model.SearchPeopleItemData>> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.List<androidx.lifecycle.MutableLiveData<com.erookies.school.data.model.SearchPeopleItemData>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isRefresh() {
        return null;
    }
    
    public final void setRefresh(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    public final void createTestData(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void createTestData() {
    }
    
    public SPViewModel(@org.jetbrains.annotations.NotNull()
    com.erookies.school.data.repository.SearchPeopleRepository repository) {
        super();
    }
}