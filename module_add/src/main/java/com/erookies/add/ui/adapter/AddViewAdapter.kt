package com.erookies.add.ui.adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.erookies.add.ui.AddEntryFragment

/**
 * Create by Cchanges.
 * Time: 2019-10-31
 */
class AddViewAdapter(private val fragments: List<AddEntryFragment>, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int): CharSequence? {
        return fragments[position].title
    }
}