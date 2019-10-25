package com.erookies.school.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.erookies.lib_common.base.BaseFragment
import com.erookies.school.R
import com.erookies.school.data.factory.SchoolPageContainerFactory
import com.erookies.school.data.viewModel.SchoolPageContainerViewModel
import com.erookies.school.utils.change
import kotlinx.android.synthetic.main.school_fragment_container.*

class SchoolPageContainerFragment : BaseFragment(),View.OnClickListener {

    private lateinit var mainView: View

    //控件
    private val spButton:TextView
        get() = school_search_switch_button
    private val lfButton: TextView
        get() = school_landf_switch_button
    private val viewPager:ViewPager
        get() = school_page_list_container

    //fragment列表
    val fragments = mutableListOf<Fragment>(SearchPeopleFragment(),LostAndFoundFragment())

    override fun getFactory(): ViewModelProvider.Factory? {
        return SchoolPageContainerFactory()
    }

    private lateinit var viewModel:SchoolPageContainerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = getViewmodel(SchoolPageContainerViewModel::class.java)
        mainView = inflater.inflate(R.layout.school_fragment_container,container,false)
        return mainView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        init()
    }

    private fun init(){
        viewPager.adapter =object : FragmentStatePagerAdapter(childFragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }

            override fun getCount(): Int {
                return fragments.size
            }

        }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                viewModel.buttonIndex.value = position
            }

        })
        spButton.setOnClickListener(this)
        lfButton.setOnClickListener(this)
    }

    private fun observe(){
        viewModel.buttonIndex.observe(this.viewLifecycleOwner,
            Observer { index ->
                //修改viewpager的当前页
                viewPager.currentItem = index

                //修改点击的按钮的状态
                if (index == 0){
                    changeButtonStatus(true)
                }else{
                    changeButtonStatus(false)
                }
            })
    }

    private fun changeButtonStatus(bool:Boolean) {
        spButton.change(bool)
        lfButton.change(!bool)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.school_search_switch_button -> {
                viewModel.change()
            }
            R.id.school_landf_switch_button -> {
                viewModel.change()
            }
        }
    }
}