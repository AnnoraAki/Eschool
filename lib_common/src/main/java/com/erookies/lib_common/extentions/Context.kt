package com.erookies.lib_common.extentions

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Point
import android.view.WindowManager
import android.widget.Toast

/**
 * Create by Cchanges.
 * Time: 2019-10-08
 */
var screenHeight = 0
var screenWeight = 0

fun Context.getScreenHeight(): Int {
    if (screenHeight == 0) {
        val wm = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        screenHeight = size.y
    }
    return screenHeight
}

fun Context.getScreenWeight(): Int {
    if (screenWeight == 0) {
        val wm = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        screenWeight = size.x
    }
    return screenWeight
}

fun Context.toast(str: String) {
    Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
}

fun Context.longToast(str: String) {
    Toast.makeText(this, str, Toast.LENGTH_LONG).show()
}