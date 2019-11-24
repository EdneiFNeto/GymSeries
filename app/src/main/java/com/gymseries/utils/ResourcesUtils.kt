package com.gymseries.utils

import android.content.Context

class ResourcesUtils {

    companion object{
        fun getString(context: Context?, id: Int):String{
            if (context != null) {
                return context.resources.getString(id)
            }
            return ""
        }
    }
}
