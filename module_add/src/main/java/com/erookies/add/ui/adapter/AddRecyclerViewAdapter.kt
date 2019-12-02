package com.erookies.add.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erookies.add.R
import com.erookies.add.bean.AddEntry
import com.erookies.add.int2String
import com.erookies.lib_common.extentions.setAvatar
import com.erookies.lib_common.extentions.setImageFromUrl
import kotlinx.android.synthetic.main.add_recycler_item.view.*

/**
 * Create by Cchanges.
 * Time: 2019-11-01
 */
class AddRecyclerViewAdapter(
    private val listener: (position: Int) -> Unit
) :
    RecyclerView.Adapter<AddRecyclerViewAdapter.ViewHolder>() {

    private var lists = mutableListOf<AddEntry>()

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = lists[position]
        holder.itemView.apply {
            civ_add_avatar.setAvatar(entry.user?.avatar)
            tv_add_nickname.text = entry.user?.nickname
            tv_tag.text = int2String(entry.tag)
            tv_time.text = "约定时间：${entry.time}"
            tv_address.text = "约定地点（店名）：${entry.content}"
            setOnClickListener {
                listener.invoke(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.add_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = lists.size

    fun changeData(newList: MutableList<AddEntry>) {
        lists.clear()
        lists.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}