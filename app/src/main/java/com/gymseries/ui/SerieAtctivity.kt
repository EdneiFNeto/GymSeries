package com.gymseries.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.gymseries.R
import com.gymseries.fragments.SerieBFragment
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class SerieAtctivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie_atab_layoutctivity)
        ActionBarUtils.createTitleActionBar(
            supportActionBar,
            ResourcesUtils.getString(this, R.string.title_serie).toUpperCase()
        )

        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        changeFragments(SerieAFragment(), ResourcesUtils.getString(this, R.string.serie_a_fragemtn))
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_serie_a -> {
                changeFragments(
                    SerieAFragment(),
                    ResourcesUtils.getString(this, R.string.serie_a_fragemtn)
                )
            }
            R.id.item_serie_b -> {
                changeFragments(
                    SerieBFragment(),
                    ResourcesUtils.getString(this, R.string.serie_b_fragemtn)
                )
            }
        }

        return true
    }

    private fun changeFragments(fragment: Fragment, tag: String) {
        fragmentManager
            .beginTransaction()
            .replace(R.id.frame_layou_serie, fragment, tag)
            .commitAllowingStateLoss()
    }
}


