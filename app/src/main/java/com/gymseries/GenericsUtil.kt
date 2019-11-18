package com.gymseries

import java.util.*

class GenericsUtil<T> {

    fun results(result: List<T>?, list: ArrayList<T>):Boolean {
        if (result != null) {
            if (result.isNotEmpty()) {
                list.clear()
                for (t in result) {
                    list.add(t)
                }
                return true
            }
        }
        return false
    }
}