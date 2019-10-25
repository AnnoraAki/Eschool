package com.erookies.mine

import android.content.Context
import com.erookies.lib_common.extentions.marginHorizontal
import org.jetbrains.anko.*

/**
 * Create by Cchanges.
 * Time: 2019-10-25
 */
object DialogHelper {
    fun editDialog(context: Context, builder: DialogBuilder) {
         context.alert {
            customView {
                title = builder.title
                val edit = editText {
                    hint = builder.hint
                }.lparam()
                yesButton {
                    if (builder.check(edit.text.toString())) {
                        builder.todoEvent?.invoke(edit.text.toString())
                    } else {
                        builder.falseEvent?.invoke()
                    }
                }
                noButton {  }
            }
        }.show()
    }
}

class DialogBuilder {
    var title = ""
    var hint = ""
    var checkEvent: ((str: String) -> Boolean)? = null
    var todoEvent: ((str: String) -> Unit)? = null
    var falseEvent: (() -> Unit)? = null

    fun check(str: String): Boolean {
        return checkEvent?.invoke(str) ?: false
    }
}