package com.gymseries.generics

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.model.*
import com.gymseries.utils.LoggerUtil
import com.gymseries.utils.ResourcesUtils


abstract class BaseAsyncInser<T>(
    val context: Context?,
    val op: String,
    private val list: List<T>
) : AsyncTask<String, String, List<T>>() {

    private val TAG = "BaseAsyncInserLog"

    override fun doInBackground(vararg p0: String?): List<T> {

        var appData = AppData.getInstance(context)
        var bicepsRoom = appData?.bicepsRoom()
        var tricepsRoom = appData?.tricepsRoom()
        var peitoRoom = appData?.peitoRoom()
        var ombroRoom = appData?.ombroRoom()
        var costaRoom = appData?.costaRoom()
        var pernaRoom = appData?.pernaRoom()
        var imcRoom = appData?.imcRoom()
        var usersRoom = appData?.userRoom()
        var serieRoom = appData?.serieRoom()

        return when (op) {
            ResourcesUtils.getString(context, R.string.op_biceps) -> {
                var all = bicepsRoom?.all(SimpleSQLiteQuery("SELECT * FROM Biceps")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var b = t as Biceps
                        bicepsRoom.insert(b)
                    }
                }
                return all
            }
            ResourcesUtils.getString(context, R.string.op_triceps) -> {
                var all = bicepsRoom?.all(SimpleSQLiteQuery("SELECT * FROM Triceps")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as Triceps
                        tricepsRoom?.insert(r)
                    }
                }
                return all
            }
            ResourcesUtils.getString(context, R.string.op_peito) -> {
                var all = bicepsRoom?.all(SimpleSQLiteQuery("SELECT * FROM Peito")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as Peito
                        peitoRoom?.insert(r)
                    }
                }
                return all

            }
            ResourcesUtils.getString(context, R.string.op_ombro) -> {

                var all = bicepsRoom?.all(SimpleSQLiteQuery("SELECT * FROM Ombro")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as Ombro
                        ombroRoom?.insert(r)
                    }
                }
                return all
            }
            ResourcesUtils.getString(context, R.string.op_costa) -> {
                var all = bicepsRoom?.all(SimpleSQLiteQuery("SELECT * FROM Costa")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as Costa
                        costaRoom?.insert(r)
                    }
                }
                return all

            }
            ResourcesUtils.getString(context, R.string.op_perna) -> {
                var all = bicepsRoom?.all(SimpleSQLiteQuery("SELECT * FROM Perna")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as Perna
                        pernaRoom?.insert(r)
                    }
                }
                return all
            }
            ResourcesUtils.getString(context, R.string.op_imc) -> {
                var all = imcRoom?.all(SimpleSQLiteQuery("SELECT * FROM IMC")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as IMC
                        imcRoom?.insert(r)
                    }
                }
                return all
            }
            ResourcesUtils.getString(context, R.string.op_user) -> {
                var all = usersRoom?.all(SimpleSQLiteQuery("SELECT * FROM User")) as List<T>
                if (all.isEmpty()) {
                    for (t in list) {
                        var r = t as User
                        usersRoom?.insert(r)
                    }
                }
                return all
            }
            ResourcesUtils.getString(context, R.string.op_serie) -> {
                for(n in list){
                    var s = n as Serie
                    LoggerUtil(TAG).error("Descr ${s.descr}")
                    LoggerUtil(TAG).error("Descr ${s.peso}")
                    LoggerUtil(TAG).error("Descr ${s.repeticoes}")
                    LoggerUtil(TAG).error("Descr ${s.serie}")
                    LoggerUtil(TAG).error("Descr ${s.status}")

                    var all = serieRoom?.all(SimpleSQLiteQuery("SELECT * FROM Serie WHERE descr = ?", arrayOf(s.descr)))
                    var idSerie:Long? = 0
                    var statusSerie:Boolean? = null

                    if(all!=null){
                        if(all.isNotEmpty()){
                            for(a in all){
                                idSerie = a.id
                                statusSerie = a.status
                                LoggerUtil(TAG).error("Status $statusSerie")
                            }
                            var serie = Serie(idSerie, s.descr, s.peso, s.repeticoes, s.serie,  statusSerie)
                            var update = serieRoom?.update(serie)
                            LoggerUtil(TAG).error("Update $update")
                        }else{
                            var insert = serieRoom?.insert(s)
                            LoggerUtil(TAG).error("Inser $insert")
                        }
                    }
                }
                return serieRoom?.all(SimpleSQLiteQuery("SELECT * FROM Serie")) as List<T>
            }

            else -> emptyList()
        }
    }
}
