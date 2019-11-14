package com.gymseries.async

import android.content.AbstractThreadedSyncAdapter
import android.content.Context
import android.os.AsyncTask
import android.widget.BaseAdapter
import com.gymseries.database.AppData

open class BaseAsyncTasks<T>(val context: Context, val adapter: BaseAdapter) :
    AsyncTask<T, T, List<T>>() {

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
        if (result != null) {
            if (result.isNotEmpty()) {
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun doInBackground(vararg params: T): List<T> {
        var room = AppData.getInstance(context)
        return listOf()
    }
}

