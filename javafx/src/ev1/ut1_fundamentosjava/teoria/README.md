# UT1 — Tipos y conversión (guión de clase)

**Objetivo:** crear una GUI que lea un `int` y un `double`, convierta tipos y muestre el resultado.  
**Patrón:** `U01_TiposYConversionApp` + `U01_TiposYConversionController` + `u01_tipos-view.fxml`  
**Temario consola de referencia:** `java/src/ev1/ut1_fundamentosjava/`

---

## Antes de empezar (5 min)

- [ ] Proyecto Gradle `javafx` abierto en IntelliJ (JDK 21).
- [ ] Scene Builder instalado (Gluon).
- [ ] Carpeta de trabajo: `javafx/src/ev1/ut1_fundamentosjava/teoria/`

**Di al alumno:** «La ventana se diseña en Scene Builder (FXML). La lógica va en el Controller. La App solo arranca todo.»

---

## Fase 1 — Diseño en Scene Builder (25–30 min)

### 1.1 Crear el FXML

1. Scene Builder → **File → New** (o New Empty).
2. En el panel **Hierarchy**, borra el contenido por defecto si molesta.
3. Arrastra un **StackPane** al centro (será la raíz).
4. **File → Save As** → `u01_tipos-view.fxml` en la carpeta `teoria/`.

### 1.2 Tamaño y centrado de la ventana

1. Clic en el **StackPane** (raíz).
2. En **Layout** (panel derecho):
   - `Pref Width` = **420**
   - `Pref Height` = **260**
   - `Min Width` = **420**
   - `Min Height` = **260**

> El StackPane centra su contenido en horizontal y vertical.

### 1.3 Formulario con GridPane

1. Arrastra un **GridPane** *dentro* del StackPane.
2. En GridPane → **Layout** → `Alignment` = **CENTER**.
3. `Hgap` = **10**, `Vgap` = **10**.
4. **Padding** = **10** en los cuatro lados.

### 1.4 Controles (fila a fila)

| Fila | Col 0 | Col 1 |
|------|-------|-------|
| 0 | **Label** `Entero:` | **TextField** → fx:id `campoEntero`, text `10`, pref width `220` |
| 1 | **Label** `Decimal:` | **TextField** → fx:id `campoDecimal`, text `3.14`, pref width `220` |
| 2 | — | **Button** `Convertir` → column span **2**, halignment **CENTER** |
| 3 | — | **Label** → fx:id `lblResultado`, text `Pulsa Convertir`, column span **2**, wrap text ✓, max width `360`, alignment **CENTER** |

**Cómo poner controles en filas/columnas (Scene Builder):**

- Selecciona el control → panel **Layout** → `Row Index`, `Column Index`.
- Para ocupar dos columnas: `Column Span` = **2**.

### 1.5 Controller en el FXML (aún sin crear la clase)

1. Clic en el **StackPane** raíz.
2. Panel **Controller** (abajo) → **Controller Class** =  
   `ev1.ut1_fundamentosjava.teoria.U01_TiposYConversionController`
3. Selecciona el botón **Convertir** → **Code** → **On Action** = `#onConvertirClick`
4. **File → Save**.

---

## Fase 2 — Controller (15 min)

1. IntelliJ → misma carpeta `teoria/` → **New → Java Class** → `U01_TiposYConversionController`.
2. Copiar/pegar o escribir:

```java
package ev1.ut1_fundamentosjava.teoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class U01_TiposYConversionController {

    @FXML private TextField campoEntero;
    @FXML private TextField campoDecimal;
    @FXML private Label lblResultado;

    @FXML
    private void onConvertirClick() {
        try {
            int entero = Integer.parseInt(campoEntero.getText().trim());
            double decimal = Double.parseDouble(campoDecimal.getText().trim());
            int parteEntera = (int) decimal;
            double suma = entero + decimal;

            lblResultado.setText(
                    "int=" + entero
                            + " | double=" + decimal
                            + " | (int)decimal=" + parteEntera
                            + " | int+double=" + suma);
        } catch (NumberFormatException e) {
            lblResultado.setText("Error: introduce numeros validos");
        }
    }
}
```

**Puntos clave para explicar:**

- `@FXML` enlaza con los `fx:id` del FXML.
- `onConvertirClick` debe llamarse **igual** que en el FXML (`#onConvertirClick`).
- `Integer.parseInt` / `Double.parseDouble` = lo mismo que en consola.

---

## Fase 3 — App (10 min)

1. **New → Java Class** → `U01_TiposYConversionApp` extends `Application`.
2. Código mínimo:

```java
package ev1.ut1_fundamentosjava.teoria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class U01_TiposYConversionApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("u01_tipos-view.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle("EV1 UT1 — Tipos y conversion");
        stage.sizeToScene();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

**Explicación rápida línea a línea:**

| Línea | Qué hace |
|-------|----------|
| `FXMLLoader` + `getResource` | Carga el `.fxml` del mismo paquete/carpeta |
| `loader.load()` | Crea los controles y el Controller |
| `new Scene(root)` | Contenido de la ventana |
| `sizeToScene()` | Ajusta el tamaño al FXML |
| `launch(args)` | Arranca JavaFX y llama a `start` |

---

## Fase 4 — Ejecutar (5 min)

1. Clic derecho en `U01_TiposYConversionApp` → **Run**.
2. Prueba: `10` y `3.14` → pulsa **Convertir**.
3. Prueba error: texto no numérico → debe salir el mensaje de error.

**Alternativa terminal:**

```powershell
cd javafx
.\gradlew.bat run "-PmainClass=ev1.ut1_fundamentosjava.teoria.U01_TiposYConversionApp"
```

---

## Errores frecuentes

| Error | Causa | Solución |
|-------|-------|----------|
| `faltan componentes JavaFX runtime` | Run sin Gradle/JavaFX | Reload Gradle; ver `javafx/README.md` |
| `fx:id` no enlaza (null) | Nombre distinto en FXML y Controller | Revisar ortografía exacta |
| `onAction` no hace nada | Método sin `@FXML` o nombre distinto | Debe coincidir con `#onConvertirClick` |
| FXML no carga | `fx:controller` mal escrito | Package completo correcto |
| Ventana muy pequeña | Sin `pref/min` en StackPane | Revisar Fase 1.2 |

---

## Cierre (2 min)

- [ ] El alumno sabe abrir y guardar FXML en Scene Builder.
- [ ] Sabe qué es `fx:id`, `fx:controller` y `onAction`.
- [ ] Ha ejecutado la App sin mirar la solución del repo (o comparando al final).
