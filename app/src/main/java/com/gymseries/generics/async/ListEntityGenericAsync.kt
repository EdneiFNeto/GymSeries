package com.gymseries.generics.async

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.GenericsUtil

/**
 * OPtions: select list
 * 0 - Ombro
 * 1 - Biceps
 * 2 - Triceps
 */
class ListEntityGenericAsync<T>(
    context: Context,
    private val lista: ArrayList<T>,
    private val adapter: RecyclerView.Adapter<*>,
    op:Int
) : AsyncGererics<T>(context = context, op = op) {

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        if (GenericsUtil<T>().results(result, lista)) {
            adapter.notifyDataSetChanged()
        }
    }
}

