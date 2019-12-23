package com.gymseries.utils

import android.content.Context
import android.content.Intent
import android.os.Handler

class IntentUtils {
companion object{

    private val time: Long=3000


    fun navigationAcitivty(context: Context, myClass: Class<Object>){
        context.startActivity(Intent(context, myClass))
    }

    fun initHandlerActivity(context: Context, myClass: Class<*>) {
        Handler().postDelayed({
            context.startActivity(Intent(context, myClass))
        }, time)
    }
}
}
