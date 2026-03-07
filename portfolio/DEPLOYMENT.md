# **Lista de objetivos**

## **Configuración inicial**
- [X] Inicializar el proyecto con **REACT** + **TYPESCRIPT** + **VITE**.
- [X] Instalar dependencia para routing. (**React router DOM**).
- [X] Instalar dependencia para estilos. (**TailWindCSS & PostCSS & Autoprefixer**).
- [X] Configurar la base/ruta de carga de **Vite**.
- [X] Configurar la carga/lectura de archivos de **TailWind**. 
- [X] Configurar colores personalizados en **TailWind** (evergreen, lavender, fawn, etc.).

## **Estructura y tipos**
- [X] Crear la estructura del proyecto (directorios en src).
- [X] Crear tipos TypeScript (**Language**, **Exercise**).
- [X] Crear datos de lenguajes (**languages.ts** con todos los lenguajes e iconos).

## **Componentes base**
- [X] Configurar el routing de la aplicación en **App.tsx**.
- [X] Crear el componente **Header.tsx** con navegación usando **\<Link>** de **React Router DOM**.
- [X] Crear el componente **Footer.tsx**.
- [X] Crear el componente **LanguageCard.tsx** para mostrar tarjetas de lenguajes.
- [X] Configurar layout flex en **index.html** (body con flex flex-col).
- [X] Configurar layout flex en **App.tsx** (main con flex-grow).

## **Páginas**
- [X] Crear **HomePage.tsx** (estructura básica).
- [X] Implementar grid de lenguajes en **HomePage.tsx** (usando LanguageCard).
- [X] Página índice por lenguaje: **LanguagePage.tsx** reutilizable para /java, /python, /c, etc. (sustituye a JavaPage).

## **Funcionalidad principal**
- [X] Mejorar **Footer.tsx** (enlaces a GitHub, GitHub Pages, copyright, créditos técnicos).
- [X] Una sola **LanguagePage** para todos los lenguajes (ruta /:languageId); no hace falta una página por lenguaje.

## **Sistema de lecciones (Java y reutilizable)**
- [X] Crear interfaz **Lesson** en **types/index.ts** (con opcional `completed` en ejercicios).
- [X] Crear **data/lessons.ts** con lecciones (4 de Java: java-1 a java-4) y helpers (getLessonsByLanguage, getLessonById).
- [X] Crear **LessonCard.tsx** (tarjeta por lección que enlaza a /lesson/:lessonId).
- [X] Crear **LessonsGrid.tsx** (grid reutilizable de lecciones usado por LanguagePage).
- [X] Crear **CodeBlock.tsx** (bloque de código con botón Copiar para LessonPage).
- [X] Crear **LessonPage.tsx** (página reutilizable para cualquier lección; barra de progreso, secciones, ejercicios, PDF, navegación).
- [X] Crear **LanguagePage.tsx** y **getLanguageById** en **data/languages.ts**; ruta **/:languageId** en **App.tsx**.
- [X] Añadir ruta **/lesson/:lessonId** y enlace a Material Icons en **index.html**.

## **MVP (Mínimo Producto Viable)**
- [X] Completar MVP: HomePage con grid funcional de todos los lenguajes.
- [X] Navegación completa: Inicio → Java → Lecciones → Lección individual (y Volver / Siguiente).
- [ ] Verificar responsive design en diferentes tamaños de pantalla.

# **Paso N.º1 - Inicializar REACT + VITE**

En el encabezado de **fuentes** he dejado la información teórica y básica de **Vite** para un entendimiento más profundo de la inicialización/creación del entorno de **React + Vite**. Debemos ejecutar los siguientes comandos siguiendo las instrucciones dadas a continuación:

### **npm create vite@latest**

Desde la raíz del repositorio/directorio ejecutamos el comando. Esto permite crear/instalar la última versión de **VITE**, elegimos el nombre del proyecto, en mi caso **clases-particulares**, luego elegimos **React** como framework y en las variantes disponibles elegimos **TypeScript + SWC** (SWC es un compilador muy rápido, gracias Aitor por enseñarme qué es y cómo funciona), si aparecen más preguntas como **rollup-vite (Experimental)** decimos que no y en **Install with npm and start now** da un poco igual, podemos decir que sí sin problema, antes de ejecutar el siguiente comando nos desplazamos de directorio, lee bien la instrucción del siguiente comando.

```bash
npm create vite@latest
```

# **Paso N.º2 - Instalar dependencias nativas**

### **npm install**

Para ejecutar este comando es necesario desplazarnos dentro del directorio donde hemos instalado **React + Vite**, abrimos ahí una terminal y ejecutamos el comando que instalará/actualizará dependencias.

```bash
npm install
```

# **Paso N.º3 - Instalar dependencias adicionales**

Este paso es muy importante, recuerdas, estás creando tu proyecto, es importante saber qué dependencias vamos a elegir para facilitarnos el trabajo porque si no, tienes dos opciones, **crear tú mismo todo desde cero** lo cual toma tiempo o **utilizar librerías ya existentes** lo cual nos ahorra mucho tiempo, mi profesor Jaime decía "¿Para qué inventar la rueda otra vez si ya existe?".

Yo elegí las siguientes dependencias, recuerda, como ya hemos creado/inicializado **REACT + VITE** tenemos que desplazarnos dentro del directorio del proyecto y desde ahí ejecutar en una terminal los siguientes comandos:

- **npm install react-router-dom:** Permite que el **routing** (redireccionamiento) dentro del proyecto sea del lado del cliente y no usando un **backend**, lo mejor en mi caso ya que **Github Pages** no permite utilizar **backend** (no directamente). Esta dependencia la conseguí investigando en **npmjs.com** que he citado en las fuentes.

```bash
npm install react-router-dom
```

- **npm install -D tailwindcss@^3.4.0 postcss autoprefixer**: El comando instala **TailWind** para el diseño y maquetado, la instrucción **"-D"** lo instala en modo devDependencies (son herramientas que necesito yo para el desarrollo, no el usuario final ni el despliegue), **postcss** es el plugin que lee las clases/código de Tailwind y al construir (build) lo transforma en **CSS** estático para el sitio web, **autoprefixer** es una dependencia requerida por PostCSS que agrega automáticamente los prefijos de navegadores necesarios para compatibilidad (como -webkit-, -moz-, etc.), la **versión 3.4.0** de Tailwind es la más usada en el mercado porque es estable y tiene muchos plugins.

```bash
npm install -D tailwindcss@^3.4.0 postcss autoprefixer
```

- **npx tailwindcss init -p:** Ahora que ya se ha instalado **tailwind** con **postcss** y **autoprefixer** necesitamos ejecutarlo/inicializarlo para que genere sus archivos de configuración, uno de **tailwind** y otro de **postcss** que usaremos para configurar ambos. **IMPORTANTE:** El archivo `postcss.config.js` que se genera automáticamente incluye `autoprefixer` en su configuración, por lo que es **necesario** haberlo instalado previamente, de lo contrario obtendrás un error al ejecutar `npm run dev`.

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
        * **(directorio) assets:** Aquí se guardan todos los archivos de uso general de la aplicación (imágenes, iconos, pdf, etc).
    * **package.json:** En forma de **JSON** aquí se encuentran las dependencias y sus versiones (React Router DOM, Tailwind CSS, etc).
    * **postcss.config.js:** Configuración del plugin **POSTCSS** que convierte clases de Tailwind a CSS estático.
    * **tailwind.config.js:** Configuración de **TailWind CSS** indicando las rutas de los archivos de estilos.
    * **tsconfig.app.json:** Configuración de **TypeScript** en términos de comportamiento (strict mode, JSX, etc).
    * **tsconfig.json:** Configuración de **TypeScript** en terminos de referencias a otros configs.
    * **vite.config.ts:** Configuración específica de **Vite**, por ejemplo, en nuestro caso, elegir **SWC** como compilador, etc.

Recordemos que este paso es el entendimiento de la estructura inicial y el qué de cada cosa, pero a medida que nos adentremos surgirán cambios, un ejemplo es el **Paso N.º7** donde defino una estructura escalable de directorios dentro de **"src"**.

# **Paso N.º5 - Configurar VITE para Github Pages**

Recordemos que **Github Pages** intenta cargar/servir desde la raíz del repositorio todos los archivos del despliegue (HTML, CSS, JS, etc), por eso es importante decirle a **Vite** desde cuál base (ruta) debe servir/cargar los archivos, el archivo original se ve así:

```ts
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
})
```

Agregamos una nueva línea después de plugins con el nombre del directorio/proyecto, quedando de la siguiente forma:

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

Cuando inicializamos por primera vez **TailWind** en los pasos anteriores se generó un archivo de configuración llamado **tailwind.config.js** el cual, originalmente se ve así:

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

Dentro de **content** tenemos que decirle a **TailWind** qué tipo de archivos (específicos por nombre o por tipo) tiene que leer buscando clases TailWind que deban ser leídas, interpretadas y (con **PostCSS**) compiladas y convertidas a CSS estático, por eso, queda así:

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

Hecho esto, tenemos que ir al directorio **src** y modificar el **index.css** donde tendremos que reemplazar el contenido que haya por defecto con las importaciones/inclusiones de **tailwind**, quedando el archivo de la siguiente forma:

```css
@tailwind base;
@tailwind components;
@tailwind utilities;
```

# **Paso N.º7 - Definir la estructura del proyecto**

Este paso ha sido fácil porque hay docenas de sitios web que recomiendan diferentes tipos de estructuras, en el apartado de **fuentes** he dejado las dos que más me han gustado señalando una estructura muy común en la comunidad escalable, la cual se ve de la siguiente forma:

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

Si te gusta este árbol de directorios se puede conseguir desde una terminal de comandos en el directorio desde el que quieres generarlo con el comando **"tree -d"**.

# **Paso N.º8 - Configurar el routing (redireccionamiento)**

Uno de los límites de **Github Pages** es que no permiten el uso directo de **backend** (se puede arreglar con, por ejemplo, **Firebase** u otras soluciones), pero yo he decidido dejar el manejo de toda la lógica del **lado cliente** (estudiantes de **DAW** sabréis que hay una asignatura con este nombre), por eso hemos instalado antes **react-router-dom (dependencia)**.

Para esto debemos entender los principios básicos del routing que enumero a continuación en forma de pasos a seguir.

## **1. Crear los tipos del proyecto:** 

En mi caso, el sitio web entero va de ofrecer a mis alumnos material educativo (ejercicios, teoría, práctica, test) de los diferentes lenguajes de programación que enseño, entonces debo crear una estructura llamada **Language** para identificar y describir cada uno, además, todos los lenguajes que enseño tienen ejercicios, por lo tanto creo una interfaz **Exercise** que relaciona 1 o varios ejercicios con "X" lenguaje, para ello dentro de **src > types** creamos un archivo **index.ts** con el siguiente contenido:

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

Ahora, ya tengo las dos estructuras iniciales, vamos a crear la página principal del sitio web y por ejemplo la de **Java** (mi lenguaje de programación favorito), para ello en el directorio **src > pages** creamos dos archivos, por ejemplo:

- **HomePage.tsx:** Página principal de nuestra aplicación **SPA**.
- **JavaPage.tsx:** Página principal del lenguaje **Java**.

```bash
src/
├───pages/
    ├───HomePage.tsx
    └───JavaPage.tsx
```

**NOTA SUPER IMPORTANTE:** Somos desarrolladores full-stack (en teoría), no se puede hacer sitios web de la nada (no si somos juniors), te recomiendo primero **maquetar** por ejemplo, en **Figma** y luego con la maqueta a un lado intentar crearla del otro lado probando poco a poco qué hace cada una de las clases que ofrece **TailWind**, en **fuentes** te he dejado un **playground** oficial de ellos para probar en tiempo real qué hace cada cosa, también puedes probar a diseñar en **Figma** (en modo móvil siempre porque Tailwind es **mobile-first** por defecto), lo que menos aconsejo es meterse de cabeza a escribir código porque se vuelve más larga la curva de aprendizaje, si vais a **fuentes** podéis ver también el **tailwind cheat sheet** que explica todas las clases de **tailwind**.

En **React** y sobre todo haciendo **SPA** las páginas se cargan solo en el momento en el que son llamadas, por eso son funciones, aunque haré más páginas os dejo los ejemplos sencillos de la página de **HomePage.tsx** y **JavaPage.tsx**:

### **HomePage.tsx**

```ts
function HomePage() {
    // La función invocada devuelve código cargable/leible.
    return (
        <div className="min-h-screen bg-lavender p-8">
            <h1 className="text-4xl font-bold text-center m-8 text-evergreen">
                Portal de clases particulares de Agustín
            </h1>
            <p className="text-center m-8 text-slate-grey text-lg">
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
        <div className="min-h-screen bg-lavender p-8">
            <h1 className="text-4xl font-bold text-center m-8 text-evergreen">
                Clases particulares de Java y contenido
            </h1>
            <p className="text-center m-8 text-slate-grey text-lg">
                ¡Has elegido mi lenguaje favorito! Ahora, **siéntete** libre de explorar el contenido disponible.
            </p>
        </div>
    );
}
```

Estos son meros diseños de prueba, para ver que todo funcione bien, poco más, si usas esta guía para tus propios proyectos debes maquetar qué quieres que vean tus usuarios y cómo quieres que lo vean y luego plasmarlos aquí, en los componentes/páginas de **React**.

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
// Importamos las páginas que hemos creado para la demo.
import HomePage from "./pages/HomePage";
import JavaPage from "./pages/JavaPage";
// Importamos el componente de navegación
import Header from "./components/Header";

// Creamos la función "App" encargada de manejar toda la lógica de redireccionamiento.
function App() {
  return (
    // Activamos el enrutamiento (routing) de la aplicación.
    <BrowserRouter>
      {/* Barra de navegación global */}
      <Header />
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

Si lo explicamos de la forma más junior posible es que **BrowserRouter** activa la dependencia de enrutamiento/redireccionamiento **react-router-dom**, **Routes** es simplemente la etiqueta utilizada para agrupar una o varias rutas y **Route** es la etiqueta que define la URL de la ruta y el elemento/componente que debe cargar nuestra **SPA** en caso de ser utilizada.

## **4. Crear navegación con Link**

El HTML tradicional es muy limitado a la hora de diseñar **SPA**, en nuestro caso, queremos evitar la recarga completa del sitio web en el intercambio de rutas, por eso, la etiqueta nativa HTML **`<a href="ruta">`** no nos sirve, la buena noticia es que **React Router DOM** incluye una etiqueta propia la cual es **`<Link to="ruta">`** que permite cambiar dinámicamente, sin recarga completa, la ruta de la **SPA**, perfecta para nosotros.

Como **App.tsx** es el encargado de (dinámicamente) mostrar el contenido dependiendo de la ruta cargando el componente específico de cada una, tiene que contar con este "menú de navegación" usando **Link**, por lo tanto, diseñamos un componente reutilizable para ello dentro del directorio **components** llamándolo **Header.tsx** que queda de la siguiente forma:

```tsx
import { Link } from "react-router-dom";

function Header() {
    return (
        <header>
            <nav className="bg-evergreen text-lavender p-4 shadow-md">
                <div className="container mx-auto flex justify-between items-center">
                    <Link to="/" className="text-xl font-bold hover:text-fawn transition-colors">
                        Clases Particulares
                    </Link>
                    <div className="space-x-4">
                        <Link to="/" className="hover:text-fawn transition-colors">Inicio</Link>
                        <Link to="/java" className="hover:text-fawn transition-colors">Java</Link>
                    </div>
                </div>
            </nav>
        </header>
    );
}

export default Header;
```

**NOTA:** Es importante usar `<Link to>` en lugar de `<a href>` para evitar recargas completas de la página y mantener la navegación fluida de la SPA.
# **Paso N.º9 - Agregar los iconos necesarios para los datos**

Este paso en teoría debería ser el N.º10 y viceversa, el N.º10 debería ser el N.º9, pero me dije a mí mismo, **al definir los datos de los lenguajes necesitas la URL de las imágenes/iconos que usarás para representarlos**, así que, **¿Por qué dejar para mañana lo que puedes hacer hoy?**.

Para ello, desde **src** navegamos hasta **assets** y creamos ahí el directorio **icons** donde subiremos (de preferencia SVG) los iconos que representarán los lenguajes que imparto en clases.

<<<<<<< HEAD
En el encabezado **fuentes** de este documento dejo el enlace a la librería gratuita de **SVG** que yo he utilizado para bajarme los iconos, la única pega es que trae 2019 iconos SVG/EPS pero yo no necesito tantos, sumando los frameworks, lenguajes base y tecnologías que se utilizan y he enseñado llego a 109, por lo tanto, actualizamos nuestro **.gitignore** para excluir todos excepto los que nos interesan, quedando así el apartado de iconos del .gitignore:

```bash
# Excluir todos los SVG y EPS para luego elegir manualmente los que quiero.
*.svg

# Incluir los SVG que me interesan de los lenguajes que imparto.
!src/assets/icons/java/
!src/assets/icons/python/
!src/assets/icons/c/
!src/assets/icons/cplusplus/
!src/assets/icons/csharp/
!src/assets/icons/php/
!src/assets/icons/mysql/
!src/assets/icons/kotlin/
!src/assets/icons/typescript/
!src/assets/icons/javascript/
!src/assets/icons/html5/
!src/assets/icons/css3/
!src/assets/icons/xml/
!src/assets/icons/json/

# Frameworks y librerías Frontend
!src/assets/icons/react/*
!src/assets/icons/reactnative/*
!src/assets/icons/angular/*
!src/assets/icons/angularjs/*
!src/assets/icons/vite/*
!src/assets/icons/vitejs/*
!src/assets/icons/astro/*
!src/assets/icons/tailwindcss/*
!src/assets/icons/nodejs/*
!src/assets/icons/express/*
!src/assets/icons/npm/*
!src/assets/icons/yarn/*

# Frameworks Backend PHP
!src/assets/icons/laravel/*
!src/assets/icons/symfony/*
!src/assets/icons/composer/*

# Frameworks Java
!src/assets/icons/spring/*
!src/assets/icons/gradle/*
!src/assets/icons/maven/*

# Herramientas de desarrollo
!src/assets/icons/git/*
!src/assets/icons/github/*
!src/assets/icons/gitlab/*
!src/assets/icons/vscode/*
!src/assets/icons/intellij/*
!src/assets/icons/androidstudio/*

# Bases de datos
!src/assets/icons/postgresql/*
!src/assets/icons/sqlite/*
!src/assets/icons/mongodb/*

# Herramientas de build y deployment
!src/assets/icons/docker/*
!src/assets/icons/cmake/*
!src/assets/icons/expo/*

# Mobile
!src/assets/icons/android/*

# Excluimos todos los EPS porque no los usaré.
*.eps
```
# **Paso N.º10 - Crear los datos (lenguajes) de la SPA**

Ahora ya tenemos un **MVP** (algo parecido), es hora de utilizar la interfaz que diseñamos que define los campos que deben tener los lenguajes de programación de los que imparto clases así como la relación que tienen los ejercicios con los mismos, para eso, desde el directorio **src** creamos un subdirectorio llamado **data** y ahí creamos el archivo **languages.ts** el cual importa la interfaz `Language`, en el siguiente fragmento muestro, por ejemplo, cómo se ve solo con los datos de **Java** aunque, por supuesto, tengo que agregarlos todos y puedes ver el archivo completo finalizado:

```ts
// Importación de la interfaz que define los tipos de lenguajes y sus datos.
import type { Language } from "../types";
// Los iconos SVG se deben importar de esta forma si no, no compilan bien.
import javaIcon from "../assets/icons/java/java-original.svg";

export const languages: Language[] = [
    // Ejemplo con el lenguaje de Java.
    {
        id: "java",
        name: "Java",
        // Fijaros que el icono y su ruta son previamente importados y usados aquí.
        icon: javaIcon,
        description: "Programación orientada a objetos (POO), Swing, JavaFX, JDBC, Spring y más",
        path: "/java"
    },
    // El resto de lenguajes...
]
```

# **Paso N.º11 - Maquetado web inicial y correcciones**

Anteriormente trabajé como **especialista SEO/SEM** antes de aprender a programar y entendí (en su momento) la importancia de una buena ortografía, semántica, etc, por eso, incorporé las **etiquetas** **HTML** de **header, footer y main** para seccionar el contenido de nuestra **SPA**, lo primero, como todo nuestro diseño está basado en flex modifiqué el **index.html** del proyecto para incorporar la clase TailWind necesaria para utilizarlo y aproveché de cambiar el **lang** de inglés a español.

```html
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <link rel="icon" type="image/svg+xml" href="/vite.svg" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>clases-particulares</title>
  </head>
  <!--
  Explicación de los estilos incorporados a todo el cuerpo de la SPA (excepto el color de fondo que se entiende que es).

  1. min-h-screen: el "body" (cuerpo) HTML ocupa como altura mínima el 100% de la pantalla visible.
  
  2. flex: Activamos "flex" en nuestra SPA para estructuración.
  
  3. flex-col: Flex tiene modo "fila" y "columna", elegimos columna para representar todo el contenido de nuestro sitio web en forma de columna de arriba hacia abajo.
  -->
  <body class="bg-lavender min-h-screen flex flex-col">
    <div id="root"></div>
    <script type="module" src="/src/main.tsx"></script>
  </body>
</html>
```

Ahora recordemos que **App.tsx** es quien (dinámicamente) "pinta" (renderiza) el contenido que queremos ver en la **SPA** dependiendo de la **URL**, por lo tanto, creamos en él la **etiqueta** **HTML** llamada **`<main>`** y le agregamos la clase **flex-grow** que hará que el main, incluso sin contenido, ocupe todo el espacio posible que no ocupen el resto de elementos como **header** o **footer**, esto por ejemplo, empuja el **footer** hacia abajo, actualmente se ve así:

```tsx
import { BrowserRouter, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage";
import JavaPage from "./pages/JavaPage";
import Header from "./components/Header";
import Footer from "./components/Footer";

function App() {
  return (
    <BrowserRouter>
      <Header />
      {/* Usamos la etiqueta HTML main para mejorar el SEO. */}
      <main className="flex-grow">
      <Routes>
        <Route path="/" element={<HomePage />}></Route>
        <Route path="/java" element={<JavaPage />}></Route>
      </Routes>
      </main>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
```

De esta forma toda la **SPA** siempre utilizará en el cuerpo (body) flex como forma de estructura y organización y el **main** siempre ocupará todo el espacio disponible que no ocupen el **header** y el **footer**, garantizando empujar ambos, **footer** y **header** hacia sus respectivas direcciones.

# **Paso N.º12 - Crear el componente "LanguageCard"**

Cuando llegamos aquí ya tenemos una aplicación visible, si la corremos, podemos ver la página principal, el footer y header básicos que hemos diseñado y maquetado, ahora, el contenido de la etiqueta HTML **`<main></main>`** es el que cambia dinámicamente en nuestra **SPA**, desde la **URL** base he decidido que quiero mostrar un grid ("tabla") con todos los lenguajes disponibles en mi plataforma educativa, los elementos dentro de estos serán clicables.

Para crear el componente **LanguageCard**, creamos un archivo **LanguageCard.tsx** dentro del directorio **src/components** con el siguiente contenido:

```tsx
import { Link } from 'react-router-dom';
import type { Language } from '../types';

interface LanguageCardProps {
    language: Language;
}

function LanguageCard({ language }: LanguageCardProps) {
    return (
        <Link 
            to={language.path}
            className="block bg-white rounded-lg shadow-md p-6 hover:shadow-xl transition-all duration-300 border border-gray-200 hover:border-evergreen group"
        >
            <div className="text-center">
                <div className="flex justify-center mb-4">
                    <img 
                        src={language.icon} 
                        alt={`${language.name} icon`}
                        className="w-16 h-16 object-contain group-hover:scale-110 transition-transform duration-300"
                    />
                </div>
                <h3 className="text-2xl font-bold text-evergreen mb-2">
                    {language.name}
                </h3>
                <p className="text-slate-grey text-sm leading-relaxed">
                    {language.description}
                </p>
            </div>
        </Link>
    );
}

export default LanguageCard;
```

Este componente recibe un objeto `Language` como prop y renderiza una tarjeta clickeable que navega a la página del lenguaje correspondiente usando `Link` de React Router DOM.

# **Paso N.º13 - Implementar el grid en HomePage**

Ahora actualizamos **HomePage.tsx** para mostrar todas las tarjetas de lenguajes en un grid responsive:

```tsx
import { languages } from '../data/languages';
import LanguageCard from '../components/LanguageCard';

function HomePage() {
    return (
        <div className="bg-lavender p-8">
            <div className="container mx-auto">
                <h1 className="text-4xl font-bold text-center m-8 text-evergreen">
                    Portal de clases particulares de Agustín
                </h1>
                <p className="text-center m-8 text-slate-grey text-lg mb-12">
                    ¡Bienvenido! Elige el tema en el que estás interesado.
                </p>
                
                {/* Grid de lenguajes - Responsive */}
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
                    {languages.map((language) => (
                        <LanguageCard key={language.id} language={language} />
                    ))}
                </div>
            </div>
        </div>
    );
}

export default HomePage;
```

El grid es responsive: 1 columna en móvil, 2 en tablet, 3 en desktop y 4 en pantallas grandes.

# **Paso N.º14 - Sistema de lecciones (Java y reutilizable)**

Se implementó un sistema de lecciones reutilizable para que cualquier lenguaje (Java primero, luego Python, etc.) pueda mostrar un índice de lecciones y una página de lección individual sin duplicar código.

**Resumen de lo creado:**

1. **types/index.ts**  
   - La interfaz **Lesson** ya existía; se añadió el campo opcional `completed?: boolean` en cada ejercicio para marcar si está completado (solo UI).

2. **data/lessons.ts**  
   - Array **lessons** con todas las lecciones (por ahora 2 de Java: java-1, java-2).  
   - **getLessonsByLanguage(languageId)**: devuelve las lecciones de un lenguaje, ordenadas por `part`.  
   - **getLessonById(lessonId)**: devuelve una lección por su ID (para la ruta `/lesson/:lessonId`).

3. **components/LessonCard.tsx**  
   - Tarjeta que muestra parte/total, título y descripción de una lección.  
   - Enlaza a `/lesson/{lesson.id}` con `<Link>`.

4. **components/LessonsGrid.tsx**  
   - Grid responsive (1/2/3 columnas) que renderiza una `LessonCard` por cada lección.  
   - Si no hay lecciones, muestra "No hay lecciones disponibles aún."  
   - Reutilizable en JavaPage, PythonPage, etc.

5. **components/CodeBlock.tsx**  
   - Muestra un bloque de código con fondo oscuro y botón "Copiar" (hover).  
   - Usado en **LessonPage** para cada sección que tenga `code`.

6. **pages/LessonPage.tsx**  
   - Página única para cualquier lección. Usa `useParams()` para leer `lessonId` y `getLessonById(lessonId)`.  
   - Si no existe la lección: mensaje y enlace "Volver a las lecciones de Java".  
   - Si existe: cabecera (part/total, título, descripción), barra de progreso, secciones de teoría + CodeBlock, bloque de ejercicios (con icono check/uncheck si tienen `completed`), enlace al PDF si existe, y pie con "Volver" y "Siguiente lección" (o "Última lección").

7. **pages/LanguagePage.tsx** (sustituye a JavaPage; ver Paso N.º15).

8. **App.tsx**  
   - Nueva ruta: `<Route path="/lesson/:lessonId" element={<LessonPage />} />`.

9. **index.html**  
   - Enlace a **Material Icons** (Google Fonts) para los iconos de secciones en LessonPage (terminal, data_object, etc.).

Con esto, la navegación queda: **Inicio** → **Java** (grid de lecciones) → **Lección** (ej. java-1) → Volver / Siguiente lección. El mismo patrón sirve para otros lenguajes añadiendo datos en **lessons.ts** y una página índice que use **LessonsGrid**.

# **Paso N.º15 - Página genérica por lenguaje (LanguagePage) y más lecciones**

Para no tener una página distinta por cada lenguaje (JavaPage, PythonPage, etc.), se creó una sola **LanguagePage** que usa la ruta dinámica **/:languageId** (ej. /java, /python, /c). Así, los 13 lenguajes del grid de inicio llevan cada uno a su página de lecciones sin crear 13 archivos.

**Cambios realizados:**

1. **data/languages.ts**  
   - Nueva función **getLanguageById(id)**: devuelve el lenguaje con ese `id` o `undefined`. La usa LanguagePage para mostrar nombre y descripción.

2. **pages/LanguagePage.tsx** (nuevo)  
   - Lee **languageId** de la URL con `useParams`.  
   - Obtiene el lenguaje con `getLanguageById(languageId)` y las lecciones con `getLessonsByLanguage(languageId)`.  
   - Si el lenguaje no existe: mensaje "Lenguaje no encontrado" y enlace a inicio.  
   - Si existe: título "Clases particulares de {nombre}", descripción del lenguaje y **LessonsGrid**. Si no hay lecciones para ese lenguaje, el grid muestra "No hay lecciones disponibles aún."

3. **App.tsx**  
   - Se eliminó la ruta fija `/java` y el uso de JavaPage.  
   - Se añadió **Route path="/:languageId"** con **LanguagePage**. El orden de rutas es: `/`, `/lesson/:lessonId`, `/:languageId` para que /lesson/java-1 no coincida con /:languageId.

4. **pages/JavaPage.tsx**  
   - Eliminado; su lógica queda cubierta por LanguagePage cuando languageId es "java".

5. **data/lessons.ts**  
   - Añadidas dos lecciones más de Java: **java-3** (Condicionales: if y switch) y **java-4** (Bucles: for y while). Quedan 4 lecciones de Java para probar el flujo "Siguiente lección".

6. **LessonPage.tsx**  
   - En "Lección no encontrada", el enlace "Volver a las lecciones" apunta a `/${languageId}` deduciendo languageId del lessonId (ej. java-1 → /java).

Resultado: desde **Inicio** se puede clicar en cualquier lenguaje (Java, Python, C, etc.) y se abre la misma estructura (título, descripción, grid de lecciones). Solo Java tiene lecciones por ahora; el resto muestra "No hay lecciones disponibles aún." Añadir contenido para otro lenguaje es solo agregar objetos en **lessons.ts** con el mismo **languageId**.

# **Preguntas comunes que yo mismo me hice**

### **¿Cómo pruebo el código que estoy haciendo?**

Existen varias formas, la mejor (para mí) es correr en modo desarrollo (**dev mode**) el proyecto lo que me permite correrlo en localhost, para ello ejecutamos el siguiente comando desde la raíz del proyecto:

```bash
npm run dev
```

¿Qué tiene de especial el modo **dev**? Son principalmente dos, los cuales nos ayudan mucho durante el desarrollo y son los siguientes:

- **Hot Module Replacement (HMR):** Todos los cambios que realice en el proyecto se muestran automáticamente en la página sin necesidad de recargar.
- **Console errors:** Todos los errores que haya en compilación o en el código aparecen en (ambos) el propio navegador web a través de la consola y en el terminal donde se ejecuta el comando.

**NOTA SUPER IMPORTANTE:** Como yo despliego desde **Github Pages** tengo que modificar la **URL** base del proyecto, para desarrollo local eso me da problemas así que modifiqué el **vite.config.ts** para que detecte el modo **dev** y utilice una ruta diferente en ese escenario, quedando de la siguiente forma:

```ts
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  // Base/ruta principal del proyecto con React.
  base: process.env.NODE_ENV === 'production' ? '/clases-particulares' : '/'})
```

**¿NODE_ENV === 'production'?** Si la respuesta es sí (modo producción), la **URL** base es **/clases-particulares** (para GitHub Pages), si no (modo desarrollo), es **/** (para localhost).

# **Guía rápida de Tailwind**

| Clase | Descripción | Ejemplo |
|-------|-------------|---------|
| `min-h-screen` | Altura mínima del elemento en la pantalla, por defecto 100% de la altura visible. | `min-h-screen` |
| `p-{n}` | Padding (separación desde el interior hacia todos los lados). El número indica el tamaño. | `p-8` (padding de 2rem en todos los lados) |
| `px-{n}` / `py-{n}` | Padding horizontal (px) o vertical (py). | `px-4 py-2` |
| `m-{n}` | Margin (separación externa hacia todos los lados). | `m-8` |
| `mx-{n}` / `my-{n}` | Margin horizontal (mx) o vertical (my). | `mx-auto` (centra horizontalmente) |
| `mt-{n}` / `mb-{n}` / `ml-{n}` / `mr-{n}` | Margin específico: top, bottom, left, right. | `mb-8` (margin-bottom de 2rem) |
| `bg-{color}-{n}` | Color del fondo (background). Puede ser color estándar o personalizado. | `bg-gray-600`, `bg-evergreen`, `bg-lavender` |
| `text-{color}-{n}` | Color del texto. Puede ser color estándar o personalizado. | `text-white`, `text-evergreen`, `text-slate` |
| `text-{size}` | Tamaño de fuente. Tamaños comunes: xs, sm, base, lg, xl, 2xl, 3xl, 4xl. | `text-xl`, `text-2xl`, `text-4xl` |
| `font-{weight}` | Grosor de la fuente. Opciones: thin, light, normal, medium, semibold, bold, extrabold. | `font-bold`, `font-light` |
| `text-{align}` | Alineación del texto. Idéntico a CSS nativo. | `text-center`, `text-justify`, `text-left` |
| `max-w-{size}` | Ancho máximo del elemento. Usa la misma nomenclatura que font-size. | `max-w-xl`, `max-w-2xl`, `max-w-7xl` |
| `container` | Contenedor con ancho máximo responsivo que se centra automáticamente. | `container mx-auto` |
| `flex` | Activa el display flexbox. | `flex` |
| `justify-{align}` | Alineación horizontal en flexbox. | `justify-between`, `justify-center`, `justify-start` |
| `items-{align}` | Alineación vertical en flexbox. | `items-center`, `items-start`, `items-end` |
| `space-x-{n}` | Espaciado horizontal entre elementos hijos. | `space-x-4` (espacio de 1rem entre elementos) |
| `shadow-{size}` | Sombra del elemento. | `shadow-md`, `shadow-lg`, `shadow-xl` |
| `hover:{class}` | Aplica estilos cuando el cursor está sobre el elemento. | `hover:text-fawn`, `hover:underline` |
| `transition-{property}` | Transición suave de propiedades. | `transition-colors`, `transition-all` |
| `rounded-{size}` | Bordes redondeados. | `rounded-lg`, `rounded-full` |
| `flex-grow` | Hace que el elemento crezca para ocupar el espacio disponible en un contenedor flex. | `flex-grow` |


# **Fuentes**

- [**Guía oficial de Vite**](https://es.vite.dev/guide): Guía oficial de **Vite** donde podemos apreciar conceptos básicos del mismo, la creación/inicialización de un proyecto, etc.
- [**NPMJS**](https://www.npmjs.com): Guía de paquetes/dependencias más utilizadas/descargadas en entornos de **JavaScript/TypeScript**.
- [**React Router DOM**](https://www.npmjs.com/package/react-router-dom): Dependencia que permite un redireccionamiento (**routing**) del lado cliente de nuestra aplicación.
- [**Tailwind CSS - Instalación**](https://tailwindcss.com/docs/installation): Documentación oficial a modo de guía sobre cómo instalar y utilizar **Tailwind CSS**.
- [**Tutoriales Markdown**](https://www.markdowntutorial.com/es/): Guía/tutoriales con teoría y práctica sobre cómo usar **Markdown**.
- [**Recomendación de estructura para proyectos react N.º1**](https://dev.to/shubhadip_bhowmik/best-folder-structure-for-react-complex-projects-432p): Recomendación de organización y creación de directorios para proyectos con **React** de **dev.to**.
- [**Recomendación de estructura para proyectos react N.º2**](https://javascript.plainenglish.io/react-project-folder-structure-that-actually-scales-2025-6dbd5f41767f): Recomendación de organización y creación de directorios para proyecto con **React** de **javascript.plainenglish.io**
- [**Sandbox de TailWind**](https://play.tailwindcss.com): Sitio web oficial de TailWind para practicar que hacen sus diferentes clases y aprender a usarlo.
- [**Tailwind Cheat Sheet**](https://nerdcave.com/tailwind-cheat-sheet): Guía fácil y rápida de clases de Tailwind, su sintaxis y que hace cada una.
- [**Generador de paletas de colores CSS**](https://coolors.co): Generador aleatorio de paletas de colores que use hasta conseguir una paleta que me gustase.
- [**Repositorio gratuito de iconos SVG**](https://devicon.dev): Maravillosa librería open-source con iconos especialmente enfocados en desarrollo de software, programación, etc.
