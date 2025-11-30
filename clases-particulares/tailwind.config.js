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

