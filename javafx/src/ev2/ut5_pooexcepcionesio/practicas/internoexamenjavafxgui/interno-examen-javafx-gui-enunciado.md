# Examen JavaFX — ventana basica

Practica interna. UT5 RA5 — GUI con JavaFX y FXML (modulo 0485).

## Objetivo

Crear una aplicacion JavaFX que abra una ventana cargando un archivo FXML.

## Archivos

| Archivo | Descripcion |
|---------|-------------|
| `ExamenGuiApp` | Clase que extiende `Application` y carga el FXML |
| `ExamenGuiController` | Controller enlazado en el FXML |
| `ExamenGuiView.fxml` | Diseno de la ventana (Scene Builder) |

## Requisitos

1. `main` llama a `launch`.
2. En `start`, usar `FXMLLoader` y mostrar un `Stage`.
3. El FXML debe declarar `fx:controller` con tu clase controller.
4. La ventana muestra al menos un `Label` identificativo.

## Entrega

Completar `*_SIN_RESOLVER`. Referencia en `*_RESUELTO` y en `src/ignorar/referencia-centros/examengui-maven/` (proyecto Maven del centro).
