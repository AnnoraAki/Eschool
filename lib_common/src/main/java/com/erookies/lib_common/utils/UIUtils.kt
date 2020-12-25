package com.erookies.lib_common.utils

import android.view.View
import android.view.ViewGroup
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.extentions.dp

private val context = BaseApp.context

fun dip2px(dpValue: Int): Int {
    val scale = context.resources.displayMetrics.density;
    return  (dpValue * scale + 0.5f).toInt()
}

fun getStatusBarHeight(): Int {
    var result = 0
    val resourceId: Int = context.resources.getIdentifier("status_bar_height", "dimen", "android")
    result = if (resourceId > 0) {
        context.resources.getDimensionPixelSize(resourceId)
    } else {
        //默认算20dp
        dip2px(20)
    }
    return result
}

fun getAttrValue(attrName: Int): Int {
    val attrs = intArrayOf(attrName)
    val typedArray = context.obtainStyledAttributes(attrs)
    //默认值56dp
    val result = typedArray.getDimensionPixelSize(0, 56.dp())
    typedArray.recycle()
    return result
}

fun View.updateMarginLayout(left:Int, top:Int, right:Int, bottom:Int)  {
    val lp : ViewGroup.LayoutParams = layoutParams
    if (lp is ViewGroup.MarginLayoutParams) {
        val margin = lp as ViewGroup.MarginLayoutParams
        margin.leftMargin += left
        margin.topMargin += top
        margin.rightMargin += right
        margin.bottomMargin += bottom
        layoutParams = margin
    }
}