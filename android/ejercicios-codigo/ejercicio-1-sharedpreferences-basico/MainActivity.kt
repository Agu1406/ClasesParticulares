package com.example.ejercicio1_sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * EJERCICIO 1: SharedPreferences - Introducción
 * 
 * Este ejercicio demuestra el uso básico de SharedPreferences para
 * guardar y recuperar preferencias de usuario.
 * 
 * GUÍA PASO A PASO PARA CREAR ESTE EJERCICIO DESDE CERO:
 * 
 * PASO 1: Crear el proyecto
 * - Abre Android Studio y crea un nuevo proyecto "Empty Activity"
 * - Nombre: "Ejercicio1SharedPreferences"
 * - Package: com.example.ejercicio1_sharedpreferences
 * - Language: Kotlin
 * - Minimum SDK: API 24 (Android 7.0)
 * 
 * PASO 2: Configurar dependencias (build.gradle.kts - app)
 * - Asegúrate de tener:
 *   implementation("androidx.appcompat:appcompat:1.6.1")
 *   implementation("com.google.android.material:material:1.9.0")
 * 
 * PASO 3: Crear el layout (res/layout/activity_main.xml)
 * - Crea un LinearLayout vertical con padding 16dp
 * - Añade un TextView para el título
 * - Añade un TextInputLayout con TextInputEditText para el nombre
 * - Añade un CheckBox para las notificaciones
 * - Añade un TextView y SeekBar para el volumen (max=100, progress=50)
 * - Añade dos botones: "Guardar preferencias" y "Cargar preferencias"
 * - Añade un TextView para mostrar los resultados
 * 
 * PASO 4: Implementar la Activity
 * - Declara las constantes: PREFS_NAME, KEY_NOMBRE, KEY_NOTIFICACIONES, KEY_VOLUMEN
 * - Declara las referencias a los componentes de la UI como lateinit var
 * - Declara la instancia de SharedPreferences como lateinit var
 * 
 * PASO 5: Implementar onCreate()
 * - Inicializar SharedPreferences: getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
 * - Llamar a initViews() para obtener referencias
 * - Llamar a setupListeners() para configurar los botones
 * 
 * PASO 6: Implementar initViews()
 * - Usar findViewById() para cada componente
 * - Configurar el SeekBar: max = 100, progress = 50
 * 
 * PASO 7: Implementar setupListeners()
 * - Configurar onClickListener para el botón "Guardar"
 * - Configurar onClickListener para el botón "Cargar"
 * 
 * PASO 8: Implementar guardarPreferencias()
 * - Validar que el nombre no esté vacío (mostrar Toast si falla)
 * - Validar que el volumen esté en rango 0-100
 * - Obtener los valores: nombre, notificaciones (isChecked), volumen (progress)
 * - Obtener el Editor: sharedPreferences.edit()
 * - Guardar valores: putString(), putBoolean(), putInt()
 * - Aplicar cambios: editor.apply()
 * - Mostrar Toast de confirmación
 * 
 * PASO 9: Implementar cargarPreferencias()
 * - Recuperar valores: getString(), getBoolean(), getInt() (con valores por defecto)
 * - Actualizar la UI: setText(), isChecked =, progress =
 * - Construir un String con la información y mostrarlo en el TextView
 * 
 * PASO 10: Probar la aplicación
 * - Ejecutar la app
 * - Introducir un nombre, activar notificaciones, cambiar volumen
 * - Presionar "Guardar preferencias" y verificar el Toast
 * - Cerrar y abrir la app, presionar "Cargar preferencias"
 * - Verificar que los valores se mantienen
 * 
 * CONCEPTOS CLAVE:
 * - SharedPreferences almacena datos clave-valor de forma persistente
 * - getSharedPreferences() obtiene una instancia (crea el archivo si no existe)
 * - MODE_PRIVATE hace que solo tu app pueda acceder a las preferencias
 * - Editor es necesario para escribir, apply() guarda de forma asíncrona
 * - Los métodos get*() requieren un valor por defecto como segundo parámetro
 */
class MainActivity : AppCompatActivity() {

    // Referencias a los componentes de la UI
    private lateinit var editTextNombre: EditText
    private lateinit var checkBoxNotificaciones: CheckBox
    private lateinit var seekBarVolumen: SeekBar
    private lateinit var textViewResultado: TextView
    private lateinit var buttonGuardar: Button
    private lateinit var buttonCargar: Button

    // Nombre del archivo de preferencias
    private val PREFS_NAME = "mis_preferencias"
    
    // Claves para los valores guardados
    private val KEY_NOMBRE = "nombre_usuario"
    private val KEY_NOTIFICACIONES = "notificaciones_activas"
    private val KEY_VOLUMEN = "volumen"

    // Instancia de SharedPreferences
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Inicializar componentes de la UI
        initViews()

        // Configurar listeners
        setupListeners()
    }

    /**
     * Inicializa las referencias a los componentes de la UI
     */
    private fun initViews() {
        editTextNombre = findViewById(R.id.editTextNombre)
        checkBoxNotificaciones = findViewById(R.id.checkBoxNotificaciones)
        seekBarVolumen = findViewById(R.id.seekBarVolumen)
        textViewResultado = findViewById(R.id.textViewResultado)
        buttonGuardar = findViewById(R.id.buttonGuardar)
        buttonCargar = findViewById(R.id.buttonCargar)

        // Configurar SeekBar (rango 0-100)
        seekBarVolumen.max = 100
        seekBarVolumen.progress = 50 // Valor por defecto
    }

    /**
     * Configura los listeners de los botones
     */
    private fun setupListeners() {
        buttonGuardar.setOnClickListener {
            guardarPreferencias()
        }

        buttonCargar.setOnClickListener {
            cargarPreferencias()
        }
    }

    /**
     * Guarda las preferencias en SharedPreferences
     */
    private fun guardarPreferencias() {
        // Validar nombre
        val nombre = editTextNombre.text.toString().trim()
        if (nombre.isEmpty()) {
            Toast.makeText(this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show()
            return
        }

        // Validar volumen (ya está en rango 0-100 por el SeekBar, pero verificamos)
        val volumen = seekBarVolumen.progress
        if (volumen < 0 || volumen > 100) {
            Toast.makeText(this, "El volumen debe estar entre 0 y 100", Toast.LENGTH_SHORT).show()
            return
        }

        // Obtener el estado de las notificaciones
        val notificacionesActivas = checkBoxNotificaciones.isChecked

        // Guardar usando SharedPreferences.Editor
        val editor = sharedPreferences.edit()
        editor.putString(KEY_NOMBRE, nombre)
        editor.putBoolean(KEY_NOTIFICACIONES, notificacionesActivas)
        editor.putInt(KEY_VOLUMEN, volumen)
        
        // Aplicar los cambios (commit() es síncrono, apply() es asíncrono)
        editor.apply()

        Toast.makeText(this, "Preferencias guardadas correctamente", Toast.LENGTH_SHORT).show()
    }

    /**
     * Carga las preferencias desde SharedPreferences y las muestra
     */
    private fun cargarPreferencias() {
        // Recuperar valores (el segundo parámetro es el valor por defecto)
        val nombre = sharedPreferences.getString(KEY_NOMBRE, "No definido")
        val notificacionesActivas = sharedPreferences.getBoolean(KEY_NOTIFICACIONES, false)
        val volumen = sharedPreferences.getInt(KEY_VOLUMEN, 50)

        // Actualizar la UI con los valores cargados
        editTextNombre.setText(nombre)
        checkBoxNotificaciones.isChecked = notificacionesActivas
        seekBarVolumen.progress = volumen

        // Mostrar información en el TextView
        val resultado = """
            Preferencias cargadas:
            - Nombre: $nombre
            - Notificaciones: ${if (notificacionesActivas) "Activadas" else "Desactivadas"}
            - Volumen: $volumen%
        """.trimIndent()

        textViewResultado.text = resultado
    }
}

