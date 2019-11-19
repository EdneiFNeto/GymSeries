package com.gymseries.generics.async

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.database.DataBaseGeneric

abstract class AsyncGererics<T>(
    val context: Context,
    var entity: T,
    val lists: ArrayList<T>
) : AsyncTask<String, String, List<T>>() {

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: String?): List<T> {
        var generic = DataBaseGeneric.getInstance(context)
        var dao = generic.getOmbroRoom()
        return dao.all(SimpleSQLiteQuery("SELECT * FROM $entity"))
    }
}
