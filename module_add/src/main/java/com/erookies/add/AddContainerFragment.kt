package com.erookies.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.erookies.lib_common.base.BaseFragment
import com.erookies.lib_common.config.ADD_ENTRY
import kotlinx.android.synthetic.main.add_fragment_add.*

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
        vp_container.adapter = AddViewAdapter(fragments,childFragmentManager)
        vp_container.offscreenPageLimit = 6
        tb_container.setupWithViewPager(vp_container)
    }

    private fun initFragment() {
        fragments = titles.map { AddEntryFragment.newInstance(it) }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        activity?.menuInflater?.inflate(R.menu.add_menu_add, menu)
        super.onPrepareOptionsMenu(menu)
    }
}
