package com.gymseries.utils

import androidx.appcompat.app.ActionBar

class ActionBarUtils {

    companion object {

        fun createTitleActionBar(actionBar: ActionBar?, title: String) {
            if (actionBar != null) {
                actionBar.title = title
            }
        }

        fun hide(actionBar: ActionBar?) {
            actionBar?.hide()
        }

        fun show(actionBar: ActionBar?) {
            actionBar?.show()
        }

        fun title(actionBar: ActionBar?, title:String) {
            actionBar?.title = title
        }
    }
}
