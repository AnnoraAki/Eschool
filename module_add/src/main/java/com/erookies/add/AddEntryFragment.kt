package com.erookies.add

import android.os.Bundle
import com.erookies.lib_common.base.BaseFragment

/**
 * Create by Cchanges.
 * Time: 2019-10-31
 */
class AddEntryFragment : BaseFragment() {
    private val titleTag = "title"
    var title = ""
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(titleTag,"")
        }
    }

    companion object {
        fun newInstance(str: String) = AddEntryFragment().apply {
            arguments = Bundle().apply {
                putString(titleTag, str)
            }
        }
    }
}