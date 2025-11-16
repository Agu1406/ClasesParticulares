package com.example.ejercicio4_sharedpreferences_modos

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Segunda Activity que demuestra que puede acceder a las mismas
 * preferencias usando MODE_PRIVATE desde otra Activity de la misma app
 */
class SegundaActivity : AppCompatActivity() {

    private lateinit var textViewResultado: TextView

    private val PREFS_NAME = "mis_prefs"
    private val KEY_VALOR = "valor_guardado"

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        textViewResultado = findViewById(R.id.textViewResultado)

        // Obtener las mismas preferencias usando MODE_PRIVATE
        // Como es la misma aplicación, puede acceder a los datos
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        mostrarValor()
    }

    /**
     * Muestra el valor guardado desde la primera Activity
     * Esto demuestra que MODE_PRIVATE permite el acceso entre
     * Activities de la misma aplicación
     */
    private fun mostrarValor() {
        val valor = sharedPreferences.getString(KEY_VALOR, "No hay valor guardado")

        val mensaje = """
            Esta es la Segunda Activity.
            
            Puede acceder a las preferencias guardadas en MainActivity
            porque ambas Activities pertenecen a la misma aplicación.
            
            Valor guardado: $valor
            
            MODE_PRIVATE permite que todas las Activities de la misma
            aplicación accedan a las preferencias compartidas.
        """.trimIndent()

        textViewResultado.text = mensaje
    }
}

