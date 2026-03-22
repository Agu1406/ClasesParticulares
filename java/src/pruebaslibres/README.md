# Pruebas libres (Programación)

Material para preparar el examen tipo test de **pruebas libres**: PDFs oficiales, test interactivo en HTML y ejercicios de práctica en Java.

## PDFs

En esta carpeta:

| Archivo | Uso |
|--------|-----|
| `Pruebas_libres_2021.pdf` … `Pruebas_libres_2025.pdf` | Enunciados originales del examen teórico |

## Test interactivo (teoría)

1. Abre en el navegador: `teoria/index.html` (doble clic o “Open with Live Server”).
2. Elige el año en el desplegable y pulsa **Cargar examen**.
3. Responde y usa **Corregir test** para ver el resultado global.

### Estado de los bancos de preguntas

| Año | Archivo de datos | Estado |
|-----|------------------|--------|
| 2021 | `teoria/data/programacion2021.js` | **40 preguntas** (completo) |
| 2022 | `teoria/data/programacion2022.js` | Placeholder: transcribe desde `Pruebas_libres_2022.pdf` |
| 2023 | `teoria/data/programacion2023.js` | Idem con `Pruebas_libres_2023.pdf` |
| 2024 | `teoria/data/programacion2024.js` | Idem con `Pruebas_libres_2024.pdf` |
| 2025 | `teoria/data/programacion2025.js` | Idem con `Pruebas_libres_2025.pdf` |

Cada pregunta en los `.js` sigue este formato (igual que en 2021):

```js
{
  numero: 1,
  enunciado: "Texto… puede usar \\n para saltos de línea",
  opciones: ["a", "b", "c", "d"],
  correcta: 0, // índice 0–3 de la opción correcta
  explicacion: "Por qué es correcta."
}
```

La lógica del test está en `teoria/script.js` y usa `window.bancoExamenes` definido por los archivos de `teoria/data/`.

## Práctica en Java

- **`practica/2021/`**: ejercicios enlazados con el temario del examen 2021 (`sin_resolver` / `resueltos`).
- **Años 2022–2025**: puedes replicar la misma estructura de carpetas (`practica/2022/`, …) cuando quieras plantear ejercicios a partir de cada PDF.

## Nota sobre `file://` y módulos

Si abres `index.html` directamente desde el disco, algunos navegadores bloquean la carga de scripts locales. En ese caso usa un servidor estático mínimo, por ejemplo desde la carpeta `teoria`:

```bash
npx --yes serve .
```

y entra a la URL que indique la consola.
