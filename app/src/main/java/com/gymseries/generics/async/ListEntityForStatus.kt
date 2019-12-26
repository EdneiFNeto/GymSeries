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


    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        LoggerUtil(TAG).error("Results $result")

        if (result != null) {
            if (result.isNotEmpty()) {

                for (r in result) {

                    when(op){

                        ResourcesUtils.getString(context, R.string.op_biceps)->{
                            var b = r as Biceps
                            series.add(Serie(id = b.id, descr = b.descr, peso = b.peso, repeticoes = b.repeticoes, serie = b.serie, status = b.status))
                        }
                        ResourcesUtils.getString(context, R.string.op_triceps)->{
                            var t = r as Triceps
                            series.add(Serie(id = t.id, descr = t.descr, peso = t.peso, repeticoes = t.repeticoes, serie = t.serie, status = t.status))
                        }
                        ResourcesUtils.getString(context, R.string.op_ombro)->{
                            var t = r as Ombro
                            series.add(Serie(id = t.id, descr = t.descr, peso = t.peso, repeticoes = t.repeticoes, serie = t.serie, status = t.status))
                        }
                        ResourcesUtils.getString(context, R.string.op_peito)->{
                            var t = r as Peito
                            series.add(Serie(id = t.id, descr = t.descr, peso = t.peso, repeticoes = t.repeticoes, serie = t.serie, status = t.status))
                        }
                        ResourcesUtils.getString(context, R.string.op_perna)->{
                            var t = r as Perna
                            series.add(Serie(id = t.id, descr = t.descr, peso = t.peso, repeticoes = t.repeticoes, serie = t.serie, status = t.status))
                        }
                        ResourcesUtils.getString(context, R.string.op_costa)->{
                            var t = r as Costa
                            series.add(Serie(id = t.id, descr = t.descr, peso = t.peso, repeticoes = t.repeticoes, serie = t.serie, status = t.status))
                        }
                    }
                }

                LoggerUtil(TAG).error("Series $series")
                InserGenericAsync(context, ResourcesUtils.getString(context, R.string.op_serie), series).execute()
            }
        }
    }
}
