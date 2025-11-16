package com.example.ejercicio7_archivo_existe

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
import java.io.FileOutputStream

/**
 * EJERCICIO 7: Sistema interno de ficheros - archivoExiste y fileList()
 * 
 * Este ejercicio demuestra cómo verificar la existencia de archivos
 * y listar todos los archivos guardados.
 * 
 * GUÍA PASO A PASO PARA CREAR ESTE EJERCICIO DESDE CERO:
 * 
 * PASO 1: Crear el proyecto
 * - Crea un nuevo proyecto "Empty Activity" en Android Studio
 * - Nombre: "Ejercicio7ArchivoExiste"
 * - Package: com.example.ejercicio7_archivo_existe
 * - Language: Kotlin
 * - Minimum SDK: API 24
 * 
 * PASO 2: Configurar dependencias
 * - Añade RecyclerView y CardView
 * 
 * PASO 3: Crear layouts
 * - activity_main.xml: EditText, botones, TextView info, RecyclerView
 * - item_archivo.xml: CardView con nombre, tamaño y botón eliminar
 * 
 * PASO 4: Crear data class ArchivoInfo
 * - Propiedades: nombre, ruta, tamaño, fechaModificacion
 * 
 * PASO 5: Implementar verificarExistencia()
 * - Obtener nombre del EditText
 * - Añadir extensión .txt si no la tiene
 * - Método 1: fileList().contains(nombreCompleto)
 * - Método 2: getFileStreamPath(nombreCompleto).exists()
 * - Si existe, obtener File y mostrar: ruta, tamaño, fecha
 * - Si no existe, mostrar mensaje
 * 
 * PASO 6: Implementar crearArchivoPrueba()
 * - Validar nombre
 * - Verificar si ya existe (mostrar diálogo de confirmación)
 * - Si no existe o confirma, llamar a crearArchivo()
 * 
 * PASO 7: Implementar crearArchivo()
 * - Crear contenido con fecha/hora actual
 * - Abrir: openFileOutput(nombreCompleto, MODE_PRIVATE)
 * - Escribir y cerrar
 * - Mostrar Toast y llamar a listarArchivos()
 * 
 * PASO 8: Implementar listarArchivos()
 * - Limpiar listaArchivos
 * - Obtener: fileList()
 * - Para cada archivo:
 *   - Crear File: getFileStreamPath(nombreArchivo)
 *   - Si existe, crear ArchivoInfo y añadir a lista
 * - Notificar cambios en adapter
 * 
 * PASO 9: Implementar mostrarInfoArchivo()
 * - Formatear fecha con SimpleDateFormat
 * - Construir mensaje con toda la información
 * - Mostrar en TextView
 * 
 * PASO 10: Crear ArchivosAdapter
 * - Extender RecyclerView.Adapter
 * - En onBindViewHolder, configurar click y botón eliminar
 * 
 * PASO 11: Implementar eliminarArchivo()
 * - Mostrar AlertDialog de confirmación
 * - Si confirma, usar deleteFile(nombreArchivo)
 * - Mostrar Toast y recargar lista
 * 
 * PASO 12: Probar la aplicación
 * - Verificar existencia de archivos
 * - Crear archivos de prueba
 * - Listar todos los archivos
 * - Ver información detallada
 * - Eliminar archivos
 * 
 * CONCEPTOS CLAVE:
 * - fileList() retorna array de nombres de archivos
 * - getFileStreamPath() obtiene objeto File con ruta completa
 * - File.exists() verifica existencia
 * - File.length() obtiene tamaño en bytes
 * - File.lastModified() obtiene timestamp de modificación
 * - deleteFile() elimina un archivo del almacenamiento interno
 */
class MainActivity : AppCompatActivity() {

    private lateinit var editTextNombreArchivo: EditText
    private lateinit var buttonVerificar: Button
    private lateinit var buttonCrearArchivo: Button
    private lateinit var buttonListar: Button
    private lateinit var textViewInfo: TextView
    private lateinit var recyclerViewArchivos: RecyclerView

    private lateinit var adapter: ArchivosAdapter
    private val listaArchivos = mutableListOf<ArchivoInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupRecyclerView()
        listarArchivos()
    }

    private fun initViews() {
        editTextNombreArchivo = findViewById(R.id.editTextNombreArchivo)
        buttonVerificar = findViewById(R.id.buttonVerificar)
        buttonCrearArchivo = findViewById(R.id.buttonCrearArchivo)
        buttonListar = findViewById(R.id.buttonListar)
        textViewInfo = findViewById(R.id.textViewInfo)
        recyclerViewArchivos = findViewById(R.id.recyclerViewArchivos)

        buttonVerificar.setOnClickListener { verificarExistencia() }
        buttonCrearArchivo.setOnClickListener { crearArchivoPrueba() }
        buttonListar.setOnClickListener { listarArchivos() }
    }

    private fun setupRecyclerView() {
        adapter = ArchivosAdapter(listaArchivos) { archivoInfo ->
            mostrarInfoArchivo(archivoInfo)
        }
        recyclerViewArchivos.layoutManager = LinearLayoutManager(this)
        recyclerViewArchivos.adapter = adapter
    }

    /**
     * Verifica si un archivo existe
     */
    private fun verificarExistencia() {
        val nombreArchivo = editTextNombreArchivo.text.toString().trim()

        if (nombreArchivo.isEmpty()) {
            Toast.makeText(this, "Introduce un nombre de archivo", Toast.LENGTH_SHORT).show()
            return
        }

        val nombreCompleto = if (nombreArchivo.endsWith(".txt")) {
            nombreArchivo
        } else {
            "$nombreArchivo.txt"
        }

        // Método 1: Usar fileList() para verificar
        val archivos = fileList()
        val existeEnLista = archivos.contains(nombreCompleto)

        // Método 2: Usar getFileStreamPath() y verificar con File.exists()
        val file = getFileStreamPath(nombreCompleto)
        val existeConFile = file.exists()

        // Mostrar información
        val mensaje = if (existeEnLista && existeConFile) {
            """
                ✓ El archivo "$nombreCompleto" EXISTE
                
                Ruta completa: ${file.absolutePath}
                Tamaño: ${file.length()} bytes
                Última modificación: ${java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss", java.util.Locale.getDefault())
                    .format(java.util.Date(file.lastModified()))}
            """.trimIndent()
        } else {
            """
                ✗ El archivo "$nombreCompleto" NO EXISTE
                
                Puedes crearlo usando el botón "Crear archivo de prueba"
            """.trimIndent()
        }

        textViewInfo.text = mensaje
    }

    /**
     * Crea un archivo de prueba
     */
    private fun crearArchivoPrueba() {
        val nombreArchivo = editTextNombreArchivo.text.toString().trim()

        if (nombreArchivo.isEmpty()) {
            Toast.makeText(this, "Introduce un nombre de archivo", Toast.LENGTH_SHORT).show()
            return
        }

        val nombreCompleto = if (nombreArchivo.endsWith(".txt")) {
            nombreArchivo
        } else {
            "$nombreArchivo.txt"
        }

        // Verificar si ya existe
        if (archivoExiste(nombreCompleto)) {
            AlertDialog.Builder(this)
                .setTitle("Archivo existente")
                .setMessage("El archivo ya existe. ¿Deseas sobrescribirlo?")
                .setPositiveButton("Sobrescribir") { _, _ ->
                    crearArchivo(nombreCompleto)
                }
                .setNegativeButton("Cancelar", null)
                .show()
        } else {
            crearArchivo(nombreCompleto)
        }
    }

    /**
     * Crea el archivo con contenido de ejemplo
     */
    private fun crearArchivo(nombreCompleto: String) {
        try {
            val contenido = "Este es un archivo de prueba creado el ${java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss", java.util.Locale.getDefault()).format(java.util.Date())}"
            
            val fileOutputStream: FileOutputStream = openFileOutput(nombreCompleto, MODE_PRIVATE)
            fileOutputStream.write(contenido.toByteArray())
            fileOutputStream.close()

            Toast.makeText(this, "Archivo creado: $nombreCompleto", Toast.LENGTH_SHORT).show()
            listarArchivos()
        } catch (e: Exception) {
            Toast.makeText(this, "Error al crear archivo: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Lista todos los archivos guardados
     */
    private fun listarArchivos() {
        listaArchivos.clear()

        // Obtener lista de archivos usando fileList()
        val archivos = fileList()

        archivos.forEach { nombreArchivo ->
            val file = getFileStreamPath(nombreArchivo)
            if (file.exists()) {
                listaArchivos.add(
                    ArchivoInfo(
                        nombre = nombreArchivo,
                        ruta = file.absolutePath,
                        tamaño = file.length(),
                        fechaModificacion = file.lastModified()
                    )
                )
            }
        }

        adapter.notifyDataSetChanged()

        if (listaArchivos.isEmpty()) {
            Toast.makeText(this, "No hay archivos guardados", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Verifica si un archivo existe
     */
    private fun archivoExiste(nombreArchivo: String): Boolean {
        return fileList().contains(nombreArchivo)
    }

    /**
     * Muestra información detallada de un archivo
     */
    private fun mostrarInfoArchivo(archivoInfo: ArchivoInfo) {
        val fecha = java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss", java.util.Locale.getDefault())
            .format(java.util.Date(archivoInfo.fechaModificacion))

        val mensaje = """
            Información del archivo:
            
            Nombre: ${archivoInfo.nombre}
            Ruta: ${archivoInfo.ruta}
            Tamaño: ${archivoInfo.tamaño} bytes
            Última modificación: $fecha
        """.trimIndent()

        textViewInfo.text = mensaje
    }

    /**
     * Clase de datos para información de archivo
     */
    data class ArchivoInfo(
        val nombre: String,
        val ruta: String,
        val tamaño: Long,
        val fechaModificacion: Long
    )

    /**
     * Adapter para el RecyclerView
     */
    class ArchivosAdapter(
        private val archivos: List<ArchivoInfo>,
        private val onItemClick: (ArchivoInfo) -> Unit
    ) : RecyclerView.Adapter<ArchivosAdapter.ArchivoViewHolder>() {

        class ArchivoViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
            val textViewNombre: TextView = itemView.findViewById(R.id.textViewNombre)
            val textViewTamaño: TextView = itemView.findViewById(R.id.textViewTamaño)
            val buttonEliminar: Button = itemView.findViewById(R.id.buttonEliminar)
        }

        override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): ArchivoViewHolder {
            val view = android.view.LayoutInflater.from(parent.context)
                .inflate(R.layout.item_archivo, parent, false)
            return ArchivoViewHolder(view)
        }

        override fun onBindViewHolder(holder: ArchivoViewHolder, position: Int) {
            val archivo = archivos[position]
            holder.textViewNombre.text = archivo.nombre
            holder.textViewTamaño.text = "${archivo.tamaño} bytes"
            
            holder.itemView.setOnClickListener {
                onItemClick(archivo)
            }

            holder.buttonEliminar.setOnClickListener {
                val context = holder.itemView.context
                if (context is MainActivity) {
                    context.eliminarArchivo(archivo.nombre)
                }
            }
        }

        override fun getItemCount() = archivos.size
    }

    /**
     * Elimina un archivo
     */
    fun eliminarArchivo(nombreArchivo: String) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar archivo")
            .setMessage("¿Estás seguro de eliminar '$nombreArchivo'?")
            .setPositiveButton("Eliminar") { _, _ ->
                if (deleteFile(nombreArchivo)) {
                    Toast.makeText(this, "Archivo eliminado", Toast.LENGTH_SHORT).show()
                    listarArchivos()
                } else {
                    Toast.makeText(this, "Error al eliminar el archivo", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}

