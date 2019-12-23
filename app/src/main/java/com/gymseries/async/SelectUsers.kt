package com.gymseries.async

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Handler
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.database.AppData
import com.gymseries.model.User
import com.gymseries.ui.FormInitActivity
import com.gymseries.ui.MainActivity

class SelectUsers(val context: Context) : AsyncTask<String, String, List<User>>() {
    override fun doInBackground(vararg params: String?): List<User>? {
        var appData = AppData.getInstance(context)
        var usersRoom = appData?.userRoom()
        return usersRoom?.all(SimpleSQLiteQuery("SELECT * FROM User"))
    }

    override fun onPostExecute(result: List<User>?) {
        super.onPostExecute(result)
        if (result != null) {
            if (result.isNotEmpty()) {
                Handler().postDelayed({
                    context.startActivity(Intent(context, MainActivity::class.java))
                }, 2000)
            } else {
                context.startActivity(Intent(context, FormInitActivity::class.java))
            }
        } else {
            context.startActivity(Intent(context, FormInitActivity::class.java))
        }
    }
}
