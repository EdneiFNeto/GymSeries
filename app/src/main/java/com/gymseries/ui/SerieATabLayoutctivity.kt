package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.gymseries.R
import com.gymseries.fragments.TabsAdapter

class SerieATabLayoutctivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie_atab_layoutctivity)

        var serieA = findViewById<TabItem>(R.id.item_serie_a)
        var serieB = findViewById<TabItem>(R.id.item_serie_b)
        var tabs  = findViewById<TabLayout>(R.id.tabs)

        var tabsAdapter = TabsAdapter(supportFragmentManager, tabs.tabCount)

        var viewPager = findViewById<ViewPager>(R.id.viewPage)
        viewPager.adapter = tabsAdapter
    }
}
