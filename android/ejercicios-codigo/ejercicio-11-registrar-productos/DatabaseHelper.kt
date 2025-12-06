package com.example.ejercicio11_registrar_productos

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * DatabaseHelper para el ejercicio de registro de productos
 */
class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "tienda.db", null, 1) {

    companion object {
        const val TABLE_CATEGORIAS = "categorias"
        const val TABLE_PRODUCTOS = "productos"

        const val COL_CAT_ID = "id_categoria"
        const val COL_CAT_NOMBRE = "nombre"

        const val COL_PROD_ID = "id_producto"
        const val COL_PROD_NOMBRE = "nombre"
        const val COL_PROD_PRECIO = "precio"
        const val COL_PROD_STOCK = "stock"
        const val COL_PROD_ID_CATEGORIA = "id_categoria"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE $TABLE_CATEGORIAS (
                $COL_CAT_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_CAT_NOMBRE TEXT NOT NULL UNIQUE
            )
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE $TABLE_PRODUCTOS (
                $COL_PROD_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_PROD_NOMBRE TEXT NOT NULL,
                $COL_PROD_PRECIO REAL NOT NULL,
                $COL_PROD_STOCK INTEGER DEFAULT 0,
                $COL_PROD_ID_CATEGORIA INTEGER,
                FOREIGN KEY ($COL_PROD_ID_CATEGORIA) REFERENCES $TABLE_CATEGORIAS($COL_CAT_ID)
            )
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUCTOS")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CATEGORIAS")
        onCreate(db)
    }

    /**
     * Inserta un nuevo producto
     */
    fun insertarProducto(nombre: String, precio: Double, stock: Int, idCategoria: Long): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_PROD_NOMBRE, nombre)
            put(COL_PROD_PRECIO, precio)
            put(COL_PROD_STOCK, stock)
            put(COL_PROD_ID_CATEGORIA, idCategoria)
        }
        return db.insert(TABLE_PRODUCTOS, null, values)
    }

    /**
     * Verifica si existe un producto con el mismo nombre
     */
    fun existeProducto(nombre: String): Boolean {
        val db = readableDatabase
        val cursor = db.query(
            TABLE_PRODUCTOS,
            arrayOf(COL_PROD_ID),
            "$COL_PROD_NOMBRE = ?",
            arrayOf(nombre),
            null, null, null
        )
        val existe = cursor.count > 0
        cursor.close()
        return existe
    }

    /**
     * Obtiene todas las categorías
     */
    fun obtenerCategorias(): List<Categoria> {
        val categorias = mutableListOf<Categoria>()
        val db = readableDatabase
        val cursor = db.query(TABLE_CATEGORIAS, null, null, null, null, null, null)

        cursor.use {
            while (it.moveToNext()) {
                val id = it.getLong(it.getColumnIndexOrThrow(COL_CAT_ID))
                val nombre = it.getString(it.getColumnIndexOrThrow(COL_CAT_NOMBRE))
                categorias.add(Categoria(id, nombre))
            }
        }

        return categorias
    }

    /**
     * Inserta una categoría de ejemplo si no hay categorías
     */
    fun crearCategoriaEjemplo(): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_CAT_NOMBRE, "General")
        }
        return db.insert(TABLE_CATEGORIAS, null, values)
    }

    data class Categoria(val id: Long, val nombre: String)
}

