package com.erookies.school.utils

import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.databinding.BindingAdapter
import com.erookies.school.R
import org.jetbrains.anko.backgroundDrawable
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

fun Button.changeStyle(restore:Boolean){
    if (!restore){
        this.background = resources.getDrawable(R.drawable.school_tag_button_select_style,null)
    }else{
        this.background = resources.getDrawable(R.drawable.school_tag_button_not_select_style,null)
    }
}

fun restoreStyle(other:Button,buttons:MutableCollection<Button>){
    other.changeStyle(false)
    for (btn in buttons){
        btn.changeStyle(true)
    }
}

fun hideButton(buttons: MutableCollection<Button>){
    for (btn in buttons){
        btn.visibility = View.GONE
    }
}