package com.gymseries.generics.async

import android.content.Context
import android.os.AsyncTask
import android.util.Log
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
abstract class BaseAddAsync<T>(
    val context: Context?,
    private val op: Int,
    private val list: List<T>) :
        AsyncTask<String, String, List<T>>() {

    private var TAG = "BaseAddAsyncLog"
    override fun doInBackground(vararg params: String?): List<T> {

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
                if (list.isNotEmpty()) {
                    for (t in list) {
                        var b = t as Biceps
                        var insert = bicepsRoom.insert(b)
                        Log.e(TAG, "Insert $insert")
                    }
                }
                return bicepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Biceps")) as List<T>
            }
            1 -> {
                if (list.isNotEmpty()) {
                    for (t in list) {
                        var b = t as Triceps
                        var insert = tricepsRoom.insert(b)
                        Log.e(TAG, "Insert $insert")
                    }
                }
                return tricepsRoom.all(SimpleSQLiteQuery("SELECT * FROM Triceps")) as List<T>
            }
            2 -> {
                if (list.isNotEmpty()) {
                    for (t in list) {
                        var b = t as Peito
                        var insert = peitoRoom.insert(b)
                        Log.e(TAG, "Insert $insert")
                    }
                }
                return peitoRoom.all(SimpleSQLiteQuery("SELECT * FROM Peito")) as List<T>
            }
            3 -> {
                if (list.isNotEmpty()) {
                    for (t in list) {
                        var b = t as Ombro
                        var insert = ombroRoom.insert(b)
                        Log.e(TAG, "Insert $insert")
                    }
                }
                return ombroRoom.all(SimpleSQLiteQuery("SELECT * FROM Ombro")) as List<T>
            }
            4 -> {
                if (list.isNotEmpty()) {
                    for (t in list) {
                        var b = t as Costa
                        var insert = costaRoom.insert(b)
                        Log.e(TAG, "Insert $insert")
                    }
                }
                return costaRoom.all(SimpleSQLiteQuery("SELECT * FROM Costa")) as List<T>
            }
            5 -> {
                if (list.isNotEmpty()) {
                    for (t in list) {
                        var b = t as Perna
                        var insert = pernaRoom.insert(b)
                        Log.e(TAG, "Insert $insert")
                    }
                }
                return pernaRoom.all(SimpleSQLiteQuery("SELECT * FROM Perna")) as List<T>
            }
            6 -> {
                if (list.isNotEmpty()) {
                    for (t in list) {
                        var b = t as IMC
                        var insert = imcRoom.insert(b)
                        Log.e(TAG, "Insert $insert")
                    }
                }
                return imcRoom.all(SimpleSQLiteQuery("SELECT * FROM IMC")) as List<T>
            }
            else -> emptyList()
        }
    }
}

