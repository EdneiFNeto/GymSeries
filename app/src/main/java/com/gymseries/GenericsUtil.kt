package com.gymseries

import android.util.Log
import java.util.*

class GenericsUtil<T> {

    private val TAG="GenericsUtil"

    fun results(result: List<T>?, list: ArrayList<T>):Boolean {
        if (result != null) {
            if (result.isNotEmpty()) {
                list.clear()
                for (t in result) {
                    Log.e(TAG, "List ${t.toString()}")
                    list.add(t)
                }
                return true
            }
        }
        return false
    }
}