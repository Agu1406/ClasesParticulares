# **Lista de objetivos**

- [X] Inicializar el proyecto con **REACT** + **TYPESCRIPT** + **VITE**.
- [X] Instalar dependencia para routing. (**React router DOM**).
- [X] Instalar dependencia para estilos. (**TailWindCSS & PostCSS**).
- [X] Configurar la base/ruta de carga de **Vite**.
- [X] Configurar la carga/lectura de archivos de **TailWind**. 
- [X] Crear la estructura del proyecto (directorios en src).
- [X] Configurar el routing de la aplicación.
- [X] Generar el MPV (Minimo producto viable).
- 


# **Paso N.º1 - Inicializar REACT + VITE**

En el encabezado de **fuentes** he dejado la información teórica y básica de **Vite** para un entendimiento más profundo de la inicialización/creación del entorno de **React + Vite**. Debemos ejecutar los siguientes comandos siguiendo las instrucciones dadas a continuación:

### **npm create vite@latest**

Desde la raíz del repositorio/directorio ejecutamos el comando. Esto permite crear/instalar la ultima versión de **VITE**, elegimos el nombre del proyecto, en mi caso **clases-particulares**, luego elegimos **React** como framework y en las variantes disponibles elegimos **TypeScript + SWC** (SWC es un compilador muy rapido, gracias Aitor por enseñarme que es y como funciona), si aparecen más preguntas como **rolldwon-vite (Experimental)** decimos que no y en **Install with npm and start now** da un poco igual, podemos decir que **si** sin problema, antes de ejecutar el siguiente comando nos desplazamos de directorio, lee bien la instrucción del siguiente comando.

```bash
npm create vite@latest
```

# **Paso N.º2 - Instalar dependencias nativas**

### **npm install**

Para ejecutar este comando es necesario desplazarnos dentro del directorio donde hemos instalado **React + Vite**, abrimos ahí una terminal y ejecutamos el comando que instalara/actualizara dependencias.

```bash
npm install
```

# **Paso N.º3 - Instalar dependencias adicionales**

Este paso es muy importante, recuerdas, estás creando tú proyecto, es importante saber que dependencías vamos a elegir para facilitarnos el trabajo porque si no, tienes dos opciones, **crear tú mismo todo desde cero** lo cual toma tiempo o **utilizar librerías ya existentes** lo cual nos ahorra mucho tiempo, mi profesor Jaime decía "¿Para que inventar la rueda otra vez si ya existe?".

Yo elegí las siguientes dependencias, recuerda, como ya hemos creado/inicializado **REACT + VITE** tenemos que desplazarnos dentro del directorio del proyecto y desde ahí ejecutar en una terminal los siguientes comandos:

- **npm install react-router-dom:** Permite que el **routing** (redireccionamiento) dentro del proyecto sea del lado del cliente y no usando un **backend**, lo mejor en mi caos ya que **Github pages** no permite utilizar **backend** (no directamente). esta dependencia la conseguí investigando en **npmjs.com** que he citado en las fuentes.

```bash
npm install react-router-dom
```

- **npm install -D tailwindcss@^3.4.0 postcss**: El comando instala **TailWind** para el diseño y maquetado, la instrucción **"-D"** lo instala en modo **build** (son herramientas que necesito yo para el desarrollo, no el usuario final ni el despliegue), **postcss** es el plugin que lee las clases/código de Tailwind y al construir (build) lo transforma en **CSS** estatico para el sitio web, la **versión 3.4.0** es la más usada en el mercado porque es estable y tiene muchos plugins.

```bash
npm install -D tailwindcss@^3.4.0 postcss
```

- **npx tailwindcss init -p:** Ahora que ya se ha instalado **tailwind** con **postcss** necesitamos ejecutarlo/inicializarlo para que genere sus archivos de configuración, uno de **tailwind** y otro de **postcss** que usaremos para configurar ambos, cuando llegue el momento, si es que es necesario.

```bash
npx tailwindcss init -p
```

# **Paso N.º4 - Entender el proyecto**

Ahora que hemos inicializado el proyecto, instalado nuestras dependencias, etc, queda dentro del directorio escogido la
siguiente estructura:

* **(directorio raíz) clases-particulares**
    * **(directorio) src:** Es donde escribimos código, contiene toda la estructura del proyecto, dentro de el podemos encontrar los archivos más importantes.
        * **main.tsx:** Es el punto de entrada del proyecto.
        * **App.tsx:** Componente principal de la aplicación, aquí va, por ejemplo, el routing del sitio web.
        * **App.css:** Estilos principales del componente del mismo nombre.
        * **index.css:** Estilos globales de toda la aplicación en general.
        * **(directorio) assets:** Aquí se guardan todos los archivos de uso general de la aplicación (imagenes, iconos, pdf, etc).
    * **package.json:** En forma de **JSON** aquí se encuentran las dependencias y sus versiones (React Router DOM, Tailwind CSS, etc).
    * **postcss.config.js:** Configuración del plugin **POSTCSS** que convierte clases de Tailwind a CSS estatico.
    * **tailwind.config.js:** Configuración de **TailWind CSS** indicando las rutas de los archivos de estilos.
    * **tsconfig.app.json:** Configuración de **TypeScript** en terminos de comportamiento (stric mode, JSX, etc).
    * **tsconfig.json:** Configuración de **TypeScript** en terminos de referencias a otros configs.
    * **vite.config.ts:** Configuración especifica de **Vite**, por ejemplo, en nuestro caso, elegir **SWC** como compilador, etc.

Recordemos que este paso es el entendimiento de la estructura inicial y el que de cada cosa, pero a mayoría que nos adentremos surgiran cambios, un ejemplo es el **Paso N.º7** donde defino una estructura escalable de directorios dentro de **"src"**.

# **Paso N.º5 - Configurar VITE para Github Pages**

Recordemos que **Github Pages** intenta cargar/servir desde la raíz del repositorio todos los archivos del despliegue (HTML, CSS, JS, etc), por eso es importarte decirle a **Vite** desde cual base (ruta) debe servir/cargar los archivos, el archivo original se ve así:

```ts
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
})
```

Agregamos una nueva linea después de plugins con el nombre del directorio/proyecto, quedando de la siguiente forma:

```ts
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  // Base/ruta principal del proyecto con React.
  base: "/clases-particulares",
})
```

# **Paso N.º6 - Configurar TailWind**

Cuando inicializamos por primera vez **TailWind** en los paso anteriores se genero un archivo de configuración llamado **tailwind.config.js** el cual, originalmente se ve así:

```js
/** @type {import('tailwindcss').Config} */
export default {
  content: [],
  theme: {
    extend: {},
  },
  plugins: [],
}
```

Dentro de **content** tenemos que decirle a **TailWind** que tipo de archivos (especificos por nombre o por tipo) tiene que leer buscando clases TailWind que deban ser leidas, interpretadas y (con **PostCSS**) compiladas y convertidas a CSS estatico, por eso, queda así:

```js
/** @type {import('tailwindcss').Config} */
export default {
  /*
  Incluimos todos los archivos de SRC de extensión JS/TS/JSX/TSX
  y el index.html principal del proyecto.
   */
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}"
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}
```

Hecho esto, tenemos que ir al directorio **src** y modificar el **index.css** donde tendremos que remplazar el contenido que haya por defecto con las importaciones/inclusiones de **tailwind**, quedando el archivo de la siguiente forma:

```css
@tailwind base;
@tailwind components;
@tailwind utilities;
```

# **Paso N.º7 - Definir la estructura del proyecto**

Este paso ha sido facíl porque hay docenas de sitios webs que recomiendan diferente tipo de estructuras, en el apartado de **fuentes** he dejado las dos que más me han gustado señalando una estructura muy común en la comunidad escalable, la cual se ve de la siguiente forma:

```bash
src/
├─── components/ # Componentes reutilizables (Header, Footer, Card, etc.)
├─── pages/ # Páginas principales de la aplicación (Home, Lenguaje, etc.)
├─── data/ # Metadatos y datos estáticos (JSON generados de los directorios)
├─── hooks/ # Custom hooks de React (useContent, useLanguage, etc.)
├─── types/ # Definiciones de tipos TypeScript
├─── utils/ # Funciones utilitarias (helpers, formatters, etc.)
├─── assets/ # Recursos estáticos (imágenes, iconos, PDFs, etc.)
├─── App.tsx # Componente principal con routing
├─── App.css # Estilos del componente App
├─── main.tsx # Punto de entrada de la aplicación
└─── index.css # Estilos globales (con directivas de Tailwind)
```

Si te gusta este arbol de directorios se puede conseguír desde una terminal de comandos en el directorio desde el que quieres generarlo con el comando **"tree -d"**.

# **Paso N.º8 - Configurar el routing (redireccionamiento)**

Uno de los limites de **Github pages** es que no permiten el uso directo de **backend** (se puede arreglar con, por ejemplo, **firebase** u otras soluciones), pero yo he decidio dejar el manejo de toda la logica del **lado cliente** (estudiantes de **DAW** sabreís que hay una asignatura con este nombre), por eso hemos instaldo antes **react routing dom (dependencia)**.

Para esto debemos a entender los principios basicos del routing que ennumero a continuación en forma de pasos a seguir.

## **1. Crear los tipos del proyecto:** 

En mi caso, el sitio web entero va de ofrecer a mis alumnos material educativo (ejercicios, teoría, practica, test) de los diferentes lenguajes de programación que enseño, entonces debo crear una estructura llamada **Languages** para identificar y describir cada uno, ademñas, todos los lenguajes que enseño tienen ejercicios, por lo tanto creo una interfaz **Excercise** que relaciona 1 o varios ejercicios con "X" lenguaje, para ello dentro de **src > types** creamos un archivo **index.ts** con el siguiente contenido:

```ts
export interface Language {
    id: string;
    name: string;
    icon: string;
    description: string;
    path: string;
}

export interface Exercise {
    id: string;
    title: string;
    file: string;
    language: string;
}
```

## **2. Crear al menos dos paginas de ejemplo**

Ahora, ya tengo las dos estructuras iniciales, vamos a crear la pagina principal del sitio web y por ejemplo la de **Java** (mi lenguaje de programación favorito), para ello en el directorio **src > pages** creamos dos archivos, por ejemplo:

- **HomePage.tsx:** Pagina principal de nuestra aplicación **SPA**.
- **JavaPage.tsx:** Pagina principal del lenguaje **Java**.

```bash
src/
├───pages/
    ├───HomePage.tsx
    └───JavaPage.tsx
```

**NOTA SUPER IMPORTANTE:** Somos desarrolladores full-stack (en teoría), no se puede hacer sitios web de la nada (no si somos juniors), te recomiendo primero **maquetar** por ejemplo, en figma y luego con la maqueta a un lado intentar crearla del otro lado probando poco a poco que hace cada una de las clases que ofrece **TailWind**, en **fuentes** te he dejado un **playground** oficial de ellos para probar en tiempo real que hace cada cosa, también puedes probar a diseñar en **Figma** (en modo movil siempre porque Tailwind es **first-mobile** por defecto), lo que menos aconsejo es meterse de cabeza a escribír código porque se vuelve más larga la curva de aprendizaje, si os vaís a **fuentes** podeís ver también el **taildwind cheat sheet** que explica todas las clases de taildwind.

En **React** y sobretodo haciendo **SPA** las paginas se cargan solo en el momento en el que son llamadas, por eso son funciones, aunque haré más paginas os dejo los ejemplos sencillos de la pagina de **HomePage.tsx** y **JavaPage.tsx**:

### **HomePage.tsx**

```ts
function HomePage() {
    // La función invocada devuelve código cargable/leible.
    return (
        <div className="min-h-screen p-8">
            <h1 className="text-4xl font-bold text-center m-8">
                Portal de clases particulares de Agustín
            </h1>
            <p className="text-center m-8">
                ¡Bienvenido! Elige el tema en el que estás interesado.
            </p>
        </div>
    );
}
```

### **JavaPage.tsx**

```ts
function JavaPage() {
    // La función invocada devuelve código cargable/leible.
    return (
        <div className="min-h-screen p-8">
            <h1 className="text-4xl font-bold text-center m-8">
                Clases particulares de Java y contenido
            </h1>
            <p className="text-center m-8">
                ¡Has elegido mi lenguaje favorito! Ahora, sientete libre de explorar el contenido disponible.
            </p>
        </div>
    );
}
```

Estos son meros diseños de prueba, para ver que todo funcione bien, poco más, si usas est guía para tus propios proyectos debe maquetar que quieres que vean tus usarios y como quieres que lo vean y luego plasmarlos aquí, en los componentes/paginas de **react**.

## **3. Configurar el routing en App.tsx**

Recordemos que anteriormente dijimos que **App.tsx** es el punto de entrada de toda la aplicación, desde ahí debemos configurar el **routing** de nuestra **SPA**, por defecto viene así:

```tsx
import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App
```

Es la vista por defecto con un pequeño contador que muestra el logo de **React** y de **Vite**, nos lo cargamos todo completo el archivo y lo hacemos de cero de la siguiente forma:

```tsx
// Importamos todos los componentes de react-router-dom
import { BrowserRouter, Routes, Route } from "react-router-dom";
// Importamos las paginas que hemos creado para la demo.
import HomePage from "./pages/HomePage";
import JavaPage from "./pages/JavaPage";

// Creamos la función "App" encargada de manejar toda la logica de redireccionamiento.
function App () {
  return (
    // Activamos el enrutamiento (routing) de la aplicación.
    <BrowserRouter>
      {/* Dentro de BrowserRouter indicamos las rutas que existen.*/}
      <Routes>
        {/* Definimos las rutas (URL) y los componentes que cargan, ejemplo con la URL "/"*/}
        <Route path="/" element={<HomePage />}></Route>
        {/* Otro ejemplo, si la URL es "/java" carga el componente (page) JavaPage.tsx*/}
        <Route path="/java" element={<JavaPage />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

// Exportamos esta función para que "main.tsx" pueda utilizarla.
export default App;
```

# **Guía rapida de TailWind**

- **"min-h-screen":** Altura minima del elemento en la pantalla, por defecto, 100%.
- **"p":** padding (separación desde el interior hacía todos los lados), ejemplo "p-8".
- **mb:** margin-bottom (margen/separación inferior de algo), ejemplo "mb-8".
- **"bg-color-num":** Color del fondo (backgroun) de un elemento, en "color" ponemos un color, ejemplo, **gray** y en number cual tonalidad de **gray** queremos, ejemplo, "bg-gray-600".
- **"text-size":** Como dije antes en notas, desde el **taildwind cheat sheet** podemos ver en **font-size** los tamaños de taildwin, los más comunes, text-xs (extra small), text-sm (small), text-base (tamaño normal, 16px creo), text-xl, text-1xl, text-2xl, etc.
- **"font-weight":** El grosor, por ejemplo, "font-bold" para negrita o "font-light" para algo ligero.
- **"text-align":** Identico a CSS nativo, hay "center", "justify", etc.
- **"max-w-size":** Permite darle un tamaño maximo de ancho a un elemento, funciona con la misma nomenclatura de **font-size** (xs, sm, base, xl, 1xl, etc).
- **"mx-auto":** Define el margen vertical, en este caso automatico, lo que centra el elemento horizontalmente según el contenedor padre.


# **Fuentes**

- [**Guía oficial de Vite**](https://es.vite.dev/guide): Guía oficial de **Vite** donde podemos apreciar conceptos básicos del mismo, la creación/inicialización de un proyecto, etc.
- [**NPMJS**](https://www.npmjs.com): Guía de paquetes/dependencias más utilizadas/descargadas en entornos de **JavaScript/TypeScript**.
- [**React Router DOM**](https://www.npmjs.com/package/react-router-dom): Dependencia que permite un redireccionamiento (**routing**) del lado cliente de nuestra aplicación.
- [**Tailwind CSS - Instalación**](https://tailwindcss.com/docs/installation): Documentación oficial a modo de guía sobre cómo instalar y utilizar **Tailwind CSS**.
- [**Tutoriales Markdown**](https://www.markdowntutorial.com/es/): Guía/tutoriales con teoría y práctica sobre cómo usar **Markdown**.
- [**Recomendación de estructura para proyectos react N.º1**](https://dev.to/shubhadip_bhowmik/best-folder-structure-for-react-complex-projects-432p): Recomendación de organización y creación de directorios para proyectos con **React** de **dev.to**.
- [**Recomendación de estructura para proyectos react N.º2**](https://javascript.plainenglish.io/react-project-folder-structure-that-actually-scales-2025-6dbd5f41767f): Recomendación de organización y creacios de directorios para proyecto con **React** de **javascript.plainenglish.io**
- [**Sandbox de TailWind**](https://play.tailwindcss.com): Sitio web oficial de TailWind para practicar que hacen sus diferentes clases y aprender a usarlo.
- [**TailWind Cheat Sheet**](https://nerdcave.com/tailwind-cheat-sheet): Guía facíl y rapida de clases de Tailwind, su sintaxis y que hace dada una.
- [****]():
