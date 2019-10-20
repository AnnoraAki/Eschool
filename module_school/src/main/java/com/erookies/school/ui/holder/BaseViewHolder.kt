package com.erookies.school.ui.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.erookies.school.data.model.BaseItemData

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun load(data: BaseItemData)
}