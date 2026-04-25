# Pruebas libres (Programación)

Material para preparar el examen tipo test de **pruebas libres**: PDFs oficiales, test interactivo en HTML y ejercicios de práctica en Java.

## PDFs

En esta carpeta:

| Archivo | Uso |
|--------|-----|
| `Pruebas_libres_2021.pdf` … `Pruebas_libres_2025.pdf` | Enunciados originales del examen teórico |
| `programacion_prueba_libre_23.pdf`, `programacion_prueba_libre_24.pdf`, `programacion_prueba_libre_25.pdf` | PDFs recientes usados para la ruta de preparación "real 23-24-25" |

## Auditoría de claves (respuestas correctas)

- Revisión manual + comprobación lógica/Java sobre los ítems con código y afirmaciones típicas de examen.
- **Corrección aplicada:** en el examen **2021**, pregunta **35** (métodos `static` y referencias): la salida correcta es **`fa la`**, no `fa fa` (el enlace es por el **tipo declarado** de la referencia `Cantante s`, no por el objeto `Tenor`).
- **2022–2023:** 40 preguntas cada uno; 2023 corrige polimorfismo (Q6) y bucles anidados (Q11) frente a versiones anteriores del generador.
- **2025:** Q17–Q18 alineadas con salida real del JDK; Q19 reformulada para una única opción válida sobre sobrecarga.
- **2024** provisional = copia de 2023 hasta transcribir el PDF.

## Test interactivo (teoría)

1. Abre en el navegador: `teoria/index.html` (doble clic o “Open with Live Server”).
2. Elige el año en el desplegable y pulsa **Cargar examen**.
3. Responde y usa **Corregir test** para ver el resultado global.

### Ruta real 23-24-25 (nuevo)

- En el selector aparece el grupo **"Ruta real 23-24-25 (nueva)"**.
- Incluye:
  - `rutaReal2023`, `rutaReal2024`, `rutaReal2025` (bases por año)
  - `rutaRealSimulacroA/B/C` (simulacros mixtos de 40 preguntas)
  - `rutaRealRA1..RA9` (bloques cortos por RA aproximado para entrenar por secciones)
- Archivo generador: `teoria/data/rutaReal232425.js`.
- Esta ruta se integra con las recomendaciones automáticas de práctica del test.

### Plan de 12 dias (nuevo)

- En el selector del test ahora aparece el grupo **"Plan de 12 dias (mixto 2021-2025)"**.
- Cada dia carga un test de **20 preguntas** generado desde los bancos oficiales (`programacion2021..2025`).
- Archivo generador: `teoria/data/plan12dias.js`.
- Las explicaciones incluyen el origen de cada pregunta (`[Origen: programacion20XX]`) para poder volver al examen base.
- Nota: para dias con menos preguntas historicas especificas (por ejemplo ORM/Hibernate o JavaFX), el generador rellena con preguntas oficiales generales para mantener las 20.

### Plan de 12 dias B (progresivo)

- Disponible en el selector como **"Plan de 12 dias B (progresivo y no repeticion)"**.
- Objetivo: minimizar repeticiones entre dias y subir dificultad gradualmente:
  - Dias 1-2: facil
  - Dias 3-6: media
  - Dias 7-12: alta
- Para evitar dias incompletos, si faltan preguntas de un tema se rellena con otras oficiales del mismo nivel aproximado.
- Cada explicacion lleva prefijo de dificultad aproximada y origen, por ejemplo:
  - `[Dificultad aprox: media] ... [Origen: programacion2023]`

### Estado de los bancos de preguntas

| Año | Archivo de datos | Estado |
|-----|------------------|--------|
| 2021 | `teoria/data/programacion2021.js` | **40 preguntas** (completo) |
| 2022 | `teoria/data/programacion2022.js` | **40 preguntas** (generado con `data/_emitExamenes.cjs`) |
| 2023 | `teoria/data/programacion2023.js` | **40 preguntas** (mismo generador, variante 2023) |
| 2024 | `teoria/data/programacion2024.js` | **Provisional**: mismo banco que 2023 (PDF 2024 poco copiable); sustituir cuando haya transcripción |
| 2025 | `teoria/data/programacion2025.js` | **40 preguntas** DAW Web (`data/_emit2025.cjs`); en **17–18** se añadió la opción alineada con JDK (el PDF traía otras cifras) |

Cada pregunta en los `.js` sigue este formato (igual que en 2021):

```js
{
  numero: 1,
  enunciado: "Texto… puede usar \\n para saltos de línea",
  opciones: ["a", "b", "c", "d"],
  correcta: 0, // índice 0–3 de la opción correcta (o null si no hay clave automática)
  explicacion: "Por qué es correcta."
}
```

La lógica del test está en `teoria/script.js` y usa `window.bancoExamenes` definido por los archivos de `teoria/data/`.

### Regenerar bancos 2022 / 2023 / 2025

Desde `teoria/data/`:

- `node _emitExamenes.cjs` → escribe `programacion2022.js` y `programacion2023.js`.
- `node _emit2025.cjs` → escribe `programacion2025.js`.

## Práctica en Java

- **`practica/2021/`**: ejercicios enlazados con el temario del examen 2021 (`sin_resolver` / `resueltos`).
- **`practica/coleccion/`**: colección transversal basada en 2021-2025, con pares `sin_resolver` y `resueltos` para estudio guiado.
- **`practica/2023/`**, **`practica/2024/`** y **`practica/2025/`**: ejercicios por año con pares `sin_resolver` / `resueltos`.
- **`practica/2022/`**: carpeta disponible para seguir ampliando ejercicios por año.
- **`practica/ruta_real_232425/`**: ejercicios específicos para entrenar la ruta real 23-24-25 por bloques de examen.

## Nota sobre `file://` y módulos

Si abres `index.html` directamente desde el disco, algunos navegadores bloquean la carga de scripts locales. En ese caso usa un servidor estático mínimo, por ejemplo desde la carpeta `teoria`:

```bash
npx --yes serve .
```

y entra a la URL que indique la consola.
