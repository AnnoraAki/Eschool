package com.erookies.add.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.core.util.Pair
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.erookies.add.R
import com.erookies.add.bean.AddEntry
import com.erookies.add.ui.adapter.AddRecyclerViewAdapter
import com.erookies.add.ui.viemodel.AddEntryViewModel
import com.erookies.lib_common.base.BaseFragment
import kotlinx.android.synthetic.main.add_fragment_container.*
import kotlinx.android.synthetic.main.add_recycler_item.*
import org.greenrobot.eventbus.EventBus

/**
 * Create by Cchanges.
 * Time: 2019-10-31
 */
class AddEntryFragment : BaseFragment() {
    private val titleTag = "title"
    private val isOwnTag = "isOwn"
    private lateinit var lists: List<AddEntry>
    private var isOwn = false
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
            isOwn = it.getBoolean(isOwnTag, false)
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
        val adapter = AddRecyclerViewAdapter({
            val options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(
                    activity as Activity,
                    Pair.create(civ_add_avatar, "add_avatar"),
                    Pair.create(tv_address, "add_address"),
                    Pair.create(tv_time, "add_time"),
                    Pair.create(tv_tag, "add_type"),
                    Pair.create(tv_add_nickname, "add_nickname")
                )
            val intent = Intent(this.context, AddDetailActivity::class.java)
            intent.putExtra("entry", lists[it])
            startActivity(intent, options.toBundle())
        }, { EventBus.getDefault().post(it) })

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
        return AddEntryViewModel.Factory(title, isOwn)
    }

    companion object {
        fun newInstance(str: String, isOwn: Boolean) = AddEntryFragment().apply {
            arguments = Bundle().apply {
                putString(titleTag, str)
                putBoolean(isOwnTag, isOwn)
            }
        }
    }
}