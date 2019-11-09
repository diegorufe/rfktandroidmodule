package com.rfktandroidmodule.utils

import android.graphics.Color

/**
 * Clase de utilidades de bytes
 */
class UtilsBytes {

    companion object {

        /**
         * Método para convertir un color hexadecimal en int
         */
        fun parseColor(hexColor : String): Int {
            return Color.parseColor(hexColor);
        }

    }
}