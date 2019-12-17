package com.rfktandroidmodule.componentes.checkbox

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.util.AttributeSet
import android.widget.CheckBox
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import com.rf.rfktandroidmodulelib.R
import com.rfktandroidmodule.constants.IRFKTComponentsConstants
import kotlin.math.absoluteValue

/**
 * Clase base para checkbox
 */
open class RFBaseCheckBox @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : CheckBox(context, attrs) {

    var defaultBackColor: Int? = null;

    var defaultFontSize: Int? = IRFKTComponentsConstants.FONT_SIZE_DEFECTO_CHECKBOX;


    var defaultTextColor: Int? = IRFKTComponentsConstants.FONT_COLOR_DEFECTO_CHECKBOX;


    var defaultBackDrawable: Int? = null;

    /**
     * Load data
     */
    open fun load() {
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
            this.context.theme.obtainStyledAttributes(attrs, R.styleable.RFBaseCheckBox, 0, 0);

        for (i in 0 until typedArray.indexCount) {
            when (typedArray.getIndex(i)) {
                R.styleable.RFBaseCheckBox_checkbox_defaultBackColor -> this.defaultBackColor =
                    this.defaultBackColor?.let { typedArray.getInt(typedArray.getIndex(i), it) }

                R.styleable.RFBaseCheckBox_checkbox_defaultBack -> this.defaultBackDrawable =
                    this.defaultBackDrawable?.let { typedArray.getInt(typedArray.getIndex(i), it) }

                R.styleable.RFBaseCheckBox_checkbox_defaultFontSize -> this.defaultFontSize =
                    this.defaultFontSize?.let { typedArray.getInt(typedArray.getIndex(i), it) }

                R.styleable.RFBaseCheckBox_checkbox_defaultTextColor -> this.defaultTextColor =
                    this.defaultTextColor?.let { typedArray.getInt(typedArray.getIndex(i), it) }
            }
        }

    }


    init {
        this.initStyleSheetAtributtes(attrs);
        this.load()
    }

}