package com.gymseries.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.gymseries.R
import com.gymseries.fragments.SerieBFragment
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.FragmentUtils
import com.gymseries.utils.ResourcesUtils

class SerieAtctivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie_atab_layoutctivity)
        ActionBarUtils.createTitleActionBar(
            supportActionBar,
            ResourcesUtils.getString(this, R.string.title_serie).toUpperCase()
        )

        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_serie)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        FragmentUtils.changeFragments(
            supportFragmentManager,
            SerieAFragment(),
            ResourcesUtils.getString(this, R.string.serie_a_fragemtn),
            R.id.frame_layou_serie
        )
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_serie_a -> {
                FragmentUtils.changeFragments(
                    supportFragmentManager,
                    SerieAFragment(),
                    ResourcesUtils.getString(this, R.string.serie_a_fragemtn),
                    R.id.frame_layou_serie
                )
            }
            R.id.item_serie_b -> {
                FragmentUtils.changeFragments(
                    supportFragmentManager,
                    SerieBFragment(),
                    ResourcesUtils.getString(this, R.string.serie_b_fragemtn),
                    R.id.frame_layou_serie
                )
            }
        }

        return true
    }


}


