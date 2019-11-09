package com.rfktandroidmodule.activities.splashScreeen

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import com.rf.rfktandroidmodulelib.R
import com.rfktandroidmodule.activities.base.BaseActivity
import com.rfktandroidmodule.constants.IRFKTConstants
import com.rfktandroidmodule.utils.UtilsClass
import com.rfktandroidmodule.utils.UtilsLog
import java.util.*
import kotlin.reflect.KClass

/**
 * Clase para mostrar la página principal por defecto.
 * En esta clase podremos definir acciones necesaiaras que se ejecutaran a la hora de lanzar la aplicación
 */
open abstract class SplashScreenDefectoActivity : BaseActivity() {

    /**
     * Método para obtener la actividad principal de la aplicación a lanzar despues del splass screen
     */
    open fun getActivityPrincipal(): KClass<*>? {
        return null;
    }

    override fun getIdLayout(): Int? {
        return R.layout.splash_screen_defecto;
    }

    /**
     * Método para cargar los datos de la aplicación al cargar la aplicación
     */
    open fun cargaDatosApp() {
        // TODO
    }

    /**
     * Método para lanzar la activity principal
     */
    fun lanzaActivityPrincipal() {
        this.startActivity(
            Intent(
                this,
                UtilsClass.classIntent(this.getActivityPrincipal()!!)
            )
        );
        // Finalizamos el splasscreen
        this.finish();
    }

    /**
     * Tiempo mínimo de milisegundos de esperas del spalshscreem
     */
    open fun milisegundosEspera(): Long {
        return IRFKTConstants.TIEMPO_MINIMO_ESPERA_SPLASHSCREEM_MILISEGUNDOS;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        // Ejecutamos hilo splashscreen
        CargaSplashScreesDefectoTask().execute();
    }

    inner class CargaSplashScreesDefectoTask() : AsyncTask<Void, Void, Void>() {

        var inicio: Date = Date();
        var fin: Date = Date();

        override fun doInBackground(vararg params: Void?): Void? {

            this.inicio = Date();

            if (UtilsLog.hasDebug()) {
                UtilsLog.debug(
                    this@SplashScreenDefectoActivity.getTag(),
                    "Ejecutando splashscreen ..."
                );
            }

            // Cargamos datos de la app
            this@SplashScreenDefectoActivity.cargaDatosApp();

            this@CargaSplashScreesDefectoTask.fin = Date();

            var diferencia: Long =
                this@CargaSplashScreesDefectoTask.fin.getTime() - this@CargaSplashScreesDefectoTask.inicio.getTime();

            if (diferencia < this@SplashScreenDefectoActivity.milisegundosEspera()) {
                Thread.sleep(this@SplashScreenDefectoActivity.milisegundosEspera() - diferencia);
            }

            return null;
        }

        override fun onPreExecute() {

            if (UtilsLog.hasDebug()) {
                UtilsLog.debug(
                    this@SplashScreenDefectoActivity.getTag(),
                    "Iniciando splashscreen ..."
                );
            }


        }

        override fun onPostExecute(result: Void?) {

            if (UtilsLog.hasDebug()) {
                UtilsLog.debug(
                    this@SplashScreenDefectoActivity.getTag(),
                    "Finalizando splashscreen ..."
                );
            }

            if (UtilsLog.hasDebug()) {
                UtilsLog.debug(
                    this@SplashScreenDefectoActivity.getTag(),
                    "Lanzando actividad principal ..."
                );
            }

            // Lanzamos la actividad principal sino es null
            if (this@SplashScreenDefectoActivity.getActivityPrincipal() != null) {
                this@SplashScreenDefectoActivity.lanzaActivityPrincipal();
            } else {
                if (UtilsLog.hasError()) {
                    UtilsLog.error(
                        this@SplashScreenDefectoActivity.getTag(),
                        "La actividad principal es null"
                    );
                }
            }
        }
    }
}