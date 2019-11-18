package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.gymseries.adapter.TricepsSelecionadoAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Triceps
import java.util.*

class ListarTricepsSelecionados(
    val context: Context,
    private val adapter: TricepsSelecionadoAdapter,
    private val triceps: ArrayList<Triceps>
) : AsyncTask<String, String, List<Triceps>>() {

    private var TAG: String= "ListarTricepsSelectLog"

    override fun onPostExecute(result: List<Triceps>?) {
        super.onPostExecute(result)

        if(result != null){
            if(result.isNotEmpty()){

                for(t in result){

                    Log.e(TAG,"Trices ${t.descr}")
                    Log.e(TAG,"Trices ${t.status}")
                    Log.e(TAG,"Trices ${t.repeticoes}")
                    Log.e(TAG,"Trices ${t.peso}")
                    triceps.add(t)
                }

                adapter.notifyDataSetChanged()
            }else{
                Log.e(TAG, "Triceps empty")
            }
        }else{
            Log.e(TAG, "Result == null")
        }
    }

    override fun doInBackground(vararg p0: String?): List<Triceps> {
        var data = AppData.getInstance(context)
        var dao = data.tricepsDao()
        return dao.allStates(true)
    }


}
