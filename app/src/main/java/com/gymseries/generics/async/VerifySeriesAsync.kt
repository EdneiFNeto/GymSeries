package com.gymseries.generics.async

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.model.Serie
import com.gymseries.utils.LoggerUtil
import com.gymseries.utils.ResourcesUtils
import java.util.ArrayList

/**
 * Verify exists data, if exists:
 * 1- Update data
 * Not exits :
 * 2 - Insert data
 */

class VerifySeriesAsync<T>(
    val context: Context?,
    val op: String,
    val series: ArrayList<T?>
) : AsyncTask<T, T, ArrayList<T>>() {

    val TAG = "VerifySeriesAsyncLog"

    override fun doInBackground(vararg params: T?): ArrayList<T> {

        var data = AppData.getInstance(context)

        when (op) {
            ResourcesUtils.getString(context, R.string.op_serie) -> {
                var serieRoom = data?.serieRoom()

                for(r in series){

                    var n = r as Serie
                    var all = serieRoom?.all(SimpleSQLiteQuery("SELECT * FROM Serie WHERE descr = ?",arrayOf(n.descr)))

                    if (all != null) {
                        if (all.isNotEmpty()) {
                            for (s in series) {
                                var serie = s as Serie
                                var update = serieRoom?.update(serie)
                                LoggerUtil(TAG).error("update $update")
                            }
                        }
                        return all as ArrayList<T>
                    }else{
                        //insert series
                        for(r in series){
                            var serie = r as Serie
                            var insert = serieRoom?.insert(serie)
                            LoggerUtil(TAG).error("Insert $insert")
                        }
                    }
                }
                return arrayListOf()
            }
        }

        return arrayListOf()
    }
}
