package com.gymseries.generics.async

import android.content.Context
import android.os.AsyncTask
import android.widget.EditText
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.database.AppData
import com.gymseries.model.*

abstract class BaseUpdateAsync<T>(
    private val context: Context,
    private val status: Boolean,
    private val peso: EditText,
    private val repeticao: EditText,
    private val op: Int,
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
            0 -> {
                var r = t as Biceps
                bicepsRoom.update(
                    Biceps(
                        id = r.id,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        descr = r.descr
                    )
                )

                return bicepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Biceps")) as List<T>
            }
            1 -> {
                var r = t as Triceps
                tricepsRoom.update(
                    Triceps(
                        id = r.id,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        descr = r.descr
                    )
                )
                return tricepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Triceps")) as List<T>
            }
            2 -> {
                var r = t as Peito
                peitoRoom.update(
                    Peito(
                        id = r.id,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        descr = r.descr
                    )
                )
                return peitoRoom.all(SimpleSQLiteQuery("SELECT * FROM Peito")) as List<T>
            }
            3 -> {
                var r = t as Ombro
                ombroRoom.update(
                    Ombro(
                        id = r.id,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        descr = r.descr
                    )
                )
                return ombroRoom.all(SimpleSQLiteQuery("SELECT * FROM Ombro")) as List<T>
            }
            4 -> {
                var r = t as Costa
                costaRoom.update(
                    Costa(
                        id = r.id,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        descr = r.descr
                    )
                )
                return costaRoom.all(SimpleSQLiteQuery("SELECT * FROM Costa")) as List<T>
            }
            5 -> {
                var r = t as Perna
                pernaRoom.update(
                    Perna(
                        id = r.id,
                        repeticoes = repeticao.text.toString(),
                        peso = peso.text.toString(),
                        status = status,
                        descr = r.descr
                    )
                )
                return pernaRoom.all(SimpleSQLiteQuery("SELECT * FROM Perna")) as List<T>
            }
            else -> emptyList()
        }

    }
}
