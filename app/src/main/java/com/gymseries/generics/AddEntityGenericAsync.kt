package com.gymseries.generics

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.GenericsUtil
import com.gymseries.generics.async.BaseAddAsync
import java.util.*

/**
 * Options:
 * 0 - biceps
 * 1 - triceps
 * 2 - Peito
 * 3 - Ombro
 * 4 - Costas
 * 5 - Perna
 */
class AddEntityGenericAsync<T>(
    context: Context,
    val op: Int,
    val list: ArrayList<T>,
    val adapter: RecyclerView.Adapter<*>
) :
        BaseAddAsync<T>(context, op, list) {

    private var TAG ="AddEntityGenericAsyncLog"

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        if(GenericsUtil<T>().results(result, list))
            adapter?.notifyDataSetChanged()
    }
}
