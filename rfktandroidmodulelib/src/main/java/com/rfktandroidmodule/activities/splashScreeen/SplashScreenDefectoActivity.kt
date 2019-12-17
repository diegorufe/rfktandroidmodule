package com.rfktandroidmodule.activities.splashScreeen

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.LinearLayout
import com.rf.rfktandroidmodulelib.R
import com.rfktandroidmodule.activities.base.BaseActivity
import com.rfktandroidmodule.constants.IRFKTConstants
import com.rfktandroidmodule.utils.UtilsAndroid
import com.rfktandroidmodule.utils.UtilsClass
import com.rfktandroidmodule.utils.UtilsLog
import java.util.*
import kotlin.reflect.KClass

/**
 * Clase para mostrar la página principal por defecto.
 * En esta clase podremos definir acciones necesaiaras que se ejecutaran a la hora de lanzar la aplicación
 */
abstract class SplashScreenDefectoActivity : BaseActivity() {

    var linear_layout_spalsh_screen_defecto: LinearLayout? = null;

    /**
     * Método para obtener el id del contedor princiapl del splash screen
     */
    open fun getIdLinearLayoutSplashScreen(): Int {
        return R.id.linear_layout_spalsh_screen_defecto
    }

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
     * Método para obtener el color de fondo del splash screen
     */
    open fun getBackgroundColor(): Int? {
        return null;
    }

    /**
     * Método para cargar los datos de la aplicación al cargar la aplicación
     */
    open fun cargaDatosApp() {
        // TODO
    }

    /**
     * Por defecto el toolbar del splash screem no se muestra
     */
    override fun isCargarToolBar(): Boolean {
        return false
    }

    /**
     * Método para lanzar la activity principal
     */
    fun lanzaActivityPrincipal() {
        val intent: Intent = Intent(
            this,
            UtilsClass.classIntent(this.getActivityPrincipal()!!)
        );

        // Cargamos datos extras a la actividad
        this.cargaDatosExtraActivityPrincipal(intent);

        this.startActivity(
            intent
        );
        // Finalizamos el splasscreen
        this.finish();
    }

    /**
     * Método para cargar datos extra a la actividad principal
     */
    open fun cargaDatosExtraActivityPrincipal(intent: Intent) {

    }

    /**
     * Tiempo mínimo de milisegundos de esperas del spalshscreem
     */
    open fun milisegundosEspera(): Long {
        return IRFKTConstants.TIEMPO_MINIMO_ESPERA_SPLASHSCREEM_MILISEGUNDOS;
    }

    /**
     * Método para cargar datos del layout
     */
    open fun cargaDatosLayout() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        this.linear_layout_spalsh_screen_defecto =
            this.findViewById(this.getIdLinearLayoutSplashScreen())

        // Fijamos el color de fondo
        if (this.getBackgroundColor() != null && this.linear_layout_spalsh_screen_defecto != null) {
            this.linear_layout_spalsh_screen_defecto!!.setBackgroundColor(
                UtilsAndroid.getColor(
                    this.applicationContext,
                    this.getBackgroundColor()!!
                )
            )
        }

        // Cargamos datos de layout
        this.cargaDatosLayout()

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
                    this@SplashScreenDefectoActivity.getLogTag(),
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
                    this@SplashScreenDefectoActivity.getLogTag(),
                    "Iniciando splashscreen ..."
                );
            }


        }

        override fun onPostExecute(result: Void?) {

            if (UtilsLog.hasDebug()) {
                UtilsLog.debug(
                    this@SplashScreenDefectoActivity.getLogTag(),
                    "Finalizando splashscreen ..."
                );
            }

            if (UtilsLog.hasDebug()) {
                UtilsLog.debug(
                    this@SplashScreenDefectoActivity.getLogTag(),
                    "Lanzando actividad principal ..."
                );
            }

            // Lanzamos la actividad principal sino es null
            if (this@SplashScreenDefectoActivity.getActivityPrincipal() != null) {
                this@SplashScreenDefectoActivity.lanzaActivityPrincipal();
            } else {
                if (UtilsLog.hasError()) {
                    UtilsLog.error(
                        this@SplashScreenDefectoActivity.getLogTag(),
                        "La actividad principal es null"
                    );
                }
            }
        }
    }
}