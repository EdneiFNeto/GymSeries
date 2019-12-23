package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gymseries.R
import com.gymseries.async.SelectUsers

class LoadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)
        SelectUsers(this).execute()
    }
}
