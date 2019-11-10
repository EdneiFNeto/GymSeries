package com.gymseries.utils

import android.content.Context
import android.content.Intent

class IntentUtils {
companion object{

    fun navigationAcitivty(context: Context, myClass: Class<Object>){
        context.startActivity(Intent(context, myClass))
    }
}
}
