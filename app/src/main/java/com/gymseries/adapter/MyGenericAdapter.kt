package com.gymseries.adapter

import android.content.Context

class MyGenericAdapter<T>(
    context: Context?, list: ArrayList<T>, op: String,
    changeLayout: Boolean
) : BaseAdapter<T>(context = context, list = list, op = op, changeLayout = changeLayout) {}

