package com.gymseries.generics.async

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.generics.InserGenericAsync
import com.gymseries.model.*
import com.gymseries.utils.LoggerUtil
import com.gymseries.utils.ResourcesUtils
/**
 * Save entity in Series
 **/
class ListEntityForStatus<T>(
    val context: Context?,
    private val lista: ArrayList<T>,
    private val adapter: RecyclerView.Adapter<*>,
    val op: String,
    status: Boolean
) : BaseListEntityStatus<T>(context = context, op = op, status = status) {

    private val TAG = "ListEntityForStatusLog"
    private var series = ArrayList<Serie?>()


    //if is result is success, list data and add in array series
    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        LoggerUtil(TAG).error("Results $result")

        if (result != null) {
            if (result.isNotEmpty()) {
                for (r in result) {
                    when(op){
                        ResourcesUtils.getString(context, R.string.op_biceps)->{
                            var b = r as Biceps
                            var serie = Serie(null, b.descr, b.peso, b.repeticoes,b.serie,  b.status)
                            series.add(serie)
                        }
                        ResourcesUtils.getString(context, R.string.op_triceps)->{
                            var b = r as Triceps
                            var serie = Serie(null, b.descr, b.peso, b.repeticoes,b.serie,  b.status)
                            series.add(serie)
                        }
                        ResourcesUtils.getString(context, R.string.op_ombro)->{
                            var b = r as Ombro
                            var serie = Serie(null, b.descr, b.peso, b.repeticoes,b.serie,  b.status)
                            series.add(serie)
                        }
                        ResourcesUtils.getString(context, R.string.op_peito)->{
                            var b = r as Peito
                            var serie = Serie(null, b.descr, b.peso, b.repeticoes,b.serie,  b.status)
                            series.add(serie)
                        }
                        ResourcesUtils.getString(context, R.string.op_perna)->{
                            var b = r as Perna
                            var serie = Serie(null, b.descr, b.peso, b.repeticoes,b.serie,  b.status)
                            series.add(serie)
                        }
                        ResourcesUtils.getString(context, R.string.op_costa)->{
                            var b = r as Costa
                            var serie = Serie(null, b.descr, b.peso, b.repeticoes,b.serie,  b.status)
                            series.add(serie)
                        }
                    }
                }

                //verify exists
                InserGenericAsync(context, ResourcesUtils.getString(context, R.string.op_serie), series).execute()
            }
        }
    }
}
