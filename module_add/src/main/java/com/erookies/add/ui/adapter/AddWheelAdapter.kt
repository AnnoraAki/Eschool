package com.erookies.add.ui.adapter

import com.contrarywind.adapter.WheelAdapter

/**
 * Create by Cchanges.
 * Time: 2019-11-03
 */
class AddWheelAdapter(private val list: List<String>) : WheelAdapter<String> {
    override fun indexOf(o: String?) = -1

    override fun getItemsCount() = list.size

    override fun getItem(index: Int) = list[index]

}