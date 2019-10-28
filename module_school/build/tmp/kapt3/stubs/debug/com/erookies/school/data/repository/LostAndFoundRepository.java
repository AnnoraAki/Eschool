package com.erookies.school.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/erookies/school/data/repository/LostAndFoundRepository;", "", "()V", "hasCached", "", "loadItemDetailInfo", "Lcom/erookies/school/data/model/LostAndFoundItemData;", "id", "", "loadItemList", "", "type", "", "Companion", "LoadType", "module_school_debug"})
public final class LostAndFoundRepository {
    
    /**
     * 如果已加载过数据则值置为 true
     */
    private boolean hasCached;
    public static final int DATA_FROM_USER = 0;
    public static final int DATA_FROM_OTHER = 1;
    private static com.erookies.school.data.repository.LostAndFoundRepository INSTANCE;
    public static final com.erookies.school.data.repository.LostAndFoundRepository.Companion Companion = null;
    
    /**
     * @param type 标识加载的是用户发布的失物招领信息还是所有人发布的失物招领信息
     * @return 失物招领信息的列表
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.erookies.school.data.model.LostAndFoundItemData> loadItemList(@com.erookies.school.data.repository.LostAndFoundRepository.LoadType()
    int type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.erookies.school.data.model.LostAndFoundItemData loadItemDetailInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    private LostAndFoundRepository() {
        super();
    }
    
    @androidx.annotation.IntDef(value = {1, 0})
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/erookies/school/data/repository/LostAndFoundRepository$LoadType;", "", "module_school_debug"})
    @java.lang.annotation.Target(value = {java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.PARAMETER})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
    @kotlin.annotation.Target(allowedTargets = {kotlin.annotation.AnnotationTarget.PROPERTY, kotlin.annotation.AnnotationTarget.FIELD, kotlin.annotation.AnnotationTarget.VALUE_PARAMETER})
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.SOURCE)
    public static abstract @interface LoadType {
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/erookies/school/data/repository/LostAndFoundRepository$Companion;", "", "()V", "DATA_FROM_OTHER", "", "DATA_FROM_USER", "INSTANCE", "Lcom/erookies/school/data/repository/LostAndFoundRepository;", "getInstance", "module_school_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.erookies.school.data.repository.LostAndFoundRepository getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}