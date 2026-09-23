package com.example.ejercicio5_sistema_archivos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * EJERCICIO 5: Sistema interno de ficheros - Introducción
 * 
 * Este ejercicio demuestra el uso básico del sistema de archivos interno
 * de Android para guardar, listar y eliminar archivos de texto.
 * 
 * GUÍA PASO A PASO PARA CREAR ESTE EJERCICIO DESDE CERO:
 * 
 * PASO 1: Crear el proyecto
 * - Crea un nuevo proyecto "Empty Activity" en Android Studio
 * - Nombre: "Ejercicio5SistemaArchivos"
 * - Package: com.example.ejercicio5_sistema_archivos
 * - Language: Kotlin
 * - Minimum SDK: API 24
 * 
 * PASO 2: Configurar dependencias (build.gradle.kts - app)
 * - Añade:
 *   implementation("androidx.recyclerview:recyclerview:1.3.1")
 *   implementation("androidx.cardview:cardview:1.0.0")
 * 
 * PASO 3: Crear layouts
 * - activity_main.xml: LinearLayout con EditTexts, botones y RecyclerView
 * - item_archivo.xml: CardView para mostrar cada archivo en la lista
 * 
 * PASO 4: Implementar MainActivity
 * - Declarar referencias a componentes UI
 * - Declarar ArchivosAdapter y listaArchivos
 * 
 * PASO 5: Implementar initViews()
 * - Obtener referencias con findViewById()
 * - Configurar listeners de botones
 * 
 * PASO 6: Implementar setupRecyclerView()
 * - Crear ArchivosAdapter con callback para abrir archivo
 * - Configurar LinearLayoutManager
 * - Asignar adapter al RecyclerView
 * 
 * PASO 7: Implementar validarNombreArchivo()
 * - Validar que no esté vacío
 * - Validar formato con Regex: solo letras, números y guiones bajos
 * - Retornar true si es válido
 * 
 * PASO 8: Implementar guardarArchivo()
 * - Validar nombre y contenido
 * - Crear nombre completo: "$nombreArchivo.txt"
 * - Abrir archivo: openFileOutput(nombreCompleto, MODE_PRIVATE)
 * - Escribir contenido: fileOutputStream.write(contenido.toByteArray())
 * - Cerrar: fileOutputStream.close()
 * - Mostrar Toast y limpiar campos
 * - Llamar a listarArchivos()
 * 
 * PASO 9: Implementar listarArchivos()
 * - Limpiar listaArchivos
 * - Obtener lista: fileList()
 * - Filtrar solo archivos .txt
 * - Añadir a listaArchivos
 * - Notificar cambios: adapter.notifyDataSetChanged()
 * 
 * PASO 10: Implementar abrirArchivo()
 * - Abrir archivo: openFileInput(nombreArchivo)
 * - Leer contenido: fileInputStream.bufferedReader().use { it.readText() }
 * - Cerrar: fileInputStream.close()
 * - Mostrar contenido en EditText
 * - Mostrar nombre (sin extensión) en EditText de nombre
 * 
 * PASO 11: Implementar eliminarTodosLosArchivos()
 * - Mostrar AlertDialog de confirmación
 * - Si confirma, iterar listaArchivos
 * - Eliminar cada archivo: deleteFile(nombreArchivo)
 * - Contar eliminados y mostrar Toast
 * - Llamar a listarArchivos()
 * 
 * PASO 12: Crear ArchivosAdapter
 * - Extender RecyclerView.Adapter
 * - Implementar métodos requeridos
 * - En onBindViewHolder, configurar click para abrir archivo
 * 
 * PASO 13: Probar la aplicación
 * - Guardar varios archivos
 * - Listar y verificar que aparecen
 * - Abrir un archivo y verificar que se carga
 * - Eliminar todos y verificar
 * 
 * CONCEPTOS CLAVE:
 * - openFileOutput() crea/sobrescribe archivos en almacenamiento interno
 * - openFileInput() lee archivos del almacenamiento interno
 * - fileList() obtiene lista de archivos guardados
 * - deleteFile() elimina un archivo
 * - MODE_PRIVATE sobrescribe el archivo si existe
 * - Los archivos se guardan en /data/data/[package]/files/
 */
class MainActivity : AppCompatActivity() {

    private lateinit var editTextContenido: EditText
    private lateinit var editTextNombreArchivo: EditText
    private lateinit var buttonGuardar: Button
    private lateinit var buttonListar: Button
    private lateinit var buttonEliminarTodos: Button
    private lateinit var recyclerViewArchivos: RecyclerView

    private lateinit var adapter: ArchivosAdapter
    private val listaArchivos = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupRecyclerView()
        listarArchivos()
    }

    private fun initViews() {
        editTextContenido = findViewById(R.id.editTextContenido)
        editTextNombreArchivo = findViewById(R.id.editTextNombreArchivo)
        buttonGuardar = findViewById(R.id.buttonGuardar)
        buttonListar = findViewById(R.id.buttonListar)
        buttonEliminarTodos = findViewById(R.id.buttonEliminarTodos)
        recyclerViewArchivos = findViewById(R.id.recyclerViewArchivos)

        buttonGuardar.setOnClickListener { guardarArchivo() }
        buttonListar.setOnClickListener { listarArchivos() }
        buttonEliminarTodos.setOnClickListener { eliminarTodosLosArchivos() }
    }

    private fun setupRecyclerView() {
        adapter = ArchivosAdapter(listaArchivos) { nombreArchivo ->
            abrirArchivo(nombreArchivo)
        }
        recyclerViewArchivos.layoutManager = LinearLayoutManager(this)
        recyclerViewArchivos.adapter = adapter
    }

    /**
     * Valida el nombre del archivo
     */
    private fun validarNombreArchivo(nombre: String): Boolean {
        if (nombre.isEmpty()) {
            Toast.makeText(this, "El nombre del archivo no puede estar vacío", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validar que no contenga caracteres especiales
        val regex = Regex("^[a-zA-Z0-9_]+$")
        if (!nombre.matches(regex)) {
            Toast.makeText(this, "El nombre solo puede contener letras, números y guiones bajos", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    /**
     * Guarda un archivo en el almacenamiento interno
     */
    private fun guardarArchivo() {
        val nombreArchivo = editTextNombreArchivo.text.toString().trim()
        val contenido = editTextContenido.text.toString()

        if (!validarNombreArchivo(nombreArchivo)) {
            return
        }

        if (contenido.isEmpty()) {
            Toast.makeText(this, "El contenido no puede estar vacío", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            // Abrir el archivo para escritura con MODE_PRIVATE
            // Esto sobrescribe el archivo si ya existe
            val nombreCompleto = "$nombreArchivo.txt"
            val fileOutputStream: FileOutputStream = openFileOutput(nombreCompleto, MODE_PRIVATE)
            
            // Escribir el contenido
            fileOutputStream.write(contenido.toByteArray())
            fileOutputStream.close()

            Toast.makeText(this, "Archivo guardado correctamente", Toast.LENGTH_SHORT).show()
            
            // Limpiar campos
            editTextNombreArchivo.setText("")
            editTextContenido.setText("")
            
            // Actualizar lista
            listarArchivos()
        } catch (e: Exception) {
            Toast.makeText(this, "Error al guardar: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Lista todos los archivos guardados
     */
    private fun listarArchivos() {
        listaArchivos.clear()
        
        // Obtener lista de archivos usando fileList()
        val archivos = fileList()
        
        // Filtrar solo archivos .txt
        archivos.filter { it.endsWith(".txt") }
            .forEach { listaArchivos.add(it) }

        adapter.notifyDataSetChanged()

        if (listaArchivos.isEmpty()) {
            Toast.makeText(this, "No hay archivos guardados", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Abre y muestra el contenido de un archivo
     */
    private fun abrirArchivo(nombreArchivo: String) {
        try {
            // Abrir el archivo para lectura
            val fileInputStream: FileInputStream = openFileInput(nombreArchivo)
            
            // Leer el contenido
            val contenido = fileInputStream.bufferedReader().use { it.readText() }
            fileInputStream.close()

            // Mostrar el contenido en el EditText
            editTextContenido.setText(contenido)
            
            // Mostrar el nombre del archivo (sin extensión)
            val nombreSinExtension = nombreArchivo.replace(".txt", "")
            editTextNombreArchivo.setText(nombreSinExtension)

            Toast.makeText(this, "Archivo cargado: $nombreArchivo", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error al abrir el archivo: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Elimina todos los archivos guardados
     */
    private fun eliminarTodosLosArchivos() {
        if (listaArchivos.isEmpty()) {
            Toast.makeText(this, "No hay archivos para eliminar", Toast.LENGTH_SHORT).show()
            return
        }

        AlertDialog.Builder(this)
            .setTitle("Eliminar todos los archivos")
            .setMessage("¿Estás seguro de eliminar todos los archivos? Esta acción no se puede deshacer.")
            .setPositiveButton("Eliminar") { _, _ ->
                var eliminados = 0
                listaArchivos.forEach { nombreArchivo ->
                    if (deleteFile(nombreArchivo)) {
                        eliminados++
                    }
                }
                Toast.makeText(this, "$eliminados archivos eliminados", Toast.LENGTH_SHORT).show()
                listarArchivos()
                editTextContenido.setText("")
                editTextNombreArchivo.setText("")
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    /**
     * Adapter para el RecyclerView de archivos
     */
    class ArchivosAdapter(
        private val archivos: List<String>,
        private val onItemClick: (String) -> Unit
    ) : RecyclerView.Adapter<ArchivosAdapter.ArchivoViewHolder>() {

        class ArchivoViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
            val textViewNombre: TextView = itemView.findViewById(R.id.textViewNombreArchivo)
        }

        override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): ArchivoViewHolder {
            val view = android.view.LayoutInflater.from(parent.context)
                .inflate(R.layout.item_archivo, parent, false)
            return ArchivoViewHolder(view)
        }

        override fun onBindViewHolder(holder: ArchivoViewHolder, position: Int) {
            val archivo = archivos[position]
            holder.textViewNombre.text = archivo
            holder.itemView.setOnClickListener {
                onItemClick(archivo)
            }
        }

        override fun getItemCount() = archivos.size
    }
}

