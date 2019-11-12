package com.erookies.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.erookies.lib_common.base.BaseFragment
import com.erookies.main.R
import kotlinx.android.synthetic.main.main_fragment_auc.*
import kotlinx.android.synthetic.main.main_fragment_pwd.*
import kotlinx.android.synthetic.main.main_fragment_stu.*
import org.jetbrains.anko.support.v4.toast

/**
 * Create by Cchanges.
 * Time: 2019-10-30
 */
class RegisterContainerFragment : BaseFragment() {

    private val param = "layoutId"
    private var layoutId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            layoutId = it.getInt(param)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        when (layoutId) {
            R.layout.main_fragment_stu -> btn_next_pwd.setOnClickListener {
                if (!check(tip_register_stu.text.toString())) {
                    toast("没有填写完整哦")
                    return@setOnClickListener
                }
                (activity as RegisterActivity).apply {
                    saveSno(tip_register_stu.text.toString())
                    showFragment(
                        newInstance(R.layout.main_fragment_pwd),
                        2
                    )
                }
            }
            R.layout.main_fragment_pwd -> {
                btn_next_auc.setOnClickListener {
                    if (!check(
                            tip_register_pwd.text.toString(),
                            tip_register_nickname.text.toString()
                        )
                    ) {
                        toast("没有填写完整哦")
                        return@setOnClickListener
                    }
                    (activity as RegisterActivity).apply {
                        savePwd(
                            tip_register_pwd.text.toString(),
                            tip_register_nickname.text.toString()
                        )
                        showFragment(
                            newInstance(R.layout.main_fragment_auc),
                            3
                        )
                    }
                }
            }
            R.layout.main_fragment_auc -> btn_finish.setOnClickListener {
                if (!check(
                        tip_register_college.text.toString(),
                        tip_register_username.text.toString()
                    )
                ) {
                    toast("没有填写完整哦")
                    return@setOnClickListener
                }
                (activity as RegisterActivity).apply {
                    saveReal(
                        tip_register_username.text.toString(),
                        tip_register_college.text.toString()
                    )
                    register()
                }
            }
        }
    }

    private fun check(vararg strs: String): Boolean {
        repeat(strs.size) {
            if (strs[it].isEmpty()) return false
        }
        return true
    }

    companion object {
        @JvmStatic
        fun newInstance(@LayoutRes layout: Int): RegisterContainerFragment =
            RegisterContainerFragment().apply {
                arguments = Bundle().apply {
                    putInt(param, layout)
                }
            }
    }

}