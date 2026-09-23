# UT8 — Frameworks web (Flask)

Espejo Java `ut8_frameworksspring` y C# `ut8_aspnet`.

| Subtema | Tema Python | Equivalente | Estado |
|---------|-------------|-------------|--------|
| `u01flask` | Flask: rutas, params, JSON | Spring MVC / ASP.NET | **Con contenido** (teoria U01–U03 + ejercicios E01–E08) |
| `u02repaso` | Repaso / examenes | Repaso | Esqueleto |

## Dependencia

Flask **no** viene en la biblioteca estandar. Instalar antes de ejecutar:

```bash
pip install flask
```

## `u01flask`

- **Teoria:** `teoria/U01_FlaskIntro.py`, `U02_RutasYParametros.py`, `U03_JsonYPost.py`
- **Ejercicios:** `ejercicios/pendientes/` y `ejercicios/resueltos/` (E01–E08)
  - E01 Ruta raiz · E02 About · E03 Saludo con path · E04 Query `edad`
  - E05 JSON lista · E06 JSON alumno · E07 POST eco · E08 Mini-API alumnos (GET lista + GET por id)

Por defecto los scripts **no** bloquean con `app.run()`: imprimen rutas o usan `test_request_context` / `test_client()`. En U01 hay una linea comentada `# app.run(debug=True)` para servir en local si quieres.

Ejecutar demos: `python ruta/al/archivo.py`
