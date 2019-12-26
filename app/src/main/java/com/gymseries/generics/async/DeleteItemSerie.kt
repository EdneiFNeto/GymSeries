package com.gymseries.generics.async

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.database.AppData
import com.gymseries.utils.LoggerUtil

class DeleteItemSerie<T>(
    val context: Context,
    val descr: String,
    val result: List<T>
) : AsyncTask<T, T, ArrayList<T>>() {

    val TAG = "DeleteItemSerieLog"

    override fun doInBackground(vararg params: T): ArrayList<T> {
        var appData = AppData.getInstance(context)
        var serieRoom = appData?.serieRoom()
        var all = serieRoom?.all(SimpleSQLiteQuery("SELECT * FROM Serie WHERE descr = ?", arrayOf(descr)))
        if (all != null) {
            if (all.isNotEmpty()) {
                for (a in all) {
                    var delete = serieRoom?.delete(a)
                    LoggerUtil(TAG).error("Delete $delete")
                }
            }
        }
        return all as ArrayList<T>
    }

}
