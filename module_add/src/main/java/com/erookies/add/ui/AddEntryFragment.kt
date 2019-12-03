package com.erookies.add.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.erookies.add.R
import com.erookies.add.bean.AddEntry
import com.erookies.add.ui.adapter.AddRecyclerViewAdapter
import com.erookies.add.ui.viemodel.AddEntryViewModel
import com.erookies.lib_common.base.BaseFragment
import kotlinx.android.synthetic.main.add_fragment_container.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Create by Cchanges.
 * Time: 2019-10-31
 */
class AddEntryFragment : BaseFragment() {
    private val titleTag = "title"
    private lateinit var lists: List<AddEntry>
    var title = ""
        private set
    private val viewModel: AddEntryViewModel by lazy(LazyThreadSafetyMode.NONE) {
        getViewModel(
            AddEntryViewModel::class.java
        )
    }

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


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = AddRecyclerViewAdapter {
            startActivity<AddDetailActivity>("entry" to lists[it])
        }
        viewModel.list.observe {
            adapter.changeData(it.toMutableList())
            lists = it
        }
        viewModel.status.observe {

        }
        viewModel.getData()
        rv_entry.layoutManager = LinearLayoutManager(this.context)
        rv_entry.adapter = adapter
        srl_add.apply {
            setColorSchemeColors(
                ContextCompat.getColor(context, R.color.themeYellow)
            )
            setOnRefreshListener {
                viewModel.getData()
                srl_add.isRefreshing = false
            }
        }
    }

    override fun getFactory(): ViewModelProvider.Factory? {
        return AddEntryViewModel.Factory(title, isOwn = false)
    }

    companion object {
        fun newInstance(str: String) = AddEntryFragment().apply {
            arguments = Bundle().apply {
                putString(titleTag, str)
            }
        }
    }
}