package com.gymseries.utils

import android.util.Log

class LoggerUtil(val tag: String) {

    fun error(s: String) {
        Log.e(tag, s)
    }


}
