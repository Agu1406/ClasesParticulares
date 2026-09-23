package com.example.ejercicio9_sqlite_conceptos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * EJERCICIO 9: SQLite - Conceptos y definición
 * 
 * Esta clase SQLiteOpenHelper demuestra la creación básica de una base de datos SQLite
 * con una tabla de usuarios.
 * 
 * GUÍA PASO A PASO PARA CREAR ESTA CLASE:
 * 
 * PASO 1: Crear la clase
 * - Crear nueva clase DatabaseHelper en el package correspondiente
 * - Extender SQLiteOpenHelper
 * - Definir constructor que recibe Context
 * 
 * PASO 2: Definir constantes en companion object
 * - DATABASE_NAME = "mi_base_datos.db"
 * - DATABASE_VERSION = 1
 * - TABLE_USUARIOS = "usuarios"
 * - Nombres de columnas: COLUMN_ID, COLUMN_NOMBRE, COLUMN_EMAIL, etc.
 * 
 * PASO 3: Implementar constructor
 * - Llamar a super(context, DATABASE_NAME, null, DATABASE_VERSION)
 * - El tercer parámetro (null) es para CursorFactory, no necesario aquí
 * 
 * PASO 4: Implementar onCreate()
 * - Crear String con SQL CREATE TABLE
 * - Definir columnas con tipos y restricciones:
 *   - _id INTEGER PRIMARY KEY AUTOINCREMENT
 *   - nombre TEXT NOT NULL
 *   - email TEXT UNIQUE NOT NULL
 *   - edad INTEGER
 *   - fecha_registro TEXT
 * - Ejecutar: db.execSQL(createTableSQL)
 * 
 * PASO 5: Implementar onUpgrade()
 * - Por ahora, implementación simple:
 *   db.execSQL("DROP TABLE IF EXISTS $TABLE_USUARIOS")
 *   onCreate(db)
 * - En producción, hacer migraciones más cuidadosas
 * 
 * PASO 6: Implementar obtenerInfoTabla()
 * - Ejecutar consulta: db.rawQuery("PRAGMA table_info($TABLE_USUARIOS)", null)
 * - Usar cursor.use { } para manejo automático de recursos
 * - Iterar con moveToNext()
 * - Extraer: name, type, notnull, dflt_value, pk
 * - Crear objetos ColumnaInfo y añadir a lista
 * - Retornar lista
 * 
 * PASO 7: Crear data class ColumnaInfo
 * - Propiedades: nombre, tipo, notNull, valorPorDefecto, esClavePrimaria
 * 
 * CONCEPTOS CLAVE:
 * - SQLiteOpenHelper es la clase base para gestionar BD en Android
 * - onCreate() solo se ejecuta si la BD no existe
 * - onUpgrade() se ejecuta cuando DATABASE_VERSION cambia
 * - PRIMARY KEY AUTOINCREMENT genera IDs automáticamente
 * - UNIQUE previene valores duplicados
 * - NOT NULL hace obligatorio el campo
 */
class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {

    companion object {
        // Nombre de la base de datos
        private const val DATABASE_NAME = "mi_base_datos.db"
        
        // Versión de la base de datos (importante para migraciones)
        private const val DATABASE_VERSION = 1

        // Nombre de la tabla
        const val TABLE_USUARIOS = "usuarios"

        // Columnas de la tabla usuarios
        const val COLUMN_ID = "_id"
        const val COLUMN_NOMBRE = "nombre"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_EDAD = "edad"
        const val COLUMN_FECHA_REGISTRO = "fecha_registro"
    }

    /**
     * Se ejecuta cuando la base de datos se crea por primera vez
     * Aquí definimos la estructura de las tablas
     */
    override fun onCreate(db: SQLiteDatabase) {
        val createTableSQL = """
            CREATE TABLE $TABLE_USUARIOS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NOMBRE TEXT NOT NULL,
                $COLUMN_EMAIL TEXT UNIQUE NOT NULL,
                $COLUMN_EDAD INTEGER,
                $COLUMN_FECHA_REGISTRO TEXT
            )
        """.trimIndent()

        db.execSQL(createTableSQL)
    }

    /**
     * Se ejecuta cuando la versión de la base de datos cambia
     * Aquí manejamos las migraciones
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Si cambia la versión, eliminamos la tabla y la recreamos
        // En producción, esto debería hacer migraciones más cuidadosas
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USUARIOS")
        onCreate(db)
    }

    /**
     * Obtiene información sobre la estructura de la tabla
     */
    fun obtenerInfoTabla(): List<ColumnaInfo> {
        val columnas = mutableListOf<ColumnaInfo>()
        val db = readableDatabase

        // Usar PRAGMA para obtener información de la tabla
        val cursor = db.rawQuery("PRAGMA table_info($TABLE_USUARIOS)", null)

        cursor.use {
            while (it.moveToNext()) {
                val nombre = it.getString(it.getColumnIndexOrThrow("name"))
                val tipo = it.getString(it.getColumnIndexOrThrow("type"))
                val notNull = it.getInt(it.getColumnIndexOrThrow("notnull")) == 1
                val defaultValue = it.getString(it.getColumnIndexOrThrow("dflt_value"))
                val pk = it.getInt(it.getColumnIndexOrThrow("pk")) == 1

                columnas.add(
                    ColumnaInfo(
                        nombre = nombre,
                        tipo = tipo,
                        notNull = notNull,
                        valorPorDefecto = defaultValue,
                        esClavePrimaria = pk
                    )
                )
            }
        }

        return columnas
    }

    /**
     * Clase de datos para información de columna
     */
    data class ColumnaInfo(
        val nombre: String,
        val tipo: String,
        val notNull: Boolean,
        val valorPorDefecto: String?,
        val esClavePrimaria: Boolean
    )
}

