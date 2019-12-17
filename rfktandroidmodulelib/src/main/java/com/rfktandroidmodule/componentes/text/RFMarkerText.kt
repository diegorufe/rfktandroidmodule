package com.rfktandroidmodule.componentes.text

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.util.AttributeSet
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import com.rf.rfktandroidmodulelib.R
import com.rfktandroidmodule.constants.IRFKTComponentsConstants

/**
 * Clase base para marcadores
 */
open class RFMarkerText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : TextView(context, attrs){

    var defaultBackColor: Int? = IRFKTComponentsConstants.BACK_COLOR_DEFECTO_MARKER_TEXT;


    var defaultPadding: Int? = IRFKTComponentsConstants.PADDING_DEFECTO_MARKER_TEXT;


    var defaultFontSize: Int? = IRFKTComponentsConstants.FONT_SIZE_DEFECTO_MARKER_TEXT;


    var defaultTextColor: Int? = IRFKTComponentsConstants.FONT_COLOR_DEFECTO_MARKER_TEXT;


    var defaultBackDrawable: Int? = IRFKTComponentsConstants.BACKGROUND_DRAWABLE_MARKER_TEXT;

    /**
     * Load data
     */
    open fun load() {
        this.changePadding(this.defaultPadding);
        this.changeFontSize(this.defaultFontSize);
        this.changeTextColor(this.defaultTextColor);
        this.changeDrawable(this.defaultBackDrawable);
        this.changeBackColor(this.defaultBackColor);
    }

    /**
     * Método para cambiar el color del texto
     */
    open fun changeTextColor(textColor: Int?) {
        this.defaultTextColor = textColor;
        if (this.defaultTextColor != null) {
            this.setTextColor(this.defaultTextColor!!);
        }
    }

    /**
     * Método para cambiar el padding
     */
    open fun changeFontSize(fontSize: Int?) {
        this.defaultFontSize = fontSize;
        if (this.defaultFontSize != null) {
            this.setTextSize(this.defaultFontSize!!.toFloat());
        }
    }

    /**
     * Método para cambiar el padding
     */
    open fun changePadding(padding: Int?) {
        this.defaultPadding = padding;
        if (this.defaultPadding != null) {
            this.setPadding(this.defaultPadding!!);
        }
    }

    /**
     * Método para cambiar el drawable de fondo
     */
    open fun changeDrawable(drawable: Int?) {

        this.defaultBackDrawable = drawable;

        if (this.defaultBackDrawable != null) {
            this.setBackground(ContextCompat.getDrawable(this.context, this.defaultBackDrawable!!));
        }
    }

    /**
     * Método para cambiar el color de fondo
     */
    open fun changeBackColor(color: Int?) {

        this.defaultBackColor = color;

        val backGroundDrawable: Drawable? = this.background;

        if (backGroundDrawable != null && this.defaultBackColor != null) {

            //val hexColor: String = String.format("#%06X", (0xFFFFFF and this.defaultBackColor!!));

            when (backGroundDrawable) {
                is ShapeDrawable -> backGroundDrawable.getPaint().setColor(this.defaultBackColor!!)
                is GradientDrawable -> backGroundDrawable.setColor(this.defaultBackColor!!)
                is ColorDrawable -> backGroundDrawable.setColor(this.defaultBackColor!!)
            }

            this.setBackground(backGroundDrawable);

        } else if (this.defaultBackColor != null) {
            this.setBackgroundColor(this.defaultBackColor!!);
        }


    }

    /**
     * Método para cargar los atributos de estilos del botón
     */
    private fun initStyleSheetAtributtes(attrs: AttributeSet?) {
        val typedArray: TypedArray =
            this.context.theme.obtainStyledAttributes(attrs, R.styleable.RFMarkerText, 0, 0);

        for (i in 0 until typedArray.indexCount) {
            when (typedArray.getIndex(i)) {
                R.styleable.RFMarkerText_marker_defaultBackColor -> this.defaultBackColor =
                    this.defaultBackColor?.let { typedArray.getInt(typedArray.getIndex(i), it) }

                R.styleable.RFMarkerText_marker_defaultBack -> this.defaultBackDrawable =
                    this.defaultBackDrawable?.let { typedArray.getInt(typedArray.getIndex(i), it) }

                R.styleable.RFMarkerText_marker_defaultFontSize -> this.defaultFontSize =
                    this.defaultFontSize?.let { typedArray.getInt(typedArray.getIndex(i), it) }

                R.styleable.RFMarkerText_marker_defaultPadding -> this.defaultPadding =
                    this.defaultPadding?.let { typedArray.getInt(typedArray.getIndex(i), it) }

                R.styleable.RFMarkerText_marker_defaultTextColor -> this.defaultTextColor =
                    this.defaultTextColor?.let { typedArray.getInt(typedArray.getIndex(i), it) }
            }
        }

    }


    init {
        this.initStyleSheetAtributtes(attrs);
        this.load()
    }

}