package com.gymseries.generics.async

import android.content.Context
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.GenericsUtil

class UpdateGeneric<T>(
    context: Context,
    status:Boolean,
    peso:EditText,
    repeticao:EditText,
    serie:String,
    op: Int,
    t: T,
    val list: ArrayList<T>,
    val adapter: RecyclerView.Adapter<*>
) :
    BaseUpdateAsync<T>(context = context,
        status = status,
        peso = peso,
        repeticao = repeticao,
        serie = serie,
        op = op,
        t = t) {

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        if(GenericsUtil<T>().results(result, list))
            adapter.notifyDataSetChanged()
    }
}
