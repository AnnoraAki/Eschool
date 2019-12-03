package com.erookies.school.utils

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.erookies.lib_common.base.BaseFragment
import com.erookies.school.R
import com.erookies.school.data.model.Tag
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
        this.textColor = Color.parseColor("#ffffff")
        this.background = resources.getDrawable(R.drawable.school_tag_button_select_style,null)
    }else{
        this.textColor = Color.parseColor("#000000")
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

fun BaseFragment.toast(meesage:CharSequence){
    Toast.makeText(this.context,meesage,Toast.LENGTH_SHORT).show()
}

fun IntParseToTag(type:Int):Tag{
    return when(type){
        0 -> Tag.SP
        1 -> Tag.CARD
        2 -> Tag.DIGITAL
        3 -> Tag.COMMODITY
        else -> Tag.OTHER
    }
}

fun TagParseToInt(tag:Tag):Int{
    return when(tag){
        Tag.SP -> 0
        Tag.DIGITAL -> 2
        Tag.COMMODITY -> 3
        Tag.CARD -> 1
        else -> 4
    }
}

