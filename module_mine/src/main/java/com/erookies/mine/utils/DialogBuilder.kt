package com.erookies.mine.utils

/**
 * Create by Cchanges.
 * Time: 2019-10-26
 */
class DialogBuilder {
    var title = ""
    var hint = ""
    var checkEvent: ((str: String) -> Boolean)? = null
    var todoEvent: ((str: String) -> Unit)? = null
    var falseEvent: (() -> Unit)? = null
    var isPwd = false

    fun check(str: String): Boolean {
        return checkEvent?.invoke(str) ?: true
    }
}
