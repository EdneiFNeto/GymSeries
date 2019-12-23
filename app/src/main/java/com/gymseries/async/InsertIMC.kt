package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.adapter.UserAdapter
import com.gymseries.database.AppData
import com.gymseries.model.IMC
import java.util.ArrayList

class InsertIMC(
    val context: Context?,
    val imcs: ArrayList<IMC>,
    val adapter: UserAdapter
) : AsyncTask<String, String, List<IMC>>() {
    private val TAG = "InsertIMCLog"

    override fun doInBackground(vararg params: String?): List<IMC>? {

        var appData = AppData.getInstance(context)
        var imcRoom = appData?.imcRoom()

        if (imcs.isNotEmpty()) {
            for (i in imcs)
                imcRoom?.insert(i)
        }

        return imcRoom?.all(SimpleSQLiteQuery("SELECT * FROM IMC ORDER BY id DESC"))
    }

    override fun onPostExecute(result: List<IMC>?) {
        super.onPostExecute(result)

        if(result!=null){
            if(result.isNotEmpty()){
                imcs.clear()
                for(i in result){
                    Log.e(TAG, "IMC ${i.imc}")
                    imcs.add(i)
                }
                adapter?.notifyDataSetChanged()
            }
        }
    }

}
