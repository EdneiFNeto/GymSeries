package com.gymseries.generics

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.GenericsUtil

class DeleteEntityGenericAsync<T>(context: Context,
                                  val op: Int,
                                  val t: T,
                                  val list: ArrayList<T>,
                                  val adapter: RecyclerView.Adapter<*>) :
        BaseDeleteAsync<T>(context, op = op, t = t) {
    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        if(GenericsUtil<T>().results(result, list))
            adapter.notifyDataSetChanged()
    }
}
