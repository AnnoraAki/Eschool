package com.erookies.school.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.extentions.setImageFromUrl
import com.erookies.school.R
import com.erookies.school.data.factory.DetailFactory
import com.erookies.school.data.model.BaseItemData
import com.erookies.school.data.model.LostAndFoundItemData
import com.erookies.school.data.model.Picture
import com.erookies.school.data.model.SearchPeopleItemData
import com.erookies.school.data.viewModel.DetailViewModel
import com.erookies.school.ui.adapter.CommonPicRVAdapter
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.school_activity_detail.*
import kotlinx.android.synthetic.main.school_common_picture_list.*
import kotlin.properties.Delegates

/**
 * Create by Koalak
 * Time : 2019-11-03
 * 根据传入参数的不同显示不同的内容
 * 15 失物详情    16寻人详情
 */

class DetailActivity : BaseActivity() {

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) { getViewmodel(DetailViewModel::class.java) }

    private var type = 15

    private val adapter:CommonPicRVAdapter
        get() = CommonPicRVAdapter()

    private lateinit var itemData:BaseItemData

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

        common_toolbar.init(title)

        itemData = when(type){
            15 -> intent.getParcelableExtra<LostAndFoundItemData>("item_data")
            16 -> intent.getParcelableExtra<SearchPeopleItemData>("item_data")
            else -> intent.getParcelableExtra<LostAndFoundItemData>("item_data")
        }

        when(type){
            15 -> viewModel.itemData1.value = itemData as LostAndFoundItemData
            16 -> viewModel.itemData2.value = itemData as SearchPeopleItemData
        }

        init()
        observe()
    }

    private fun init(){
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        recyclerView.adapter = adapter
    }

    private fun observe(){
        val list:MutableList<Picture> = mutableListOf()
        when(type){
            15 -> {
                viewModel.itemData1.observe(this,
                    Observer { lsData ->
                        tagButton.text = lsData.tag.tag
                        if (lsData.user.avatar.isNotEmpty()){
                            userAvatar.setImageFromUrl(lsData.user.avatar)
                        }else{
                            userAvatar.setImageResource(R.mipmap.ic_launcher)
                        }
                        userName.text = lsData.user.username
                        content.text = lsData.content
                        if (lsData.picUrls.isNullOrEmpty()){
                            recyclerView.visibility = View.GONE
                        }else{
                            list.addAll(lsData.picUrls)
                            adapter.updateAdapter(list)
                        }
                    })
            }
            16 -> {
                viewModel.itemData2.observe(this,
                    Observer { spData ->
                        tagButton.text = spData.tag
                        if (spData.user.avatar.isNotEmpty()){
                            userAvatar.setImageFromUrl(spData.user.avatar)
                        }else{
                            userAvatar.setImageResource(R.mipmap.ic_launcher)
                        }
                        userName.text = spData.user.username
                        content.text = spData.content
                        if (spData.picUrls.isNullOrEmpty()){
                            recyclerView.visibility = View.GONE
                        }else{
                            list.addAll(spData.picUrls)
                            adapter.updateAdapter(list)
                        }
                    })
            }
        }
    }

    override fun getFactory(): ViewModelProvider.Factory? = DetailFactory()
}
