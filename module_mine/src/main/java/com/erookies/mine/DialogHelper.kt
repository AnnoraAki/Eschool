package com.erookies.mine

import android.content.Context
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
                        hint = builder.editHint
                        maxLines = 1
                    }.lparams(width = ViewGroup.LayoutParams.MATCH_PARENT) {
                        horizontalMargin = dip(8)
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
}

class DialogBuilder {
    var title = ""
    var editHint = ""
    var checkEvent: ((str: String) -> Boolean)? = null
    var todoEvent: ((str: String) -> Unit)? = null
    var falseEvent: (() -> Unit)? = null

    fun check(str: String): Boolean {
        return checkEvent?.invoke(str) ?: false
    }
}
