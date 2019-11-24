package com.gymseries.utils

import android.content.Context
import androidx.appcompat.app.ActionBar

class ActionBarUtils {

    companion object {
        fun createTitleActionBar(actionBar: ActionBar?, title:String) {
            if (actionBar != null) {
                actionBar.title = title

            }
        }

        fun hiide(actionBar: ActionBar?) {
            actionBar?.hide()
        }
    }
}
