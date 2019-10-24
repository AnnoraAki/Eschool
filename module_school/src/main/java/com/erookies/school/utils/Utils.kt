package com.erookies.school.utils

import android.widget.Button
import androidx.annotation.ColorInt
import com.erookies.school.R
import org.jetbrains.anko.textColor

fun Button.changeTextSizeAndColor(@ColorInt colorInt: Int,size:Float) {
    this.textColor = colorInt
    this.textSize = size
}