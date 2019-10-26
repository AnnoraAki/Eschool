package com.erookies.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


/**
 * Create by Cchanges.
 * Time: 2019-10-22
 */
class ViewPagerAdapter(private val fragments:List<Fragment>,manager: FragmentManager) : FragmentPagerAdapter(manager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

}

