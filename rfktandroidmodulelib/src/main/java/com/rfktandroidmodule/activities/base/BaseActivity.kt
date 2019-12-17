package com.rfktandroidmodule.activities.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.rf.rfktandroidmodulelib.R
import com.rfktandroidmodule.constants.IRFKTComponentsConstants
import com.rfktandroidmodule.utils.UtilsClass

/**
 * Activity base de la que estenderan todas las activities
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * Método para obtener el id del layout a mostrar. Puede devolver null
     */
    open fun getIdLayout(): Int? {
        return null;
    }

    /**
     * Método para saber si tenemos que ocultar el action bar
     */
    open fun isOcultarActionBar(): Boolean {
        return true;
    }

    /**
     * Método para obtener el titulo del toolbar
     * Puede devolver null
     */
    open fun getTituloToolBar(): String? {
        return null;
    }

    /**
     * Propiedad para saber si hay que cargar el toolbar o no
     */
    open fun isCargarToolBar(): Boolean {
        return true
    }

    /**
     * Método para obtener el id del texto del toolbar
     */
    open fun getIdTextoToolBar(): Int? {
        return R.id.textoToolbarDefecto;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        // Cargamos el log
        this.configuraLog()

        // Ocultamos el action bar si es necesario
        if (this.isOcultarActionBar()) {
            this.getSupportActionBar()?.hide();
        }

        //Fijamos el layout
        if (this.getIdLayout() != null) {
            setContentView(this.getIdLayout()!!);
        }

        this.cargaFragmentInicio(savedInstanceState)

        // Fijamos datos del toolbar
        if (this.supportActionBar != null && this.isCargarToolBar()) {
            this.cargaDatosToolbar()
        }

        // Cargamos datos de la actividad
        this.cargaDatosActiviy()

    }

    /**
     * Método para cargar el frament del inicio si tiene
     */
    open fun cargaFragmentInicio(savedInstanceState: Bundle?) {

    }

    /**
     * Método para cargar los datos del toolbar
     */
    open fun cargaDatosToolbar() {
        if (this.supportActionBar != null && this.isCargarToolBar()) {
            // Fijamos el título del toolbar
            this.fijaTituloToolbar()

            // Fijamos el color de fondo del toolbar
            val linearLayoutToolbar: LinearLayout = this.findViewById(R.id.toolBarDefectoLayout)
            linearLayoutToolbar.setBackgroundColor(IRFKTComponentsConstants.BACK_COLOR_TOOLBAR_DEFECTO)

            if (IRFKTComponentsConstants.SRC_IMAGE_ASSET_TOOLBAR != null) {
                val imageDrawable: ImageView = this.findViewById(R.id.imageViewToolbarDefecto)
                // get input stream
                val ims = assets.open(IRFKTComponentsConstants.SRC_IMAGE_ASSET_TOOLBAR!!)
                // load image as Drawable
                val d = Drawable.createFromStream(ims, null)
                // set image to ImageView
                imageDrawable.setImageDrawable(d)
                ims.close()
            }
        }
    }

    /**
     * Método para fijar el titulo del toolbar
     */
    open fun fijaTituloToolbar() {
        // Fijamos el titulo del toolbar si tiene
        if (this.getTituloToolBar() != null && this.getIdTextoToolBar() != null && this.isCargarToolBar()) {
            findViewById<TextView>(getIdTextoToolBar()!!)?.text = this.getTituloToolBar()
            findViewById<TextView>(getIdTextoToolBar()!!)?.setTextColor(IRFKTComponentsConstants.FONT_COLOR_TOOLBAR_DEFECTO)
        }
    }

    /**
     * Método para cargar datos de la activiadd
     */
    open fun cargaDatosActiviy() {

    }

    /**
     * Método para obtener el tad del log
     */
    open fun getLogTag(): String {
        return UtilsClass.className(this::class);
    }

    /**
     * Método para configurar el log
     */
    open fun configuraLog() {

    }

}