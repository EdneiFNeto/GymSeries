package com.gymseries.generics.async

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.database.AppData

abstract class BaseListAsync<T>(
    val context: Context,
    private val op:Int
) : AsyncTask<String, String, List<T>>() {

    override fun doInBackground(vararg params: String?): List<T> {
        var appData = AppData.getInstance(context)
        return when(op){
            0-> return appData.bicepsRoom().all(SimpleSQLiteQuery("SELECT * FROM Biceps")) as List<T>
            1-> return appData.tricepsRoom().all(SimpleSQLiteQuery("SELECT * FROM Triceps")) as List<T>
            2-> return appData.peitoRoom().all(SimpleSQLiteQuery("SELECT * FROM Peito")) as List<T>
            3-> return appData.ombroRoom().all(SimpleSQLiteQuery("SELECT * FROM Ombro")) as List<T>
            4-> return appData.costaRoom().all(SimpleSQLiteQuery("SELECT * FROM Costa")) as List<T>
            5-> return appData.pernaRoom().all(SimpleSQLiteQuery("SELECT * FROM Perna")) as List<T>
            else -> emptyList()
        }
    }

}
