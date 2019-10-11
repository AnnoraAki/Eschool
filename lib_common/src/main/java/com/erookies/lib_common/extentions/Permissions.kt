package com.erookies.lib_common.extentions

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tbruyelle.rxpermissions2.RxPermissions
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton


/**
 * Create by Cchanges.
 * Time: 2019-10-11
 * 简化权限请求操作
 */

class PermissionsActionBuilder {
    var granted: () -> Unit = {}
        private set

    var refused: (() -> Unit)? = null
        private set

    // 说明权限使用原因
    var reason: String? = null

    // 同意权限后操作
    fun doAfterGranted(action: () -> Unit) {
        granted = action
    }

    // 拒绝权限后操作
    fun doAfterRefused(action: () -> Unit) {
        refused = action
    }
}

private fun doRxPermission(
    context: Context,
    rxPermission: RxPermissions,
    vararg permissionsRequired: String,
    actionBuilder: PermissionsActionBuilder.() -> Unit
) {
    val builder = PermissionsActionBuilder().apply(actionBuilder)
    val permissionsToRequest = permissionsRequired.filterNot { rxPermission.isGranted(it) }

    when {
        permissionsToRequest.isEmpty() -> builder.granted.invoke()
        builder.reason != null -> context.alert(builder.reason!!) {
            yesButton {
                requestPermission(rxPermission, builder, *permissionsToRequest.toTypedArray())
            }
            noButton {}
        }.show()
        else -> requestPermission(rxPermission, builder, *permissionsToRequest.toTypedArray())
    }
}

private fun requestPermission(
    rxPermissions: RxPermissions,
    builder: PermissionsActionBuilder,
    vararg permissionsToRequest: String
) =
    rxPermissions.request(*permissionsToRequest).subscribe { granted ->
        if (granted) {
            builder.granted()
        } else {
            builder.refused?.invoke()
        }
    }

fun AppCompatActivity.doPermissionAction(
    vararg permissions: String,
    actionBuilder: PermissionsActionBuilder.() -> Unit
) {
    doRxPermission(this, RxPermissions(this), *permissions, actionBuilder = actionBuilder)
}

fun Fragment.doPermissionAction(
    vararg permissions: String,
    actionBuilder: PermissionsActionBuilder.() -> Unit
) {
    doRxPermission(
        activity ?: return,
        RxPermissions(this),
        *permissions,
        actionBuilder = actionBuilder
    )
}