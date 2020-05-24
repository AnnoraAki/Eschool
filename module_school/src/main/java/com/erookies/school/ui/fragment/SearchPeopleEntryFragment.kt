package com.erookies.school.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.SCHOOL_SEARCH_PEOPLE
import com.erookies.lib_common.config.START_FROM_MAIN
import com.erookies.lib_common.event.IMEvent
import com.erookies.school.R
import com.erookies.lib_common.IStartConversation
import com.erookies.school.data.factory.SearchPeopleFactory
import com.erookies.school.data.repository.SearchPeopleRepository
import com.erookies.school.data.viewModel.SPViewModel
import com.erookies.school.databinding.SchoolFragmentSearchPeopleBinding
import com.erookies.school.ui.adapter.SearchPeopleRVAdapter
import com.erookies.school.utils.toast
import kotlinx.android.synthetic.main.school_common_recycler_view.*
import org.greenrobot.eventbus.EventBus

/**
 * Create by Koalak.
 * Time: 2019-10-20
 */

@Route(path = SCHOOL_SEARCH_PEOPLE)
class SearchPeopleEntryFragment : BaseFragment(),
    IStartConversation {

    @JvmField
    @Autowired(name = "start_type")
    var startType = START_FROM_MAIN

    private val viewModel: SPViewModel by lazy { getViewModel(SPViewModel::class.java) }
    private lateinit var adapter:SearchPeopleRVAdapter

    private lateinit var binding:SchoolFragmentSearchPeopleBinding

    //控件
    private val recyclerView:RecyclerView
        get() = school_common_recycler_view

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.school_fragment_search_people,container,false)

        binding.viewModel = viewModel

        viewModel.startType = startType
        viewModel.currentUser.value = BaseApp.user
        viewModel.getItemDataListFromNetWork()
        adapter = SearchPeopleRVAdapter(listener = this)
        adapter.list.addAll(viewModel.items.value ?: mutableListOf())

        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        observe()
    }

    private fun observe(){
        viewModel.items.observe(this.viewLifecycleOwner, Observer {
            adapter.list.clear()
            adapter.list.addAll(it)
            adapter.notifyDataSetChanged()
        })
        viewModel.isRefresh.observe(this.viewLifecycleOwner,
            Observer {
                adapter.notifyDataSetChanged()
            })
        viewModel.needToast.observe { need->
            if (need){
                toast(viewModel.error)
                viewModel.error = ""
            }
        }
    }

    private fun init(){
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        Log.d("SearchPeopleFragment","LayoutManager is : ${recyclerView.layoutManager.toString()}")
        recyclerView.adapter = adapter
    }

    override fun getFactory(): ViewModelProvider.Factory? = SearchPeopleFactory(
        SearchPeopleRepository.getInstance())

    override fun sendEvent(event: IMEvent) {
        EventBus.getDefault().post(event)
        Log.d("sendEvent_sp","send finish : $event")
    }
}