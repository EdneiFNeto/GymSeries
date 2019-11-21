package com.gymseries.generics.async

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.GenericsUtil

/**
 * Options:
 * 0 - Biceps
 * 1 - Triceps
 * 2 - Peito
 * 3 - Ombro
 * 4 - Costas
 * 5 - Perna
 */
class ListEntityGenericAsync<T>(
    context: Context,
    private val lista: ArrayList<T>,
    private val adapter: RecyclerView.Adapter<*>,
    op:Int
) : BaseListAsync<T, Any?, Any?>(context = context, op = op) {

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        if (GenericsUtil<T>().results(result, lista)) {
            adapter.notifyDataSetChanged()
        }
    }
}

