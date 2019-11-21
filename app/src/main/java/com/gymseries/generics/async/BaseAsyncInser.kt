package com.gymseries.generics

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.database.AppData
import com.gymseries.model.*

/**
 * Options:
 * 0 - biceps
 * 1 - triceps
 * 2 - Peito
 * 3 - Ombro
 * 4 - Costas
 * 5 - Perna
 */

abstract class BaseAsyncInser<T>(
    val context: Context,
    val op: Int,
    private val list: List<T>
) : AsyncTask<String, String, List<T>>() {

    override fun doInBackground(vararg p0: String?): List<T> {

        var appData = AppData.getInstance(context)
        var bicepsRoom = appData.bicepsRoom()
        var tricepsRoom = appData.tricepsRoom()
        var peitoRoom = appData.peitoRoom()
        var ombroRoom = appData.ombroRoom()
        var costaRoom = appData.costaRoom()
        var pernaRoom = appData.pernaRoom()

        return when (op) {
            0 -> {
                for (t in list) {
                    var b = t as Biceps
                    bicepsRoom.insert(b)
                }

                return bicepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Biceps")) as List<T>
            }
            1 -> {
                for (t in list) {
                    var r = t as Triceps
                    tricepsRoom.insert(r)
                }

                return tricepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Triceps")) as List<T>
            }
            2 -> {
                for (t in list) {
                    var r = t as Peito
                    peitoRoom.insert(r)
                }
                return peitoRoom.all(SimpleSQLiteQuery("SELECT * FROM Peito")) as List<T>

            }
            3 -> {
                for (t in list) {
                    var r = t as Ombro
                    ombroRoom.insert(r)
                }
                return ombroRoom.all(SimpleSQLiteQuery("SELECT * FROM Ombro")) as List<T>
            }
            4 -> {
                for (t in list) {
                    var r = t as Costa
                    costaRoom.insert(r)
                }

                return costaRoom.all(SimpleSQLiteQuery("SELECT * FROM Costa")) as List<T>

            }
            5 -> {
                for (t in list) {
                    var r = t as Perna
                    pernaRoom.insert(r)
                }
                return pernaRoom.all(SimpleSQLiteQuery("SELECT * FROM Perna")) as List<T>
            }
            else -> emptyList()
        }
    }
}
