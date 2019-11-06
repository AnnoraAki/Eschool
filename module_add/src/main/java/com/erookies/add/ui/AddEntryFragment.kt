package com.erookies.add.ui

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.erookies.add.bean.AddEntry
import com.erookies.add.ui.adapter.AddRecyclerViewAdapter
import com.erookies.add.FakeHelper
import com.erookies.add.R
import com.erookies.lib_common.base.BaseFragment
import kotlinx.android.synthetic.main.add_fragment_container.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

/**
 * Create by Cchanges.
 * Time: 2019-10-31
 */
class AddEntryFragment : BaseFragment() {
    private val titleTag = "title"
    private lateinit var lists: List<AddEntry>
    var title = ""
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(titleTag, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_fragment_container, container, false)
    }


    @TargetApi(Build.VERSION_CODES.M)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lists = FakeHelper.fakeData(title)
        rv_entry.layoutManager = LinearLayoutManager(this.context)
        rv_entry.adapter = AddRecyclerViewAdapter(lists) {
            startActivity<AddDetailActivity>("entry" to lists[it])
        }
        srl_add.apply {
            setColorSchemeColors(
                this@AddEntryFragment.resources.getColor(
                    R.color.colorPink,
                    this@AddEntryFragment.context!!.theme
                )
            )
            setOnRefreshListener {
                toast("refresh")
                srl_add.isRefreshing = false
            }
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