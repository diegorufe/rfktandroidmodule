package com.rfktandroidmodule.activities.base

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.rf.rfktandroidmodulelib.BuildConfig
import com.rf.rfktandroidmodulelib.R
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
     * Método para obtener el id del texto del toolbar
     */
    open fun getIdTextoToolBar(): Int? {
        return R.id.textoToolbarDefecto;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        // Cargamos el log
        this.configuraLog();

        // Ocultamos el action bar si es necesario
        if (this.isOcultarActionBar()) {
            this.getSupportActionBar()?.hide();
        }
        //Fijamos el layout
        if (this.getIdLayout() != null) {
            setContentView(this.getIdLayout()!!);
        }

        // Fijamos titulo del toolba rsi tiene
        this.fijaTituloToolbar();

        // Cargamos datos de la actividad
        this.cargaDatosActiviy();

    }

    /**
     * Método para fijar el titulo del toolbar
     */
    open fun fijaTituloToolbar() {
        // Fijamos el titulo del toolbar si tiene
        if (this.getTituloToolBar() != null && this.getIdTextoToolBar() != null) {
            var textViewTituloToolBar: TextView? =
                findViewById<TextView>(this.getIdTextoToolBar()!!);
            if (textViewTituloToolBar != null) {
                textViewTituloToolBar.setText(this.getTituloToolBar());
            }
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
    open fun getTag(): String {
        return UtilsClass.className(this::class);
    }

    /**
     * Método para configurar el log
     */
    open fun configuraLog() {
       
    }

}