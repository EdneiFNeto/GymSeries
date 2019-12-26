package com.gymseries.generics

import android.content.Context
import android.util.Log
import com.anychart.charts.Resource
import com.gymseries.utils.ResourcesUtils

class InserGenericAsync<T>(
    context: Context?,
    op: String,
    list: ArrayList<T>
) : BaseAsyncInser<T>(context = context, op = op, list = list) {

    val TAG = "InserGenericAsyncLog"

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        Log.e(TAG, "Success ${result?.size}")
    }
}
