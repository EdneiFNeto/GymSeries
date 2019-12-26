package com.gymseries.generics.async

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.GenericsUtil

/**
 * Options:
 * ResourscesUtil.getString(context, title)
 */
class ListEntityGenericAsync<T>(
    context: Context?,
    private val lista: ArrayList<T>,
    private val adapter: RecyclerView.Adapter<*>,
    op:String
) : BaseListAsync<T>(context = context, op = op) {

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        if (GenericsUtil<T>().results(result, lista)) {
            adapter.notifyDataSetChanged()
        }
    }
}

