package com.gymseries.generics.async

import android.content.Context
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.GenericsUtil
import com.gymseries.model.Biceps
import com.gymseries.model.Serie
import com.gymseries.utils.LoggerUtil


/**
 * Update entity:
 * Select entity and insert data in Series
 * Sucess, insert entty in data base
*/
class UpdateGeneric<T>(
    val context: Context,
    status: Boolean,
    peso: EditText,
    repeticao: EditText,
    serie: String,
    val op: String,
    t: T,
    val list: ArrayList<T>,
    val adapter: RecyclerView.Adapter<*>
) : BaseUpdateAsync<T>(
    context = context, status = status, peso = peso, repeticao = repeticao,
    serie = serie, op = op, t = t) {

    private val TAG = "UpdateGenericLog"

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        if (GenericsUtil<T>().results(result, list)) {
            adapter.notifyDataSetChanged()
            if (result != null) {
                if (result.isNotEmpty()){
                    ListEntityForStatus(context, list, adapter, op, true ).execute()
                }
            }
        }
    }
}

