package com.erookies.school.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.User
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.SCHOOL_SEARCH_PEOPLE
import com.erookies.lib_common.network.ApiGenerator
import com.erookies.school.R
import com.erookies.school.data.factory.SearchPeopleFactory
import com.erookies.school.data.model.SearchPeopleItemData
import com.erookies.school.data.repository.SearchPeopleRepository
import com.erookies.school.data.viewModel.SPViewModel
import com.erookies.school.databinding.SchoolFragmentSearchPeopleBinding
import com.erookies.school.ui.adapter.SearchPeopleRVAdapter
import com.erookies.school.utils.START_FROM_MAIN
import kotlinx.android.synthetic.main.school_common_recycler_view.*
import kotlinx.android.synthetic.main.school_fragment_search_people.*

/**
 * Create by Koalak.
 * Time: 2019-10-20
 */

@Route(path = SCHOOL_SEARCH_PEOPLE)
class SearchPeopleFragment : BaseFragment() {

    @JvmField
    @Autowired(name = "start_type")
    var startType = START_FROM_MAIN

    private val viewModel: SPViewModel by lazy { getViewModel(SPViewModel::class.java) }
    private lateinit var adapter:SearchPeopleRVAdapter

    private lateinit var binding:SchoolFragmentSearchPeopleBinding

    private val handler = Handler(Looper.getMainLooper()){msg ->
        when(msg.what){
            1 -> viewModel.createTestData("koalak","玲珑骰子安红豆，入骨相思知不知")
        }
        true
    }

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
        adapter = SearchPeopleRVAdapter(viewModel)
        viewModel.createTestData("自由如风","我在萧萧的雨幕里，飘然一曲有我侧耳听，水面萧中剑的倒影，是爱中藏恨的诗句")
        binding.viewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        observe()
        handler.postDelayed({
            val msg = Message.obtain()
            msg.what = 1
            msg.target = handler
            msg.sendToTarget()
        },3000)
    }

    private fun observe(){
        viewModel.isRefresh.observe(this.viewLifecycleOwner,
            Observer { refresh ->
                //school_search_people_refresh.isRefreshing = refresh
                if (refresh == true){
                    adapter.notifyDataSetChanged()
                }
            })
    }

    private fun init(){
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        Log.d("LostAndFoundFragment","LayoutManager is : ${recyclerView.layoutManager.toString()}")
        recyclerView.adapter = adapter
    }

    override fun getFactory(): ViewModelProvider.Factory? = SearchPeopleFactory(
        SearchPeopleRepository.getInstance())
}