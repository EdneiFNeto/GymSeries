package com.gymseries.generics.async

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.utils.ResourcesUtils

abstract class BaseListAsync<T>(
    val context: Context?,
    private val op:String
) : AsyncTask<String, String, List<T>>() {

    override fun doInBackground(vararg params: String?): List<T> {
        var appData = AppData.getInstance(context)
        return when(op){
            ResourcesUtils.getString(context, R.string.op_biceps)-> return appData?.bicepsRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Biceps")) as List<T>
            ResourcesUtils.getString(context, R.string.op_triceps)-> return appData?.tricepsRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Triceps")) as List<T>
            ResourcesUtils.getString(context, R.string.op_peito)-> return appData?.peitoRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Peito")) as List<T>
            ResourcesUtils.getString(context, R.string.op_ombro)-> return appData?.ombroRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Ombro")) as List<T>
            ResourcesUtils.getString(context, R.string.op_costa)-> return appData?.costaRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Costa")) as List<T>
            ResourcesUtils.getString(context, R.string.op_perna)-> return appData?.pernaRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Perna")) as List<T>
            ResourcesUtils.getString(context, R.string.op_imc)-> return appData?.imcRoom()?.all(SimpleSQLiteQuery("SELECT * FROM IMC")) as List<T>
            ResourcesUtils.getString(context, R.string.op_user)-> return appData?.userRoom()?.all(SimpleSQLiteQuery("SELECT * FROM User")) as List<T>
            ResourcesUtils.getString(context, R.string.op_serie)-> return appData?.serieRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Serie ORDER BY serie ASC")) as List<T>
            else -> emptyList()
        }
    }

}
