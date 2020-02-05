package com.erookies.lib_common.config

/**
 * Create by Cchanges.
 * Time: 2019-10-11
 *
 * 路由表命名规则：
 * <ul>
 *     <li>常量名（全大写）：模块名_功能描述，例：MAIN_ENTRY</li>
 *     <li>二级路由：/模块名/功能描述，例：/main/entry</li>
 *     <li>多级路由：/模块依赖关系倒置/功能描述，例：/user/main/entry</li>
 * </ul>
 */
const val MINE_ENTRY = "/mine/entry"
const val MINE_LOGIN = "/mine/login"

const val SCHOOL_ENTRY = "/school/entry"
const val SCHOOL_LOST_FOUND = "/user/school/lost"
const val SCHOOL_SEARCH_PEOPLE = "/user/school/search"
const val SCHOOL_DETAIL = "/school/detail"
const val SCHOOL_PUBLISH = "/school/publish"

const val IM_ENTRY = "/im/entry"

const val ADD_ENTRY = "/add/entry"