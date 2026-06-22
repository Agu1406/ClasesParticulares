# Ejercicios EV2 — JavaFX (UT5)

Cuatro ejercicios guiados, uno por bloque de teoria U01–U04. Patron: **FXML (Scene Builder) + Controller + App**.

| Ej. | Tema teoria | Carpeta | Objetivo |
|-----|-------------|---------|----------|
| E01 | U01 Stage/Scene | `e01_saludo` | Label + TextField + boton |
| E02 | U02 FXMLLoader | `e02_ventana` | Abrir segunda ventana |
| E03 | U03 Controller | `e03_combo` | ComboBox + Initializable |
| E04 | U04 Calculadora | `e04_operaciones` | Dos operandos + try/catch |

## Flujo alumno

1. Abrir el `.fxml` en **Scene Builder** (layout ya preparado en pendiente).
2. Completar `*Controller_SIN_RESOLVER.java`.
3. Completar `*App_SIN_RESOLVER.java` si tiene TODO.
4. Ejecutar la App. Comparar con `resueltos/`.

## Ejecutar (resuelto)

```powershell
cd javafx
.\gradlew.bat run "-PmainClass=ev2.ut5_pooexcepcionesio.ejercicios.resueltos.e01_saludo.E01_SaludoApp"
```

Cambiar `mainClass` por el ejercicio deseado (`e02_ventana` … `e04_operaciones`).
