package com.erookies.school.data.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0012\u0010\u000bR&\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00060\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00140\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000b\u00a8\u0006\""}, d2 = {"Lcom/erookies/school/data/viewModel/LostAndFoundViewModel;", "Lcom/erookies/lib_common/base/BaseViewModel;", "repository", "Lcom/erookies/school/data/repository/LostAndFoundRepository;", "(Lcom/erookies/school/data/repository/LostAndFoundRepository;)V", "currentTag", "Landroidx/lifecycle/MutableLiveData;", "Lcom/erookies/school/data/model/Tag;", "getCurrentTag", "()Landroidx/lifecycle/MutableLiveData;", "setCurrentTag", "(Landroidx/lifecycle/MutableLiveData;)V", "currentUser", "Lcom/erookies/lib_common/bean/User;", "getCurrentUser", "setCurrentUser", "isRefreshing", "", "setRefreshing", "items", "", "Lcom/erookies/school/data/model/LostAndFoundItemData;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "users", "getUsers", "setUsers", "createTestData", "", "name", "", "content", "module_school_debug"})
public final class LostAndFoundViewModel extends com.erookies.lib_common.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.erookies.lib_common.bean.User>> users;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.erookies.lib_common.bean.User> currentUser;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<androidx.lifecycle.MutableLiveData<com.erookies.school.data.model.LostAndFoundItemData>> items;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.erookies.school.data.model.Tag> currentTag;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isRefreshing;
    private final com.erookies.school.data.repository.LostAndFoundRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.erookies.lib_common.bean.User>> getUsers() {
        return null;
    }
    
    public final void setUsers(@org.jetbrains.annotations.NotNull()
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
    public final java.util.List<androidx.lifecycle.MutableLiveData<com.erookies.school.data.model.LostAndFoundItemData>> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.List<androidx.lifecycle.MutableLiveData<com.erookies.school.data.model.LostAndFoundItemData>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.erookies.school.data.model.Tag> getCurrentTag() {
        return null;
    }
    
    public final void setCurrentTag(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.erookies.school.data.model.Tag> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isRefreshing() {
        return null;
    }
    
    public final void setRefreshing(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    public final void createTestData(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void createTestData() {
    }
    
    public LostAndFoundViewModel(@org.jetbrains.annotations.NotNull()
    com.erookies.school.data.repository.LostAndFoundRepository repository) {
        super();
    }
}