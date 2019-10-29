package com.erookies.mine.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.MINE_ENTRY
import com.erookies.lib_common.extentions.setImageFromUrl
import com.erookies.mine.R
import com.erookies.mine.utils.DialogBuilder
import com.erookies.mine.utils.DialogHelper
import com.erookies.mine.utils.makeFakeUser
import com.erookies.mine.viewmodel.UserViewModel
import com.wildma.pictureselector.PictureSelector
import kotlinx.android.synthetic.main.mine_fragment_user.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast


@Route(path = MINE_ENTRY)
class UserFragment : BaseFragment() {

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) { getViewModel(UserViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mine_fragment_user, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        BaseApp.user = makeFakeUser()
        viewModel.nickname.observe { tv_nickname.text = it }
        viewModel.avatarUrl.observe { civ_avatar.setImageFromUrl(it) }
        civ_avatar.setOnClickListener {
            PictureSelector.create(this@UserFragment, PictureSelector.SELECT_REQUEST_CODE)
                .selectPicture()
        }
        tv_nickname.setOnClickListener { view ->
            val builder = DialogBuilder().apply {
                title = "设置昵称"
                hint = "写下你想要的称呼哦～"
                checkEvent = { it.trim() != "" && BaseApp.isLogin }
                todoEvent = { viewModel.nickname.value = it }
                falseEvent = { if (BaseApp.isLogin) toast("昵称不能为空或者全空格哦") else toast("请登录再设置哦") }
            }
            DialogHelper.editDialog(view.context, builder)
        }
        tv_mine_material.setOnClickListener { startActivity<AuthenticationActivity>() }
        tv_mine_add.setOnClickListener {
            //todo: 我的拼单
        }
        tv_find_people.setOnClickListener {
            //todo：我的寻人
        }
        tv_find_things.setOnClickListener {
            //todo: 我的失物招领
        }
        tv_setting.setOnClickListener { startActivity<SettingActivity>() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            val path = data?.getStringExtra(PictureSelector.PICTURE_PATH)
            path ?: return
            val requestOptions = RequestOptions
                .circleCropTransform()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
            //todo:上传到网络
            Glide.with(this).load(path).apply(requestOptions).into(civ_avatar)
        }
    }
}
