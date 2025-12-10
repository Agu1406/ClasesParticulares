package com.example.ejercicio9_sqlite_conceptos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * EJERCICIO 9: SQLite - Conceptos y definición
 * 
 * Esta Activity demuestra la creación y consulta de información
 * sobre una base de datos SQLite.
 * 
 * GUÍA PASO A PASO PARA CREAR ESTE EJERCICIO DESDE CERO:
 * 
 * PASO 1: Crear el proyecto
 * - Crea un nuevo proyecto "Empty Activity" en Android Studio
 * - Nombre: "Ejercicio9SQLiteConceptos"
 * - Package: com.example.ejercicio9_sqlite_conceptos
 * - Language: Kotlin
 * - Minimum SDK: API 24
 * 
 * PASO 2: Crear DatabaseHelper.kt
 * - Crear clase DatabaseHelper que extiende SQLiteOpenHelper
 * - Definir constantes: DATABASE_NAME, DATABASE_VERSION, nombres de tablas y columnas
 * - Implementar constructor llamando a super()
 * 
 * PASO 3: Implementar onCreate() en DatabaseHelper
 * - Crear SQL CREATE TABLE para la tabla "usuarios"
 * - Columnas: _id (INTEGER PRIMARY KEY AUTOINCREMENT), nombre (TEXT NOT NULL),
 *   email (TEXT UNIQUE NOT NULL), edad (INTEGER), fecha_registro (TEXT)
 * - Ejecutar: db.execSQL(createTableSQL)
 * 
 * PASO 4: Implementar onUpgrade() en DatabaseHelper
 * - Por ahora, eliminar y recrear: DROP TABLE IF EXISTS, luego onCreate()
 * - En producción, esto debería hacer migraciones más cuidadosas
 * 
 * PASO 5: Implementar obtenerInfoTabla() en DatabaseHelper
 * - Ejecutar: db.rawQuery("PRAGMA table_info(usuarios)", null)
 * - Iterar Cursor y extraer información de cada columna
 * - Retornar lista de ColumnaInfo
 * 
 * PASO 6: Crear data class ColumnaInfo
 * - Propiedades: nombre, tipo, notNull, valorPorDefecto, esClavePrimaria
 * 
 * PASO 7: Crear layout activity_main.xml
 * - LinearLayout vertical con padding
 * - Tres botones: "Crear base de datos", "Mostrar información", "Eliminar BD"
 * - ScrollView con TextView para mostrar información
 * 
 * PASO 8: Implementar MainActivity
 * - Declarar DatabaseHelper como lateinit var
 * - Declarar referencias a componentes UI
 * 
 * PASO 9: Implementar crearBaseDatos()
 * - Crear instancia: databaseHelper = DatabaseHelper(this)
 * - Obtener BD: val db = databaseHelper.readableDatabase
 * - Cerrar: db.close()
 * - Esto automáticamente llama a onCreate() si la BD no existe
 * - Mostrar Toast y llamar a mostrarInformacion()
 * 
 * PASO 10: Implementar mostrarInformacion()
 * - Obtener nombre y versión de la BD
 * - Obtener ruta: getDatabasePath(DATABASE_NAME).absolutePath
 * - Obtener información de columnas: databaseHelper.obtenerInfoTabla()
 * - Construir String con toda la información
 * - Mostrar en TextView
 * 
 * PASO 11: Implementar eliminarBaseDatos()
 * - Cerrar databaseHelper si está inicializado
 * - Eliminar: deleteDatabase(DATABASE_NAME)
 * - Mostrar Toast según resultado
 * 
 * PASO 12: Probar la aplicación
 * - Presionar "Crear base de datos"
 * - Presionar "Mostrar información" y verificar estructura
 * - Verificar ruta física de la BD
 * - Probar "Eliminar base de datos" y recrear
 * 
 * CONCEPTOS CLAVE:
 * - SQLiteOpenHelper gestiona creación y versionado de BD
 * - onCreate() se ejecuta solo cuando la BD se crea por primera vez
 * - onUpgrade() se ejecuta cuando DATABASE_VERSION aumenta
 * - PRAGMA table_info() obtiene metadatos de la estructura de tablas
 * - La BD se guarda en /data/data/[package]/databases/
 * - readableDatabase y writableDatabase obtienen instancias de SQLiteDatabase
 */
class MainActivity : AppCompatActivity() {

    private lateinit var buttonCrearBD: Button
    private lateinit var buttonMostrarInfo: Button
    private lateinit var buttonEliminarBD: Button
    private lateinit var textViewInfo: TextView

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupListeners()
    }

    private fun initViews() {
        buttonCrearBD = findViewById(R.id.buttonCrearBD)
        buttonMostrarInfo = findViewById(R.id.buttonMostrarInfo)
        buttonEliminarBD = findViewById(R.id.buttonEliminarBD)
        textViewInfo = findViewById(R.id.textViewInfo)
    }

    private fun setupListeners() {
        buttonCrearBD.setOnClickListener { crearBaseDatos() }
        buttonMostrarInfo.setOnClickListener { mostrarInformacion() }
        buttonEliminarBD.setOnClickListener { eliminarBaseDatos() }
    }

    /**
     * Crea la base de datos obteniendo una instancia
     * Esto automáticamente llama a onCreate() si la BD no existe
     */
    private fun crearBaseDatos() {
        try {
            databaseHelper = DatabaseHelper(this)
            
            // Obtener una instancia de la base de datos (esto la crea si no existe)
            val db = databaseHelper.readableDatabase
            db.close()

            Toast.makeText(this, "Base de datos creada correctamente", Toast.LENGTH_SHORT).show()
            mostrarInformacion()
        } catch (e: Exception) {
            Toast.makeText(this, "Error al crear la base de datos: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Muestra información sobre la base de datos
     */
    private fun mostrarInformacion() {
        try {
            if (!::databaseHelper.isInitialized) {
                databaseHelper = DatabaseHelper(this)
            }

            val db = databaseHelper.readableDatabase

            // Información básica
            val nombreBD = DatabaseHelper.DATABASE_NAME
            val versionBD = databaseHelper.readableDatabase.version

            // Información de la tabla
            val columnas = databaseHelper.obtenerInfoTabla()

            val info = StringBuilder()
            info.append("INFORMACIÓN DE LA BASE DE DATOS\n")
            info.append("==============================\n\n")
            info.append("Nombre: $nombreBD\n")
            info.append("Versión: $versionBD\n")
            info.append("Ruta: ${getDatabasePath(nombreBD).absolutePath}\n\n")
            info.append("ESTRUCTURA DE LA TABLA: ${DatabaseHelper.TABLE_USUARIOS}\n")
            info.append("==========================================\n\n")

            if (columnas.isEmpty()) {
                info.append("La tabla no existe o no se pudo obtener información.\n")
                info.append("Presiona 'Crear base de datos' primero.\n")
            } else {
                columnas.forEachIndexed { index, columna ->
                    info.append("Columna ${index + 1}: ${columna.nombre}\n")
                    info.append("  - Tipo: ${columna.tipo}\n")
                    info.append("  - NOT NULL: ${if (columna.notNull) "Sí" else "No"}\n")
                    info.append("  - Clave Primaria: ${if (columna.esClavePrimaria) "Sí" else "No"}\n")
                    if (columna.valorPorDefecto != null) {
                        info.append("  - Valor por defecto: ${columna.valorPorDefecto}\n")
                    }
                    info.append("\n")
                }
            }

            textViewInfo.text = info.toString()
            db.close()
        } catch (e: Exception) {
            textViewInfo.text = "Error: ${e.message}\n\nAsegúrate de crear la base de datos primero."
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Elimina la base de datos
     */
    private fun eliminarBaseDatos() {
        try {
            if (::databaseHelper.isInitialized) {
                databaseHelper.close()
            }
            val eliminado = deleteDatabase(DatabaseHelper.DATABASE_NAME)
            if (eliminado) {
                Toast.makeText(this, "Base de datos eliminada", Toast.LENGTH_SHORT).show()
                textViewInfo.text = "Base de datos eliminada. Presiona 'Crear base de datos' para crear una nueva."
            } else {
                Toast.makeText(this, "No se pudo eliminar la base de datos", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}

