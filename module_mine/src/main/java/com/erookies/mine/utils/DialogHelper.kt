package com.erookies.mine.utils

import android.content.Context
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.ViewGroup
import android.widget.EditText
import org.jetbrains.anko.*


/**
 * Create by Cchanges.
 * Time: 2019-10-25
 */
object DialogHelper {
    fun editDialog(context: Context, builder: DialogBuilder) {
        context.alert {
            customView {
                lateinit var edit: EditText
                linearLayout {
                    title = builder.title
                    edit = editText {
                        hint = builder.hint
                        maxLines = 1
                        inputType =
                            if (builder.isPwd) InputType.TYPE_TEXT_VARIATION_PASSWORD else InputType.TYPE_CLASS_TEXT
                        if (builder.isPwd) transformationMethod = PasswordTransformationMethod()
                    }.lparams(width = ViewGroup.LayoutParams.MATCH_PARENT) {
                        horizontalMargin = dip(8)
                        topMargin = dip(8)
                    }
                }
                yesButton {
                    if (builder.check(edit.text.toString())) {
                        builder.todoEvent?.invoke(edit.text.toString())
                    } else {
                        builder.falseEvent?.invoke()
                    }
                }
                noButton { }
            }
        }.show()
    }

    fun toastDialog(context: Context, builder: DialogBuilder) {
        context.alert {
            title = builder.title
            message = builder.hint
            yesButton {
                if (builder.check("")) {
                    builder.todoEvent?.invoke("")
                } else {
                    builder.falseEvent?.invoke()
                }
            }
            noButton { }
        }.show()
    }
}

