# U04 — Colecciones (Kotlin)

## Array

```kotlin
var arrayEmpty = emptyArray<String>()
var arrayNull = arrayOfNulls<String>(5)
var arrayCosas = arrayOf(1, 2, 3, 4, 5, 6, true)
var arrayNumeros = intArrayOf(1, 2, 3, 4, 5, 6, 7)
```

Recorrido típico de clase:

```kotlin
(0 until numeros.size).forEach {
    numeros[it] = (rangoInicial..rangoFinal).random()
}
numeros.forEach { println(it) }
numeros.find { it == numeroBuscar }
numeros.filter { it == numeroBuscar }.size
```

## listOf y arrayListOf

```kotlin
val fijas = listOf("a", "b")           // inmutable
val mutables = arrayListOf("a", "b")   // mutable (ArrayList)
mutables.add("c")
```

## ArrayList en controladores (estilo CES)

```kotlin
lateinit var people: ArrayList<Person>
init {
    people = arrayListOf()
}
people.add(student)
people.find { it.dni.equals(dni, true) }
people.filter { it is Asalariado }
```

Operaciones que más se usan en prácticas:

| Método   | Uso típico                          |
|----------|-------------------------------------|
| `add`    | registrar en la lista               |
| `forEach`| listar / mostrarDatos               |
| `find`   | buscar por dni / id                 |
| `filter` | listar solo un tipo                 |
| `remove` | despedir / borrar                   |

La práctica de alumnos trabaja menú + `ArrayList` + búsqueda por id.
