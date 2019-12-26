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

class SelectUsers(
    val context: Context,
    val gif: ImageView
) : AsyncTask<String, String, List<User>>() {

    override fun onPreExecute() {
        super.onPreExecute()
        Glide.with(context)
            .load(R.drawable.load_fitness) // aqui é teu gif
            .asGif()
            .into(gif)
    }

    override fun doInBackground(vararg params: String?): List<User>? {
        var appData = AppData.getInstance(context)
        var usersRoom = appData?.userRoom()
        return usersRoom?.all(SimpleSQLiteQuery("SELECT * FROM User"))
    }

    override fun onPostExecute(result: List<User>?) {
        super.onPostExecute(result)
        if (result != null) {
            if (result.isNotEmpty()) {
                statiAcitivy(MainActivity::class.java)
            } else {
                statiAcitivy(FormInitActivity::class.java)
            }
        } else {
            statiAcitivy(FormInitActivity::class.java)
        }
    }

    private fun statiAcitivy(myClass: Class<*>) {
        Handler().postDelayed({
            context.startActivity(Intent(context, myClass))
        }, 2000)
    }
}
