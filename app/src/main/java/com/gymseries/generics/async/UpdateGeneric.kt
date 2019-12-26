package com.gymseries.generics.async

import android.content.Context
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.GenericsUtil


/**
 * Update entity:
 * Select entity and insert data in Series
 * Sucess, insert entty in data base
 */
class UpdateGeneric<T>(
    val context: Context,
    val status: Boolean,
    peso: EditText,
    repeticao: EditText,
    val title: String,
    serie: String,
    val op: String,
    t: T,
    val list: ArrayList<T>,
    val adapter: RecyclerView.Adapter<*>
) : BaseUpdateAsync<T>(
    context = context, status = status, peso = peso, repeticao = repeticao,
    serie = serie, op = op, t = t
) {

    private val TAG = "UpdateGenericLog"


    //when is success update,
    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        if (GenericsUtil<T>().results(result, list)) {
            adapter.notifyDataSetChanged()
            if (result != null) {
                if (result.isNotEmpty()) {
                    if (status) {
                        //list data where status is true
                        ListEntityForStatus(context, list, adapter, op, true).execute()
                    }else{
                        //delete item series
                        DeleteItemSerie(context, title, result).execute()
                    }
                }
            }

        }
    }
}

