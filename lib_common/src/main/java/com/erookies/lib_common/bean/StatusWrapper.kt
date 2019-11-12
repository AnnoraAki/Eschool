package com.erookies.lib_common.bean

import java.io.Serializable

/**
 * Create by Cchanges.
 * Time: 2019-11-11
 */
open class StatusBean : Serializable {
    var code: Int = 0
    var msg: String = ""
}

/**
 * 当返回的接口json中有data字段时使用此接口
 */
class StatusWrapper<T>(val data: T) : StatusBean()