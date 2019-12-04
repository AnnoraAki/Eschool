package com.erookies.school.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.extentions.setImageFromUrl
import com.erookies.school.R
import com.erookies.school.data.factory.DetailFactory
import com.erookies.school.data.model.ItemData
import com.erookies.school.data.viewModel.DetailViewModel
import com.erookies.school.ui.adapter.CommonPicRVAdapter
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.school_activity_detail.*
import kotlinx.android.synthetic.main.school_common_picture_list.*

/**
 * Create by Koalak
 * Time : 2019-11-03
 * 根据传入参数的不同显示不同的内容
 * 15 失物详情    16寻人详情
 */

class DetailActivity : BaseActivity() {
    val pictures:MutableList<String> = mutableListOf()

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) { getViewModel(DetailViewModel::class.java) }

    private var type = 15

    private val adapter:CommonPicRVAdapter
        get() = CommonPicRVAdapter(pictures,false)

    private var itemData:ItemData = ItemData()

    //控件列表
    private val tagButton:Button
        get() = school_detail_tag_button
    private val userAvatar:CircleImageView
        get() = school_detail_user_avatar
    private val userName:TextView
        get() = school_detail_user_name
    private val content:TextView
        get() = school_detail_content
    private val recyclerView:RecyclerView
        get() = school_common_picture_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.school_activity_detail)

        type = intent.getIntExtra("type",15)

        val title = when(type){
            15 -> "失物详情"
            16 -> "寻人详情"
            else -> "失物详情"
        }

        itemData = intent.getParcelableExtra("item_data") as ItemData
        viewModel.itemData.value = itemData

        common_toolbar.init(title)

        init()
        observe()
    }

    private fun init(){
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        recyclerView.adapter = adapter
    }

    private fun observe(){
        viewModel.itemData.observe(this,
            Observer { data->
                tagButton.text = data.tag.tag
                Glide.with(this).load("http://118.24.129.217/api/download_face_api/${data.user.avatar}").placeholder(R.drawable.common_default_avatar).into(userAvatar)
                userName.text = data.user.nickname
                content.text = data.content
                if (data.pictures.isNullOrEmpty()){
                    recyclerView.visibility = View.GONE
                }else{
                    pictures.addAll(data.pictures)
                    adapter.notifyDataSetChanged()
                }
            })
    }

    override fun getFactory(): ViewModelProvider.Factory? = DetailFactory()
}
