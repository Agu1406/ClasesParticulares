# Examen / Prácticas — Fundamentos de Informática (Tema 5)

**Universidad Miguel Hernández — Campus de Elche**  
**Grado en Ingeniería Mecánica**  
**Curso 2025-26 · Lenguaje de programación Python**

Material combinado a partir de:

- Práctica 2 — Entrada y Salida (teclado, pantalla y ficheros)
- Práctica 3 — Tipos de Datos Compuestos (listas, tuplas, conjuntos y diccionarios)
- Problemas de examen (algoritmo + código)

PDFs originales en esta carpeta:

- `elche-umh-t5-p2-entrada-salida.pdf`
- `elche-umh-t5-p3-datos-compuestos.pdf`

## Normas generales

1. En todos los ejercicios incluye el **algoritmo** lo más detallado posible (además del código).
2. Solo se pueden utilizar las estructuras, tipos de datos e instrucciones vistas durante el curso.
3. **No** se pueden utilizar librerías externas.
4. **No** se pueden utilizar las instrucciones `break` y `continue`.

---

## Bloque A — Entrada y salida (Práctica 2)

### A1. Datos alineados

Pide por teclado tres números reales. Muestra una tabla con tres filas:

- Fila 1: valores originales
- Fila 2: cuadrados
- Fila 3: cubos

Cada fila empieza con una etiqueta alineada a la izquierda en **10** caracteres. Los tres valores van con **2** decimales, ocupando **10** caracteres cada uno, **centrados**, entre barras `|`.

### A2. Datos ponderados

Solicita:

1. Nombre, primer apellido y segundo apellido
2. Tres notas parciales (0–10)
3. Nota del examen final
4. Nota del trabajo final

Nota final:

- 55% del promedio de las tres parciales
- 30% del examen final
- 15% del trabajo final

Muestra **una sola línea** con las iniciales del nombre completo en mayúsculas, y `True` si la nota total es **> 5.0**, o `False` en caso contrario.

### A3. Escritura en ficheros

Pide tres frases por teclado. Guárdalas en `frases.txt`, una por línea (añade `\n`). Cierra el fichero correctamente.

### A4. Lectura de ficheros

Abre `frases.txt`, lee todo el contenido y muestra cuántos caracteres tiene en total (incluye espacios y saltos de línea). ¿Se han contabilizado los `\n`?

Después, lee las tres frases e imprímelas en tres líneas consecutivas. Si aparece una línea vacía entre ellas, explica por qué y corrígelo.

### A5. Marco de texto

Abre `linea.txt` (una frase) y genera `marco.txt` con un marco de asteriscos adaptado a `len(frase)`. Usa `strip()` para no incluir el salto de línea dentro del marco.

### A6. Adicional — Ecuación de segundo grado

Pide coeficientes `A`, `B` y `C` de `A·x² + B·x + C = 0` y muestra las dos soluciones (suponiendo que existen). Puedes usar `** 0.5` para la raíz.

---

## Bloque B — Datos compuestos (Práctica 3)

### B1. Pruebas básicas con listas

`lista1 = [5, 8, 10]` y `lista2 = [3, 2, 9, 12, 4]`. Realiza las operaciones del enunciado PDF (longitud, concatenación, máximos, primer/último elemento, modificación, alias `lista3 = lista2`, `append`, `insert`, `remove`, `pop`, `index`, `count`, sublista de posiciones pares, copia con `list(lista1)`).

### B2. Listas y conjuntos

Partiendo de `valores = [4, 6, 2, 4, 9, 6, 2, 1, 10, 2, 6, 8]`, obtén `sin_repetir` ordenada vía conjunto.

Con `conjunto1 = {1,2,3,4,5,6}` y `conjunto2 = {4,5,6,7,8,9}` calcula intersección, diferencia simétrica y solo en `conjunto1`.

Pide 3 números, forma un conjunto nuevo y comprueba inclusión respecto a `conjunto1` / `conjunto2` (todos en alguno, alguno en alguno, alguno en conjunto1, ninguno en ninguno).

### B3. Diccionarios

Pide tres países y sus capitales; guarda `pais -> capital`. Muestra el diccionario, las claves, los valores y la lista de tuplas `(pais, capital)`. Con `.get()` consulta un país; si no existe, muestra `País no encontrado`.

### B4. Fichero a listas

Crea `datos.txt` con líneas `Nombre,Edad,Ciudad,Estudios,Hobby` (ej. Ana, Luis, Carmen, Pedro, Lucía). Luego:

1. `contenido = read()` y muéstralo
2. `personas = split("\n")` (filtra vacíos si hace falta)
3. `lista_personas = [p.split(",") for p in personas]`
4. Nombre de la primera, ciudad de la última, hobby de la tercera
5. Listas de nombres y de estudios
6. Nombres con edad `> 20` con comprensión + `if`

---

## Bloque C — Problemas de examen

### C1. Palabras comunes [1,5]

Pide varias frases por teclado (termina con frase vacía). Obtén las palabras que se repiten en **todas** las frases.

### C2. Collatz [1,5]

Serie de Collatz: si `n` es par → `n/2`; si es impar → `3*n+1`. Termina en 1.

Ejemplo desde 6: `6, 3, 10, 5, 16, 8, 4, 2, 1`

Implementa `collatz(n)` que **devuelva una lista** con la secuencia hasta 1. (Sin `break`/`continue`.)

### C3. Conteo de letras [1,5]

Lee una frase y genera un diccionario `palabras` (o mejor `letras`) con las veces que aparece **cada letra**.

### C4. Ventas máximas [1,5]

El fichero `ventas.txt` tiene líneas `codigo,precio_unitario,unidades`. Puede haber varias líneas del mismo código. Calcula qué artículo ha generado **mayores ingresos** (precio × unidades acumulado).

---

## Correspondencia con plantillas

Plantillas en `sin_resolver/` (`*_SinResolver.py`) y `resuelto/` (`*_Resuelto.py`):

| Código | Archivo |
|--------|---------|
| A1 | `E01_DatosAlineados` |
| A2 | `E02_DatosPonderados` |
| A3 | `E03_EscribirFrases` |
| A4 | `E04_LeerFrases` |
| A5 | `E05_MarcoTexto` |
| A6 | `E06_EcuacionSegundoGrado` |
| B1 | `E07_PruebasListas` |
| B2 | `E08_ListasYConjuntos` |
| B3 | `E09_DiccionariosPaises` |
| B4 | `E10_FicheroPersonas` |
| C1 | `E11_PalabrasComunes` |
| C2 | `E12_Collatz` |
| C3 | `E13_ConteoLetras` |
| C4 | `E14_VentasMaximo` |
