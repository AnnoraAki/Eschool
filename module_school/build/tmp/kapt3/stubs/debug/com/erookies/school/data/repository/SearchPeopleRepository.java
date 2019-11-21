package com.erookies.school.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JM\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00040\b2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00040\bH\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/erookies/school/data/repository/SearchPeopleRepository;", "", "()V", "loadItemList", "", "type", "", "opreation", "Lkotlin/Function1;", "", "Lcom/erookies/school/data/model/ItemData;", "error", "", "Lkotlin/ParameterName;", "name", "message", "Companion", "module_school_debug"})
public final class SearchPeopleRepository {
    private static com.erookies.school.data.repository.SearchPeopleRepository INSTANCE;
    public static final com.erookies.school.data.repository.SearchPeopleRepository.Companion Companion = null;
    
    /**
     * @param type 标识加载的是用户发布的失物招领信息还是所有人发布的失物招领信息
     * @return 失物招领信息的列表
     */
    @android.annotation.SuppressLint(value = {"CheckResult"})
    public final void loadItemList(@com.erookies.school.data.repository.LostAndFoundRepository.LoadType()
    int type, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.erookies.school.data.model.ItemData>, kotlin.Unit> opreation, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> error) {
    }
    
    private SearchPeopleRepository() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/erookies/school/data/repository/SearchPeopleRepository$Companion;", "", "()V", "INSTANCE", "Lcom/erookies/school/data/repository/SearchPeopleRepository;", "getInstance", "module_school_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.erookies.school.data.repository.SearchPeopleRepository getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}