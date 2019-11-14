package com.gymseries.async

import android.content.Context
import android.os.AsyncTask

class UpdateTreinoAsyncTasks<T>(val context: Context,
                             val numRepeticao: String,
                             val kg: String,
                             val status: Boolean): AsyncTask<String, String, List<T>>() {

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: String?): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
