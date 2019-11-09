package com.rfktandroidmodule.constants

import android.graphics.Color
import com.rf.rfktandroidmodulelib.R
import com.rfktandroidmodule.utils.UtilsBytes
import com.rfktandroidmodule.utils.UtilsMetrics

/**
 * Interfaz con constantes por defecto de colors
 */
interface IRFKTComponentsConstants {

    companion object {

        /**
         * Constantes de buttons
         */
        /**
         * Color por defecto back de los botones
         */
        var BACK_COLOR_DEFECTO_BUTTONS: Int = UtilsBytes.parseColor("#6DC066");

        /**
         * Color por defecto del texto de los botones
         */
        var FONT_COLOR_DEFECTO_BUTTONS: Int = UtilsBytes.parseColor("#FFFFFF");

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

    }
}