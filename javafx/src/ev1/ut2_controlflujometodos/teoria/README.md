# UT2 — Condicionales y métodos (guión de clase)

**Objetivo:** GUI con `if/else`, métodos propios y un contador que se incrementa con botones.  
**Patrón:** `U01_CondicionalesYMetodosApp` + `U01_CondicionalesYMetodosController` + `u01_condicionales-view.fxml`  
**Temario consola de referencia:** `java/src/ev1/ut2_controlflujometodos/`

---

## Antes de empezar (5 min)

- [ ] Misma configuración que UT1 (proyecto `javafx`, JDK 21, Scene Builder).
- [ ] Carpeta: `javafx/src/ev1/ut2_controlflujometodos/teoria/`

**Repaso:** App + Controller + FXML. Hoy usamos **VBox** en lugar de GridPane (lista vertical).

---

## Fase 1 — Diseño en Scene Builder (20–25 min)

### 1.1 Crear el FXML

1. Scene Builder → **File → New**.
2. Arrastra un **StackPane** como raíz.
3. **Save As** → `u01_condicionales-view.fxml` en `teoria/`.

### 1.2 Tamaño del StackPane

| Propiedad | Valor |
|-----------|-------|
| Pref Width | 340 |
| Pref Height | 280 |
| Min Width | 340 |
| Min Height | 280 |

### 1.3 VBox interior (lista vertical centrada)

1. Arrastra un **VBox** *dentro* del StackPane.
2. VBox → **Layout**:
   - `Alignment` = **CENTER** (centra hijos en horizontal)
   - `Spacing` = **12**
   - `Padding` = **10** (todos los lados)

### 1.4 Controles (de arriba a abajo, dentro del VBox)

Arrastra en este orden:

| # | Control | Propiedades importantes |
|---|---------|-------------------------|
| 1 | **TextField** | fx:id `campoNumero`, text `7`, prompt `Escribe un entero`, pref width `280` |
| 2 | **Button** | text `Comprobar par / impar`, onAction `#onComprobarParidadClick` |
| 3 | **Label** | fx:id `lblParidad`, text `Paridad: —`, wrap text ✓, max width `280`, alignment CENTER |
| 4 | **Button** | text `Incrementar contador`, onAction `#onIncrementarClick` |
| 5 | **Label** | fx:id `lblContador`, text `Contador: 0` |

### 1.5 Controller en FXML

1. StackPane raíz → **Controller Class** =  
   `ev1.ut2_controlflujometodos.teoria.U01_CondicionalesYMetodosController`
2. Enlaza los dos botones con sus `onAction` (tabla arriba).
3. **Save**.

> **Tip de enseñanza:** el VBox apila; el StackPane centra el bloque entero en la ventana.

---

## Fase 2 — Controller (15–20 min)

1. Crear clase `U01_CondicionalesYMetodosController`.

```java
package ev1.ut2_controlflujometodos.teoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class U01_CondicionalesYMetodosController {

    @FXML private TextField campoNumero;
    @FXML private Label lblParidad;
    @FXML private Label lblContador;

    private int contador = 0;

    @FXML
    private void onComprobarParidadClick() {
        try {
            int numero = Integer.parseInt(campoNumero.getText().trim());
            lblParidad.setText("Paridad: " + clasificarParidad(numero));
        } catch (NumberFormatException e) {
            lblParidad.setText("Paridad: numero no valido");
        }
    }

    @FXML
    private void onIncrementarClick() {
        incrementarContador();
        lblContador.setText("Contador: " + contador);
    }

    private static String clasificarParidad(int numero) {
        if (numero % 2 == 0) {
            return numero + " es par";
        }
        return numero + " es impar";
    }

    private void incrementarContador() {
        contador++;
    }
}
```

**Qué destacar en clase:**

- `clasificarParidad` = método con `if/else` (igual que consola).
- `incrementarContador` = método void que modifica estado (`contador`).
- El **Label** solo muestra texto; no calcula.

---

## Fase 3 — App (10 min)

Crear `U01_CondicionalesYMetodosApp`:

```java
package ev1.ut2_controlflujometodos.teoria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class U01_CondicionalesYMetodosApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("u01_condicionales-view.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle("EV1 UT2 — Condicionales y metodos");
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

(Solo cambia el nombre del FXML y el título respecto a UT1.)

---

## Fase 4 — Ejecutar y probar (5 min)

- [ ] `7` → **Comprobar par / impar** → «7 es impar»
- [ ] `8` → «8 es par»
- [ ] Texto inválido → mensaje de error
- [ ] **Incrementar contador** varias veces → sube 1, 2, 3…

```powershell
.\gradlew.bat run "-PmainClass=ev1.ut2_controlflujometodos.teoria.U01_CondicionalesYMetodosApp"
```

---

## Errores frecuentes

| Error | Solución |
|-------|----------|
| Contador no sube | ¿`onIncrementarClick` enlazado en el botón? |
| Paridad siempre igual | Revisar `% 2` y el `if` |
| Botones no centrados | VBox `alignment = CENTER` |
| Dos métodos `onAction` | Cada botón su propio `#nombreMetodo` |

---

## Cierre (2 min)

- [ ] Diferencia entre **evento** (`@FXML void onXxxClick`) y **método de lógica** (`clasificarParidad`).
- [ ] El alumno puede repetir el patrón StackPane → VBox → controles sin ayuda.
