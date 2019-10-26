package com.erookies.school.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.erookies.lib_common.base.BaseFragment
import com.erookies.school.R
import com.erookies.school.data.factory.LostAndFoundFactory
import com.erookies.school.data.model.Tag
import com.erookies.school.data.repository.LostAndFoundRepository
import com.erookies.school.data.viewModel.LostAndFoundViewModel
import com.erookies.school.databinding.SchoolFragmentLostFoundBinding
import com.erookies.school.ui.adapter.LostAndFoundRVAdapter
import com.erookies.school.utils.restoreStyle
import kotlinx.android.synthetic.main.school_common_recycler_view.*
import kotlinx.android.synthetic.main.school_fragment_lost_found.*

/**
 * Create by Koalak.
 * Time: 2019-10-20
 * bug:无法生成列表
 */
class LostAndFoundFragment : BaseFragment(),View.OnClickListener {

    private lateinit var viewModel:LostAndFoundViewModel

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
    private val swipeRefreshLayout:SwipeRefreshLayout
        get() = school_landf_refresh_layout

    //适配器
    private lateinit var adapter:LostAndFoundRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = getViewmodel(LostAndFoundViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.school_fragment_lost_found,container,false)

        viewModel.createTestData()

        adapter = LostAndFoundRVAdapter(viewModel)

        binding.viewModel = viewModel
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

        swipeRefreshLayout.setOnRefreshListener {
            viewModel.createTestData()
        }

        cardButton.setOnClickListener(this)
        digitalButton.setOnClickListener(this)
        dailyButton.setOnClickListener(this)
        othersButton.setOnClickListener(this)

        buttons[Tag.CARD.tag] = cardButton
        buttons[Tag.COMMODITY.tag] = dailyButton
        buttons[Tag.DIGITAL.tag] = digitalButton
        buttons[Tag.OTHER.tag] = othersButton
    }

    private fun observe(){
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
        viewModel.isRefreshing.observe(this.viewLifecycleOwner,
            Observer { refresh ->
                if (refresh) {
                    adapter.notifyDataSetChanged()
                }
            })
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.school_id_card_button -> {
                viewModel.currentTag.value = Tag.CARD
                viewModel.createTestData()
            }
            R.id.school_digital_button -> {
                viewModel.currentTag.value = Tag.DIGITAL
                viewModel.createTestData()
            }
            R.id.school_daily_goods_button -> {
                viewModel.currentTag.value = Tag.COMMODITY
                viewModel.createTestData()
            }
            R.id.school_others_button -> {
                viewModel.currentTag.value = Tag.OTHER
                viewModel.createTestData()
            }
        }
        Log.d("LostAndFoundFragment","${viewModel.currentTag.value?.tag} is be selected!")
    }

    override fun getFactory(): ViewModelProvider.Factory? = LostAndFoundFactory(
        LostAndFoundRepository.getInstance())
}