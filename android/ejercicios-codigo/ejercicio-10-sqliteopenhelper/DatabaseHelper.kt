package com.example.ejercicio10_sqliteopenhelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * EJERCICIO 10: SQLiteOpenHelper - Creación y estructura
 * 
 * Esta clase demuestra una estructura completa de SQLiteOpenHelper
 * con múltiples tablas relacionadas y sistema de versionado.
 * 
 * GUÍA PASO A PASO PARA CREAR ESTA CLASE:
 * 
 * PASO 1: Crear la clase
 * - Crear DatabaseHelper que extiende SQLiteOpenHelper
 * - Constructor privado para implementar patrón Singleton
 * 
 * PASO 2: Definir constantes en companion object
 * - DATABASE_NAME = "tienda.db"
 * - DATABASE_VERSION = 1 (incrementar para migraciones)
 * - Nombres de tablas: TABLE_CATEGORIAS, TABLE_PRODUCTOS
 * - Nombres de columnas para cada tabla
 * 
 * PASO 3: Implementar patrón Singleton
 * - @Volatile private var INSTANCE: DatabaseHelper? = null
 * - Función getInstance(context: Context): DatabaseHelper
 * - Usar synchronized para thread-safety
 * - Retornar instancia existente o crear nueva
 * 
 * PASO 4: Implementar constructor
 * - Constructor privado
 * - Llamar a super(context, DATABASE_NAME, null, DATABASE_VERSION)
 * 
 * PASO 5: Implementar onCreate()
 * - Crear tabla categorias:
 *   CREATE TABLE categorias (
 *     id_categoria INTEGER PRIMARY KEY AUTOINCREMENT,
 *     nombre TEXT NOT NULL UNIQUE,
 *     descripcion TEXT
 *   )
 * - Crear tabla productos con clave foránea:
 *   CREATE TABLE productos (
 *     id_producto INTEGER PRIMARY KEY AUTOINCREMENT,
 *     nombre TEXT NOT NULL,
 *     precio REAL NOT NULL,
 *     stock INTEGER DEFAULT 0,
 *     id_categoria INTEGER,
 *     FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
 *   )
 * - Ejecutar ambos CREATE TABLE
 * 
 * PASO 6: Implementar onUpgrade()
 * - Usar when(oldVersion) para manejar diferentes migraciones
 * - Versión 1 a 2: ALTER TABLE productos ADD COLUMN fecha_creacion TEXT
 * - Versión 2 a 3: CREATE TABLE ventas con estructura completa
 * - En producción, hacer migraciones incrementales y cuidadosas
 * 
 * PASO 7: Implementar obtenerVersion()
 * - Retornar: readableDatabase.version
 * 
 * PASO 8: Probar la clase
 * - Crear instancia con getInstance()
 * - Verificar que solo se crea una instancia
 * - Probar migraciones incrementando DATABASE_VERSION
 * 
 * CONCEPTOS CLAVE:
 * - Singleton garantiza una sola instancia de DatabaseHelper
 * - FOREIGN KEY establece relaciones entre tablas
 * - onUpgrade() maneja migraciones cuando cambia la versión
 * - DEFAULT 0 establece valor por defecto para stock
 * - UNIQUE previene nombres de categoría duplicados
 * - REAL es el tipo para números decimales en SQLite
 * - En producción, hacer backups antes de migraciones
 */
class DatabaseHelper private constructor(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {

    companion object {
        private const val DATABASE_NAME = "tienda.db"
        private const val DATABASE_VERSION = 1

        // Tablas
        const val TABLE_CATEGORIAS = "categorias"
        const val TABLE_PRODUCTOS = "productos"

        // Columnas de categorias
        const val COL_CAT_ID = "id_categoria"
        const val COL_CAT_NOMBRE = "nombre"
        const val COL_CAT_DESCRIPCION = "descripcion"

        // Columnas de productos
        const val COL_PROD_ID = "id_producto"
        const val COL_PROD_NOMBRE = "nombre"
        const val COL_PROD_PRECIO = "precio"
        const val COL_PROD_STOCK = "stock"
        const val COL_PROD_ID_CATEGORIA = "id_categoria"

        // Instancia única (Singleton)
        @Volatile
        private var INSTANCE: DatabaseHelper? = null

        fun getInstance(context: Context): DatabaseHelper {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: DatabaseHelper(context.applicationContext).also { INSTANCE = it }
            }
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Crear tabla categorias
        val createCategoriasSQL = """
            CREATE TABLE $TABLE_CATEGORIAS (
                $COL_CAT_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_CAT_NOMBRE TEXT NOT NULL UNIQUE,
                $COL_CAT_DESCRIPCION TEXT
            )
        """.trimIndent()

        // Crear tabla productos con clave foránea
        val createProductosSQL = """
            CREATE TABLE $TABLE_PRODUCTOS (
                $COL_PROD_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_PROD_NOMBRE TEXT NOT NULL,
                $COL_PROD_PRECIO REAL NOT NULL,
                $COL_PROD_STOCK INTEGER DEFAULT 0,
                $COL_PROD_ID_CATEGORIA INTEGER,
                FOREIGN KEY ($COL_PROD_ID_CATEGORIA) REFERENCES $TABLE_CATEGORIAS($COL_CAT_ID)
            )
        """.trimIndent()

        db.execSQL(createCategoriasSQL)
        db.execSQL(createProductosSQL)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        when (oldVersion) {
            1 -> {
                // Migración de versión 1 a 2: añadir columna fecha_creacion
                if (newVersion >= 2) {
                    db.execSQL("ALTER TABLE $TABLE_PRODUCTOS ADD COLUMN fecha_creacion TEXT")
                }
            }
            2 -> {
                // Migración de versión 2 a 3: crear tabla ventas
                if (newVersion >= 3) {
                    val createVentasSQL = """
                        CREATE TABLE ventas (
                            id_venta INTEGER PRIMARY KEY AUTOINCREMENT,
                            id_producto INTEGER,
                            cantidad INTEGER,
                            fecha TEXT,
                            FOREIGN KEY (id_producto) REFERENCES $TABLE_PRODUCTOS($COL_PROD_ID)
                        )
                    """.trimIndent()
                    db.execSQL(createVentasSQL)
                }
            }
        }
    }

    /**
     * Obtiene la versión actual de la base de datos
     */
    fun obtenerVersion(): Int {
        return readableDatabase.version
    }
}

