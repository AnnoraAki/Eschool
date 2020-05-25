package com.erookies.module_im.util

import android.view.View
import android.view.ViewGroup

fun View.updateMarginLayout(left:Int, top:Int, right:Int, bottom:Int)  {
    val lp : ViewGroup.LayoutParams? = layoutParams
    lp ?: return
    if (lp is ViewGroup.MarginLayoutParams) {
        val margin = lp as ViewGroup.MarginLayoutParams
        margin.leftMargin = left
        margin.topMargin = top
        margin.rightMargin = right
        margin.bottomMargin = bottom
        layoutParams = margin
    }
}