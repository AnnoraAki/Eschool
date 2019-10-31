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
                (activity as RegisterActivity).showFragment(newInstance(R.layout.main_fragment_pwd))
            }
            R.layout.main_fragment_pwd -> btn_next_auc.setOnClickListener {
                (activity as RegisterActivity).showFragment(newInstance(R.layout.main_fragment_auc))
            }
            R.layout.main_fragment_auc -> btn_finish.setOnClickListener {
                toast("完成注册!")
                activity?.finish()
            }
        }
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