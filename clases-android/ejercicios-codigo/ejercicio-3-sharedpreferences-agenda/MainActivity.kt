package com.example.ejercicio3_sharedpreferences_agenda

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * EJERCICIO 3: SharedPreferences - Agenda de contactos
 * 
 * Este ejercicio demuestra cómo usar SharedPreferences con StringSet
 * para almacenar una lista limitada de contactos.
 * 
 * NOTA: Este es un ejemplo didáctico. En producción, se recomienda
 * usar SQLite o Room para gestionar listas de contactos.
 * 
 * GUÍA PASO A PASO PARA CREAR ESTE EJERCICIO DESDE CERO:
 * 
 * PASO 1: Crear el proyecto
 * - Crea un nuevo proyecto "Empty Activity" en Android Studio
 * - Nombre: "Ejercicio3SharedPreferencesAgenda"
 * - Package: com.example.ejercicio3_sharedpreferences_agenda
 * - Language: Kotlin
 * - Minimum SDK: API 24
 * 
 * PASO 2: Configurar dependencias (build.gradle.kts - app)
 * - Añade:
 *   implementation("androidx.recyclerview:recyclerview:1.3.1")
 *   implementation("androidx.cardview:cardview:1.0.0")
 *   implementation("com.google.android.material:material:1.9.0")
 * 
 * PASO 3: Crear layouts
 * - activity_main.xml: CoordinatorLayout con RecyclerView y FAB
 * - item_contacto.xml: CardView con nombre, teléfono y botón eliminar
 * - dialog_agregar_contacto.xml: Dialog con EditTexts para nombre y teléfono
 * 
 * PASO 4: Crear data class Contacto
 * - data class Contacto(val nombre: String, val telefono: String)
 * 
 * PASO 5: Implementar MainActivity
 * - Declarar constantes: PREFS_NAME, KEY_CONTACTOS, MAX_CONTACTOS = 10
 * - Declarar SharedPreferences, RecyclerView, Adapter, listaContactos
 * 
 * PASO 6: Implementar cargarContactos()
 * - Obtener StringSet: getStringSet(KEY_CONTACTOS, emptySet())
 * - Para cada elemento del Set, parsear formato "nombre|telefono"
 * - Crear objetos Contacto y añadirlos a listaContactos
 * - Llamar a actualizarUI()
 * 
 * PASO 7: Implementar guardarContactos()
 * - Convertir listaContactos a Set<String> con formato "nombre|telefono"
 * - Usar editor.putStringSet(KEY_CONTACTOS, contactosSet)
 * - Aplicar cambios con apply()
 * 
 * PASO 8: Implementar mostrarDialogoAgregarContacto()
 * - Verificar límite MAX_CONTACTOS
 * - Crear AlertDialog con dialog_agregar_contacto.xml
 * - En botón positivo, validar y llamar a agregarContacto()
 * 
 * PASO 9: Implementar validarContacto()
 * - Validar nombre no vacío
 * - Validar teléfono no vacío
 * - Validar teléfono solo números (usar Regex)
 * - Retornar true si es válido
 * 
 * PASO 10: Implementar agregarContacto()
 * - Añadir Contacto a listaContactos
 * - Llamar a guardarContactos()
 * - Llamar a actualizarUI()
 * - Mostrar Toast de confirmación
 * 
 * PASO 11: Implementar eliminarContacto()
 * - Mostrar AlertDialog de confirmación
 * - Si confirma, remover de listaContactos
 * - Llamar a guardarContactos() y actualizarUI()
 * 
 * PASO 12: Crear ContactosAdapter
 * - Extender RecyclerView.Adapter<ContactoViewHolder>
 * - Implementar onCreateViewHolder(), onBindViewHolder(), getItemCount()
 * - En onBindViewHolder, configurar botón eliminar con callback
 * 
 * PASO 13: Probar la aplicación
 * - Agregar contactos y verificar que se guardan
 * - Cerrar y abrir la app, verificar persistencia
 * - Eliminar contactos y verificar actualización
 * - Intentar agregar más de 10 contactos
 * 
 * CONCEPTOS CLAVE:
 * - StringSet permite guardar conjuntos de strings en SharedPreferences
 * - Formato de serialización: "nombre|telefono" para estructurar datos
 * - putStringSet() y getStringSet() para trabajar con conjuntos
 * - RecyclerView requiere Adapter y ViewHolder para mostrar listas
 * - SharedPreferences NO es ideal para listas grandes o complejas
 */
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewContactos: RecyclerView
    private lateinit var fabAgregar: FloatingActionButton
    private lateinit var textViewContador: TextView

    private val PREFS_NAME = "agenda_preferences"
    private val KEY_CONTACTOS = "lista_contactos"
    private val MAX_CONTACTOS = 10

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var adapter: ContactosAdapter
    private val listaContactos = mutableListOf<Contacto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        initViews()
        cargarContactos()
        setupRecyclerView()
    }

    private fun initViews() {
        recyclerViewContactos = findViewById(R.id.recyclerViewContactos)
        fabAgregar = findViewById(R.id.fabAgregar)
        textViewContador = findViewById(R.id.textViewContador)

        fabAgregar.setOnClickListener {
            mostrarDialogoAgregarContacto()
        }
    }

    private fun setupRecyclerView() {
        adapter = ContactosAdapter(listaContactos) { contacto ->
            eliminarContacto(contacto)
        }
        recyclerViewContactos.layoutManager = LinearLayoutManager(this)
        recyclerViewContactos.adapter = adapter
    }

    /**
     * Carga los contactos desde SharedPreferences
     */
    private fun cargarContactos() {
        listaContactos.clear()
        
        // Obtener el StringSet de contactos
        val contactosSet = sharedPreferences.getStringSet(KEY_CONTACTOS, emptySet())
        
        // Parsear cada contacto (formato: "nombre|telefono")
        contactosSet?.forEach { contactoString ->
            val partes = contactoString.split("|")
            if (partes.size == 2) {
                listaContactos.add(Contacto(partes[0], partes[1]))
            }
        }
        
        actualizarUI()
    }

    /**
     * Guarda los contactos en SharedPreferences
     */
    private fun guardarContactos() {
        val contactosSet = listaContactos.map { "${it.nombre}|${it.telefono}" }.toSet()
        
        val editor = sharedPreferences.edit()
        editor.putStringSet(KEY_CONTACTOS, contactosSet)
        editor.apply()
    }

    /**
     * Muestra el diálogo para agregar un nuevo contacto
     */
    private fun mostrarDialogoAgregarContacto() {
        // Verificar límite de contactos
        if (listaContactos.size >= MAX_CONTACTOS) {
            Toast.makeText(this, "Se ha alcanzado el límite de $MAX_CONTACTOS contactos", Toast.LENGTH_SHORT).show()
            return
        }

        val dialogView = layoutInflater.inflate(R.layout.dialog_agregar_contacto, null)
        val editTextNombre = dialogView.findViewById<EditText>(R.id.editTextNombre)
        val editTextTelefono = dialogView.findViewById<EditText>(R.id.editTextTelefono)

        AlertDialog.Builder(this)
            .setTitle("Agregar contacto")
            .setView(dialogView)
            .setPositiveButton("Guardar") { _, _ ->
                val nombre = editTextNombre.text.toString().trim()
                val telefono = editTextTelefono.text.toString().trim()

                if (validarContacto(nombre, telefono)) {
                    agregarContacto(nombre, telefono)
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    /**
     * Valida los datos del contacto
     */
    private fun validarContacto(nombre: String, telefono: String): Boolean {
        if (nombre.isEmpty()) {
            Toast.makeText(this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show()
            return false
        }

        if (telefono.isEmpty()) {
            Toast.makeText(this, "El teléfono no puede estar vacío", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validar que el teléfono contenga solo números
        if (!telefono.matches(Regex("^[0-9]+$"))) {
            Toast.makeText(this, "El teléfono solo puede contener números", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    /**
     * Agrega un nuevo contacto a la lista
     */
    private fun agregarContacto(nombre: String, telefono: String) {
        listaContactos.add(Contacto(nombre, telefono))
        guardarContactos()
        actualizarUI()
        Toast.makeText(this, "Contacto agregado correctamente", Toast.LENGTH_SHORT).show()
    }

    /**
     * Elimina un contacto de la lista
     */
    private fun eliminarContacto(contacto: Contacto) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar contacto")
            .setMessage("¿Estás seguro de eliminar a ${contacto.nombre}?")
            .setPositiveButton("Eliminar") { _, _ ->
                listaContactos.remove(contacto)
                guardarContactos()
                actualizarUI()
                Toast.makeText(this, "Contacto eliminado", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    /**
     * Actualiza la UI después de cambios
     */
    private fun actualizarUI() {
        adapter.notifyDataSetChanged()
        textViewContador.text = "Contactos: ${listaContactos.size}/$MAX_CONTACTOS"
    }

    /**
     * Clase de datos para representar un contacto
     */
    data class Contacto(
        val nombre: String,
        val telefono: String
    )

    /**
     * Adapter para el RecyclerView
     */
    class ContactosAdapter(
        private val contactos: List<Contacto>,
        private val onEliminarClick: (Contacto) -> Unit
    ) : RecyclerView.Adapter<ContactosAdapter.ContactoViewHolder>() {

        class ContactoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textViewNombre: TextView = itemView.findViewById(R.id.textViewNombre)
            val textViewTelefono: TextView = itemView.findViewById(R.id.textViewTelefono)
            val buttonEliminar: Button = itemView.findViewById(R.id.buttonEliminar)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_contacto, parent, false)
            return ContactoViewHolder(view)
        }

        override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
            val contacto = contactos[position]
            holder.textViewNombre.text = contacto.nombre
            holder.textViewTelefono.text = contacto.telefono
            holder.buttonEliminar.setOnClickListener {
                onEliminarClick(contacto)
            }
        }

        override fun getItemCount() = contactos.size
    }
}

