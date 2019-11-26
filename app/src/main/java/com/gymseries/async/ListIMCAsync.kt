package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.adapter.IMCAdapter
import com.gymseries.database.AppData
import com.gymseries.model.IMC
import java.util.*

class ListIMCAsync(val context: Context?,
                   val imcs: ArrayList<IMC>,
                   val adapter: IMCAdapter) : AsyncTask<String, String, List<IMC>>() {

    override fun doInBackground(vararg params: String?): List<IMC>? {
        var appData = AppData.getInstance(context)
        return appData?.imcRoom()?.all(SimpleSQLiteQuery("SELECT * FROM IMC ORDER BY id DESC"))
    }

    override fun onPostExecute(result: List<IMC>?) {
        super.onPostExecute(result)
        if(result!=null){
            if(result.isNotEmpty()){
                for(i in result)
                    imcs.add(i)
                adapter.notifyDataSetChanged()
            }
        }
    }

}
