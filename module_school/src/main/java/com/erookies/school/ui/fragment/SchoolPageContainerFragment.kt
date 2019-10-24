package com.erookies.school.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.erookies.lib_common.base.BaseFragment
import com.erookies.school.R
import kotlinx.android.synthetic.main.school_fragment_container.*

class SchoolPageContainerFragment : BaseFragment() {
    private lateinit var mainView: View
    private val spButton:Button
        get() = school_search_switch_button
    private val lfButton: Button
        get() = school_landf_switch_button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainView = inflater.inflate(R.layout.school_fragment_container,container,false)
        return mainView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}