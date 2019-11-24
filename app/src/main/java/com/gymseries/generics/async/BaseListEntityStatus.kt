package com.gymseries.generics.async


/**
 * Options:
 * 0 - Biceps
 * 1 - Triceps
 * 2 - Peito
 * 3 - Ombro
 * 4 - Costas
 * 5 - Perna
 */

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.database.AppData

abstract class BaseListEntityStatus<T>(
    private val context: Context?,
    private val op:Int,
    private val status:Boolean) : AsyncTask<String, String, List<T>>() {

    override fun doInBackground(vararg params: String?): List<T> {

        var appData = AppData.getInstance(context)
        var status = arrayOf(status)

        return when (op) {
            0 -> return appData!!.bicepsRoom().all(SimpleSQLiteQuery("SELECT * FROM Biceps WHERE status = ?", status)) as List<T>
            1 -> return appData!!.tricepsRoom().all(SimpleSQLiteQuery("SELECT * FROM Triceps WHERE status = ?", status)) as List<T>
            2 -> return appData!!.peitoRoom().all(SimpleSQLiteQuery("SELECT * FROM Peito WHERE status = ?", status)) as List<T>
            3 -> return appData!!.ombroRoom().all(SimpleSQLiteQuery("SELECT * FROM Ombro WHERE status = ?", status)) as List<T>
            4 -> return appData!!.costaRoom().all(SimpleSQLiteQuery("SELECT * FROM Costa WHERE status = ?", status)) as List<T>
            5 -> return appData!!.pernaRoom().all(SimpleSQLiteQuery("SELECT * FROM Perna WHERE status = ?", status)) as List<T>
            else -> emptyList()
        }
    }
}
