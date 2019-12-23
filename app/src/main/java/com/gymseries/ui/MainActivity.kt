package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.gymseries.R
import com.gymseries.fragments.*
import com.gymseries.utils.FragmentUtils
import com.gymseries.utils.ResourcesUtils

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FragmentUtils.changeFragments(
            supportFragmentManager,
            MainFragments(),
            ResourcesUtils.getString(this, R.string.main_fragemtn),
            R.id.frame_layout_main
        )

        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_main)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_home -> {
                FragmentUtils.changeFragments(
                    supportFragmentManager,
                    MainFragments(),
                    ResourcesUtils.getString(this, R.string.main_fragemtn),
                    R.id.frame_layout_main
                )
            }
            R.id.item_treino -> {
                FragmentUtils.changeFragments(
                    supportFragmentManager,
                    SerieFragment(),
                    ResourcesUtils.getString(this, R.string.serie_fragemtn),
                    R.id.frame_layout_main
                )
            } R.id.item_imc -> {
                FragmentUtils.changeFragments(
                    supportFragmentManager,
                    UserFragments(),
                    ResourcesUtils.getString(this, R.string.imc_fragemtn),
                    R.id.frame_layout_main
                )
            }
            R.id.item_chart -> {
                FragmentUtils.changeFragments(
                    supportFragmentManager,
                    ChartFragment(),
                    ResourcesUtils.getString(this, R.string.setting_fragemtn),
                    R.id.frame_layout_main
                )
            }
        }
        return true
    }
}
