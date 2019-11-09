package com.rfktandroidmodule.utils

import android.content.Context
import android.content.res.Resources

/**
 * Clase de utilidades de metricas
 */
class UtilsMetrics {

    companion object {

        /**
         * Método para convertir de pixeles a dp
         */
        fun dpFromPx(px: Float): Int {
            return ((px / Resources.getSystem().getDisplayMetrics().density).toInt());
        }

        /**
         * Método para convertir de dp a pixeles
         */
        fun pxFromDp(dp: Float): Int {
            return (dp * Resources.getSystem().getDisplayMetrics().density).toInt();
        }
    }
}