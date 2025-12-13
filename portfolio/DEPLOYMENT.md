# **Lista de objetivos**

- [X] Inicializar el proyecto con **REACT** + **TYPESCRIPT** + **VITE**.
- [X] Instalar dependencia para routing. (**React router DOM**).
- [X] Instalar dependencia para estilos. (**TailWindCSS & PostCSS & Autoprefixer**).
- [X] Configurar la base/ruta de carga de **Vite**.
- [X] Configurar la carga/lectura de archivos de **TailWind**. 
- [X] Crear la estructura del proyecto (directorios en src).
- [X] Configurar el routing de la aplicación.
- [X] Crear el componente de navegación de URLS con **\<Link>** de **React Router DOM**.
- [X] Generar el MPV (Minimo producto viable).
- [ ] Ignorar esto, es la linea que copio-pego para agregar cosas.
- [ ] Ignorar esto, es la linea que copio-pego para agregar cosas.
- [ ] Ignorar esto, es la linea que copio-pego para agregar cosas.
- [ ] Ignorar esto, es la linea que copio-pego para agregar cosas.


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

- **npm install react-router-dom:** Permite que el **routing** (redireccionamiento) dentro del proyecto sea del lado del cliente y no usando un **backend**, lo mejor en mi caso ya que **Github pages** no permite utilizar **backend** (no directamente). esta dependencia la conseguí investigando en **npmjs.com** que he citado en las fuentes.

```bash
npm install react-router-dom
```

- **npm install -D tailwindcss@^3.4.0 postcss autoprefixer**: El comando instala **TailWind** para el diseño y maquetado, la instrucción **"-D"** lo instala en modo **build** (son herramientas que necesito yo para el desarrollo, no el usuario final ni el despliegue), **postcss** es el plugin que lee las clases/código de Tailwind y al construir (build) lo transforma en **CSS** estatico para el sitio web, **autoprefixer** es una dependencia **requerida** por PostCSS que agrega automáticamente los prefijos de navegadores necesarios para compatibilidad (como -webkit-, -moz-, etc.), la **versión 3.4.0** de Tailwind es la más usada en el mercado porque es estable y tiene muchos plugins.

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

Uno de los limites de **Github pages** es que no permiten el uso directo de **backend** (se puede arreglar con, por ejemplo, **firebase** u otras soluciones), pero yo he decidido dejar el manejo de toda la logica del **lado cliente** (estudiantes de **DAW** sabréis que hay una asignatura con este nombre), por eso hemos instalado antes **react routing dom (dependencia)**.

Para esto debemos a entender los principios basicos del routing que ennumero a continuación en forma de pasos a seguir.

## **1. Crear los tipos del proyecto:** 

En mi caso, el sitio web entero va de ofrecer a mis alumnos material educativo (ejercicios, teoría, practica, test) de los diferentes lenguajes de programación que enseño, entonces debo crear una estructura llamada **Languages** para identificar y describir cada uno, además, todos los lenguajes que enseño tienen ejercicios, por lo tanto creo una interfaz **Exercise** que relaciona 1 o varios ejercicios con "X" lenguaje, para ello dentro de **src > types** creamos un archivo **index.ts** con el siguiente contenido:

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
        <div className="min-h-screen bg-lavender p-8">
            <h1 className="text-4xl font-bold text-center m-8 text-evergreen">
                Portal de clases particulares de Agustín
            </h1>
            <p className="text-center m-8 text-slate text-lg">
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
            <p className="text-center m-8 text-slate text-lg">
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
// Importamos el componente de navegación
import Navigation from "./components/Navigation";

// Creamos la función "App" encargada de manejar toda la logica de redireccionamiento.
function App () {
  return (
    // Activamos el enrutamiento (routing) de la aplicación.
    <BrowserRouter>
      {/* Barra de navegación global */}
      <Navigation />
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

Si lo explicamos de la forma más junior posible es que **BrowserRouter** activa la dependencia de enrutamiento/redireccionamiento **react router dom**, **Routes** es simplemente la etiqueta utilizad para agrupar una o varias rutas y **Route** es la etiqueta que define la URL de la ruta y el elemento/componente que debe cargar nuestra **SPA** en caso de ser utilizada.

## **4. Crear navegación con Link**

El HTML tradicional es muy limitado a la hora de diseñar **SPA**, en nuestro caso, queremos evitar la recarga completa del sitio web en el intercambio de rutas, por eso, la etiqueta nativa HTML **"\<a href="rute">"** no nos sirve, la buena noticia es que **React Router DOM** incluye una etiqueta propia la cual es **"\<Link to="ruta">"** que permite cambiar dinamicamente, sin recarga completa, la ruta de la **SPA**, perfecta para nosotros.

Como **App.tsx** es el encargado de (dinamicamente) mostrar el contenido dependiendo de la ruta cargando el componente especifico de cada una, tiene que contar con este "menú de navegación" usando **Link**, por lo tanto, diseñamos un componente reutilizable para ello dentro del directorio **components** llamando, por ejemplo **Navigation.tsx** que queda de la siguiente forma:

**NOTA:** Aunque React Router DOM recomienda usar `<Link to>` en lugar de `<a href>` para evitar recargas completas, en este ejemplo se muestra con `<a href>` para simplicidad. En producción, es recomendable usar `<Link to="/ruta">` importado de `react-router-dom`.

```tsx
function Navigation() {
    return (
        <nav className="bg-evergreen text-lavender p-4 shadow-md">
            <div className="container mx-auto flex justify-between items-center">
                <a href="/" className="text-xl font-bold hover:text-fawn transition-colors">
                    Clases Particulares
                </a>
                <div className="space-x-4">
                    <a href="/" className="hover:text-fawn transition-colors">Inicio</a>
                    <a href="/java" className="hover:text-fawn transition-colors">Java</a>
                </div>
            </div>
        </nav>
    );
}

export default Navigation;
```
# **Paso N.º9 - Agregar los iconos necesarios para los datos**

Este paso en teoría debería ser el N.º10 y viceversa, el N.º10 debería ser el N.º9, pero me dije a mi mismo, **al definir los datos de los lenguajes necesitas la URL de las imagenes/iconos que usaras para representarlos**, así que, **¿Por que dejar para mañana lo que puedes hacer hoy?**.

Para ello, desde **src** navegamos hasta **assets** y creamos ahí el directorio **icons** donde subiremos (de preferencia SVG) los iconos que representaran los lenguajes que imparto en clases.

En el encabezado **fuentes** de este documento dejo el enlace a la libreria gratuita de **SVG** que yo he utilizado para bajarme los iconos, la unica pega es que trae 2019 iconos SVG/EPS pero yo no necesito tantos, sumando los frameworks, lenguajes base y tecnologías que se utilizar y he enseñado llego a 109, por lo tanto, actualizamos nuestro **gitignore** para excluir todos excepto los que nos interesan, quedando así el apartado de iconos del gitignore:

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

# Exlcuimos todos los EPS porque no los usare.
*.eps
```
# **Paso N.º10 - Crear los datos (lenguajes) de la SPA**

Ahora ya tenemos un **MVP** (algo parecido), es hora utilizar la interfaz que diseñamos que define los campos que deben tener los lenguajes de programación de los que imparto clases así como la relación que tienen los ejercicios con los mismos, para eso, desde el directorio **src** creamos un subdirectorio llamado **data** y ahí creamos el archivo **languages.ts** el cual importa la interfaz `Languages`, en el siguiente fragmento muestro, por ejemplo, como se ve solo con los datos de **JAVA** aunque, por supuesto, tengo que agregarlos todos y puedes ver el archivo completo finalizado:

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
# **Preguntas comunes que yo mismo me hice**

### **¿Como pruebo el código que estoy haciendo?**

Existen varias formas, la mejor (para mi) es correr en modo desarrollo (**dev mode**) el proyecto lo que me permite correrlo en localhost, para ello ejecutamos el siguiente comando desde la raiz del proyecto:

```bash
npm run dev
```

¿Que tiene de especial el modo **dev**? Son principlamente dos, los cuales nos ayudan mucho durante el desarrollo y son los siguientes:

- **Hot Module Replacement (HMR):** Todos los cambios que realize en el proyecto se muestran automaticamente en la pagina sin necesidad de recargar.
- **Console errors:** Todos los errores que haya en compilación o en el código aparecen en (ambos) el propio navegador web a través de la consola y en el terminal donde se ejecuta el comando.

**NOTA SUPER IMPORTANTE:** Como yo despliego desde **Github pages** tengo que modificar la **URL** base del proyecto, para desarrollo local eso me da problemas así que modifique el **vite.config.ts** para que detecte el modo **dev** y utilice una ruta diferente en ese escenario, quedando de la siguiente forma:

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
| `ignorar esto`| Es lo que utilizo para copiar y pegar la siguiente linea| `curioso, ¿no?`|


# **Fuentes**

- [**Guía oficial de Vite**](https://es.vite.dev/guide): Guía oficial de **Vite** donde podemos apreciar conceptos básicos del mismo, la creación/inicialización de un proyecto, etc.
- [**NPMJS**](https://www.npmjs.com): Guía de paquetes/dependencias más utilizadas/descargadas en entornos de **JavaScript/TypeScript**.
- [**React Router DOM**](https://www.npmjs.com/package/react-router-dom): Dependencia que permite un redireccionamiento (**routing**) del lado cliente de nuestra aplicación.
- [**Tailwind CSS - Instalación**](https://tailwindcss.com/docs/installation): Documentación oficial a modo de guía sobre cómo instalar y utilizar **Tailwind CSS**.
- [**Tutoriales Markdown**](https://www.markdowntutorial.com/es/): Guía/tutoriales con teoría y práctica sobre cómo usar **Markdown**.
- [**Recomendación de estructura para proyectos react N.º1**](https://dev.to/shubhadip_bhowmik/best-folder-structure-for-react-complex-projects-432p): Recomendación de organización y creación de directorios para proyectos con **React** de **dev.to**.
- [**Recomendación de estructura para proyectos react N.º2**](https://javascript.plainenglish.io/react-project-folder-structure-that-actually-scales-2025-6dbd5f41767f): Recomendación de organización y creacios de directorios para proyecto con **React** de **javascript.plainenglish.io**
- [**Sandbox de TailWind**](https://play.tailwindcss.com): Sitio web oficial de TailWind para practicar que hacen sus diferentes clases y aprender a usarlo.
- [**Tailwind Cheat Sheet**](https://nerdcave.com/tailwind-cheat-sheet): Guía fácil y rápida de clases de Tailwind, su sintaxis y que hace cada una.
- [**Generador de paletas de colores CSS**](https://coolors.co): Generador aleatorio de paletas de colores que use hasta conseguir una paleta que me gustase.
- [**Repositorio gratuito de iconos SVG**](https://devicon.dev): Maravillosa libreria open-source con iconos especialemnte enfocados en desarrollo de software, programación, etc.
- [**Ignorar esta linea**](): Es la que copio-pego para agregar más enlaces.
