package com.erookies.school.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.IStartConversation
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.SCHOOL_DETAIL_LOST_FOUND
import com.erookies.lib_common.config.START_FROM_MAIN
import com.erookies.lib_common.event.IMEvent

import com.erookies.school.R
import com.erookies.school.data.factory.LostAndFoundFactory
import com.erookies.school.data.model.Tag
import com.erookies.school.data.repository.LostAndFoundRepository
import com.erookies.school.data.repository.LostAndFoundRepository.LoadType
import com.erookies.school.data.viewModel.LostAndFoundViewModel
import com.erookies.school.ui.adapter.LostAndFoundRVAdapter
import kotlinx.android.synthetic.main.school_common_recycler_view.*
import kotlinx.android.synthetic.main.school_fragment_lost_found_detail.*
import org.greenrobot.eventbus.EventBus

@Route(path = SCHOOL_DETAIL_LOST_FOUND)
class LostFoundDetailFragment : BaseFragment(), IStartConversation {

    @JvmField
    @Autowired(name = "tag")
    var tag:Tag = Tag.OTHER

    @JvmField
    @Autowired(name = "from")
    var from = START_FROM_MAIN

    private val viewModel by lazy { getViewModel(LostAndFoundViewModel::class.java) }

    override fun getFactory(): ViewModelProvider.Factory? {
        return LostAndFoundFactory(LostAndFoundRepository.getInstance())
    }

    private val mSwipeRefreshLayout:SwipeRefreshLayout
        get() = school_ls_refresh_layout
    private val mRecyclerView:RecyclerView
        get() = school_common_recycler_view

    private lateinit var adapter : LostAndFoundRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        viewModel.startType = from
        viewModel.currentTag.value = tag
        viewModel.currentUser.value = BaseApp.user
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.school_fragment_lost_found_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getItemDataList()
        initView()
        observe()
    }

    private fun initView(){
        adapter = LostAndFoundRVAdapter(listener = this)
        adapter.list.addAll(viewModel.items.value ?: mutableListOf())

        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView.adapter = adapter

        mSwipeRefreshLayout.apply {
            setColorSchemeColors(
                ContextCompat.getColor(context, R.color.themeYellow)
            )
            setOnRefreshListener {
                viewModel.getItemDataList()
                mSwipeRefreshLayout.isRefreshing = false
            }
        }
    }

    private fun observe(){
        viewModel.items.observe { list ->
            adapter.list.clear()
            adapter.list.addAll(list)
            adapter.notifyDataSetChanged()
        }
    }

    override fun sendEvent(event: IMEvent) {
        EventBus.getDefault().post(event)
    }

}
