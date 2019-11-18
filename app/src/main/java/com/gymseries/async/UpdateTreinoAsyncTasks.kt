package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.database.AppData

class UpdateTreinoAsyncTasks<T>(val context: Context,
                             val numRepeticao: String,
                             val kg: String,
                             val status: Boolean): AsyncTask<String, String, List<T>>() {

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: String?): List<T> {
        return emptyList()
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun onCancelled() {
        super.onCancelled()
    }

    override fun onCancelled(result: List<T>?) {
        super.onCancelled(result)
    }

}
