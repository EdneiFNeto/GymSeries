package com.gymseries.generics.async

import android.content.Context
import android.util.Log
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
class ListEntityForStatus<T>(
    context: Context,
    private val lista: ArrayList<T>,
    private val adapter: RecyclerView.Adapter<*>,
    op:Int,
    status:Boolean
) : BaseListEntityStatus<T>(context = context, op = op, status = status){

    private val TAG = "ListEntityForStatusLog"

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        if(GenericsUtil<T>().results(result, lista)){
            adapter.notifyDataSetChanged()
            Log.e(TAG, "List ${lista.size}")
        }else{
            Log.e(TAG, "List empty ${lista.size}")
        }
    }
}
