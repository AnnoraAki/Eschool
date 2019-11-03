package com.erookies.school.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0014B\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u000f\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/erookies/school/data/model/Tag;", "", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Ljava/lang/String;ILandroid/os/Parcel;)V", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "flags", "CARD", "DIGITAL", "COMMODITY", "OTHER", "CREATOR", "module_school_debug"})
public enum Tag implements android.os.Parcelable {
    /*public static final*/ CARD /* = new CARD(null) */,
    /*public static final*/ DIGITAL /* = new DIGITAL(null) */,
    /*public static final*/ COMMODITY /* = new COMMODITY(null) */,
    /*public static final*/ OTHER /* = new OTHER(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tag = null;
    public static final com.erookies.school.data.model.Tag.CREATOR CREATOR = null;
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTag() {
        return null;
    }
    
    Tag(java.lang.String tag) {
    }
    
    Tag(android.os.Parcel parcel) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/erookies/school/data/model/Tag$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/erookies/school/data/model/Tag;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/erookies/school/data/model/Tag;", "module_school_debug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<com.erookies.school.data.model.Tag> {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.erookies.school.data.model.Tag createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.erookies.school.data.model.Tag[] newArray(int size) {
            return null;
        }
        
        private CREATOR() {
            super();
        }
    }
}