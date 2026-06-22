# Recuperación ordinaria — Programación (DAM/DAW)

Examen completo de recuperación. Nota máxima por bloque: **5 puntos**.

| Ej. | Tema | RA | Módulo |
|-----|------|-----|--------|
| 1 | Auditorio y Conservatorio Musical | RA1, RA2, RA3, RA4, RA7 | `java` |
| 2 | Gestor de Presupuestos de Hardware | RA1, RA2, RA3, RA4, RA7 | `java` |
| 3 | Archivo Digital de Agencia de Detectives | RA1, RA2, RA3, RAS | `javafx` |
| 4 | Sistema de Análisis de Rachas y Puntuaciones | RA1, RA2, RA3, RA6 | `java` |
| 5 | Validación de Matrículas y Gestión de Flotas | RA1, RA2, RA3, RA6 | `java` |

**PDF del centro:** colocar en esta carpeta como `recuperacion-ordinaria.pdf` (cuando lo tengas en imagen/PDF).

---

## 1. Auditorio y Conservatorio Musical (RA1–RA4, RA7 · máx. 5)

Un conservatorio organiza recitales de fin de curso. En el escenario suben distintos intérpretes y el sistema debe saber cómo presentarlos.

### Apartado A (1,5 pts)

- Clase abstracta `Interprete`: atributo `nombreEstudiante` (String), método abstracto `interpretar(String titulo)`, método implementado `void saludar()`.
- Interfaz `Instrumentista`: método `void afinarInstrumento()`.
- Interfaz `Vocalista`: método `void calentarVoz()`.

### Apartado B (2,0 pts)

1. **Pianista**: hereda de `Interprete`, implementa `Instrumentista`. Mensajes por consola (ej. «Afinando piano…», «Tocando la partitura…»).
2. **Cantante**: hereda de `Interprete`, implementa `Vocalista`. Mensajes por consola (ej. «Haciendo escalas graves…», «Cantando el aria…»).

### Apartado C (1,5 pts)

En la clase principal, simula un concierto con una colección de `Interprete` (dos pianistas y dos cantantes).

Método que reciba la lista y use polimorfismo:

- A los `Instrumentista`, `afinarInstrumento()`.
- A los `Vocalista`, `calentarVoz()`.
- Todos, `saludar()`.

---

## 2. Gestor de Presupuestos de Hardware (RA1–RA4, RA7 · máx. 5)

Tienda de informática: calcular TDP y rendimiento de PCs de gama alta.

### Apartado A (1,5 pts)

- Clase abstracta `Componente`: `modelo` (String) y `tdpMaximo` (int, vatios), protegidos. Constructor y método abstracto `double calcularPuntuacionRendimiento()`.

### Apartado B (2,0 pts)

1. **Procesador**: `numeroNucleos` (int), `frecuenciaGhz` (double). Rendimiento = `numeroNucleos * frecuenciaGhz * 100`.
2. **TarjetaGrafica**: `vramGB` (int), `tensorCores` (int). Rendimiento = `(vramGB * 50) + (tensorCores * 2)`.

### Apartado C (1,5 pts)

- Clase **Ordenador** con colección de `Componente`.
- `int calcularConsumoTotal()`: suma de `tdpMaximo`.
- `void mostrarInforme()`: recorre la lista mostrando modelo y puntuación de cada componente (polimorfismo).

---

## 3. Archivo Digital de Agencia de Detectives (RA1–RA3, RAS · máx. 5)

**Implementación en `javafx/src/recuperacionordinaria/…`**

Clase `CasoDetective`: `codigoCaso`, `nombreSospechoso`, `estaResuelto` (boolean), constructor, getters y setters. `Serializable`.

### Apartado A (1,5 pts — GUI)

- TextField «Código del Caso».
- TextField «Nombre del Sospechoso».
- ComboBox: «Caso Cerrado» / «Caso Resuelto».
- Botones: «Archivar Expediente» y «Cargar Último Expediente».

### Apartado B (2,0 pts — Serialización)

Al pulsar **Archivar**: leer campos, instanciar `CasoDetective`, guardar en `archivo_secreto.dat` junto a los demás casos.

### Apartado C (1,5 pts — Deserialización)

Al pulsar **Cargar Último**: recuperar el **último** caso del fichero y actualizar TextFields y ComboBox.

---

## 4. Sistema de Análisis de Rachas y Puntuaciones (RA1–RA3, RA6 · máx. 5)

`Map<String, List<Integer>>`: clave = equipo, valor = puntos por partida (orden cronológico). Negativo = penalización.

### Apartado A (1,5 pts)

Devuelve `Set<String>` con equipos **invictos**: ≥ 3 partidas y ninguna puntuación ≤ 0.

### Apartado B (2,5 pts)

Dada una `List<Integer>`, calcula la **Mejor Racha**: suma de la secuencia **más larga** de partidas consecutivas con puntuación **estrictamente positiva**. Si no hay ninguna, 0.

> Ejemplo del enunciado: `[10, -5, 20, 15, -2, 30]` → racha `[20, 15]` → suma **35**.

### Apartado C (1,0 pt)

`Map<String, Integer>`: nombre del equipo → su Mejor Racha (usando el método del apartado B).

Se entrega la clase `Torneo` para pruebas.

---

## 5. Validación de Matrículas y Gestión de Flotas (RA1–RA3, RA6 · máx. 5)

`List<String>` con matrículas duplicadas y formatos inválidos.

### Apartado A (1,0 pt)

Eliminar duplicados. Devolver colección sin repetidos.

### Apartado B (2,5 pts)

`boolean esMatriculaValida(String matricula)`:

1. Exactamente 7 caracteres.
2. Cuatro primeros: dígitos `0`–`9`.
3. Tres últimos: letras mayúsculas.

### Apartado C (1,5 pts)

`Map<Character, List<String>>`: solo matrículas válidas, clave = última letra, valor = lista de matrículas que terminan en esa letra.

Se entrega la clase `Coches` para pruebas.
