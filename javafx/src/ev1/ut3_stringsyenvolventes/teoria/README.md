# UT3 — Strings y envolventes (guión de clase)

**Objetivo:** practicar métodos de `String` y `Integer.parseInt` desde botones de una GUI.  
**Patrón:** `U01_StringsYEnvolventesApp` + `U01_StringsYEnvolventesController` + `u01_strings-view.fxml`  
**Temario consola de referencia:** `java/src/ev1/ut3_stringsyenvolventes/`

---

## Antes de empezar (5 min)

- [ ] UT1 y UT2 hechas (o al menos entendido App + Controller + FXML).
- [ ] Carpeta: `javafx/src/ev1/ut3_stringsyenvolventes/teoria/`

**Novedad de esta UT:** **varios botones**, cada uno con su `onAction` distinto.

---

## Fase 1 — Diseño en Scene Builder (20–25 min)

### 1.1 Crear el FXML

1. Scene Builder → **File → New**.
2. Raíz: **StackPane**.
3. **Save As** → `u01_strings-view.fxml`.

### 1.2 Tamaño del StackPane

| Propiedad | Valor |
|-----------|-------|
| Pref Width | 320 |
| Pref Height | 340 |
| Min Width | 320 |
| Min Height | 340 |

### 1.3 VBox interior

1. **VBox** dentro del StackPane.
2. `Alignment` = **CENTER**
3. `Spacing` = **10**
4. `Padding` = **10**

### 1.4 Controles (orden vertical)

| # | Control | fx:id / text / onAction |
|---|---------|-------------------------|
| 1 | TextField | fx:id `campoTexto`, text `  hola DAM  `, pref width `260` |
| 2 | Button | `toUpperCase()` → `#onMayusculasClick` |
| 3 | Button | `length()` → `#onLongitudClick` |
| 4 | Button | `trim()` → `#onTrimClick` |
| 5 | Button | `Integer.parseInt()` → `#onParseIntClick` |
| 6 | Label | fx:id `lblResultado`, text `Resultado: —`, wrap text ✓, max width `260`, alignment CENTER |

### 1.5 Controller en FXML

1. StackPane → **Controller Class** =  
   `ev1.ut3_stringsyenvolventes.teoria.U01_StringsYEnvolventesController`
2. Enlaza los **cuatro** botones (un `onAction` distinto por botón).
3. **Save**.

> **Tip:** en Scene Builder, selecciona cada botón y en **Code** pon su `onAction` antes de pasar al siguiente.

---

## Fase 2 — Controller (15–20 min)

Crear `U01_StringsYEnvolventesController`:

```java
package ev1.ut3_stringsyenvolventes.teoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class U01_StringsYEnvolventesController {

    @FXML private TextField campoTexto;
    @FXML private Label lblResultado;

    @FXML
    private void onMayusculasClick() {
        lblResultado.setText("Resultado: " + campoTexto.getText().toUpperCase());
    }

    @FXML
    private void onLongitudClick() {
        lblResultado.setText("Resultado: length=" + campoTexto.getText().length());
    }

    @FXML
    private void onTrimClick() {
        String recortado = campoTexto.getText().trim();
        campoTexto.setText(recortado);
        lblResultado.setText("Resultado: trim -> '" + recortado + "'");
    }

    @FXML
    private void onParseIntClick() {
        try {
            int valor = Integer.parseInt(campoTexto.getText().trim());
            lblResultado.setText("Resultado: parseInt=" + valor);
        } catch (NumberFormatException e) {
            lblResultado.setText("Resultado: escribe un entero (ej. 42)");
        }
    }
}
```

**Qué explicar:**

- `getText()` lee el TextField; `setText()` escribe Label o TextField.
- `trim()` en **onTrimClick** también actualiza el campo (el alumno *ve* el cambio).
- `parseInt` necesita `try/catch` si el texto no es un entero.

---

## Fase 3 — App (10 min)

Crear `U01_StringsYEnvolventesApp` (mismo esquema que UT1/UT2):

```java
package ev1.ut3_stringsyenvolventes.teoria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class U01_StringsYEnvolventesApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("u01_strings-view.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle("EV1 UT3 — Strings y envolventes");
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

---

## Fase 4 — Ejecutar y probar (5–10 min)

Con texto `  hola DAM  `:

- [ ] **toUpperCase()** → `HOLA DAM` (con espacios)
- [ ] **length()** → cuenta caracteres incluidos espacios
- [ ] **trim()** → quita espacios del campo y del resultado
- [ ] **Integer.parseInt()** con `hola` → mensaje de error
- [ ] Cambia el campo a `42` → **parseInt** → `42`

```powershell
.\gradlew.bat run "-PmainClass=ev1.ut3_stringsyenvolventes.teoria.U01_StringsYEnvolventesApp"
```

---

## Errores frecuentes

| Error | Solución |
|-------|----------|
| Un botón ejecuta método de otro | Cada botón su `#onXxxClick` único |
| `parseInt` crashea | Falta `try/catch` |
| trim no se ve en el campo | Hay que hacer `campoTexto.setText(recortado)` |
| Cuatro métodos y un solo `@FXML` campo | Un `fx:id` compartido está bien |

---

## Cierre — EV1 completa (5 min)

Repaso de las tres UT:

| UT | Layout interior | Concepto Java |
|----|-----------------|-------------|
| UT1 | GridPane | tipos, cast, parse |
| UT2 | VBox | if/else, métodos, estado |
| UT3 | VBox | String, envolventes |

**Patrón fijo en las tres:**

```
StackPane (centra + tamaño ventana)
  └── VBox o GridPane (formulario)
        └── controles con fx:id y onAction
```

- [ ] El alumno puede crear una GUI nueva con Scene Builder sin copiar el repo.
- [ ] Sabe enlazar FXML ↔ Controller ↔ App.
