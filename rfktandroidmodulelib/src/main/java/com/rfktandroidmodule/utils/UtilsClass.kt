package com.rfktandroidmodule.utils

import kotlin.reflect.KClass

/**
 * Utlidades para clases
 */
class UtilsClass {

    companion object {

        /**
         * Simple name class not found constants
         */
        const val SIMPLE_NAME_NOT_FOUND: String = "SIMPLE_NAME_NOT FOUND";

        /**
         * Método para obtener el nombre de una clase
         */
        fun className(classObject: KClass<*>): String {
            return classObject.simpleName ?: SIMPLE_NAME_NOT_FOUND;
        }

        /**
         * Método para obtener la clase para un intent
         */
        fun classIntent(anyClass: KClass<*>): Class<*> {
            return anyClass.java;
        }
    }
}