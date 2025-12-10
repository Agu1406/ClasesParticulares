package com.example.ejercicio8_modos_archivos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

/**
 * EJERCICIO 8: Sistema interno de ficheros - Guardar archivo (MODE_PRIVATE / MODE_APPEND)
 * 
 * Este ejercicio demuestra el uso de MODE_PRIVATE (sobrescritura)
 * y MODE_APPEND (añadir al final) para guardar archivos.
 * 
 * GUÍA PASO A PASO PARA CREAR ESTE EJERCICIO DESDE CERO:
 * 
 * PASO 1: Crear el proyecto
 * - Crea un nuevo proyecto "Empty Activity" en Android Studio
 * - Nombre: "Ejercicio8ModosArchivos"
 * - Package: com.example.ejercicio8_modos_archivos
 * - Language: Kotlin
 * - Minimum SDK: API 24
 * 
 * PASO 2: Configurar dependencias
 * - Añade:
 *   implementation("androidx.fragment:fragment-ktx:1.6.1")
 *   implementation("androidx.viewpager2:viewpager2:1.0.0")
 * 
 * PASO 3: Crear layouts
 * - activity_main.xml: ViewPager2 con TabLayout
 * - fragment_modo_private.xml: Formulario para guardar archivo nuevo
 * - fragment_modo_append.xml: Formulario para añadir al diario
 * 
 * PASO 4: Crear ViewPagerAdapter
 * - Extender FragmentStateAdapter
 * - Implementar getItemCount() = 2
 * - En createFragment(), retornar ModoPrivateFragment() o ModoAppendFragment()
 * 
 * PASO 5: Implementar MainActivity
 * - Configurar ViewPager2 y TabLayout
 * - Usar TabLayoutMediator para conectar tabs con fragments
 * 
 * PASO 6: Crear ModoPrivateFragment
 * - Extender Fragment
 * - En onCreateView(), inflar fragment_modo_private.xml
 * - Implementar guardarArchivo():
 *   - Validar nombre y contenido
 *   - Abrir: openFileOutput("$nombre.txt", MODE_PRIVATE)
 *   - Escribir y cerrar
 *   - MODE_PRIVATE sobrescribe si existe
 * 
 * PASO 7: Crear ModoAppendFragment
 * - Extender Fragment
 * - Constante: NOMBRE_DIARIO = "diario.txt"
 * - En onCreateView(), inflar fragment_modo_append.xml
 * - En onResume(), llamar a cargarDiario()
 * 
 * PASO 8: Implementar agregarEntrada() en ModoAppendFragment
 * - Validar entrada
 * - Obtener fecha/hora: SimpleDateFormat.format(Date())
 * - Abrir: openFileOutput(NOMBRE_DIARIO, MODE_APPEND)
 * - Escribir: "[fecha] entrada\n"
 * - Cerrar y recargar diario
 * 
 * PASO 9: Implementar cargarDiario() en ModoAppendFragment
 * - Verificar existencia: fileList().contains(NOMBRE_DIARIO)
 * - Si existe, abrir: openFileInput(NOMBRE_DIARIO)
 * - Leer: String(fileInputStream.readBytes())
 * - Mostrar en TextView
 * 
 * PASO 10: Implementar limpiarDiario()
 * - Mostrar AlertDialog de confirmación
 * - Eliminar: deleteFile(NOMBRE_DIARIO)
 * - Crear archivo vacío: openFileOutput(NOMBRE_DIARIO, MODE_PRIVATE)
 * - Escribir "" y cerrar
 * - Recargar diario
 * 
 * PASO 11: Probar la aplicación
 * - Pestaña MODE_PRIVATE: guardar archivos (sobrescribe si existe)
 * - Pestaña MODE_APPEND: añadir entradas al diario
 * - Verificar que MODE_APPEND añade al final
 * - Probar limpiar diario
 * 
 * CONCEPTOS CLAVE:
 * - MODE_PRIVATE: sobrescribe el archivo si ya existe
 * - MODE_APPEND: añade al final del archivo (crea si no existe)
 * - ViewPager2 permite deslizar entre fragments
 * - TabLayout muestra pestañas para navegación
 * - FragmentStateAdapter gestiona fragments en ViewPager2
 * - MODE_APPEND es ideal para logs o diarios
 */
class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupViewPager()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "MODE_PRIVATE"
                1 -> "MODE_APPEND"
                else -> ""
            }
        }.attach()
    }
}

/**
 * Fragment para MODE_PRIVATE (sobrescritura)
 */
class ModoPrivateFragment : androidx.fragment.app.Fragment() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextContenido: EditText
    private lateinit var buttonGuardar: Button

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View {
        return inflater.inflate(R.layout.fragment_modo_private, container, false)
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextNombre = view.findViewById(R.id.editTextNombre)
        editTextContenido = view.findViewById(R.id.editTextContenido)
        buttonGuardar = view.findViewById(R.id.buttonGuardar)

        buttonGuardar.setOnClickListener {
            guardarArchivo()
        }
    }

    private fun guardarArchivo() {
        val nombre = editTextNombre.text.toString().trim()
        val contenido = editTextContenido.text.toString().trim()

        if (nombre.isEmpty()) {
            Toast.makeText(requireContext(), "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show()
            return
        }

        if (contenido.isEmpty()) {
            Toast.makeText(requireContext(), "El contenido no puede estar vacío", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val nombreCompleto = "$nombre.txt"
            val fileOutputStream: FileOutputStream = requireContext().openFileOutput(nombreCompleto, MODE_PRIVATE)
            fileOutputStream.write(contenido.toByteArray())
            fileOutputStream.close()

            Toast.makeText(requireContext(), "Archivo guardado (MODE_PRIVATE - sobrescribe si existe)", Toast.LENGTH_SHORT).show()
            editTextNombre.setText("")
            editTextContenido.setText("")
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}

/**
 * Fragment para MODE_APPEND (añadir al final)
 */
class ModoAppendFragment : androidx.fragment.app.Fragment() {

    private lateinit var editTextEntrada: EditText
    private lateinit var buttonAgregar: Button
    private lateinit var buttonLimpiar: Button
    private lateinit var textViewDiario: TextView

    private val NOMBRE_DIARIO = "diario.txt"

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View {
        return inflater.inflate(R.layout.fragment_modo_append, container, false)
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextEntrada = view.findViewById(R.id.editTextEntrada)
        buttonAgregar = view.findViewById(R.id.buttonAgregar)
        buttonLimpiar = view.findViewById(R.id.buttonLimpiar)
        textViewDiario = view.findViewById(R.id.textViewDiario)

        buttonAgregar.setOnClickListener {
            agregarEntrada()
        }

        buttonLimpiar.setOnClickListener {
            limpiarDiario()
        }

        cargarDiario()
    }

    override fun onResume() {
        super.onResume()
        cargarDiario()
    }

    /**
     * Añade una nueva entrada al diario usando MODE_APPEND
     */
    private fun agregarEntrada() {
        val entrada = editTextEntrada.text.toString().trim()

        if (entrada.isEmpty()) {
            Toast.makeText(requireContext(), "La entrada no puede estar vacía", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            // Obtener fecha y hora actual
            val fechaHora = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
                .format(Date())

            // Añadir al final del archivo usando MODE_APPEND
            val fileOutputStream: FileOutputStream = requireContext().openFileOutput(NOMBRE_DIARIO, MODE_APPEND)
            val entradaCompleta = "\n[$fechaHora] $entrada\n"
            fileOutputStream.write(entradaCompleta.toByteArray())
            fileOutputStream.close()

            Toast.makeText(requireContext(), "Entrada añadida al diario", Toast.LENGTH_SHORT).show()
            editTextEntrada.setText("")
            cargarDiario()
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Carga y muestra el contenido completo del diario
     */
    private fun cargarDiario() {
        try {
            if (requireContext().fileList().contains(NOMBRE_DIARIO)) {
                val fileInputStream: FileInputStream = requireContext().openFileInput(NOMBRE_DIARIO)
                val contenido = String(fileInputStream.readBytes())
                fileInputStream.close()

                if (contenido.trim().isEmpty()) {
                    textViewDiario.text = "El diario está vacío. Añade tu primera entrada."
                } else {
                    textViewDiario.text = contenido
                }
            } else {
                textViewDiario.text = "El diario está vacío. Añade tu primera entrada."
            }
        } catch (e: Exception) {
            textViewDiario.text = "Error al cargar el diario: ${e.message}"
        }
    }

    /**
     * Limpia el diario eliminándolo y creándolo de nuevo vacío
     */
    private fun limpiarDiario() {
        AlertDialog.Builder(requireContext())
            .setTitle("Limpiar diario")
            .setMessage("¿Estás seguro de eliminar todo el contenido del diario?")
            .setPositiveButton("Limpiar") { _, _ ->
                try {
                    // Eliminar el archivo
                    if (requireContext().fileList().contains(NOMBRE_DIARIO)) {
                        requireContext().deleteFile(NOMBRE_DIARIO)
                    }

                    // Crear un archivo nuevo vacío
                    val fileOutputStream: FileOutputStream = requireContext().openFileOutput(NOMBRE_DIARIO, MODE_PRIVATE)
                    fileOutputStream.write("".toByteArray())
                    fileOutputStream.close()

                    Toast.makeText(requireContext(), "Diario limpiado", Toast.LENGTH_SHORT).show()
                    cargarDiario()
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}

/**
 * Adapter para el ViewPager2
 */
class ViewPagerAdapter(fragmentActivity: androidx.fragment.app.FragmentActivity) :
    androidx.fragment.app.FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): androidx.fragment.app.Fragment {
        return when (position) {
            0 -> ModoPrivateFragment()
            1 -> ModoAppendFragment()
            else -> ModoPrivateFragment()
        }
    }
}

