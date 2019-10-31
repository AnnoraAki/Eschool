package com.erookies.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.ADD_ENTRY

@Route(path = ADD_ENTRY)
class AddFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_fragment_add, container, false)
    }

}
