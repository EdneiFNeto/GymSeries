package com.gymseries.generics

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.database.AppData
import com.gymseries.model.*

abstract class BaseDeleteAsync<T>(val context: Context,
                                  private val op: Int,
                                  private val t: T) : AsyncTask<String, String, List<T>>() {

    override fun doInBackground(vararg params: String?): List<T> {

        var appData = AppData.getInstance(context)
        var bicepsRoom = appData?.bicepsRoom()
        var tricepsRoom = appData?.tricepsRoom()
        var peitoRoom = appData?.peitoRoom()
        var ombroRoom = appData?.ombroRoom()
        var pernaRoom = appData?.pernaRoom()
        var costaRoom = appData?.costaRoom()

        return when (op) {
            0 -> {
                var b = t as Biceps
                bicepsRoom?.delete(b)
                return bicepsRoom?.all(SimpleSQLiteQuery("SELECT * FROM Biceps")) as List<T>
            }
            1 -> {
                var b = t as Triceps
                tricepsRoom?.delete(b)
                return tricepsRoom?.all(SimpleSQLiteQuery("SELECT * FROM Triceps")) as List<T>
            }
            2 -> {
                var b = t as Peito
                peitoRoom?.delete(b)
                return peitoRoom?.all(SimpleSQLiteQuery("SELECT * FROM Peito")) as List<T>
            }
            3 -> {
                var b = t as Ombro
                ombroRoom?.delete(b)
                return ombroRoom?.all(SimpleSQLiteQuery("SELECT * FROM Ombro")) as List<T>
            }
            4 -> {
                var b = t as Costa
                costaRoom?.delete(b)
                return pernaRoom?.all(SimpleSQLiteQuery("SELECT * FROM Costa")) as List<T>
            }
            5 -> {
                var b = t as Perna
                pernaRoom?.delete(b)
                return pernaRoom?.all(SimpleSQLiteQuery("SELECT * FROM Perna")) as List<T>
            }
            else -> emptyList()
        }
    }
}
