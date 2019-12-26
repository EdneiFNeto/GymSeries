package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.database.AppData
import kotlin.collections.ArrayList

class ListStatusSerie<T>(
    val context: Context,
    val list: ArrayList<T>,
    val status: Boolean
): AsyncTask<T, T, ArrayList<T>>() {

    override fun doInBackground(vararg params: T): ArrayList<T> {
        var data = AppData.getInstance(context)
        var serieRoom = data?.serieRoom()
        var all = serieRoom?.all(SimpleSQLiteQuery("SELECT * FROM Serie WHERE status = ?", arrayOf(true)))
        return all as ArrayList<T>
    }

    override fun onPostExecute(result: ArrayList<T>?) {
        super.onPostExecute(result)
        if(result!=null){
            if (result.isNotEmpty()){

                //get title
            }
        }
    }

}
