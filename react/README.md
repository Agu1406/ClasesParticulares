# Instalación de React + Vite

La documentación oficial de **React** recomienda usar siempre un framework o un toolchain (como Vite) incluso cuando se aprende desde cero, porque facilita la curva de aprendizaje y la continuidad. En mi **TFG** usé **React** con **Vite**, así que en este proyecto se sigue la misma instalación.

## Cómo instalar

1. Abre el directorio donde quieras el proyecto (en este repo, la carpeta se llama `react`).
2. Abre una terminal en ese directorio y ejecuta:

```bash
npm create vite@latest .
```

El punto (`.`) indica que el proyecto se crea en la carpeta actual. Cuando el asistente pregunte, elige **React** y la variante que prefieras (por ejemplo, TypeScript). Luego:

```bash
npm install
npm run dev
```

## Estructura del proyecto

Una duda habitual es cómo organizar las carpetas. Hay muchas formas; una muy apoyada por la comunidad es la siguiente (referencia [Bulletproof React](https://github.com/alan2207/bulletproof-react/blob/master/docs/project-structure.md)):

```
src/
├── app/          # Capa de aplicación (rutas, router, provider según el framework)
├── assets/       # Archivos estáticos: imágenes, fuentes, etc.
├── components/   # Componentes compartidos en toda la app
├── config/       # Configuración global y variables de entorno
├── features/    # Módulos por funcionalidad
├── hooks/        # Hooks reutilizables
├── lib/          # Librerías y utilidades preconfiguradas
├── stores/       # Estado global (stores)
├── testing/      # Utilidades y mocks para tests
├── types/        # Tipos compartidos (TypeScript)
└── utils/        # Funciones auxiliares compartidas
```

**No hace falta crear todo desde el principio.** Conviene ir añadiendo carpetas según las necesites. Para los primeros pasos suele bastar con **assets** (ya viene por defecto) y **components**.

- [React: iniciar un nuevo proyecto](https://es.react.dev/learn/start-a-new-react-project)
- [Bulletproof React – Estructura del proyecto](https://github.com/alan2207/bulletproof-react/blob/master/docs/project-structure.md)

# React + TypeScript + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

- [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react) uses [Oxc](https://oxc.rs)
- [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react-swc) uses [SWC](https://swc.rs/)

## React Compiler

The React Compiler is enabled on this template. See [this documentation](https://react.dev/learn/react-compiler) for more information.

Note: This will impact Vite dev & build performances.

## Expanding the ESLint configuration

If you are developing a production application, we recommend updating the configuration to enable type-aware lint rules:

```js
export default defineConfig([
  globalIgnores(['dist']),
  {
    files: ['**/*.{ts,tsx}'],
    extends: [
      // Other configs...

      // Remove tseslint.configs.recommended and replace with this
      tseslint.configs.recommendedTypeChecked,
      // Alternatively, use this for stricter rules
      tseslint.configs.strictTypeChecked,
      // Optionally, add this for stylistic rules
      tseslint.configs.stylisticTypeChecked,

      // Other configs...
    ],
    languageOptions: {
      parserOptions: {
        project: ['./tsconfig.node.json', './tsconfig.app.json'],
        tsconfigRootDir: import.meta.dirname,
      },
      // other options...
    },
  },
])
```

You can also install [eslint-plugin-react-x](https://github.com/Rel1cx/eslint-react/tree/main/packages/plugins/eslint-plugin-react-x) and [eslint-plugin-react-dom](https://github.com/Rel1cx/eslint-react/tree/main/packages/plugins/eslint-plugin-react-dom) for React-specific lint rules:

```js
// eslint.config.js
import reactX from 'eslint-plugin-react-x'
import reactDom from 'eslint-plugin-react-dom'

export default defineConfig([
  globalIgnores(['dist']),
  {
    files: ['**/*.{ts,tsx}'],
    extends: [
      // Other configs...
      // Enable lint rules for React
      reactX.configs['recommended-typescript'],
      // Enable lint rules for React DOM
      reactDom.configs.recommended,
    ],
    languageOptions: {
      parserOptions: {
        project: ['./tsconfig.node.json', './tsconfig.app.json'],
        tsconfigRootDir: import.meta.dirname,
      },
      // other options...
    },
  },
])
```
