package com.erookies.lib_common.extentions

import android.view.View
import android.view.ViewGroup

/**
 * Create by Cchanges.
 * Time: 2019-10-11
 */
fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.marginAll(a: Int) {
    margin(a, a, a, a)
}

fun View.marginVertical(value: Int) {
    margin(0, value, 0, value)
}

fun View.marginHorizontal(value: Int) {
    margin(value, 0, value, 0)
}

fun View.margin(l: Int, t: Int, r: Int, b: Int) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.setMargins(l, t, r, b)
        this.requestLayout()
    }
}