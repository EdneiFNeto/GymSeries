package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.GenericsUtil
import com.gymseries.adapter.MyGenericAdapter
import com.gymseries.database.AppData
import com.gymseries.model.IMC
import java.util.ArrayList

class InsertIMC(
    val context: Context?,
    val imcs: ArrayList<IMC>,
    val adapter: MyGenericAdapter<IMC>?
) : AsyncTask<String, String, List<IMC>>() {
    private val TAG = "InsertIMCLog"

    override fun doInBackground(vararg params: String?): List<IMC> {

        var appData = AppData.getInstance(context)
        var imcRoom = appData?.imcRoom()

        if (imcs.isNotEmpty()) {
            for (i in imcs)
                imcRoom?.insert(i)
        }

        if (imcRoom != null) {
            return imcRoom.all(SimpleSQLiteQuery("SELECT * FROM IMC"))
        }

        return emptyList()
    }

    override fun onPostExecute(result: List<IMC>?) {
        super.onPostExecute(result)

        if(result!=null){
            if(result.isNotEmpty()){
                for(i in result){
                    Log.e(TAG, "result ${i.peso}")
                    Log.e(TAG, "result ${i.altura}")
                    Log.e(TAG, "result ${i.resultado}")
                }

                adapter?.notifyDataSetChanged()
            }
        }
    }

}
