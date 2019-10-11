package com.erookies.lib_common.extentions

import android.content.Context
import android.content.SharedPreferences
import com.erookies.lib_common.config.DEFAULT_PREFERENCE_FILENAME

/**
 * Create by Cchanges.
 * Time: 2019-10-11
 */
val Context.defaultSharedPreferences get() = sharedPreferences(DEFAULT_PREFERENCE_FILENAME)

fun Context.sharedPreferences(name: String): SharedPreferences = getSharedPreferences(name, Context.MODE_PRIVATE)
fun SharedPreferences.editor(editorBuilder: SharedPreferences.Editor.() -> Unit) = edit().apply(editorBuilder).apply()