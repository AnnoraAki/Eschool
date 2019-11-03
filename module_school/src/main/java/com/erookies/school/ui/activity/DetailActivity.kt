package com.erookies.school.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.extentions.setImageFromUrl
import com.erookies.school.R
import com.erookies.school.data.factory.DetailFactory
import com.erookies.school.data.model.BaseItemData
import com.erookies.school.data.model.LostAndFoundItemData
import com.erookies.school.data.model.SearchPeopleItemData
import com.erookies.school.data.viewModel.DetailViewModel
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

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) { getViewmodel(DetailViewModel::class.java) }

    private val type:Int by lazy(LazyThreadSafetyMode.NONE) {
        intent.getIntExtra("type",15)
    }

    private var itemData:BaseItemData = when(type){
        15 -> intent.getParcelableExtra<LostAndFoundItemData>("item_data")
        16 -> intent.getParcelableExtra<SearchPeopleItemData>("item_data")
        else -> intent.getParcelableExtra<LostAndFoundItemData>("item_data")
    }

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

        val title = when(type){
            15 -> "失物详情"
            16 -> "寻人详情"
            else -> "失物详情"
        }

        common_toolbar.init(title)

        when(type){
            15 -> viewModel.itemData1.value = itemData as LostAndFoundItemData
            16 -> viewModel.itemData2.value = itemData as SearchPeopleItemData
        }

        init()
        observe()
    }

    private fun init(){
        //todo 初始化RecyclerView
    }

    private fun observe(){
        when(type){
            15 -> {
                viewModel.itemData1.observe(this,
                    Observer { lsData ->
                        tagButton.text = lsData.tag.tag
                        userAvatar.setImageFromUrl(lsData.user.avatar)
                        userName.text = lsData.user.nickname
                        content.text = lsData.content
                        //todo 图片列表适配器
                    })
            }
            16 -> {
                viewModel.itemData2.observe(this,
                    Observer { spData ->
                        tagButton.text = spData.tag
                        userAvatar.setImageFromUrl(spData.user.avatar)
                        userName.text = spData.user.nickname
                        content.text = spData.content
                        //todo 图片列表适配器
                    })
            }
        }
    }

    override fun getFactory(): ViewModelProvider.Factory? = DetailFactory()
}
