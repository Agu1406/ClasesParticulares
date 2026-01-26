# Tipos (interfaces) existentes hasta el momento

- **Languages**: Define los datos que tienen los lenguajes de programación como nombre, id, descripción, etc.
- **Exercises:** Define los datos que tienen los ejercicios descargables de dichos lenguajes, como id, titulo, descripción, URL de descarga.
- **Lessons:** Define los datos que tienen las lecciones como su contenido, id, titulo, ejemplos de código, etc.

# Explicación de los tipos

Los **tipos** definen los campos/datos que deben tener los "objetos" en nuestra aplicación, por ejemplo, desde **pages/HomePage.tsx** se cargan todos los lenguajes disponibles en el portal de clases particulares, estos lenguajes no se obtienen desde una base de datos, si no que existen en **data/languages.ts** donde están definidos en forma de un Array, ejemplo:

```ts
export const languages: Language[] = [
    {
        id: "java",
        name: "Java",
        icon: javaIcon,
        description: "Programación orientada a objetos (POO), Swing, JavaFX, JDBC, multihilo, estructuras de datos",
        path: "/java"
    },
    {
        Otros lenguajes...
    }
]
```

Si os dais cuenta, la estructura es tipica de una base de datos SQL, tiene campos como **ID** (varchar), **name** (varchar), **icon** (una ruta relativa al icono existente en **assets/icons/...**), **description** (varchar), **path** (varchar con la ruta del lenguaje).

en **types/index.ts** es donde definimos que campos debe y no debe tener un objeto para ser valido o no como lenguaje (en este caso), como ejercicio, como lección, etc, de nuestra aplicación, por ejemplo, la estructura que define los datos que debe tener los lenguajes en **data/languages.ts** lo encontramos aquí en **types/index.ts** más o menos de la siguiente forma:

```ts
export interface Language {
    id: string;
    name: string;
    icon: string;
    description: string;
    path: string;
}
```

Todo en **TypeScript** debido al stack que utilizamos en nuestra **SPA** (Single Page Application).