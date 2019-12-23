package com.gymseries.generics

import android.content.Context
import android.util.Log
import com.anychart.charts.Resource
import com.gymseries.utils.ResourcesUtils

/**
 * Options:
 * 0 - biceps
 * 1 - triceps
 * 2 - Peito
 * 3 - Ombro
 * 4 - Costas
 * 5 - Perna
 */
class InserGenericAsync<T>(
    context: Context?,
    op: String,
    list: ArrayList<T>
) : BaseAsyncInser<T>(context = context, op = op, list = list) {

    private val TAG = "InserGenericAsyncLog"

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        Log.e(TAG, "Success ${result?.size}")
    }
}
