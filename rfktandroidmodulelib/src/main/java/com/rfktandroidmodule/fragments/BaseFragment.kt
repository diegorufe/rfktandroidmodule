package com.rfktandroidmodule.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rfktandroidmodule.utils.UtilsClass

/**
 * Clase base para los fragments
 */
abstract class BaseFragment : Fragment() {

    /**
     * Método para obtener el id del layout a mostrar. Puede devolver null
     */
    abstract fun getIdLayout(): Int;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(this.getIdLayout(), container, false)
        this.cargaDatosFragment(view);
        return view;
    }

    /**
     * Método para cargar los datos del fragment
     */
    open fun cargaDatosFragment(view: View) {

    }

    /**
     * Método para obtener el tad del log
     */
    open fun getLogTag(): String {
        return UtilsClass.className(this::class);
    }

}