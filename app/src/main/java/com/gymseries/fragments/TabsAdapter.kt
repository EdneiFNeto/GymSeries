package com.gymseries.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.gymseries.fragments.table.SerieATabFrgment

class TabsAdapter(
    fm: FragmentManager,
    private val numOfTabs:Int
) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun tab1(): Fragment? {
        return SerieATabFrgment()
    }

    private fun tab2(): Fragment? {
        return SerieATabFrgment()
    }

    override fun getCount(): Int {
        return numOfTabs
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

}