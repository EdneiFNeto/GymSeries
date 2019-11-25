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
    val context: Context?,
    val op: Int,
    private val list: List<T>
) : AsyncTask<String, String, List<T>>() {

    override fun doInBackground(vararg p0: String?): List<T> {

        var appData = AppData.getInstance(context)
        var bicepsRoom = appData!!.bicepsRoom()
        var tricepsRoom = appData!!.tricepsRoom()
        var peitoRoom = appData!!.peitoRoom()
        var ombroRoom = appData!!.ombroRoom()
        var costaRoom = appData!!.costaRoom()
        var pernaRoom = appData!!.pernaRoom()
        var imcRoom = appData!!.imcRoom()

        return when (op) {
            0 -> {
                var all = bicepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Biceps")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var b = t as Biceps
                        bicepsRoom.insert(b)
                    }
                }
                return all
            }
            1 -> {
                var all = bicepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Triceps")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as Triceps
                        tricepsRoom.insert(r)
                    }
                }
                return all
            }
            2 -> {
                var all = bicepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Peito")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as Peito
                        peitoRoom.insert(r)
                    }
                }
                return all

            }
            3 -> {

                var all = bicepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Ombro")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as Ombro
                        ombroRoom.insert(r)
                    }
                }
                return all
            }
            4 -> {
                var all = bicepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Costa")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as Costa
                        costaRoom.insert(r)
                    }
                }
                return all

            }
            5 -> {
                var all = bicepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Perna")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as Perna
                        pernaRoom.insert(r)
                    }
                }
                return all
            }
            6 -> {
                var all = imcRoom.all(SimpleSQLiteQuery("SELECT * FROM IMC")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as IMC
                        imcRoom.insert(r)
                    }
                }
                return all
            }
            else -> emptyList()
        }
    }
}
