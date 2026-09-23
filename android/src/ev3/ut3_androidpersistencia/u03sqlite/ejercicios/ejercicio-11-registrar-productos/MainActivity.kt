package com.example.ejercicio11_registrar_productos

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * EJERCICIO 11: SQLite - Registrar productos con validación
 * 
 * GUÍA PASO A PASO PARA CREAR ESTE EJERCICIO DESDE CERO:
 * 
 * PASO 1: Crear el proyecto
 * - Crea un nuevo proyecto "Empty Activity" en Android Studio
 * - Nombre: "Ejercicio11RegistrarProductos"
 * - Package: com.example.ejercicio11_registrar_productos
 * - Language: Kotlin
 * - Minimum SDK: API 24
 * 
 * PASO 2: Crear DatabaseHelper.kt
 * - Extender SQLiteOpenHelper
 * - Crear tablas: categorias y productos
 * - Implementar métodos: insertarProducto(), existeProducto(), obtenerCategorias()
 * - Ver guía completa en DatabaseHelper.kt
 * 
 * PASO 3: Crear layout activity_main.xml
 * - TextInputLayouts para: nombre, precio, stock
 * - Spinner para categoría
 * - Botón "Registrar producto"
 * - Botón "Crear categoría de ejemplo" (inicialmente gone)
 * - TextView para mensajes de error/éxito
 * 
 * PASO 4: Implementar MainActivity
 * - Declarar DatabaseHelper y referencias a componentes
 * - En onCreate(), inicializar DatabaseHelper y cargar categorías
 * 
 * PASO 5: Implementar cargarCategorias()
 * - Obtener lista: databaseHelper.obtenerCategorias()
 * - Si está vacía, mostrar botón "Crear categoría" y mensaje
 * - Si hay categorías, crear ArrayAdapter y asignar al Spinner
 * 
 * PASO 6: Implementar validarNombre()
 * - No vacío
 * - Mínimo 3 caracteres
 * - No solo espacios en blanco
 * - Retornar true si válido, mostrar error si no
 * 
 * PASO 7: Implementar validarPrecio()
 * - No vacío
 * - Convertir a Double (usar toDoubleOrNull())
 * - Mayor que 0
 * - Máximo 2 decimales (verificar con split("."))
 * - Retornar true si válido
 * 
 * PASO 8: Implementar validarStock()
 * - No vacío
 * - Convertir a Int (usar toIntOrNull())
 * - No negativo (>= 0)
 * - Retornar true si válido
 * 
 * PASO 9: Implementar validarCategoria()
 * - Verificar que Spinner tenga selección válida
 * - Retornar true si válido
 * 
 * PASO 10: Implementar registrarProducto()
 * - Obtener valores de EditTexts
 * - Llamar a todas las validaciones
 * - Verificar duplicados: databaseHelper.existeProducto(nombre)
 * - Si no existe duplicado, insertar: databaseHelper.insertarProducto()
 * - Mostrar mensaje de éxito o error
 * - Limpiar campos si éxito
 * 
 * PASO 11: Implementar crearCategoriaEjemplo()
 * - Llamar a databaseHelper.crearCategoriaEjemplo()
 * - Recargar categorías
 * 
 * PASO 12: Probar la aplicación
 * - Crear categoría de ejemplo
 * - Registrar productos válidos
 * - Intentar registrar producto duplicado
 * - Probar validaciones con datos inválidos
 * 
 * CONCEPTOS CLAVE:
 * - Validar datos antes de insertar en BD
 * - Verificar duplicados con consulta previa
 * - ContentValues para estructurar datos a insertar
 * - insert() retorna el ID del registro insertado o -1 si falla
 * - Manejar errores con try-catch
 * - Mostrar mensajes claros al usuario
 */
class MainActivity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextPrecio: EditText
    private lateinit var editTextStock: EditText
    private lateinit var spinnerCategoria: Spinner
    private lateinit var buttonRegistrar: Button
    private lateinit var buttonCrearCategoria: Button
    private lateinit var textViewMensaje: TextView

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseHelper = DatabaseHelper(this)
        initViews()
        cargarCategorias()
    }

    private fun initViews() {
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextPrecio = findViewById(R.id.editTextPrecio)
        editTextStock = findViewById(R.id.editTextStock)
        spinnerCategoria = findViewById(R.id.spinnerCategoria)
        buttonRegistrar = findViewById(R.id.buttonRegistrar)
        buttonCrearCategoria = findViewById(R.id.buttonCrearCategoria)
        textViewMensaje = findViewById(R.id.textViewMensaje)

        buttonRegistrar.setOnClickListener { registrarProducto() }
        buttonCrearCategoria.setOnClickListener { crearCategoriaEjemplo() }
    }

    private fun cargarCategorias() {
        val categorias = databaseHelper.obtenerCategorias()

        if (categorias.isEmpty()) {
            buttonCrearCategoria.visibility = android.view.View.VISIBLE
            textViewMensaje.text = "No hay categorías. Crea una categoría de ejemplo primero."
        } else {
            buttonCrearCategoria.visibility = android.view.View.GONE
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                categorias.map { it.nombre }
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCategoria.adapter = adapter
        }
    }

    private fun registrarProducto() {
        val nombre = editTextNombre.text.toString().trim()
        val precioTexto = editTextPrecio.text.toString().trim()
        val stockTexto = editTextStock.text.toString().trim()

        // Validaciones
        if (!validarNombre(nombre)) return
        if (!validarPrecio(precioTexto)) return
        if (!validarStock(stockTexto)) return
        if (!validarCategoria()) return

        val precio = precioTexto.toDouble()
        val stock = stockTexto.toInt()
        val categoriaSeleccionada = spinnerCategoria.selectedItemPosition
        val categorias = databaseHelper.obtenerCategorias()
        val idCategoria = categorias[categoriaSeleccionada].id

        // Verificar duplicados
        if (databaseHelper.existeProducto(nombre)) {
            textViewMensaje.text = "Error: Ya existe un producto con ese nombre"
            Toast.makeText(this, "Ya existe un producto con ese nombre", Toast.LENGTH_SHORT).show()
            return
        }

        // Insertar producto
        try {
            val id = databaseHelper.insertarProducto(nombre, precio, stock, idCategoria)
            if (id > 0) {
                textViewMensaje.text = "✓ Producto registrado correctamente (ID: $id)"
                Toast.makeText(this, "Producto registrado correctamente", Toast.LENGTH_SHORT).show()
                limpiarCampos()
            } else {
                textViewMensaje.text = "Error: No se pudo registrar el producto"
            }
        } catch (e: Exception) {
            textViewMensaje.text = "Error: ${e.message}"
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validarNombre(nombre: String): Boolean {
        if (nombre.isEmpty()) {
            textViewMensaje.text = "Error: El nombre no puede estar vacío"
            return false
        }
        if (nombre.length < 3) {
            textViewMensaje.text = "Error: El nombre debe tener al menos 3 caracteres"
            return false
        }
        if (nombre.trim().isEmpty()) {
            textViewMensaje.text = "Error: El nombre no puede contener solo espacios"
            return false
        }
        return true
    }

    private fun validarPrecio(precioTexto: String): Boolean {
        if (precioTexto.isEmpty()) {
            textViewMensaje.text = "Error: El precio no puede estar vacío"
            return false
        }
        val precio = precioTexto.toDoubleOrNull()
        if (precio == null) {
            textViewMensaje.text = "Error: El precio debe ser un número válido"
            return false
        }
        if (precio <= 0) {
            textViewMensaje.text = "Error: El precio debe ser mayor que 0"
            return false
        }
        // Validar máximo 2 decimales
        if (precioTexto.contains(".") && precioTexto.split(".")[1].length > 2) {
            textViewMensaje.text = "Error: El precio debe tener máximo 2 decimales"
            return false
        }
        return true
    }

    private fun validarStock(stockTexto: String): Boolean {
        if (stockTexto.isEmpty()) {
            textViewMensaje.text = "Error: El stock no puede estar vacío"
            return false
        }
        val stock = stockTexto.toIntOrNull()
        if (stock == null) {
            textViewMensaje.text = "Error: El stock debe ser un número entero"
            return false
        }
        if (stock < 0) {
            textViewMensaje.text = "Error: El stock no puede ser negativo"
            return false
        }
        return true
    }

    private fun validarCategoria(): Boolean {
        if (spinnerCategoria.selectedItemPosition == android.widget.AdapterView.INVALID_POSITION) {
            textViewMensaje.text = "Error: Debes seleccionar una categoría"
            return false
        }
        return true
    }

    private fun limpiarCampos() {
        editTextNombre.setText("")
        editTextPrecio.setText("")
        editTextStock.setText("")
    }

    private fun crearCategoriaEjemplo() {
        val id = databaseHelper.crearCategoriaEjemplo()
        if (id > 0) {
            Toast.makeText(this, "Categoría de ejemplo creada", Toast.LENGTH_SHORT).show()
            cargarCategorias()
        }
    }
}

