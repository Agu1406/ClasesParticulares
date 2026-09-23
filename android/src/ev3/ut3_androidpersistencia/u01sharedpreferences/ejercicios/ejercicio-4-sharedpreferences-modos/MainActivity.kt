package com.example.ejercicio4_sharedpreferences_modos

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * EJERCICIO 4: SharedPreferences - Modos de acceso
 * 
 * Este ejercicio demuestra el uso de diferentes modos de acceso
 * en SharedPreferences, específicamente MODE_PRIVATE.
 * 
 * GUÍA PASO A PASO PARA CREAR ESTE EJERCICIO DESDE CERO:
 * 
 * PASO 1: Crear el proyecto
 * - Crea un nuevo proyecto "Empty Activity" en Android Studio
 * - Nombre: "Ejercicio4SharedPreferencesModos"
 * - Package: com.example.ejercicio4_sharedpreferences_modos
 * - Language: Kotlin
 * - Minimum SDK: API 24
 * 
 * PASO 2: Crear SegundaActivity
 * - Crea una nueva Activity: SegundaActivity
 * - Crea su layout: activity_segunda.xml
 * - Registra en AndroidManifest.xml
 * 
 * PASO 3: Crear layout activity_main.xml
 * - LinearLayout vertical con padding 16dp
 * - EditText para introducir un valor
 * - Dos botones: "Guardar valor" y "Verificar valores"
 * - Dos TextViews para mostrar valores de cada instancia
 * - Botón "Abrir Segunda Activity"
 * 
 * PASO 4: Implementar MainActivity
 * - Declarar constantes: PREFS_NAME, KEY_VALOR
 * - Declarar dos instancias de SharedPreferences: sharedPreferences1 y sharedPreferences2
 * 
 * PASO 5: Implementar initSharedPreferences()
 * - Primera instancia: getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
 * - Segunda instancia: getSharedPreferences(PREFS_NAME, 0) (0 = MODE_PRIVATE)
 * - Ambas apuntan al mismo archivo porque tienen el mismo nombre
 * 
 * PASO 6: Implementar guardarValor()
 * - Validar que el valor no esté vacío
 * - Guardar en ambas instancias (aunque es el mismo archivo)
 * - Mostrar Toast de confirmación
 * - Llamar a actualizarTextViews()
 * 
 * PASO 7: Implementar verificarValores()
 * - Leer valor desde sharedPreferences1
 * - Leer valor desde sharedPreferences2
 * - Comparar valores y mostrar resultado
 * - Llamar a actualizarTextViews()
 * 
 * PASO 8: Implementar actualizarTextViews()
 * - Obtener valores de ambas instancias
 * - Mostrar en los TextViews correspondientes
 * 
 * PASO 9: Implementar SegundaActivity
 * - Obtener las mismas preferencias con MODE_PRIVATE
 * - Leer el valor guardado desde MainActivity
 * - Mostrar mensaje explicando que puede acceder porque es la misma app
 * 
 * PASO 10: Probar la aplicación
 * - Guardar un valor y verificar que ambas instancias lo leen
 * - Abrir SegundaActivity y verificar que puede leer el valor
 * - Esto demuestra que MODE_PRIVATE permite acceso entre Activities de la misma app
 * 
 * CONCEPTOS CLAVE:
 * - MODE_PRIVATE (o 0) es el modo por defecto y más seguro
 * - Múltiples instancias con el mismo nombre acceden al mismo archivo
 * - MODE_PRIVATE permite acceso entre Activities de la misma aplicación
 * - Los modos deprecados (MODE_WORLD_READABLE, etc.) no deben usarse
 * - Siempre usar MODE_PRIVATE en aplicaciones modernas
 */
class MainActivity : AppCompatActivity() {

    private lateinit var editTextValor: EditText
    private lateinit var textViewPrefs1: TextView
    private lateinit var textViewPrefs2: TextView
    private lateinit var buttonGuardar: Button
    private lateinit var buttonVerificar: Button
    private lateinit var buttonIrSegundaActivity: Button

    private val PREFS_NAME = "mis_prefs"

    // Dos instancias de SharedPreferences con el mismo nombre
    // Ambas usan MODE_PRIVATE (por defecto)
    private lateinit var sharedPreferences1: SharedPreferences
    private lateinit var sharedPreferences2: SharedPreferences

    private val KEY_VALOR = "valor_guardado"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initSharedPreferences()
        setupListeners()
        actualizarTextViews()
    }

    private fun initViews() {
        editTextValor = findViewById(R.id.editTextValor)
        textViewPrefs1 = findViewById(R.id.textViewPrefs1)
        textViewPrefs2 = findViewById(R.id.textViewPrefs2)
        buttonGuardar = findViewById(R.id.buttonGuardar)
        buttonVerificar = findViewById(R.id.buttonVerificar)
        buttonIrSegundaActivity = findViewById(R.id.buttonIrSegundaActivity)
    }

    /**
     * Inicializa dos instancias de SharedPreferences
     * Ambas acceden al mismo archivo porque tienen el mismo nombre
     */
    private fun initSharedPreferences() {
        // Primera instancia: usando getSharedPreferences con MODE_PRIVATE explícito
        sharedPreferences1 = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Segunda instancia: usando getSharedPreferences con 0 (equivalente a MODE_PRIVATE)
        // En versiones recientes, MODE_PRIVATE = 0
        sharedPreferences2 = getSharedPreferences(PREFS_NAME, 0)
    }

    private fun setupListeners() {
        buttonGuardar.setOnClickListener {
            guardarValor()
        }

        buttonVerificar.setOnClickListener {
            verificarValores()
        }

        buttonIrSegundaActivity.setOnClickListener {
            // Abrir segunda Activity para demostrar acceso entre Activities
            startActivity(android.content.Intent(this, SegundaActivity::class.java))
        }
    }

    /**
     * Guarda el valor en ambas instancias de SharedPreferences
     * Como ambas apuntan al mismo archivo, el valor se guarda una sola vez
     */
    private fun guardarValor() {
        val valor = editTextValor.text.toString().trim()

        if (valor.isEmpty()) {
            Toast.makeText(this, "El valor no puede estar vacío", Toast.LENGTH_SHORT).show()
            return
        }

        // Guardar usando la primera instancia
        val editor1 = sharedPreferences1.edit()
        editor1.putString(KEY_VALOR, valor)
        editor1.apply()

        // Como ambas instancias acceden al mismo archivo,
        // no necesitamos guardar en la segunda instancia
        // Pero lo hacemos para demostrar que ambas pueden escribir
        val editor2 = sharedPreferences2.edit()
        editor2.putString(KEY_VALOR, valor)
        editor2.apply()

        Toast.makeText(this, "Valor guardado correctamente", Toast.LENGTH_SHORT).show()
        actualizarTextViews()
    }

    /**
     * Verifica que ambas instancias leen el mismo valor
     */
    private fun verificarValores() {
        val valor1 = sharedPreferences1.getString(KEY_VALOR, "No definido")
        val valor2 = sharedPreferences2.getString(KEY_VALOR, "No definido")

        val mensaje = if (valor1 == valor2) {
            "✓ Ambas instancias leen el mismo valor: $valor1"
        } else {
            "✗ Las instancias leen valores diferentes"
        }

        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        actualizarTextViews()
    }

    /**
     * Actualiza los TextViews con los valores actuales
     */
    private fun actualizarTextViews() {
        val valor1 = sharedPreferences1.getString(KEY_VALOR, "No definido")
        val valor2 = sharedPreferences2.getString(KEY_VALOR, "No definido")

        textViewPrefs1.text = "Instancia 1 (MODE_PRIVATE explícito): $valor1"
        textViewPrefs2.text = "Instancia 2 (MODE_PRIVATE = 0): $valor2"
    }
}

