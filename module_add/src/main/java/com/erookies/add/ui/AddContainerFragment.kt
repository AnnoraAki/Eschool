package com.erookies.add.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.erookies.add.R
import com.erookies.add.bean.AddEntry
import com.erookies.add.ui.adapter.AddViewAdapter
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.ADD_ENTRY
import com.erookies.lib_common.event.ClickMenuEvent
import kotlinx.android.synthetic.main.add_fragment_add.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.support.v4.startActivity

@Route(path = ADD_ENTRY)
class AddContainerFragment : BaseFragment() {

    private lateinit var fragments: List<AddEntryFragment>
    private val titles = arrayListOf(
        AddEntry.CAR,
        AddEntry.MOVIE,
        AddEntry.EAT,
        AddEntry.GAME,
        AddEntry.SING,
        AddEntry.OTHER
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_fragment_add, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initFragment()
        vp_container.apply {
            adapter = AddViewAdapter(fragments, childFragmentManager)
            offscreenPageLimit = 6
        }
        tb_container.setupWithViewPager(vp_container)
    }

    private fun initFragment() {
        fragments = titles.map { AddEntryFragment.newInstance(it) }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun clickMenu(event: ClickMenuEvent) {
        if (event.position == 0) {
            startActivity<AddActivity>()
        }
    }
}
