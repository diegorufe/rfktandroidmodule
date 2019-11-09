package com.rfktandroidmodule.utils

import android.content.Context
import android.os.Build

/**
 * Clas de utilidades para android
 */
class UtilsAndroid {

    companion object {

        /**
         * Método para obtener un color
         */
        fun getColor(context: Context, id:Int) : Int{
           if (Build.VERSION.SDK_INT < 23) {
               return context.getResources().getColor(id);
           } else {
               return context.getColor(id);
           }
       }
    }
}