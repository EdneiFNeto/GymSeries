package com.gymseries.generics

import android.content.Context
import android.content.Intent
import android.util.Log
import com.gymseries.ui.MainActivity

class InserGenericAsync<T>(
    context: Context,
    op: Int,
    list: ArrayList<T>
) : BaseAsyncInser<T>(context = context, op = op, list = list) {

    private val TAG = "InserGenericAsyncLog"

    override fun onPostExecute(result: List<T>?) {
        super.onPostExecute(result)

        if(result!=null){
            if(result.isNotEmpty()){
                for(n in result){
                    Log.e(TAG, "Result ${n.toString()}")
                }
            }
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}
