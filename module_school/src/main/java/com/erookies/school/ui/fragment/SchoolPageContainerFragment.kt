package com.erookies.school.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.SCHOOL_ENTRY
import com.erookies.lib_common.config.SCHOOL_PUBLISH
import com.erookies.school.R
import com.erookies.school.data.factory.SchoolPageContainerFactory
import com.erookies.school.data.viewModel.SchoolPageContainerViewModel
import com.erookies.school.databinding.SchoolFragmentContainerBinding
import com.erookies.school.ui.activity.PublishActivity
import com.erookies.school.utils.change
import kotlinx.android.synthetic.main.school_fragment_container.*
import org.jetbrains.anko.support.v4.startActivity

@Route(path = SCHOOL_ENTRY)
class SchoolPageContainerFragment : BaseFragment(),View.OnClickListener {
    private  lateinit var binding:SchoolFragmentContainerBinding

    //控件
    private val spTextButton:TextView
        get() = school_search_switch_button
    private val lfTextButton: TextView
        get() = school_landf_switch_button
    private val viewPager:ViewPager
        get() = school_page_list_container

    //fragment列表
    val fragments = mutableListOf<Fragment>(SearchPeopleFragment(),LostAndFoundFragment())

    override fun getFactory(): ViewModelProvider.Factory? {
        return SchoolPageContainerFactory()
    }

    private val viewModel:SchoolPageContainerViewModel by lazy { getViewModel(SchoolPageContainerViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        ARouter.getInstance().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.school_fragment_container,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        init()
    }

    private fun init(){
        viewPager.offscreenPageLimit = 1
        viewPager.adapter =object : FragmentStatePagerAdapter(childFragmentManager,
            BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
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
        spTextButton.setOnClickListener(this)
        lfTextButton.setOnClickListener(this)
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
        spTextButton.change(bool)
        lfTextButton.change(!bool)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.school_landf_switch_button -> {
                viewModel.buttonIndex.value = 1
            }
            R.id.school_search_switch_button -> {
                viewModel.buttonIndex.value = 0
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.add -> {
                ARouter.getInstance().build(SCHOOL_PUBLISH).navigation()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.school_menu,menu)
    }
}