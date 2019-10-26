package com.erookies.main

import android.util.SparseArray
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Create by Cchanges.
 * Time: 2019-10-23
 */
class OnPageChangedListener(private val bottomNavigationView: BottomNavigationView,
                            private val viewPager: ViewPager,
                            private val listener:((position:Int,item:MenuItem)->Unit)?)  : BottomNavigationView.OnNavigationItemSelectedListener,ViewPager.OnPageChangeListener {

    private val idToPosition : SparseArray<Int>
    private val positionToItem : SparseArray<MenuItem>

    init {
        val menu = bottomNavigationView.menu
        val size = menu.size()
        idToPosition = SparseArray()
        positionToItem = SparseArray()
        var j = 0
        for(i in 0 until size) {
            val item = menu.getItem(i)
            if(item.isEnabled) {
                positionToItem.put(j,item)
                idToPosition.put(item.itemId,j++)
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem) : Boolean {
        val position = idToPosition[item.itemId]
        viewPager.currentItem = position
        listener?.invoke(position,item)
        return true
    }

    override fun onPageScrollStateChanged(state: Int) = Unit

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit

    override fun onPageSelected(position: Int) {
        bottomNavigationView.selectedItemId = positionToItem[position].itemId
        listener?.invoke(position,positionToItem[position])
    }

}