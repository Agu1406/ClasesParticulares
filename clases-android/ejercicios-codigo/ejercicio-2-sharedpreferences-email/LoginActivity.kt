package com.example.ejercicio2_sharedpreferences_email

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * EJERCICIO 2: SharedPreferences - Ejemplo práctico del email
 * 
 * Este ejercicio implementa una pantalla de login que recuerda
 * el último email introducido usando SharedPreferences.
 * 
 * GUÍA PASO A PASO PARA CREAR ESTE EJERCICIO DESDE CERO:
 * 
 * PASO 1: Crear el proyecto
 * - Crea un nuevo proyecto "Empty Activity" en Android Studio
 * - Nombre: "Ejercicio2SharedPreferencesEmail"
 * - Package: com.example.ejercicio2_sharedpreferences_email
 * - Language: Kotlin
 * - Minimum SDK: API 24
 * 
 * PASO 2: Configurar el AndroidManifest.xml
 * - Cambiar MainActivity por LoginActivity como Activity principal
 * - O crear LoginActivity y configurarla en el manifest
 * 
 * PASO 3: Crear el layout (res/layout/activity_login.xml)
 * - LinearLayout vertical con padding 24dp y gravity center_vertical
 * - TextView para el título
 * - TextInputLayout con TextInputEditText para email (inputType="textEmailAddress")
 * - TextInputLayout con TextInputEditText para contraseña (inputType="textPassword")
 * - CheckBox con texto "Recordar email"
 * - Button "Iniciar sesión"
 * 
 * PASO 4: Implementar la Activity
 * - Declarar constantes: PREFS_NAME, KEY_EMAIL, KEY_RECORDAR_EMAIL
 * - Declarar referencias a componentes UI
 * - Declarar SharedPreferences como lateinit var
 * 
 * PASO 5: Implementar onCreate()
 * - Inicializar SharedPreferences
 * - Llamar a initViews()
 * - Llamar a cargarEmailGuardado() para cargar email al iniciar
 * - Configurar listener del botón "Iniciar sesión"
 * 
 * PASO 6: Implementar initViews()
 * - Obtener referencias con findViewById()
 * - Restaurar estado del CheckBox desde SharedPreferences
 * 
 * PASO 7: Implementar cargarEmailGuardado()
 * - Obtener email guardado: getString(KEY_EMAIL, null)
 * - Si existe, ponerlo en el EditText con setText()
 * - Si no existe, dejar el campo vacío
 * 
 * PASO 8: Implementar esEmailValido()
 * - Usar Patterns.EMAIL_ADDRESS.matcher(email).matches()
 * - Retornar true si es válido, false si no
 * 
 * PASO 9: Implementar iniciarSesion()
 * - Obtener email y contraseña de los EditText
 * - Validar formato del email usando esEmailValido()
 * - Validar que la contraseña no esté vacía
 * - Obtener el Editor de SharedPreferences
 * - Si el CheckBox está marcado:
 *   - Guardar email: putString(KEY_EMAIL, email)
 *   - Guardar preferencia: putBoolean(KEY_RECORDAR_EMAIL, true)
 *   - Mostrar Toast "Email guardado"
 * - Si el CheckBox NO está marcado:
 *   - Eliminar email: remove(KEY_EMAIL)
 *   - Guardar preferencia: putBoolean(KEY_RECORDAR_EMAIL, false)
 *   - Mostrar Toast "Email eliminado"
 * - Aplicar cambios: editor.apply()
 * - Limpiar campo de contraseña por seguridad
 * 
 * PASO 10: Probar la aplicación
 * - Ejecutar la app
 * - Introducir un email válido y contraseña
 * - Marcar "Recordar email" y presionar "Iniciar sesión"
 * - Cerrar y abrir la app, verificar que el email se carga automáticamente
 * - Desmarcar "Recordar email" y presionar "Iniciar sesión"
 * - Cerrar y abrir la app, verificar que el email no se carga
 * 
 * CONCEPTOS CLAVE:
 * - Cargar datos en onCreate() para restaurar estado al iniciar
 * - Validar datos antes de guardarlos (especialmente emails)
 * - Usar remove() para eliminar una clave específica
 * - Patterns.EMAIL_ADDRESS es una utilidad de Android para validar emails
 * - Guardar preferencias condicionalmente según la elección del usuario
 */
class LoginActivity : AppCompatActivity() {

    // Referencias a los componentes de la UI
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var checkBoxRecordarEmail: CheckBox
    private lateinit var buttonIniciarSesion: Button

    // Nombre del archivo de preferencias
    private val PREFS_NAME = "login_preferences"
    
    // Clave para el email guardado
    private val KEY_EMAIL = "email_guardado"
    private val KEY_RECORDAR_EMAIL = "recordar_email"

    // Instancia de SharedPreferences
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Inicializar componentes de la UI
        initViews()

        // Cargar email guardado al iniciar la Activity
        cargarEmailGuardado()

        // Configurar listener del botón
        buttonIniciarSesion.setOnClickListener {
            iniciarSesion()
        }
    }

    /**
     * Inicializa las referencias a los componentes de la UI
     */
    private fun initViews() {
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        checkBoxRecordarEmail = findViewById(R.id.checkBoxRecordarEmail)
        buttonIniciarSesion = findViewById(R.id.buttonIniciarSesion)

        // Restaurar el estado del CheckBox
        checkBoxRecordarEmail.isChecked = sharedPreferences.getBoolean(KEY_RECORDAR_EMAIL, false)
    }

    /**
     * Carga el email guardado si existe
     */
    private fun cargarEmailGuardado() {
        val emailGuardado = sharedPreferences.getString(KEY_EMAIL, null)
        
        if (emailGuardado != null) {
            editTextEmail.setText(emailGuardado)
        } else {
            // Si no hay email guardado, el campo queda vacío
            editTextEmail.setText("")
        }
    }

    /**
     * Valida el formato del email
     */
    private fun esEmailValido(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    /**
     * Maneja el proceso de inicio de sesión
     */
    private fun iniciarSesion() {
        val email = editTextEmail.text.toString().trim()
        val password = editTextPassword.text.toString()

        // Validar formato del email
        if (!esEmailValido(email)) {
            Toast.makeText(this, "El formato del email no es válido", Toast.LENGTH_SHORT).show()
            return
        }

        // Validar que la contraseña no esté vacía
        if (password.isEmpty()) {
            Toast.makeText(this, "La contraseña no puede estar vacía", Toast.LENGTH_SHORT).show()
            return
        }

        // Gestionar el guardado del email según el CheckBox
        val editor = sharedPreferences.edit()
        
        if (checkBoxRecordarEmail.isChecked) {
            // Guardar el email
            editor.putString(KEY_EMAIL, email)
            editor.putBoolean(KEY_RECORDAR_EMAIL, true)
            editor.apply()
            Toast.makeText(this, "Email guardado correctamente", Toast.LENGTH_SHORT).show()
        } else {
            // Eliminar el email guardado
            editor.remove(KEY_EMAIL)
            editor.putBoolean(KEY_RECORDAR_EMAIL, false)
            editor.apply()
            Toast.makeText(this, "Email eliminado de las preferencias", Toast.LENGTH_SHORT).show()
        }

        // Aquí iría la lógica real de autenticación
        // Por ahora, solo mostramos un mensaje de éxito
        Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
        
        // Limpiar el campo de contraseña por seguridad
        editTextPassword.setText("")
    }
}

