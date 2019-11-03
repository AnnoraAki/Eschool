package com.erookies.school.ui.holder

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.config.SCHOOL_DETAIL
import com.erookies.school.data.model.LostAndFoundItemData
import com.erookies.school.databinding.SchoolItemLostFoundBinding
import com.erookies.school.ui.activity.DetailActivity

class LostAndFoundViewHolder(val binding: SchoolItemLostFoundBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item:LostAndFoundItemData?){
        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context,DetailActivity::class.java)
            intent.putExtra("item_data",item)
            intent.putExtra("type",15)
            binding.root.context.startActivity(intent)
        }
    }
}