package com.erookies.mine.ui

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.config.IM_ENTRY
import com.erookies.lib_common.event.IMEvent
import com.erookies.lib_common.event.IMEventType
import com.erookies.lib_common.extentions.toast
import com.erookies.mine.R
import com.erookies.mine.bean.RegisterBean
import com.erookies.mine.viewmodel.RegisterViewModel
import com.erookies.mine.viewmodel.RegisterViewModel.Companion.REGISTER_FAILED
import com.erookies.mine.viewmodel.RegisterViewModel.Companion.REGISTER_SUCCEED
import kotlinx.android.synthetic.main.mine_activity_register.*
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.startActivity

class RegisterActivity : BaseActivity() {

    private var sno: String = ""
    private var pwd: String = ""
    private var nickname: String = ""
    private var realName: String = ""
    private var college: String = ""

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) { getViewModel(RegisterViewModel::class.java) }

    private val style by lazy(LazyThreadSafetyMode.NONE) {
        SpannableStringBuilder(
            resources.getString(
                R.string.mine_type_register
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_activity_register)
        ARouter.getInstance().inject(this)

        common_toolbar.init("注册")

        viewModel.statusEvent.observe {
            when (it) {
                REGISTER_SUCCEED -> {
                    toast("注册成功")
                    EventBus.getDefault().postSticky(IMEvent(IMEventType.REGISTER,friend = viewModel.registerUser))
                    startActivity<LoginActivity>()
                    finish()
                }
                REGISTER_FAILED -> {
                    toast("注册失败")
                }
            }
        }
        showFragment(RegisterContainerFragment.newInstance(R.layout.mine_fragment_stu), 1)
    }

    fun showFragment(fragment: Fragment, status: Int) {
        when (status) {
            1 -> style.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPink)),
                0,
                6,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE
            )
            2 -> style.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPink)),
                9,
                18,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE
            )
            3 -> style.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPink)),
                21,
                30,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE
            )
        }
        tv_message.text = style
        style.clearSpans()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()  //开启事务
        transaction.replace(R.id.fl_container, fragment).setTransition(TRANSIT_FRAGMENT_FADE)
        transaction.commit()//提交事务
    }

    fun saveSno(sno: String) {
        this.sno = sno
    }

    fun savePwd(pwd: String, nickname: String) {
        this.pwd = pwd
        this.nickname = nickname
    }

    fun saveReal(realName: String, college: String) {
        this.realName = realName
        this.college = college
    }

    fun register() {
        viewModel.register(getRegisterBean())
    }

    private fun getRegisterBean() = RegisterBean(
        sno = sno,
        institute = college,
        name = realName,
        nickname = nickname,
        password = pwd
    )
}
