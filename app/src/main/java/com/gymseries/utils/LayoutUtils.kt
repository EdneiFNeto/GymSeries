package com.gymseries.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class LayoutUtils {

    companion object {
        fun inflateLayout(context: Context?, parent: ViewGroup, layout: Int): View {
            return LayoutInflater.from(context).inflate(layout, parent, false)
        }

    }
}
