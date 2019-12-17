package com.rfktandroidmodule.constants

import com.rf.rfktandroidmodulelib.R
import com.rfktandroidmodule.utils.UtilsBytes
import com.rfktandroidmodule.utils.UtilsMetrics

/**
 * Interfaz con constantes por defecto de colors
 */
interface IRFKTComponentsConstants {

    companion object {

        /**
         * Constantes de toolbar
         */
        /**
         * Color toolbar defecto
         */
        var BACK_COLOR_TOOLBAR_DEFECTO: Int = UtilsBytes.parseColor("#EEFFC107")

        /**
         * Ruta de la imagen del toolbar a mostrar
         */
        var SRC_IMAGE_ASSET_TOOLBAR: String? = null

        /**
         * Color de texto del toolbar
         */
        var FONT_COLOR_TOOLBAR_DEFECTO: Int = UtilsBytes.parseColor("#00574B")

        /**
         * Constantes de buttons
         */
        /**
         * Color por defecto back de los botones
         */
        var BACK_COLOR_DEFECTO_BUTTONS: Int = UtilsBytes.parseColor("#6DC066")

        /**
         * Color por defecto del texto de los botones
         */
        var FONT_COLOR_DEFECTO_BUTTONS: Int = UtilsBytes.parseColor("#FFFFFF")

        /**
         * Bakcground defecto de los botones
         */
        var BACKGROUND_DRAWABLE_DEFECTO_BUTTONS: Int = R.drawable.rounded_button;

        /**
         * Padding por defecto para botones
         */
        var PADDING_DEFECTO_BUTTONS: Int = UtilsMetrics.dpFromPx(80F);

        /**
         * Fuente por defecto para botones
         */
        var FONT_SIZE_DEFECTO_BUTTONS: Int = UtilsMetrics.dpFromPx(80F);

        /**
         * Constantes de marquerText
         */
        /**
         * Color por defecto back de los markers
         */
        var BACK_COLOR_DEFECTO_MARKER_TEXT: Int = UtilsBytes.parseColor("#6DC066");

        /**
         * Color por defecto del texto de los markers
         */
        var FONT_COLOR_DEFECTO_MARKER_TEXT: Int = UtilsBytes.parseColor("#FFFFFF");

        /**
         * Bakcground defecto de los markers
         */
        var BACKGROUND_DRAWABLE_MARKER_TEXT: Int = R.drawable.rounded_marker_text;

        /**
         * Padding por defecto para markers
         */
        var PADDING_DEFECTO_MARKER_TEXT: Int = UtilsMetrics.dpFromPx(60F);

        /**
         * Fuente por defecto para markers
         */
        var FONT_SIZE_DEFECTO_MARKER_TEXT: Int = UtilsMetrics.dpFromPx(60F);

        /**
         * Constantes para componentes de texto
         */
        /**
         * Color por defecto del texto
         */
        var FONT_COLOR_DEFECTO_TEXT: Int = UtilsBytes.parseColor("#000000");

        /**
         * Padding por defecto para el texto
         */
        var PADDING_DEFECTO_TEXT: Int = UtilsMetrics.dpFromPx(60F);

        /**
         * Fuente por defecto para texto
         */
        var FONT_SIZE_DEFECTO_TEXT: Int = UtilsMetrics.dpFromPx(60F);

        /**
         * Constantes para componentes de checkbox
         */
        /**
         * Color por defecto del checkbox
         */
        var FONT_COLOR_DEFECTO_CHECKBOX: Int = UtilsBytes.parseColor("#000000");

        /**
         * Fuente por defecto para checkbox
         */
        var FONT_SIZE_DEFECTO_CHECKBOX: Int = UtilsMetrics.dpFromPx(60F);

    }
}