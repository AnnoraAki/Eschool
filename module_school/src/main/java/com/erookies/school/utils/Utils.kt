package com.erookies.school.utils

import android.graphics.Color
import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.databinding.BindingAdapter
import com.erookies.school.R
import org.jetbrains.anko.textColor

fun TextView.change(need: Boolean) {
    val tp = this.paint
    if (need){
        this.textColor = Color.parseColor("#E6000000")
        tp.isFakeBoldText = true
    }else{
        this.textColor = Color.parseColor("#99000000")
        tp.isFakeBoldText = false
    }
}