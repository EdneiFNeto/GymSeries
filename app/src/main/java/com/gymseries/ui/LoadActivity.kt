package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gymseries.R
import com.gymseries.async.SelectUsers
import kotlinx.android.synthetic.main.activity_load.*

class LoadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        var actionBar = supportActionBar
        actionBar?.hide()

        SelectUsers(this, img_load).execute()
    }
}
