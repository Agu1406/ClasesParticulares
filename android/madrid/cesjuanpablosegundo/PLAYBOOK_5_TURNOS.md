# Playbook — máximo 5 interacciones

Principio: **nunca** pedir explicaciones ni “mejora el código”. Solo generar / corregir ficheros.

## Turno 1 (el que debe resolver el 90 %)

1. Abre un chat nuevo en Cursor (idealmente con la carpeta del repo / `android/madrid/cesjuanpablosegundo`).
2. Pega el contenido de [`PROMPT_EXAMEN_AGENTE.md`](PROMPT_EXAMEN_AGENTE.md) desde el `---` hasta el checklist.
3. Adjunta con `@` si puedes:
   - `@referencia-estilo/p1-centralita` (o p2/p3/p4 según parecido al enunciado)
   - la regla se aplica sola si editas `.kt`
4. Pega el enunciado del examen.
5. Cierra con: `Genera YA todos los ficheros .kt completos. Sin explicaciones.`

## Turno 2 — solo si no compila o faltan clases

```
Corrige solo lo necesario para que compile y cumpla el enunciado.
Mantén el mismo estilo (model/controller, ArrayList, mostrarDatos, menú).
No reescribas archivos que ya estén bien.
Lista qué archivos cambias.
```

## Turno 3 — herencia / polimorfismo mal

```
La jerarquía debe ser exactamente la del enunciado (abstracta/open + hijas).
Ajusta overrides y cálculos en las subclases.
No cambies el menú salvo que sea imprescindible.
```

## Turno 4 — menú, listas, costes / salarios

```
Ajusta solo Entrada.kt y el controller (Centralita/Empresa/Colegio…).
Las clases model no las toques si ya están correctas.
```

## Turno 5 — pulido final

```
Pasa el checklist del prompt.
Entrega la versión final de TODOS los .kt (completos).
Sin comentarios meta ni resumen.
```

## Qué NO escribir en ningún turno

- “Explícame la solución”
- “Hazlo más limpio / idiomático / con sealed / data class”
- “Usa best practices”
- Preguntas abiertas que gasten el turno sin código

## Atajo si el enunciado parece una práctica conocida

| Parecido a | @-mencionar |
|------------|-------------|
| Llamadas / centralita / coste por segundo | `referencia-estilo/p1-centralita` |
| Círculo / rectángulo / triángulo / figuras | `referencia-estilo/p2-figuras` |
| Asalariados / autónomos / jefes / empresa | `referencia-estilo/p3-trabajadores` |
| Alumnos / colegio / matricular / calificar | `referencia-estilo/p4-alumnos` |
