package com.rfktandroidmodule.constants

import android.util.Log

/**
 *
 */
interface IRFKTConstants {

    companion object {

        /**
         * Simple name class not found constants
         */
        const val TIEMPO_MINIMO_ESPERA_SPLASHSCREEM_MILISEGUNDOS: Long =  1000L;

        /**
         * Método para fijar el log por defecto
         */
        val LOG_LEVEL = Log.DEBUG;

    }

}