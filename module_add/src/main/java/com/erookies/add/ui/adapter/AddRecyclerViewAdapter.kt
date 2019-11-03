package com.erookies.add.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erookies.add.R
import com.erookies.add.bean.AddEntry
import com.erookies.lib_common.extentions.setImageFromUrl
import kotlinx.android.synthetic.main.add_recycler_item.view.*

/**
 * Create by Cchanges.
 * Time: 2019-11-01
 */
class AddRecyclerViewAdapter(
    private var lists: List<AddEntry>,
    private val listener: (position: Int) -> Unit
) :
    RecyclerView.Adapter<AddRecyclerViewAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = lists[position]
        holder.itemView.apply {
            civ_add_avatar.setImageFromUrl(entry.avatar)
            tv_add_nickname.text = entry.nickname
            tb_tag.text = entry.tag
            tv_time.text = entry.time
            tv_address.text = entry.address
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

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}