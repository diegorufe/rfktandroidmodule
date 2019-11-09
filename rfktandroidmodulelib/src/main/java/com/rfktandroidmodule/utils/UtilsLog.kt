package com.rfktandroidmodule.utils

import android.util.Log
import com.rfktandroidmodule.constants.IRFKTConstants

/**
 * Clase con utilidades para el log
 */
class UtilsLog {

    companion object {

        /**
         * Enviar log de debug
         */
        fun debug(tag: String, message: String) {
            if (UtilsLog.hasDebug()) {
                Log.d(tag, message);
            }
        }

        /**
         * Método para saber si hay debug
         */
        fun hasDebug(): Boolean {
            return Log.DEBUG >= IRFKTConstants.LOG_LEVEL;
        }

        /**
         * Enviar log de info
         */
        fun info(tag: String, message: String) {
            if (UtilsLog.hasInfo()) {
                Log.d(tag, message);
            }
        }

        /**
         * Método para saber si hay info
         */
        fun hasInfo(): Boolean {
            return Log.INFO >= IRFKTConstants.LOG_LEVEL
        }

        /**
         * Enviar log de error
         */
        fun error(tag: String, message: String) {
            if (UtilsLog.hasError()) {
                Log.d(tag, message);
            }
        }

        /**
         * Método para saber si hay error
         */
        fun hasError(): Boolean {
            return Log.ERROR >= IRFKTConstants.LOG_LEVEL
        }

        /**
         * Enviar log de assert
         */
        fun assert(tag: String, message: String) {
            if (UtilsLog.hasAssert()) {
                Log.d(tag, message);
            }
        }

        /**
         * Método para saber si hay assert
         */
        fun hasAssert(): Boolean {
            return Log.ASSERT >= IRFKTConstants.LOG_LEVEL
        }

        /**
         * Enviar log de warning
         */
        fun warning(tag: String, message: String) {
            if (UtilsLog.hasWarning()) {
                Log.d(tag, message);
            }
        }

        /**
         * Método para saber si hay warning
         */
        fun hasWarning(): Boolean {
            return Log.WARN >= IRFKTConstants.LOG_LEVEL
        }

        /**
         * Enviar log verbose
         */
        fun verbose(tag: String, message: String) {
            if (UtilsLog.hasVerbose()) {
                Log.d(tag, message);
            }
        }

        /**
         * Método para saber si hay verbose
         */
        fun hasVerbose(): Boolean {
            return Log.VERBOSE >= IRFKTConstants.LOG_LEVEL
        }
    }
}