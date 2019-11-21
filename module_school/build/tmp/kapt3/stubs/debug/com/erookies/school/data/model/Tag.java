package com.erookies.school.data.model;

import java.lang.System;

@kotlinx.android.parcel.Parcelize()
@android.annotation.SuppressLint(value = {"ParcelCreator"})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u00d6\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/erookies/school/data/model/Tag;", "", "Landroid/os/Parcelable;", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CARD", "DIGITAL", "COMMODITY", "SP", "OTHER", "module_school_debug"})
public enum Tag implements android.os.Parcelable {
    /*public static final*/ CARD /* = new CARD(null) */,
    /*public static final*/ DIGITAL /* = new DIGITAL(null) */,
    /*public static final*/ COMMODITY /* = new COMMODITY(null) */,
    /*public static final*/ SP /* = new SP(null) */,
    /*public static final*/ OTHER /* = new OTHER(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tag = null;
    public static final android.os.Parcelable.Creator CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTag() {
        return null;
    }
    
    Tag(java.lang.String tag) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Object[] newArray(int size) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Object createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
    }
}