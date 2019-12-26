package com.gymseries.generics.async

import android.content.Context
import android.os.AsyncTask
import android.widget.EditText
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.model.*
import com.gymseries.utils.ResourcesUtils

abstract class BaseUpdateAsync<T>(
    private val context: Context,
    private val status: Boolean,
    private val peso: EditText,
    private val repeticao: EditText,
    private val serie:String,
    private val op: String,
    private val t: T
) : AsyncTask<String, String, List<T>>() {
    private val TAG = "BaseUpdateAsyncLog"

    override fun doInBackground(vararg params: String?): List<T> {

        var appData = AppData.getInstance(context)
        var bicepsRoom = appData!!.bicepsRoom()
        var tricepsRoom = appData!!.tricepsRoom()
        var peitoRoom = appData!!.peitoRoom()
        var ombroRoom = appData!!.ombroRoom()
        var costaRoom = appData!!.costaRoom()
        var pernaRoom = appData!!.pernaRoom()


        return when (op) {
            ResourcesUtils.getString(context, R.string.op_biceps) -> {
                var r = t as Biceps
                bicepsRoom.update(
                    Biceps(
                        id = r.id,
                        descr = r.descr,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        serie = serie
                    )
                )

                return bicepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Biceps")) as List<T>
            }
            ResourcesUtils.getString(context, R.string.op_triceps) -> {
                var r = t as Triceps
                tricepsRoom.update(
                    Triceps(
                        id = r.id,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        descr = r.descr,
                        serie = serie
                    )
                )
                return tricepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Triceps")) as List<T>
            }
            ResourcesUtils.getString(context, R.string.op_peito) -> {
                var r = t as Peito
                peitoRoom.update(
                    Peito(
                        id = r.id,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        descr = r.descr,
                        serie = serie
                    )
                )
                return peitoRoom.all(SimpleSQLiteQuery("SELECT * FROM Peito")) as List<T>
            }
            ResourcesUtils.getString(context, R.string.op_ombro) -> {
                var r = t as Ombro
                ombroRoom.update(
                    Ombro(
                        id = r.id,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        descr = r.descr,
                        serie = serie
                    )
                )
                return ombroRoom.all(SimpleSQLiteQuery("SELECT * FROM Ombro")) as List<T>
            }
            ResourcesUtils.getString(context, R.string.op_costa) -> {
                var r = t as Costa
                costaRoom.update(
                    Costa(
                        id = r.id,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        descr = r.descr,
                        serie = serie
                    )
                )
                return costaRoom.all(SimpleSQLiteQuery("SELECT * FROM Costa")) as List<T>
            }
            ResourcesUtils.getString(context, R.string.op_perna) -> {
                var r = t as Perna
                pernaRoom.update(
                    Perna(
                        id = r.id,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        descr = r.descr,
                        serie = serie
                    )
                )
                return pernaRoom.all(SimpleSQLiteQuery("SELECT * FROM Perna")) as List<T>
            }
            else -> emptyList()
        }

    }
}
