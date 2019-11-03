package com.erookies.school.data.model;

import java.lang.System;

/**
 * Create by Koalak.
 * Time: 2019-10-21
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B3\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0002\u0010\u000fJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010%\u001a\u00020!H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006\'"}, d2 = {"Lcom/erookies/school/data/model/LostAndFoundItemData;", "Lcom/erookies/school/data/model/BaseItemData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "user", "Lcom/erookies/lib_common/User;", "content", "", "tag", "Lcom/erookies/school/data/model/Tag;", "picUrls", "", "Lcom/erookies/school/data/model/Picture;", "(Lcom/erookies/lib_common/User;Ljava/lang/String;Lcom/erookies/school/data/model/Tag;Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getPicUrls", "()Ljava/util/List;", "setPicUrls", "(Ljava/util/List;)V", "getTag", "()Lcom/erookies/school/data/model/Tag;", "setTag", "(Lcom/erookies/school/data/model/Tag;)V", "getUser", "()Lcom/erookies/lib_common/User;", "setUser", "(Lcom/erookies/lib_common/User;)V", "describeContents", "", "handle", "", "writeToParcel", "flags", "CREATOR", "module_school_debug"})
public final class LostAndFoundItemData extends com.erookies.school.data.model.BaseItemData implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private com.erookies.lib_common.User user;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String content;
    @org.jetbrains.annotations.NotNull()
    private com.erookies.school.data.model.Tag tag;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.erookies.school.data.model.Picture> picUrls;
    public static final com.erookies.school.data.model.LostAndFoundItemData.CREATOR CREATOR = null;
    
    @java.lang.Override()
    public void handle() {
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.erookies.lib_common.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    com.erookies.lib_common.User p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final void setContent(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.erookies.school.data.model.Tag getTag() {
        return null;
    }
    
    public final void setTag(@org.jetbrains.annotations.NotNull()
    com.erookies.school.data.model.Tag p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.erookies.school.data.model.Picture> getPicUrls() {
        return null;
    }
    
    public final void setPicUrls(@org.jetbrains.annotations.NotNull()
    java.util.List<com.erookies.school.data.model.Picture> p0) {
    }
    
    public LostAndFoundItemData(@org.jetbrains.annotations.NotNull()
    com.erookies.lib_common.User user, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    com.erookies.school.data.model.Tag tag, @org.jetbrains.annotations.NotNull()
    java.util.List<com.erookies.school.data.model.Picture> picUrls) {
        super();
    }
    
    public LostAndFoundItemData() {
        super();
    }
    
    public LostAndFoundItemData(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/erookies/school/data/model/LostAndFoundItemData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/erookies/school/data/model/LostAndFoundItemData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/erookies/school/data/model/LostAndFoundItemData;", "module_school_debug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<com.erookies.school.data.model.LostAndFoundItemData> {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.erookies.school.data.model.LostAndFoundItemData createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.erookies.school.data.model.LostAndFoundItemData[] newArray(int size) {
            return null;
        }
        
        private CREATOR() {
            super();
        }
    }
}