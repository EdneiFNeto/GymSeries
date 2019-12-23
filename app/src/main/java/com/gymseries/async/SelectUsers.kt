package com.gymseries.async

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Handler
import android.widget.ImageView
import androidx.sqlite.db.SimpleSQLiteQuery
import com.bumptech.glide.Glide
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.model.User
import com.gymseries.ui.FormInitActivity
import com.gymseries.ui.MainActivity
import com.gymseries.utils.IntentUtils

class SelectUsers(val context: Context, private val imgLoad: ImageView) :
    AsyncTask<String, String, List<User>>() {

    private val time: Long = 3000

    override fun doInBackground(vararg params: String?): List<User>? {
        var appData = AppData.getInstance(context)
        var usersRoom = appData?.userRoom()
        return usersRoom?.all(SimpleSQLiteQuery("SELECT * FROM User"))
    }

    override fun onPreExecute() {
        super.onPreExecute()
        Glide.with(context)
            .load(R.drawable.load_fitness)
            .into(imgLoad)
    }

    override fun onPostExecute(result: List<User>?) {
        super.onPostExecute(result)
        if (result != null) {
            if (result.isNotEmpty()) {
                IntentUtils.initHandlerActivity(context,MainActivity::class.java)
            } else {
                IntentUtils.initHandlerActivity(context,FormInitActivity::class.java)
            }
        } else {
                IntentUtils.initHandlerActivity(context,FormInitActivity::class.java)
        }
    }


}
