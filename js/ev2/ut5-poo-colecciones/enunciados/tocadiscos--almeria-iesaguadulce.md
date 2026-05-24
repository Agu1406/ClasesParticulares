# Ejercicio: Sistema de Reproducción de Discos

## Objetivo

Implementar un sistema de reproducción de música utilizando conceptos de **Programación Orientada a Objetos** en JavaScript, aplicando **herencia** y **polimorfismo**.

---

## Instrucciones Detalladas

### Paso 1: Clase Base `Disco`

Define una clase base llamada `Disco` que:

#### Constructor
- Reciba en su constructor dos parámetros:
  - `titulo` (string): Título del disco
  - `artista` (string): Nombre del artista
- Utilice setters para asignar los valores (no asignar directamente a las propiedades privadas)

#### Propiedades Privadas
- `#_titulo`: Almacena el título del disco
- `#_artista`: Almacena el nombre del artista

#### Setters y Getters
- **Setter `titulo`**: 
  - Valide que el parámetro sea un string y no esté vacío
  - Si no cumple, lance un error con un mensaje descriptivo
- **Setter `artista`**: 
  - Valide que el parámetro sea un string y no esté vacío
  - Si no cumple, lance un error con un mensaje descriptivo
- **Getters `titulo` y `artista`**: Retornen los valores de las propiedades privadas

#### Métodos

**Método `obtenerSonido()`**:
- Retorne una cadena de texto genérica: `"Sonido genérico del disco"`
- Este método será sobrescrito por las subclases para aplicar polimorfismo

**Método `toString()` - OBLIGATORIO**:
- Retorne una cadena de texto con el formato: `"Disco: [título] - Artista: [artista]"`
- Ejemplo: `"Disco: Abbey Road - Artista: The Beatles"`
- Este método será reutilizado por las subclases usando `super.toString()`

#### Formato de Exportación
- Use `export default class Disco { ... }` (formato ES6)

---

### Paso 2: Clase `Vinilo` (Hereda de `Disco`)

Crea una clase llamada `Vinilo` que herede de `Disco`:

#### Constructor
- Reciba tres parámetros: `titulo`, `artista`, y `revolucionesPorMinuto`
- Llame al constructor del padre usando `super(titulo, artista)`
- Asigne `revolucionesPorMinuto` usando el setter

#### Propiedades Privadas
- `#_revolucionesPorMinuto`: Almacena las revoluciones por minuto

#### Constantes Estáticas Privadas
- `static #MIN_REVOLUCION = 33`: Valor mínimo permitido
- `static #MAX_REVOLUCION = 45`: Valor máximo permitido

#### Setters y Getters

**Setter `revolucionesPorMinuto`** - Validaciones obligatorias:
- Use una estructura `if...else if` para las validaciones:
  1. **Primera validación**: Verificar que sea un número usando `isNaN()`
     - Si no es un número, lance: `"Las revoluciones por minuto deben ser un número"`
  2. **Segunda validación**: Verificar que sea un número entero usando `Number.isInteger()`
     - Si no es entero, lance: `"Las revoluciones por minuto deben ser un número entero"`
  3. **Tercera validación**: Verificar que esté dentro del rango permitido
     - Compare con `Vinilo.#MIN_REVOLUCION` y `Vinilo.#MAX_REVOLUCION`
     - Si está fuera del rango, lance: `"Las revoluciones por minuto deben estar entre [MIN] y [MAX]"`
- Si pasa todas las validaciones, asigne el valor a la propiedad privada

**Getter `revolucionesPorMinuto`**: Retorne el valor de la propiedad privada

#### Métodos

**Método `obtenerSonido()`**:
- Sobrescriba el método del padre
- Retorne: `"Sonido cálido y analógico del vinilo a [RPM] RPM"`
- Ejemplo: `"Sonido cálido y analógico del vinilo a 33 RPM"`

**Método `toString()` - OBLIGATORIO**:
- **Debe reutilizar el método del padre usando `super.toString()`**
- Pasos a seguir:
  1. Llame a `super.toString()` y almacene el resultado en una variable (ej: `let cadenaVinilo = super.toString();`)
  2. Reemplace "Disco:" por "Vinilo:" en la cadena
  3. Agregue al final: `" - RPM: [valor]"`
  4. Retorne la cadena modificada
- Formato final esperado: `"Vinilo: [título] - Artista: [artista] - RPM: [rpm]"`
- Ejemplo: `"Vinilo: Abbey Road - Artista: The Beatles - RPM: 33"`

---

### Paso 3: Clase `CD` (Hereda de `Disco`)

Crea una clase llamada `CD` que herede de `Disco`:

#### Constructor
- Reciba dos parámetros: `titulo` y `artista`
- Llame al constructor del padre usando `super(titulo, artista)`

#### Métodos

**Método `obtenerSonido()`**:
- Sobrescriba el método del padre
- Retorne: `"Sonido digital y cristalino del CD"`

**Método `toString()` - OBLIGATORIO**:
- **Debe reutilizar el método del padre usando `super.toString()`**
- Pasos a seguir:
  1. Llame a `super.toString()` y almacene el resultado en una variable (ej: `let cadenaCD = super.toString();`)
  2. Reemplace "Disco:" por "CD:" en la cadena
  3. Retorne la cadena modificada
- Formato final esperado: `"CD: [título] - Artista: [artista]"`
- Ejemplo: `"CD: Thriller - Artista: Michael Jackson"`

---

### Paso 4: Clase `TocaDiscos`

Desarrolla una clase llamada `TocaDiscos`:

#### Constructor
- No requiere parámetros ni propiedades iniciales
- Debe importar las clases `Disco` y `CD` para poder validar el tipo

#### Métodos

**Método `reproducir(disco)`**:
- Reciba un objeto `Disco` como parámetro (puede ser `Disco` base o `Vinilo`, **NO acepta `CD`**)
- **Validaciones obligatorias**:
  1. Verificar que el parámetro sea una instancia de `Disco` usando `instanceof Disco`
     - Si no es un `Disco`, lance un error: `"El parámetro debe ser un objeto Disco válido"`
  2. Verificar que **NO** sea una instancia de `CD` usando `instanceof CD`
     - Si es un `CD`, lance un error: `"Los CDs no se pueden reproducir en un TocaDiscos. Use ReproductorCDs para reproducir CDs."`
- Si pasa las validaciones, muestre por consola:
  - El título del disco: `console.log("Título: " + disco.titulo)`
  - El artista del disco: `console.log("Artista: " + disco.artista)`
  - El resultado de `disco.obtenerSonido()`: `console.log("Sonido: " + disco.obtenerSonido())`
- Este método demuestra **polimorfismo** y **validación específica**: funciona con `Disco` base y `Vinilo`, pero rechaza `CD`

---

### Paso 5: Clase `ReproductorCDs`

Desarrolla una clase llamada `ReproductorCDs`:

#### Constructor
- No requiere parámetros ni propiedades iniciales
- Debe importar la clase `CD` para poder validar el tipo

#### Métodos

**Método `reproducir(cd)`**:
- Reciba un objeto `CD` como parámetro
- **Validación obligatoria**:
  - Verificar que el parámetro sea una instancia de `CD` usando `instanceof CD`
  - Si no es un `CD`, lance un error: `"El parámetro debe ser un objeto CD válido"`
- Si pasa la validación, muestre por consola:
  - El título del CD: `console.log("Título: " + cd.titulo)`
  - El artista del CD: `console.log("Artista: " + cd.artista)`
  - El resultado de `cd.obtenerSonido()`: `console.log("Sonido: " + cd.obtenerSonido())`
- Este reproductor es específico para CDs y rechaza cualquier otro tipo de disco

---

### Paso 6: Pruebas y Verificación

Crea un archivo `uso.js` que:

1. **Importe todas las clases necesarias** (incluyendo `ReproductorCDs`)
2. **Use un bloque `try-catch`** para manejar posibles errores:
   ```javascript
   try {
     // Tu código aquí
   } catch (ex) {
     console.log(ex);
   }
   ```
3. **Cree instancias de ambos reproductores**:
   - Una instancia de `TocaDiscos` (para vinilos y discos base)
   - Una instancia de `ReproductorCDs` (para CDs)
   - Puedes usar nombres simples como `tocadisc01`, `reproductorcds01`
4. **Cree instancias de prueba**:
   - Un `Vinilo` con título, artista y 33 RPM (ej: `vinilo01`)
   - Un `Vinilo` con título, artista y 45 RPM (ej: `vinilo02`)
   - Un `CD` con título y artista (ej: `cd01`, `cd02`)
   - Un `Disco` base con título y artista (ej: `disco01`)
5. **Muestre el resultado de `toString()`** para cada instancia
6. **Pruebe los métodos `obtenerSonido()`** de cada instancia
7. **Use los reproductores apropiados**:
   - Use `TocaDiscos` para reproducir vinilos y discos base
   - Use `ReproductorCDs` para reproducir CDs
8. **Pruebe las validaciones usando `try-catch`**:
   - Intente reproducir un CD con `TocaDiscos` (debe lanzar error)
   - Intente reproducir un vinilo con `ReproductorCDs` (debe lanzar error)
   - Intente crear un vinilo con RPM inválido (debe lanzar error)
   - Intente crear un disco con título vacío (debe lanzar error)

#### Estilo Recomendado para `uso.js`

Puedes usar un estilo simple y directo:

```javascript
import TocaDiscos from "./tocadiscos.js";
import ReproductorCDs from "./reproductorcds.js";
import Vinilo from "./vinilo.js";
import CD from "./cd.js";
import Disco from "./disco.js";

try {
  let tocadisc01 = new TocaDiscos();
  let reproductorcds01 = new ReproductorCDs();
  let vinilo01 = new Vinilo("Abbey Road", "The Beatles", 33);
  let cd01 = new CD("Thriller", "Michael Jackson");
  
  // Probar métodos
  console.log(vinilo01.toString());
  tocadisc01.reproducir(vinilo01);
  
  // Probar validaciones
  try {
    tocadisc01.reproducir(cd01);
  } catch (ex) {
    console.log(ex);
  }
  
} catch (ex) {
  console.log(ex);
}
```

---

## Conceptos a Aplicar

- ✅ **Herencia**: Clases `Vinilo` y `CD` heredan de `Disco` usando `extends`
- ✅ **Polimorfismo**: 
  - El método `obtenerSonido()` se comporta diferente según la clase
  - Los métodos `reproducir()` funcionan con diferentes tipos de discos según el reproductor
- ✅ **Reutilización de código**: Los métodos `toString()` de las subclases deben usar `super.toString()`
- ✅ **Encapsulación**: Uso de propiedades privadas (`#_`) y constantes estáticas privadas
- ✅ **Validación**: 
  - Uso de setters con validaciones y estructura `if...else if`
  - Validación específica de tipos usando `instanceof` en los reproductores
- ✅ **Separación de responsabilidades**: Cada reproductor tiene un propósito específico

---

## Estructura de Archivos Recomendada

```
ejercicio tocadiscos musica/
├── disco.js          # Clase base Disco
├── vinilo.js          # Clase Vinilo (hereda de Disco)
├── cd.js              # Clase CD (hereda de Disco)
├── tocadiscos.js      # Clase TocaDiscos (solo vinilos y discos base)
├── reproductorcds.js  # Clase ReproductorCDs (solo CDs)
├── uso.js             # Archivo de uso y pruebas
└── index.html         # Archivo HTML para ejecutar en el navegador
```

---

## Cómo Ejecutar el Código

### Opción 1: Desde el Navegador (Recomendado)

1. Abre el archivo `index.html` en tu navegador
2. Haz clic en el botón "Ejecutar Demostración"
3. Verás la salida en la página

**Ventajas**: No necesitas instalar nada, solo abrir el HTML en el navegador.

### Opción 2: Desde Node.js (Opcional)

Si prefieres ejecutar desde la terminal:

```bash
node uso.js
```

**Nota**: Para usar Node.js necesitarías crear un archivo `package.json` con `"type": "module"`, pero no es necesario si usas HTML.

---

## Recomendaciones de Estilo para `uso.js`

Para el archivo de pruebas, puedes usar un estilo simple y directo:

- **Nombres de variables simples**: Usa nombres como `tocadisc01`, `vinilo01`, `cd01`, `disco01`
- **Uso de `let`**: Puedes usar `let` para declarar variables
- **Bloque try-catch principal**: Envuelve todo el código principal en un `try-catch`
- **Try-catch para validaciones**: Usa `try-catch` individuales para probar cada validación
- **Mensajes simples**: Usa `console.log(ex)` para mostrar errores

Ejemplo de estructura:

```javascript
import TocaDiscos from "./tocadiscos.js";
import ReproductorCDs from "./reproductorcds.js";
import Vinilo from "./vinilo.js";
import CD from "./cd.js";
import Disco from "./disco.js";

try {
  let tocadisc01 = new TocaDiscos();
  let reproductorcds01 = new ReproductorCDs();
  let vinilo01 = new Vinilo("Título", "Artista", 33);
  let cd01 = new CD("Título", "Artista");
  
  // Probar métodos
  console.log(vinilo01.toString());
  tocadisc01.reproducir(vinilo01);
  
  // Probar validaciones
  try {
    tocadisc01.reproducir(cd01); // Debe fallar
  } catch (ex) {
    console.log(ex);
  }
  
} catch (ex) {
  console.log(ex);
}
```

---

## Ejemplo de Resultado Esperado

Al ejecutar el código (desde `index.html` o `uso.js`), deberías ver algo como:

```
🎵 Sistema de Reproducción de Discos 🎵

--- Mostrando información de los discos (toString) ---
Información del vinilo: Vinilo: Abbey Road - Artista: The Beatles - RPM: 33
Información del CD: CD: Thriller - Artista: Michael Jackson

--- Reproduciendo discos ---
=== Reproduciendo disco ===
Título: Abbey Road
Artista: The Beatles
Sonido: Sonido cálido y analógico del vinilo a 33 RPM
===========================
```

---

## Checklist de Verificación

Antes de considerar el ejercicio completado, verifica que:

- [ ] La clase `Disco` tiene setters con validación
- [ ] La clase `Disco` tiene el método `toString()` implementado
- [ ] La clase `Vinilo` tiene constantes estáticas privadas `#MIN_REVOLUCION` y `#MAX_REVOLUCION`
- [ ] El setter de `revolucionesPorMinuto` usa `if...else if` para validaciones
- [ ] El setter valida: número, entero, y rango (33-45)
- [ ] La clase `Vinilo` sobrescribe `obtenerSonido()`
- [ ] La clase `Vinilo` sobrescribe `toString()` usando `super.toString()`
- [ ] La clase `CD` sobrescribe `obtenerSonido()`
- [ ] La clase `CD` sobrescribe `toString()` usando `super.toString()`
- [ ] La clase `TocaDiscos` tiene el método `reproducir()` que valida que NO sea un CD
- [ ] La clase `TocaDiscos` acepta `Disco` base y `Vinilo`, pero rechaza `CD`
- [ ] La clase `ReproductorCDs` tiene el método `reproducir()` que solo acepta `CD`
- [ ] La clase `ReproductorCDs` rechaza vinilos y discos base
- [ ] Todas las clases usan `export default class`
- [ ] El archivo `uso.js` demuestra el funcionamiento de todas las clases y las validaciones
