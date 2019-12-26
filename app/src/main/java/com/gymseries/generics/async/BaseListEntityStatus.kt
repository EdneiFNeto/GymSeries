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
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.utils.ResourcesUtils

abstract class BaseListEntityStatus<T>(
    private val context: Context?,
    private val op:String,
    private val status:Boolean) : AsyncTask<String, String, List<T>>() {

    override fun doInBackground(vararg params: String?): List<T> {

        var appData = AppData.getInstance(context)
        var where = arrayOf(status)

        return when (op) {
            ResourcesUtils.getString(context, R.string.op_biceps) -> return appData?.bicepsRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Biceps WHERE status = ?", where)) as List<T>
            ResourcesUtils.getString(context, R.string.op_triceps) -> return appData?.tricepsRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Triceps WHERE status = ?",where)) as List<T>
            ResourcesUtils.getString(context, R.string.op_peito) -> return appData?.peitoRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Peito WHERE status = ?", where)) as List<T>
            ResourcesUtils.getString(context, R.string.op_ombro) -> return appData?.ombroRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Ombro WHERE status = ?", where)) as List<T>
            ResourcesUtils.getString(context, R.string.op_costa) -> return appData?.costaRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Costa WHERE status = ?", where)) as List<T>
            ResourcesUtils.getString(context, R.string.op_perna) -> return appData?.pernaRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Perna WHERE status = ?", where)) as List<T>
            else -> emptyList()
        }
    }
}
