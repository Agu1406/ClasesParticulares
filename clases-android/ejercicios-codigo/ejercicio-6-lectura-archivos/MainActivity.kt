package com.example.ejercicio6_lectura_archivos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.Scanner

/**
 * EJERCICIO 6: Sistema interno de ficheros - Lectura de archivo txt
 * 
 * Este ejercicio demuestra diferentes métodos de lectura de archivos
 * desde el almacenamiento interno.
 * 
 * GUÍA PASO A PASO PARA CREAR ESTE EJERCICIO DESDE CERO:
 * 
 * PASO 1: Crear el proyecto
 * - Crea un nuevo proyecto "Empty Activity" en Android Studio
 * - Nombre: "Ejercicio6LecturaArchivos"
 * - Package: com.example.ejercicio6_lectura_archivos
 * - Language: Kotlin
 * - Minimum SDK: API 24
 * 
 * PASO 2: Crear layout activity_main.xml
 * - LinearLayout vertical con padding
 * - Botón "Crear archivo de ejemplo"
 * - TextView para información del archivo
 * - Tres botones: "Leer con BufferedReader", "Leer con InputStream", "Leer con Scanner"
 * - ScrollView con TextView para mostrar resultados
 * 
 * PASO 3: Implementar MainActivity
 * - Declarar constantes: NOMBRE_ARCHIVO = "archivo_ejemplo.txt"
 * - Declarar referencias a componentes UI
 * 
 * PASO 4: Implementar crearArchivoEjemplo()
 * - Crear String con contenido multilínea (varias líneas de texto)
 * - Abrir archivo: openFileOutput(NOMBRE_ARCHIVO, MODE_PRIVATE)
 * - Escribir: fileOutputStream.write(contenido.toByteArray())
 * - Cerrar: fileOutputStream.close()
 * - Llamar a actualizarInfoArchivo()
 * 
 * PASO 5: Implementar leerConBufferedReader()
 * - Verificar que archivo existe: archivoExiste()
 * - Medir tiempo: val inicio = System.currentTimeMillis()
 * - Abrir: openFileInput(NOMBRE_ARCHIVO)
 * - Leer línea por línea:
 *   fileInputStream.bufferedReader().use { reader ->
 *     val lineas = mutableListOf<String>()
 *     reader.forEachLine { lineas.add(it) }
 *     lineas.joinToString("\n")
 *   }
 * - Calcular tiempo y llamar a mostrarResultado()
 * 
 * PASO 6: Implementar leerConInputStream()
 * - Verificar existencia
 * - Medir tiempo
 * - Abrir: openFileInput(NOMBRE_ARCHIVO)
 * - Leer todo: String(fileInputStream.readBytes())
 * - Cerrar y mostrar resultado
 * 
 * PASO 7: Implementar leerConScanner()
 * - Verificar existencia
 * - Medir tiempo
 * - Abrir: openFileInput(NOMBRE_ARCHIVO)
 * - Leer con Scanner:
 *   Scanner(fileInputStream).use { scanner ->
 *     val lineas = mutableListOf<String>()
 *     while (scanner.hasNextLine()) {
 *       lineas.add(scanner.nextLine())
 *     }
 *     lineas.joinToString("\n")
 *   }
 * - Cerrar y mostrar resultado
 * 
 * PASO 8: Implementar archivoExiste()
 * - Retornar: fileList().contains(NOMBRE_ARCHIVO)
 * 
 * PASO 9: Implementar actualizarInfoArchivo()
 * - Si archivo existe, obtener File: getFileStreamPath(NOMBRE_ARCHIVO)
 * - Obtener tamaño: file.length()
 * - Obtener fecha: SimpleDateFormat.format(Date(file.lastModified()))
 * - Mostrar información en TextView
 * 
 * PASO 10: Implementar mostrarResultado()
 * - Construir String con método usado, tiempo y contenido
 * - Mostrar en TextView
 * - Llamar a actualizarInfoArchivo()
 * 
 * PASO 11: Probar la aplicación
 * - Crear archivo de ejemplo
 * - Probar cada método de lectura
 * - Comparar tiempos de ejecución
 * - Verificar que todos leen el mismo contenido
 * 
 * CONCEPTOS CLAVE:
 * - BufferedReader es eficiente para archivos grandes (lee línea por línea)
 * - InputStream.readBytes() lee todo el contenido de una vez (simple pero usa más memoria)
 * - Scanner es útil para parsing de datos estructurados
 * - use{} cierra automáticamente los recursos (try-with-resources en Kotlin)
 * - Medir tiempo ayuda a comparar eficiencia de métodos
 * - getFileStreamPath() obtiene la ruta completa del archivo
 */
class MainActivity : AppCompatActivity() {

    private lateinit var buttonCrearArchivo: Button
    private lateinit var buttonLeerBufferedReader: Button
    private lateinit var buttonLeerInputStream: Button
    private lateinit var buttonLeerScanner: Button
    private lateinit var textViewResultado: TextView
    private lateinit var textViewInfo: TextView

    private val NOMBRE_ARCHIVO = "archivo_ejemplo.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupListeners()
    }

    private fun initViews() {
        buttonCrearArchivo = findViewById(R.id.buttonCrearArchivo)
        buttonLeerBufferedReader = findViewById(R.id.buttonLeerBufferedReader)
        buttonLeerInputStream = findViewById(R.id.buttonLeerInputStream)
        buttonLeerScanner = findViewById(R.id.buttonLeerScanner)
        textViewResultado = findViewById(R.id.textViewResultado)
        textViewInfo = findViewById(R.id.textViewInfo)
    }

    private fun setupListeners() {
        buttonCrearArchivo.setOnClickListener { crearArchivoEjemplo() }
        buttonLeerBufferedReader.setOnClickListener { leerConBufferedReader() }
        buttonLeerInputStream.setOnClickListener { leerConInputStream() }
        buttonLeerScanner.setOnClickListener { leerConScanner() }
    }

    /**
     * Crea un archivo de ejemplo con varias líneas de contenido
     */
    private fun crearArchivoEjemplo() {
        try {
            val contenido = """
                Línea 1: Este es un archivo de ejemplo
                Línea 2: Contiene múltiples líneas de texto
                Línea 3: Para demostrar diferentes métodos de lectura
                Línea 4: Cada método tiene sus ventajas y desventajas
                Línea 5: BufferedReader es eficiente para archivos grandes
                Línea 6: InputStream.readBytes() lee todo de una vez
                Línea 7: Scanner es útil para parsing de datos estructurados
            """.trimIndent()

            val fileOutputStream = openFileOutput(NOMBRE_ARCHIVO, MODE_PRIVATE)
            fileOutputStream.write(contenido.toByteArray())
            fileOutputStream.close()

            Toast.makeText(this, "Archivo creado correctamente", Toast.LENGTH_SHORT).show()
            actualizarInfoArchivo()
        } catch (e: Exception) {
            Toast.makeText(this, "Error al crear archivo: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Método 1: Leer usando BufferedReader (línea por línea)
     */
    private fun leerConBufferedReader() {
        try {
            if (!archivoExiste()) {
                Toast.makeText(this, "Primero crea el archivo de ejemplo", Toast.LENGTH_SHORT).show()
                return
            }

            val inicio = System.currentTimeMillis()

            val fileInputStream: FileInputStream = openFileInput(NOMBRE_ARCHIVO)
            val contenido = fileInputStream.bufferedReader().use { reader ->
                val lineas = mutableListOf<String>()
                reader.forEachLine { lineas.add(it) }
                lineas.joinToString("\n")
            }
            fileInputStream.close()

            val tiempo = System.currentTimeMillis() - inicio

            mostrarResultado("Método: BufferedReader (línea por línea)", contenido, tiempo)
        } catch (e: Exception) {
            mostrarError("Error al leer con BufferedReader: ${e.message}")
        }
    }

    /**
     * Método 2: Leer usando InputStream.readBytes() (todo de una vez)
     */
    private fun leerConInputStream() {
        try {
            if (!archivoExiste()) {
                Toast.makeText(this, "Primero crea el archivo de ejemplo", Toast.LENGTH_SHORT).show()
                return
            }

            val inicio = System.currentTimeMillis()

            val fileInputStream: FileInputStream = openFileInput(NOMBRE_ARCHIVO)
            val contenido = String(fileInputStream.readBytes())
            fileInputStream.close()

            val tiempo = System.currentTimeMillis() - inicio

            mostrarResultado("Método: InputStream.readBytes()", contenido, tiempo)
        } catch (e: Exception) {
            mostrarError("Error al leer con InputStream: ${e.message}")
        }
    }

    /**
     * Método 3: Leer usando Scanner (línea por línea)
     */
    private fun leerConScanner() {
        try {
            if (!archivoExiste()) {
                Toast.makeText(this, "Primero crea el archivo de ejemplo", Toast.LENGTH_SHORT).show()
                return
            }

            val inicio = System.currentTimeMillis()

            val fileInputStream: FileInputStream = openFileInput(NOMBRE_ARCHIVO)
            val contenido = Scanner(fileInputStream).use { scanner ->
                val lineas = mutableListOf<String>()
                while (scanner.hasNextLine()) {
                    lineas.add(scanner.nextLine())
                }
                lineas.joinToString("\n")
            }
            fileInputStream.close()

            val tiempo = System.currentTimeMillis() - inicio

            mostrarResultado("Método: Scanner", contenido, tiempo)
        } catch (e: Exception) {
            mostrarError("Error al leer con Scanner: ${e.message}")
        }
    }

    /**
     * Verifica si el archivo existe
     */
    private fun archivoExiste(): Boolean {
        return fileList().contains(NOMBRE_ARCHIVO)
    }

    /**
     * Actualiza la información del archivo
     */
    private fun actualizarInfoArchivo() {
        if (archivoExiste()) {
            try {
                val file = getFileStreamPath(NOMBRE_ARCHIVO)
                val tamaño = file.length()
                val fechaModificacion = java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss", java.util.Locale.getDefault())
                    .format(java.util.Date(file.lastModified()))

                textViewInfo.text = """
                    Información del archivo:
                    - Nombre: $NOMBRE_ARCHIVO
                    - Tamaño: $tamaño bytes
                    - Última modificación: $fechaModificacion
                """.trimIndent()
            } catch (e: Exception) {
                textViewInfo.text = "Error al obtener información del archivo"
            }
        } else {
            textViewInfo.text = "No hay archivo creado"
        }
    }

    /**
     * Muestra el resultado de la lectura
     */
    private fun mostrarResultado(metodo: String, contenido: String, tiempo: Long) {
        val resultado = """
            $metodo
            Tiempo de lectura: ${tiempo}ms
            
            Contenido:
            $contenido
        """.trimIndent()

        textViewResultado.text = resultado
        actualizarInfoArchivo()
    }

    /**
     * Muestra un error
     */
    private fun mostrarError(mensaje: String) {
        textViewResultado.text = mensaje
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}

