package com.erookies.school.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.SCHOOL_DETAIL_LOST_FOUND
import com.erookies.lib_common.config.SCHOOL_LOST_FOUND_NEW_STYLE
import com.erookies.lib_common.config.START_FROM_MAIN

import com.erookies.school.R
import com.erookies.school.data.model.Tag
import com.erookies.school.ui.adapter.LostFoundVPAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.school_fragment_lost_found_entry_new_style.*

class LostFoundEntryFragmentNewStyle : BaseFragment() {

    private val mTabLayout:TabLayout
        get() = school_ls_new_tab_layout
    private val mViewPager:ViewPager
        get() = school_ls_new_vp

    private var fragments = mutableListOf<LostFoundDetailFragment>()
    private val tags = arrayListOf(
        Tag.CARD,
        Tag.DIGITAL,
        Tag.COMMODITY,
        Tag.OTHER
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.school_fragment_lost_found_entry_new_style,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragments()
        initView()
    }

    private fun initFragments() {
        fragments = tags.map {
            Log.d("LostAndFoundViewModel",it.tag)
            ARouter.getInstance()
                .build(SCHOOL_DETAIL_LOST_FOUND)
                .withParcelable("tag",it)
                .withInt("from", START_FROM_MAIN)
                .navigation() as LostFoundDetailFragment
        }.toMutableList()
    }

    private fun initView() {
        mViewPager.apply {
            adapter = LostFoundVPAdapter(fragments,childFragmentManager)
            offscreenPageLimit = 4
        }
        mTabLayout.setupWithViewPager(mViewPager)
        tags.forEachIndexed { index, tag ->
            mTabLayout.getTabAt(index)?.text = tag.tag
        }
    }
}
