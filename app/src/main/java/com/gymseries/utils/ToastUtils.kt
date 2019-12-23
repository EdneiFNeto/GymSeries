package com.gymseries.utils

import android.content.Context
import android.widget.Toast

class ToastUtils {

    companion object{
        fun   message(context: Context, msg:String){
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
