package com.gymseries.async

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.model.User
import com.gymseries.ui.MainActivity
import com.gymseries.utils.ResourcesUtils
import com.gymseries.utils.ToastUtils

class InsertUsers(val context: Context, val user:User): AsyncTask<String, String, List<User>>() {

    override fun doInBackground(vararg params: String?): List<User>? {
        var appData = AppData.getInstance(context)
        var usersRoom = appData?.userRoom()
        usersRoom?.insert(user)
        return usersRoom?.all(SimpleSQLiteQuery("SELECT * FROM User"))
    }

    override fun onPostExecute(result: List<User>?) {
        super.onPostExecute(result)
        if(result!=null){
            if(result.isNotEmpty()){
                ToastUtils.message(context, ResourcesUtils.getString(context, R.string.message_success_save))
                context.startActivity(Intent(context, MainActivity::class.java))
            }else{
                ToastUtils.message(context, ResourcesUtils.getString(context, R.string.message_fail_save))
            }
        }else{
            ToastUtils.message(context, ResourcesUtils.getString(context, R.string.message_fail_save))
        }
    }
}
