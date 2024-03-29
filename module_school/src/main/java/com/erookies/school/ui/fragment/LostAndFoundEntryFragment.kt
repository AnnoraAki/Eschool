package com.erookies.school.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.IntDef
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.BaseApp
import com.erookies.lib_common.base.BaseActivity
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.SCHOOL_LOST_FOUND
import com.erookies.lib_common.config.START_FROM_MAIN
import com.erookies.school.R
import com.erookies.school.data.factory.LostAndFoundFactory
import com.erookies.school.data.model.Tag
import com.erookies.school.data.repository.LostAndFoundRepository
import com.erookies.school.data.viewModel.LostAndFoundViewModel
import com.erookies.school.databinding.SchoolFragmentLostFoundBinding
import com.erookies.school.ui.adapter.LostAndFoundRVAdapter
import com.erookies.school.utils.hideButton
import com.erookies.school.utils.restoreStyle
import com.erookies.school.utils.toast
import kotlinx.android.synthetic.main.school_common_recycler_view.*
import kotlinx.android.synthetic.main.school_fragment_lost_found.*

/**
 * Create by Koalak.
 * Time: 2019-10-20
 */

@Route(path = SCHOOL_LOST_FOUND)
class LostAndFoundEntryFragment : BaseFragment(),View.OnClickListener {

    //添加JvmField解决字段注入问题
    @JvmField
    @Autowired(name = "start_type")
    var startType:Int = START_FROM_MAIN

    private val viewModel:LostAndFoundViewModel by lazy { getViewModel(LostAndFoundViewModel::class.java) }

    private lateinit var binding:SchoolFragmentLostFoundBinding

    private val buttons = hashMapOf<String,Button>()

    //控件
    private val cardButton:Button
        get() = school_id_card_button
    private val digitalButton:Button
        get() = school_digital_button
    private val dailyButton:Button
        get() = school_daily_goods_button
    private val othersButton:Button
        get() = school_others_button
    private val recyclerView:RecyclerView
        get() = school_common_recycler_view

    //适配器
    private lateinit var adapter:LostAndFoundRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.school_fragment_lost_found,container,false)

        binding.viewModel = viewModel

        viewModel.currentUser.value = BaseApp.user
        viewModel.getItemDataList()
        adapter = LostAndFoundRVAdapter(viewModel.items.value)

        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    private fun init(){
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        Log.d("LostAndFoundFragment","LayoutManager is : ${recyclerView.layoutManager.toString()}")
        recyclerView.adapter = adapter
        Log.d("LostAndFoundFragment","recyclerview list is : ${adapter.itemCount}")

        buttons[Tag.CARD.tag] = cardButton
        buttons[Tag.COMMODITY.tag] = dailyButton
        buttons[Tag.DIGITAL.tag] = digitalButton
        buttons[Tag.OTHER.tag] = othersButton

        if (startType == START_FROM_MAIN){
            cardButton.setOnClickListener(this)
            digitalButton.setOnClickListener(this)
            dailyButton.setOnClickListener(this)
            othersButton.setOnClickListener(this)
        }else{
            val btns = buttons.values
            hideButton(btns)
        }
    }

    private fun observe(){
        if (startType == START_FROM_MAIN){
            viewModel.currentTag.observe(this.viewLifecycleOwner,
                Observer {tag ->
                    Log.d("LostAndFoundFragment","current tag is changed, current tag is : ${tag.tag}")
                    val button = buttons.remove(tag.tag)
                    if (button != null) {
                        val btns = buttons.values
                        restoreStyle(button,btns)
                        buttons[tag.tag] = button
                    }
                })
        }
        viewModel.isRefreshing.observe(this.viewLifecycleOwner,
            Observer {
                adapter.notifyDataSetChanged()
            })
        viewModel.needToast.observe(this.viewLifecycleOwner,
            Observer {need ->
                if (need){
                    toast(viewModel.errorMsg)
                }
            })
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.school_id_card_button -> {
                viewModel.currentTag.value = Tag.CARD
                viewModel.getItemDataList()
            }
            R.id.school_digital_button -> {
                viewModel.currentTag.value = Tag.DIGITAL
                viewModel.getItemDataList()
            }
            R.id.school_daily_goods_button -> {
                viewModel.currentTag.value = Tag.COMMODITY
                viewModel.getItemDataList()
            }
            R.id.school_others_button -> {
                viewModel.currentTag.value = Tag.OTHER
                viewModel.getItemDataList()
            }
        }
        Log.d("LostAndFoundFragment","${viewModel.currentTag.value?.tag} is be selected!")
    }

    override fun getFactory(): ViewModelProvider.Factory? = LostAndFoundFactory(
        LostAndFoundRepository.getInstance())
}