package com.erookies.lib_common.extentions

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.erookies.lib_common.utils.dip2px

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
        this.layoutParams = p
    }
}

fun RecyclerView.ViewHolder.toast(chars: CharSequence) {
    Toast.makeText(itemView.context, chars, Toast.LENGTH_SHORT).show()
}

fun Int.dp(): Int = dip2px(this)

fun Float.dp(): Int = (this + 0.5f).dp()